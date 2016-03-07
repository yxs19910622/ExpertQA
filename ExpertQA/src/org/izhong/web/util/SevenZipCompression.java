package org.izhong.web.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.izhong.expert.model.SystemInfos;
import org.izhong.web.model.DownloadFileItem;
import org.izhong.web.model.DownloadPackage;

public class SevenZipCompression {
//	private static Logger logUtil = Logger.getLogger(SevenZipCompression.class);
	
	static byte[] DECOMPRESSPROPERTIES = new byte[] { 0x5d,0x00,0x00,0x00,0x01 }; //{ 0x5b, 0x00, 0x00, 0x00, 0x01 }; //{ 0x5D,0x00,0x80,0x00,0x00}
	
	public static DownloadPackage Compression(String elementName, Element element, List<String> fileIDs, List<String> fileLocations) throws IOException
	{
		DownloadPackage dpk = new DownloadPackage();
		if((fileIDs == null) || (fileIDs.size() == 0))
		{
			dpk.setItems(new DownloadFileItem[0]);
			dpk.setCount(0);
		}
		else {
			String rootpath = StaticTable.ROOTPATH;
			if(!System.getProperty("os.name").contains("Windows"))
			{
				rootpath = StaticTable.LINXROOTPATH;
			}
			FileInputStream fileInStream = null;
			ByteArrayOutputStream outStream = null;
			int count = fileIDs.size();
			DownloadFileItem[] items = new DownloadFileItem[count+1];
			items[0] = toFileItem(elementName, element);		
			for(int i=0;i<count;i++)
			{
				DownloadFileItem item = new DownloadFileItem();
				items[i+1] = item;
				item.setItemName(fileIDs.get(i));
				String fullName = rootpath + fileLocations.get(i);
//				System.out.println("转换前:"+fullName);
				fullName = fullName.replace("\\", "/");
//				System.out.println("转换后:"+fullName);
				try {
//					fullName = fullName.replaceAll("\\",System.getProperty("file.separator"))
//							.replaceAll("/",System.getProperty("file.separator"));
//					if(fullName.indexOf("\\") >= 0)
//					{
//						fullName = fullName.replace("\\", "/");
//					}
					fileInStream = new FileInputStream(fullName);
					item.setBeforeLength(fileInStream.available());
					sevenzip.compression.lzma.Encoder coder = new sevenzip.compression.lzma.Encoder();
					outStream = new ByteArrayOutputStream();   
					coder.Code(fileInStream, outStream, -1, -1, null);
					byte[] bytes = outStream.toByteArray();
					item.setBytes(bytes);
					
					item.setAfterLength(bytes.length);
				}  catch (IOException e) {
					e.printStackTrace();
				} finally{
					if(fileInStream!=null){fileInStream.close();}
					if(outStream!=null){outStream.close();}
				}
			}
			dpk.setItems(items);
			dpk.setCount(count+1);
		}
		return dpk;
	}

	public static DownloadPackage Compression(String elementName, Element element, String elementName2, Element element2, List<String> fileIDs, List<String> fileLocations) throws IOException
	{
		DownloadPackage dpk = new DownloadPackage();
		if((fileIDs == null) || (fileIDs.size() == 0))
		{
			dpk.setItems(new DownloadFileItem[0]);
			dpk.setCount(0);
		}
		else {
			String rootpath = StaticTable.ROOTPATH;
			if(!System.getProperty("os.name").contains("Windows"))
			{
				rootpath = StaticTable.LINXROOTPATH;
			}
			FileInputStream fileInStream = null;
			ByteArrayOutputStream outStream = null;
			int count = fileIDs.size();
			DownloadFileItem[] items = new DownloadFileItem[count+2];
			items[0] = toFileItem(elementName, element);
			items[1] = toFileItem(elementName2, element2);
			for(int i=0;i<count;i++)
			{
				DownloadFileItem item = new DownloadFileItem();
				items[i+2] = item;
				item.setItemName(fileIDs.get(i));
				String fullName = rootpath + fileLocations.get(i);
//				System.out.println("转换前:"+fullName);
				fullName = fullName.replace("\\", "/");
//				System.out.println("转换后:"+fullName);
				try {
//					fullName = fullName.replaceAll("\\",System.getProperty("file.separator"))
//							.replaceAll("/",System.getProperty("file.separator"));
//					if(fullName.indexOf("\\") >= 0)
//					{
//						fullName = fullName.replace("\\", "/");
//					}
					fileInStream = new FileInputStream(fullName);
					item.setBeforeLength(fileInStream.available());
					sevenzip.compression.lzma.Encoder coder = new sevenzip.compression.lzma.Encoder();
					outStream = new ByteArrayOutputStream();   
					coder.Code(fileInStream, outStream, -1, -1, null);
					byte[] bytes = outStream.toByteArray();
					item.setBytes(bytes);
					
					item.setAfterLength(bytes.length);
				}  catch (IOException e) {
					e.printStackTrace();
				} finally{
					if(fileInStream!=null){fileInStream.close();}
					if(outStream!=null){outStream.close();}
				}
			}
			dpk.setItems(items);
			dpk.setCount(count+2);
		}
		return dpk;
	}
		
