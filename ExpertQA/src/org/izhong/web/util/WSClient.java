package org.izhong.web.util;

import java.io.IOException;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class WSClient {
	
//	public static Object[] invoke(String method,Object param)
//	{
//		//String endpointURL = "http://192.168.50.131:9999/ExpertQA/services/UserService?wsdl";
//		String endpointURL = "http://192.168.50.131:9999/ExpertQA/services/UserService.UserServiceHttpSoap11Endpoint";
//		String namespaceURL = "http://expert.web.izhong.org";
//		Object [] result = null;
//		try {
//			RPCServiceClient rpcSC = new RPCServiceClient();
//			Options options = rpcSC.getOptions();
//			EndpointReference erf = new EndpointReference(endpointURL);
//			options.setTo(erf);
//			QName qname = new QName(namespaceURL, method);
//			Object [] sendData = new Object []{param};
//			result = rpcSC.invokeBlocking(qname, sendData, new Class []{String.class});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	public static void main(String[] args) throws IOException {
//		byte[] bytes = null;
//		bytes = "AB4Uifh0HwKAg3y01b43ek3Y+PaX6prCaEhllS74MNUqVuJE+ehzfmWnLrVmAscu36hUf806IBFeBeJ7MnHlhykXMQBhgKSeTg2GvAAAAA==".getBytes();
		Element result = DocumentHelper.createElement("Root");
		result.addElement("LoginName");
		result.addElement("PassWord");
		result.addElement("DeviceSN").addText("077420139B52983D0");
//		DownloadPackage dpk = SevenZipCompression.Compression("UserInfo", result);

		//SevenZipCompression.Compression("Items", result);
		
//		DownloadFileItem item = new DownloadFileItem();
//		item.setAfterLength(79);
//		item.setBeforeLength(88);
//		item.setItemName("UserInfo");
//		item.setBytes(bytes);
//		
//		DownloadFileItem[] items = new DownloadFileItem[1];
//		items[0] = item;
//		
//		DownloadPackage dpk = new DownloadPackage();
//		dpk.setCount(1);
//		dpk.setItems(items);
		
//		WSClient.invoke("GetSystemDataTime", dpk);
	}
}
