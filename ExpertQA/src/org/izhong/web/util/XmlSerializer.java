package org.izhong.web.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.izhong.expert.model.QuestionQueryResultObj;
import org.izhong.expert.model.RESUDP_Catalog;
import org.izhong.expert.model.RESUDP_CatalogFullTree;
import org.izhong.expert.model.RESUDP_DocumentInfo;
import org.izhong.expert.model.RESUDP_LawDocumentEntity;
import org.izhong.expert.model.RESUDP_LawExample;
import org.izhong.expert.model.RESUDP_Question;
import org.izhong.expert.model.RESUDP_QuestionExample;
import org.izhong.expert.model.RESUDP_QuestionLawRef;
import org.izhong.expert.model.RESUDP_UserInfo;
import org.izhong.expert.model.RES_UpdateTableInfo;
import org.izhong.expert.model.RES_UseTechniqueinfo;
import org.izhong.expert.model.RESUDP_SystemInfo;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.StringUtil;

public class XmlSerializer {

	//序列化、反序列化RES_UpdateTableInfo对象
	public static Element SerializeRES_UpdateTableInfos(List<RES_UpdateTableInfo> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RES_UpdateTableInfo");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RES_UpdateTableInfo o = values.get(i);
				Element el = DocumentHelper.createElement("RES_UpdateTableInfo");
				el.addElement("TID").setText(String.valueOf(o.getTid()));
				el.addElement("TABLENAME").setText(o.getTablename());
				el.addElement("LASTDATE").setText(DateUtil.formatDate(o.getLastdate()));
				el.addElement("EXTENSIONFIELD1").setText(StringUtil.replaceNull(o.getExtensionfield1()));
				el.addElement("EXTENSIONFIELD2").setText(StringUtil.replaceNull(o.getExtensionfield2()));
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				rootEl.add(el);
			}
		}
		return rootEl;
	}

	public static List<RES_UpdateTableInfo> DeserializeRES_UpdateTableInfos(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RES_UpdateTableInfo".equalsIgnoreCase(typeName)) {
				List<RES_UpdateTableInfo> values = new ArrayList<RES_UpdateTableInfo>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RES_UpdateTableInfo o = new RES_UpdateTableInfo();
					o.setTid(Integer.parseInt(el.element("TID").getText()));
					o.setTablename(el.element("TABLENAME").getText());
					try
					{
						o.setLastdate(df.parse(el.element("LASTDATE").getText()));						
					}catch(Exception e) { }					
					o.setExtensionfield1(el.element("EXTENSIONFIELD1").getText());
					o.setExtensionfield2(el.element("EXTENSIONFIELD2").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	
	//序列化、反序列化RES_UpdateTableInfo对象
	public static Element SerializeRES_UseTechniqueinfos(List<RES_UseTechniqueinfo> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RES_UseTechniqueinfo");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RES_UseTechniqueinfo o = values.get(i);
				Element el = DocumentHelper.createElement("RES_UseTechniqueinfo");
				el.addElement("TID").setText(String.valueOf(o.getTid()));
				el.addElement("TECHNAME").setText(o.getTechname());
				el.addElement("TECHTEXT").setText(o.getTechtext());
				el.addElement("INDEXNO").setText(String.valueOf(o.getIndexno()));
				el.addElement("EXTENSIONFIELD1").setText(StringUtil.replaceNull(o.getExtensionfield1()));
				el.addElement("EXTENSIONFIELD2").setText(StringUtil.replaceNull(o.getExtensionfield2()));
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				rootEl.add(el);
			}
		}
		return rootEl;
	}

	public static List<RES_UseTechniqueinfo> DeserializeRES_UseTechniqueinfos(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        String typeName = xmldata.attribute("Type").getText();
			if ("RES_UseTechniqueinfo".equalsIgnoreCase(typeName)) {
				List<RES_UseTechniqueinfo> values = new ArrayList<RES_UseTechniqueinfo>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RES_UseTechniqueinfo o = new RES_UseTechniqueinfo();
					o.setTid(Integer.parseInt(el.element("TID").getText()));
					o.setTechname(el.element("TECHNAME").getText());
					o.setTechtext(el.element("TECHTEXT").getText());
					o.setIndexno(Integer.parseInt(el.element("INDEXNO").getText()));
					o.setExtensionfield1(el.element("EXTENSIONFIELD1").getText());
					o.setExtensionfield2(el.element("EXTENSIONFIELD2").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	//序列化、反序列化RESUDP_Catalog对象
	public static Element SerializeRESUDP_Catalogs(List<RESUDP_Catalog> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_Catalog");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_Catalog o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_Catalog");
				el.addElement("CATALOGID").setText(o.getCatalogid());
				el.addElement("CATALOGNAME").setText(o.getCatalogname());
				el.addElement("FULLCATALOGNAME").setText(o.getFullcatalogname());
				el.addElement("PARENTCATALOGID").setText(o.getParentcatalogid());
				el.addElement("INPARENTINDEXNO").setText(String.valueOf(o.getInparentindexno()));
				el.addElement("LEVELNAME").setText(String.valueOf(o.getLevelname()));
				el.addElement("NODETYPE").setText(String.valueOf(o.getNodetype()));				
				el.addElement("EXTENSIONFIELD1").setText(StringUtil.replaceNull(o.getExtensionfield1()));
				el.addElement("EXTENSIONFIELD2").setText(StringUtil.replaceNull(o.getExtensionfield2()));
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				rootEl.add(el);
			}
		}
		return rootEl;
	}

	public static List<RESUDP_Catalog> DeserializeRESUDP_Catalogs(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_Catalog".equalsIgnoreCase(typeName)) {
				List<RESUDP_Catalog> values = new ArrayList<RESUDP_Catalog>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RESUDP_Catalog o = new RESUDP_Catalog();
					o.setCatalogid(el.element("CATALOGID").getText());
					o.setCatalogname(el.element("CATALOGNAME").getText());
					o.setFullcatalogname(el.element("FULLCATALOGNAME").getText());
					o.setParentcatalogid(el.element("PARENTCATALOGID").getText());
					o.setInparentindexno(Integer.parseInt(el.element("INPARENTINDEXNO").getText()));
					o.setLevelname(Integer.parseInt(el.element("LEVELNAME").getText()));
					o.setNodetype(el.element("NODETYPE").getText());					
					o.setExtensionfield1(el.element("EXTENSIONFIELD1").getText());
					o.setExtensionfield2(el.element("EXTENSIONFIELD2").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	//序列化、反序列化RESUDP_CatalogFullTree对象
	public static Element SerializeRESUDP_CatalogFullTree(List<RESUDP_CatalogFullTree> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_CatalogFullTree");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_CatalogFullTree o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_CatalogFullTree");
				el.addElement("CATALOGNODEID").setText(o.getCatalognodeid());
				el.addElement("CATALOGNODENAME").setText(o.getCatalognodename());
				el.addElement("CATALOGID").setText(o.getCatalogid());
				el.addElement("NODETYPE").setText(o.getNodetype());
				el.addElement("VIEWRESOURCE").setText(o.getViewresource());
				el.addElement("EDITRESOURCE").setText(o.getEditresource());
				el.addElement("SAVERESOURCE").setText(o.getSaveresource());
				el.addElement("TRANSMITRESOURCE").setText(o.getTransmitresource());
				el.addElement("CANCATALOGSEARCH").setText(o.getCancatalogsearch());
				el.addElement("CANFULLTEXTSEARCH").setText(o.getCanfulltextsearch());
				el.addElement("FULLTEXTSEARCHRESOURCE").setText(StringUtil.replaceNull(o.getFulltextsearchresource()));
				el.addElement("CANSHOWEXTENSIONS").setText(o.getCanshowextensions());
				el.addElement("INDEXNO").setText(String.valueOf(o.getIndexno()));
				el.addElement("EXTENSIONFIELD1").setText(StringUtil.replaceNull(o.getExtensionfield1()));
				el.addElement("EXTENSIONFIELD2").setText(StringUtil.replaceNull(o.getExtensionfield2()));
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				rootEl.add(el);
			}
		}
		return rootEl;
	}

	public static List<RESUDP_CatalogFullTree> DeserializeRESUDP_CatalogFullTree(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_CatalogFullTree".equalsIgnoreCase(typeName)) {
				List<RESUDP_CatalogFullTree> values = new ArrayList<RESUDP_CatalogFullTree>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RESUDP_CatalogFullTree o = new RESUDP_CatalogFullTree();
					o.setCatalognodeid(el.element("CATALOGNODEID").getText());
					o.setCatalognodename(el.element("CATALOGNODENAME").getText());
					o.setCatalogid(el.element("CATALOGID").getText());
					o.setNodetype(el.element("NODETYPE").getText());
					o.setViewresource(el.element("VIEWRESOURCE").getText());
					o.setEditresource(el.element("EDITRESOURCE").getText());
					o.setSaveresource(el.element("SAVERESOURCE").getText());
					o.setTransmitresource(el.element("TRANSMITRESOURCE").getText());
					o.setCancatalogsearch(el.element("CANCATALOGSEARCH").getText());
					o.setCanfulltextsearch(el.element("CANFULLTEXTSEARCH").getText());
					o.setFulltextsearchresource(el.element("FULLTEXTSEARCHRESOURCE").getText());
					o.setCanshowextensions(el.element("CANSHOWEXTENSIONS").getText());
					o.setIndexno(Integer.parseInt(el.element("INDEXNO").getText()));
					o.setExtensionfield1(el.element("EXTENSIONFIELD1").getText());
					o.setExtensionfield2(el.element("EXTENSIONFIELD2").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	
	//序列化、反序列化RESUDP_DocumentInfo对象
	public static Element SerializeRESUDP_DocumentInfos(List<RESUDP_DocumentInfo> values)
		{
			Element rootEl = DocumentHelper.createElement("Root");
			rootEl.addAttribute("Type", "RESUDP_DocumentInfo");
			if(values != null)
			{
				int size = values.size();
				for(int i=0;i<size;i++)
				{
					RESUDP_DocumentInfo o = values.get(i);
					Element el = DocumentHelper.createElement("RESUDP_DocumentInfo");
					el.addElement("DOCUMENTID").setText(o.getDocumentid());
					el.addElement("TITLE").setText(o.getTitle());
					el.addElement("CREATOR").setText(o.getCreator());
					el.addElement("SUBJECT").setText(o.getSubject());
					el.addElement("DESCRIPTION").setText(StringUtil.replaceNull(o.getDescription()));
					el.addElement("PUBLISHER").setText(o.getPublisher());
					el.addElement("CONTRIBUTOR").setText(o.getContributor());
					el.addElement("DOCUMENTDATE").setText(DateUtil.formatDate(o.getDocumentdate()));
					el.addElement("TYPE").setText(StringUtil.replaceNull(o.getType()));
					el.addElement("FORMAT").setText(StringUtil.replaceNull(o.getFormat()));
					el.addElement("SOURCE").setText(StringUtil.replaceNull(o.getSource()));
					el.addElement("IDENTIFIER").setText(StringUtil.replaceNull(o.getIdentifier()));
					el.addElement("LANGUAGE").setText(o.getLanguage());
					el.addElement("RELATION").setText(StringUtil.replaceNull(o.getRelation()));
					el.addElement("COVERAGE").setText(StringUtil.replaceNull(o.getCoverage()));
					el.addElement("RIGHTS").setText(o.getRights());
					el.addElement("MD5").setText(StringUtil.replaceNull(o.getMd5()));
					el.addElement("VERSION").setText(o.getVersion());
					el.addElement("LOCATION").setText(o.getLocation());
					el.addElement("FILEEXTENSION").setText(o.getFileextension());
					el.addElement("DELETESTATUS").setText(o.getDeletestatus());
					el.addElement("PROJECTNAME").setText(o.getProjectname());
					rootEl.add(el);
				}
			}
			return rootEl;
		}

	public static List<RESUDP_DocumentInfo> DeserializeRESUDP_DocumentInfos(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_DocumentInfo".equalsIgnoreCase(typeName)) {
				List<RESUDP_DocumentInfo> values = new ArrayList<RESUDP_DocumentInfo>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el = els.get(i);
					RESUDP_DocumentInfo o = new RESUDP_DocumentInfo();
					o.setDocumentid(el.element("DOCUMENTID").getText());
					o.setTitle(el.element("TITLE").getText());
					o.setCreator(el.element("CREATOR").getText());
					o.setSubject(el.element("SUBJECT").getText());
					o.setDescription(el.element("DESCRIPTION").getText());
					o.setPublisher(el.element("PUBLISHER").getText());
					o.setContributor(el.element("CONTRIBUTOR").getText());
					try
					{
						o.setDocumentdate(df.parse(el.element("DOCUMENTDATE").getText()));						
					}catch(Exception e) { }
					
					o.setType(el.element("TYPE").getText());
					o.setFormat(el.element("FORMAT").getText());
					o.setSource(el.element("SOURCE").getText());
					o.setIdentifier(el.element("IDENTIFIER").getText());
					o.setLanguage(el.element("LANGUAGE").getText());
					o.setRelation(el.element("RELATION").getText());
					o.setCoverage(el.element("COVERAGE").getText());
					o.setRights(el.element("RIGHTS").getText());
					o.setMd5(el.element("MD5").getText());
					o.setVersion(el.element("VERSION").getText());
					o.setLocation(el.element("LOCATION").getText());
					o.setFileextension(el.element("FILEEXTENSION").getText());
					o.setDeletestatus(el.element("DELETESTATUS").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	
	//序列化、反序列化RESUDP_DocumentInfo对象
	public static Element SerializeRESUDP_SystemInfos(List<RESUDP_SystemInfo> values)
		{
			Element rootEl = DocumentHelper.createElement("Root");
			rootEl.addAttribute("Type", "RESUDP_SystemInfo");
			if(values != null)
			{
				int size = values.size();
				for(int i=0;i<size;i++)
				{
					RESUDP_SystemInfo o = values.get(i);
					Element el = DocumentHelper.createElement("RESUDP_SystemInfo");
					el.addElement("DOCUMENTID").setText(o.getDocumentid());
					el.addElement("TITLE").setText(StringUtil.replaceNull(o.getTitle()));
					el.addElement("CREATOR").setText(StringUtil.replaceNull(o.getCreator()));
					el.addElement("SUBJECT").setText(StringUtil.replaceNull(o.getSubject()));
					el.addElement("DESCRIPTION").setText(StringUtil.replaceNull(o.getDescription()));
					el.addElement("PUBLISHER").setText(StringUtil.replaceNull(o.getPublisher()));
					el.addElement("CONTRIBUTOR").setText(StringUtil.replaceNull(o.getContributor()));
					el.addElement("DOCUMENTDATE").setText(DateUtil.formatDate(o.getDocumentdate()));
					el.addElement("TYPE").setText(StringUtil.replaceNull(o.getType()));
					el.addElement("FORMAT").setText(StringUtil.replaceNull(o.getFormat()));
					el.addElement("SOURCE").setText(StringUtil.replaceNull(o.getSource()));
					el.addElement("IDENTIFIER").setText(StringUtil.replaceNull(o.getIdentifier()));
					el.addElement("LANGUAGE").setText(StringUtil.replaceNull(o.getLanguage()));
					el.addElement("RELATION").setText(StringUtil.replaceNull(o.getRelation()));
					el.addElement("COVERAGE").setText(StringUtil.replaceNull(o.getCoverage()));
					el.addElement("RIGHTS").setText(StringUtil.replaceNull(o.getRights()));
					el.addElement("MD5").setText(StringUtil.replaceNull(o.getMd5()));
					el.addElement("VERSION").setText(StringUtil.replaceNull(o.getVersion()));
					el.addElement("LOCATION").setText(StringUtil.replaceNull(o.getLocation()));
					el.addElement("FILEEXTENSION").setText(StringUtil.replaceNull(o.getFileextension()));
					el.addElement("DELETESTATUS").setText(StringUtil.replaceNull(o.getDeletestatus()));
					el.addElement("PROJECTNAME").setText(StringUtil.replaceNull(o.getProjectname()));
					rootEl.add(el);
				}
			}
			return rootEl;
		}

	public static List<RESUDP_SystemInfo> DeserializeRESUDP_SystemInfos(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_SystemInfo".equalsIgnoreCase(typeName)) {
				List<RESUDP_SystemInfo> values = new ArrayList<RESUDP_SystemInfo>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el = els.get(i);
					RESUDP_SystemInfo o = new RESUDP_SystemInfo();
					o.setDocumentid(el.element("DOCUMENTID").getText());
					o.setTitle(el.element("TITLE").getText());
					o.setCreator(el.element("CREATOR").getText());
					o.setSubject(el.element("SUBJECT").getText());
					o.setDescription(el.element("DESCRIPTION").getText());
					o.setPublisher(el.element("PUBLISHER").getText());
					o.setContributor(el.element("CONTRIBUTOR").getText());
					try
					{
						o.setDocumentdate(df.parse(el.element("DOCUMENTDATE").getText()));						
					}catch(Exception e) { }
					
					o.setType(el.element("TYPE").getText());
					o.setFormat(el.element("FORMAT").getText());
					o.setSource(el.element("SOURCE").getText());
					o.setIdentifier(el.element("IDENTIFIER").getText());
					o.setLanguage(el.element("LANGUAGE").getText());
					o.setRelation(el.element("RELATION").getText());
					o.setCoverage(el.element("COVERAGE").getText());
					o.setRights(el.element("RIGHTS").getText());
					o.setMd5(el.element("MD5").getText());
					o.setVersion(el.element("VERSION").getText());
					o.setLocation(el.element("LOCATION").getText());
					o.setFileextension(el.element("FILEEXTENSION").getText());
					o.setDeletestatus(el.element("DELETESTATUS").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	
	//序列化RESUDP_LawDocumentEntity对象
	public static Element SerializeRESUDP_LawDocumentEntities(List<RESUDP_LawDocumentEntity> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_LawDocumentEntity");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_LawDocumentEntity o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_LawDocumentEntity");
				el.addElement("DOCUMENTID").setText(o.getDocumentID());
				el.addElement("DOCUMENTNAME").setText(o.getDocumentName());
				el.addElement("ENTITYNO").setText(o.getEntityNo());
				el.addElement("DESCRIPTION").setText(o.getDescription());
				rootEl.add(el);
			}
		}
		return rootEl;
	}	
	//序列化、反序列化RESUDP_Question对象
	public static Element SerializeRESUDP_Questions(List<RESUDP_Question> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_Question");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_Question o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_Question");
				el.addElement("QUESTIONID").setText(o.getQuestionid());
				el.addElement("SUBJECT").setText(o.getSubject());
				el.addElement("TITLE").setText(o.getTitle());
				el.addElement("DESCRIPTION").setText(o.getDescription());
				el.addElement("ANSWER").setText(o.getAnswer());
				el.addElement("REFERENCENOTES").setText(o.getReferencenotes());
				el.addElement("EXAMPLE").setText(o.getExample());
				el.addElement("INTERPRETATION").setText(o.getInterpretation());
				el.addElement("NOTES").setText(o.getNotes());
				el.addElement("EXTENSIONFIELD1").setText(StringUtil.replaceNull(o.getExtensionfield1()));
				el.addElement("EXTENSIONFIELD2").setText(StringUtil.replaceNull(o.getExtensionfield2()));
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				
				rootEl.add(el);
			}
		}
		return rootEl;
	}

	public static List<RESUDP_Question> DeserializeRESUDP_Questions(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_Question".equalsIgnoreCase(typeName)) {
				List<RESUDP_Question> values = new ArrayList<RESUDP_Question>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RESUDP_Question o = new RESUDP_Question();
					o.setQuestionid(el.element("QUESTIONID").getText());
					o.setSubject(el.element("SUBJECT").getText());
					o.setTitle(el.element("TITLE").getText());
					o.setDescription(el.element("DESCRIPTION").getText());
					o.setAnswer(el.element("ANSWER").getText());
					o.setReferencenotes(el.element("REFERENCENOTES").getText());
					o.setExample(el.element("EXAMPLE").getText());
					o.setInterpretation(el.element("INTERPRETATION").getText());
					o.setNotes(el.element("NOTES").getText());
					o.setExtensionfield1(el.element("EXTENSIONFIELD1").getText());
					o.setExtensionfield2(el.element("EXTENSIONFIELD2").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	//序列化、反序列化RESUDP_QuestionLawRef对象
	public static Element SerializeRESUDP_QuestionLawRefs(List<RESUDP_QuestionLawRef> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_QuestionLawRef");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_QuestionLawRef o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_QuestionLawRef");
				el.addElement("TID").setText(String.valueOf(o.getTid()));			
				el.addElement("QUESTIONID").setText(o.getQuestionid());
				el.addElement("DOCUMENTID").setText(o.getDocumentid());
				el.addElement("DOCUMENTNAME").setText(o.getDocumentname());
				el.addElement("ENTITYNO").setText(StringUtil.replaceNull(o.getEntityno()));				
				el.addElement("DESCRIPTION").setText(StringUtil.replaceNull(o.getDescription()));
				el.addElement("EXTENSIONFIELD1").setText(StringUtil.replaceNull(o.getExtensionfield1()));
				el.addElement("EXTENSIONFIELD2").setText(StringUtil.replaceNull(o.getExtensionfield2()));
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				
				rootEl.add(el);
			}
		}
		return rootEl;
	}
	
	public static List<RESUDP_QuestionLawRef> DeserializeRESUDP_QuestionLawRefs(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_QuestionLawRef".equalsIgnoreCase(typeName)) {
				List<RESUDP_QuestionLawRef> values = new ArrayList<RESUDP_QuestionLawRef>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RESUDP_QuestionLawRef o = new RESUDP_QuestionLawRef();
					o.setTid(Integer.parseInt(el.element("TID").getText()));					
					o.setQuestionid(el.element("QUESTIONID").getText());
					o.setDocumentid(el.element("DOCUMENTID").getText());
					o.setDocumentname(el.element("DOCUMENTNAME").getText());
					o.setEntityno(el.element("ENTITYNO").getText());					
					o.setDescription(el.element("DESCRIPTION").getText());
					o.setExtensionfield1(el.element("EXTENSIONFIELD1").getText());
					o.setExtensionfield2(el.element("EXTENSIONFIELD2").getText());
					o.setProjectname(el.element("PROJECTNAME").getText());
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	//序列化 & 反序列化RESUDP_QuestionExample
	public static Element SerializeRESUDP_QuestionExamples(List<RESUDP_QuestionExample> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_QuestionExample");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_QuestionExample o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_QuestionExample");
				el.addElement("TID").setText(String.valueOf(o.getTid()));			
				el.addElement("QUESTIONID").setText(o.getQuestionid());
				el.addElement("CATALOGNODEID").setText(o.getCatalognodeid());
				el.addElement("CATALOGNODENAME").setText(o.getCatalognodename());
				el.addElement("NODETYPE").setText(o.getNodetype());				
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				
				rootEl.add(el);
			}
		}
		return rootEl;
	}
	
	public static List<RESUDP_QuestionExample> DeserializeRESUDP_QuestionExamples(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_QuestionExample".equalsIgnoreCase(typeName)) {
				List<RESUDP_QuestionExample> values = new ArrayList<RESUDP_QuestionExample>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RESUDP_QuestionExample o = new RESUDP_QuestionExample();
					o.setTid(Integer.parseInt(el.element("TID").getText()));					
					o.setQuestionid(el.element("QUESTIONID").getText());
					o.setCatalognodeid(el.element("CATALOGNODEID").getText());
					o.setCatalognodename(el.element("CATALOGNODENAME").getText());
					o.setNodetype(el.element("NODETYPE").getText());					
					o.setProjectname(el.element("PROJECTNAME").getText());
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	//序列化 & 反序列化 RESUDP_LawExample
	public static Element SerializeRESUDP_LawExamples(List<RESUDP_LawExample> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_LawExample");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_LawExample o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_LawExample");
				el.addElement("EXAMPLEID").setText(String.valueOf(o.getExampleid()));			
				el.addElement("SUBJECT").setText(o.getSubject());
				el.addElement("TITLE").setText(o.getTitle());
				el.addElement("EXAMPLE").setText(o.getExample());
				el.addElement("INTERPRETATION").setText(o.getInterpretation());				
				el.addElement("NOTES").setText(o.getNotes());						
				el.addElement("PROJECTNAME").setText(o.getProjectname());
				
				rootEl.add(el);
			}
		}
		return rootEl;
	}
	
	public static List<RESUDP_LawExample> DeserializeRESUDP_LawExamples(Element xmldata)
	{
		if((xmldata != null)&&("".equals(xmldata) == false)) 
		{
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String typeName = xmldata.attribute("Type").getText();
			if ("RESUDP_LawExample".equalsIgnoreCase(typeName)) {
				List<RESUDP_LawExample> values = new ArrayList<RESUDP_LawExample>();
				
				List<Element> els = xmldata.elements();
				int size = els.size();
				for(int i=0;i<size;i++)
				{
					Element el =els.get(i);
					RESUDP_LawExample o = new RESUDP_LawExample();
					o.setExampleid(el.element("EXAMPLEID").getText());
					o.setSubject(el.element("SUBJECT").getText());					
					o.setTitle(el.element("TITLE").getText());
					o.setExample(el.element("EXAMPLE").getText());					
					o.setInterpretation(el.element("INTERPRETATION").getText());
					o.setNotes(el.element("NOTES").getText());					
					o.setProjectname(el.element("PROJECTNAME").getText());
					
					values.add(o);
				}
				return values;
			}		
		}
		return null;
	}
	//序列化RESUDP_UserInfo对象
	public static Element SerializeRESUDP_UserInfos(List<RESUDP_UserInfo> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "RESUDP_UserInfo");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				RESUDP_UserInfo o = values.get(i);
				Element el = DocumentHelper.createElement("RESUDP_UserInfo");
				el.addElement("USERID").setText(o.getUserid());			
				el.addElement("USERNAME").setText(o.getUsername());
				el.addElement("LOGINNAME").setText(o.getLoginname());
				
				rootEl.add(el);
			}
		}
		return rootEl;
	}

	//序列化QuestionQueryResultObj对象
	public static Element SerializeQuestionQueryResultObj(List<QuestionQueryResultObj> values)
	{
		Element rootEl = DocumentHelper.createElement("Root");
		rootEl.addAttribute("Type", "QuestionQueryResultObj");
		if(values != null)
		{
			int size = values.size();
			for(int i=0;i<size;i++)
			{
				QuestionQueryResultObj o = values.get(i);
				Element el = DocumentHelper.createElement("QuestionQueryResultObj");
				el.addElement("CAPTIONTEXT").setText(o.getCaptiontext());			
				el.addElement("QUESTIONURL").setText(o.getQuestionID());
				
				rootEl.add(el);
			}
		}
		return rootEl;
	}
	
}