	public static DownloadPackage Compression(String elementName, Element element) throws IOException {
		DownloadPackage dpk = new DownloadPackage();
		if (element == null)
		{
			dpk.setItems(new DownloadFileItem[0]);
			dpk.setCount(0);
		}else{
			DownloadFileItem[] items = new DownloadFileItem[1];
			items[0] = toFileItem(elementName, element);
			dpk.items = items;		
			dpk.setCount(1);
		}
		return dpk;
	}
	
	public static DownloadPackage Compression(String elementName, Element element, String elementName2, Element element2) throws IOException
	{
		DownloadPackage dpk = new DownloadPackage();
		
		DownloadFileItem[] items = new DownloadFileItem[2];
		items[0] = toFileItem(elementName, element);
		items[1] = toFileItem(elementName2, element2);		
		dpk.setItems(items);
		dpk.setCount(2);
		
		return dpk;
	}
	
	public static DownloadPackage Compression(List<SystemInfos> systemInfos) throws IOException
	{
		DownloadPackage dpk = new DownloadPackage();
		if(systemInfos == null)
		{
			dpk.setItems(new DownloadFileItem[0]);
			dpk.setCount(0);
		}else{
			Element rootEl = DocumentHelper.createElement("Root");
			for (int i = 0; i < systemInfos.size(); i++) {
				SystemInfos info = systemInfos.get(i);
				Element bodyEl = DocumentHelper.createElement("Item");
				bodyEl.addAttribute("DocumentID", info.getDocumentID());
				bodyEl.addAttribute("Title", info.getTitle());
				bodyEl.addAttribute("Creator", info.getCreator());
				bodyEl.addAttribute("Subject", info.getSubject());
				bodyEl.addAttribute("Description", info.getDescription());
				bodyEl.addAttribute("Publisher", info.getPublisher());
				bodyEl.addAttribute("Contributor", info.getContributor());
				bodyEl.addAttribute("Date", (info.getDocumentDate()==null?"":info.getDocumentDate().toString()));
				bodyEl.addAttribute("Type", info.getType());
				bodyEl.addAttribute("Format", info.getFormat());
				bodyEl.addAttribute("Identifier", info.getIdentifier());
				bodyEl.addAttribute("Source", info.getSource());
				bodyEl.addAttribute("Language", info.getLanguage());
				bodyEl.addAttribute("Relation", info.getRelation());
				bodyEl.addAttribute("Coverage", info.getCoverage());
				bodyEl.addAttribute("Rights", info.getRights());
				bodyEl.addAttribute("MD5", info.getMd5());
				bodyEl.addAttribute("Location", info.getLocation());
				bodyEl.addAttribute("Version", info.getVersion());
				bodyEl.addAttribute("FileExtension", info.getFileExtension());
				bodyEl.addAttribute("deleteStatus", info.getDeleteStatus());
				rootEl.add(bodyEl);
			}			
			DownloadFileItem[] items = new DownloadFileItem[1];
			items[0] = toFileItem("Items", rootEl);
			dpk.setItems(items);
			dpk.setCount(1);
		}
		return dpk;
	}
	
	private static DownloadFileItem toFileItem(String itemName, Element sourceEl) throws IOException
	{
//		Document document = new DefaultDocument();
//		document.setXMLEncoding("GBK");
//		document.add(sourceEl);
//		String source = formatXML(document, "GBK");
//
//		logUtil.info("XML片断:");
//		logUtil.info(source);
		
		String source = sourceEl.asXML();
		ByteArrayInputStream inStream = null;
		ByteArrayOutputStream outStream = null;
		byte[] bytes = null;
		try {
			inStream = new ByteArrayInputStream(source.getBytes());   
			sevenzip.compression.lzma.Encoder coder = new sevenzip.compression.lzma.Encoder();
			outStream = new ByteArrayOutputStream();   
			coder.Code(inStream, outStream, -1, -1, null);	
			bytes = outStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(inStream!=null){inStream.close();}
			if(outStream!=null){outStream.close();}
		}
		DownloadFileItem downItem = new DownloadFileItem();
		downItem.setItemName(itemName);
		downItem.setBeforeLength(source.length());
		downItem.setAfterLength(bytes.length);
		downItem.setBytes(bytes);
		return downItem;
	}
	
	private static String formatXML(Document document, String charset) { 
         OutputFormat format = OutputFormat.createPrettyPrint(); 
         format.setEncoding(charset); 
         StringWriter sw = new StringWriter(); 
         XMLWriter xw = new XMLWriter(sw, format); 
         try { 
                 xw.write(document); 
                 xw.flush(); 
                 xw.close(); 
         } catch (IOException e) { 
//                 log.error("格式化XML文档发生异常，请检查！", e); 
         } 
         return sw.toString(); 
	 }
	
	/**
	 * 解压缩
	 * @param fileItem
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @author whz
	 */
	public static Element Decompression(DownloadFileItem fileItem) throws DocumentException, IOException {
		String xml = null;
		if(fileItem==null)
		{
			return DocumentHelper.createElement("Root");
		}else{
			ByteArrayInputStream inStream = null;
			ByteArrayOutputStream outStream = null;			
			try {
				inStream = new ByteArrayInputStream(fileItem.getBytes());
				sevenzip.compression.lzma.Decoder decoder = new sevenzip.compression.lzma.Decoder();
				
				decoder.SetDecoderProperties(DECOMPRESSPROPERTIES);
				outStream = new ByteArrayOutputStream(); 
				long outSize = fileItem.getBeforeLength();
				decoder.Code(inStream, outStream, outSize);
				
				byte[] bytes = outStream.toByteArray();
				xml = new String(bytes);
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(inStream!=null){inStream.close();}
				if(outStream!=null){outStream.close();}
			}
			return DocumentHelper.parseText(xml).getRootElement();		
		}
	}
	
	public static String Decompression(String source) throws IOException {
		if((source!=null)&&(source.length() > 0))
		{
			ByteArrayInputStream inStream = null;
			ByteArrayOutputStream outStream = null;			
			try {
				inStream = new ByteArrayInputStream(source.getBytes());
				sevenzip.compression.lzma.Decoder decoder = new sevenzip.compression.lzma.Decoder();
				
				decoder.SetDecoderProperties(DECOMPRESSPROPERTIES);
				outStream = new ByteArrayOutputStream(); 
				long outSize = source.length() * 5;
				decoder.Code(inStream, outStream, outSize);
				
				byte[] bytes = outStream.toByteArray();
				return new String(bytes);		
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(inStream!=null){inStream.close();}
				if(outStream!=null){outStream.close();}
			}
		}
		return null;
	}
	
	public static String Decompression(byte[] source) throws IOException {
		if((source!=null)&&(source.length > 0))
		{
			ByteArrayInputStream inStream = null;
			ByteArrayOutputStream outStream = null;			
			try {
				inStream = new ByteArrayInputStream(source);
				sevenzip.compression.lzma.Decoder decoder = new sevenzip.compression.lzma.Decoder();
				
				decoder.SetDecoderProperties(DECOMPRESSPROPERTIES);
				outStream = new ByteArrayOutputStream(); 
				long outSize = source.length * 5;
				decoder.Code(inStream, outStream, outSize);
				
				byte[] bytes = outStream.toByteArray();
				return new String(bytes);		
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				if(inStream!=null){inStream.close();}
				if(outStream!=null){outStream.close();}
			}
		}
		return null;
	}
}
