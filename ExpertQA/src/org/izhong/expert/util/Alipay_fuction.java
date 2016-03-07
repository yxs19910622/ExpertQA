package org.izhong.expert.util;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;



/**
 *功能：支付宝接口公用函数
 *详细：该页面是请求、通知返回两个文件所调用的公用函数核心处理文件，不需要修改
 *版本：3.0
 *修改日期：2010-06-22
 '说明：
 '以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 '该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

*/

public class Alipay_fuction
{
	/**
	 * 用户使用支付宝支付是否成功
	 * @param request
	 * @return
	 */
	public static Boolean isAlipaySuccess(HttpServletRequest request)
	{
		//支付是否成功
		Boolean isAlipaySuccess = false;
		
		//获得支付成功后支付宝返回的sign值
		String sign = request.getParameter("sign");
		
		//计算我的sign值
		String mySign = getMyReturnSign(request);
		
		//获取支付宝ATN返回结果
		String responseTxt = getResponseTxt(request);
		
		if (mySign.equals(sign)&& responseTxt.equals("true"))
		{
			/*if ("TRADE_FINISHED".equals(request.getParameter("trade_status")) || "TRADE_SUCCESS".equals(request.getParameter("trade_status")))*/
			if ("TRADE_SUCCESS".equals(request.getParameter("trade_status")))
			{
				isAlipaySuccess = true;
			}
		}
		return isAlipaySuccess;
	}

	/**
	 * 获取支付宝ATN返回结果
	 * @param request
	 * @return
	 */
	public static String getResponseTxt(HttpServletRequest request)
	{
		String responseTxt = "";
		
		//支付宝合作伙伴id (账户内提取)
		String partner = AlipayConfig.partner;
		
		//**********************************************************************************
		//如果您服务器不支持https交互，可以使用http的验证查询地址
		//*注意下面的注释，如果在测试的时候导致response等于空值的情况，请将下面一个注释，打开上面一个验证连接，另外检查本地端口，
		//请打开80或者443端口
		//String alipayNotifyURL = "https://www.alipay.com/cooperate/gateway.do?service=notify_verify"
		String alipayNotifyURL = "http://notify.alipay.com/trade/notify_query.do?"
									+ "partner="
									+ partner
									+ "&notify_id="
									+ request.getParameter("notify_id");
		//**********************************************************************************
		//mysign.equals(request.getParameter("sign")判断交易信息是否一致
		// responseTxt.equals("true")判断数据来源是否是支付宝
		//获取支付宝ATN返回结果，true是正确的订单信息，false 是无效的
		responseTxt = Alipay_fuction.checkurl(alipayNotifyURL);
		
		return responseTxt;
	}
	
	/**
	 * 通过支付宝返回参数，计算出我自己的 （返回）sign
	 * @param request
	 * @return
	 */
	public static String getMyReturnSign(HttpServletRequest request)
	{
		String myReturnSign = "";
		
		//支付宝安全校验码(账户内提取)
		String privateKey = AlipayConfig.key;


		//获得POST 过来参数设置到新的params中
		Map params = new HashMap();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();)
		{
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++)
			{
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				//System.out.println("valueStr:"+valueStr);
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化（现在已经使用）
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.put(name, valueStr);
		}

		myReturnSign = Alipay_fuction.sign(params,privateKey,request);

		return myReturnSign;
	}
	
	
	// 对支付成功返回参数进行遍历
	public static String sign(Map params, String privateKey, HttpServletRequest request) {
		Properties properties = new Properties();

		for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			Object value = params.get(name);

			if (name == null || name.equalsIgnoreCase("sign")
					|| name.equalsIgnoreCase("sign_type")) {
				continue;
			}

			properties.setProperty(name, value.toString());
			
		}
		String content = getSignatureContent(properties);

		if (privateKey == null) {
			return null;
		}
		String signBefore = content + privateKey;
		//System.out.print("signBefore===" + signBefore);
		// *****************************************************************
		// 当alipay收到信息，会把接受的信息写程日志
		// 该文件存在于和应用服务器 启动文件同一目录下，文件名是alipay log加服务器时间
		try {
			String xpath = request.getSession().getServletContext().getRealPath("/") + "paylogfiles/alipay" + File.separator;
			File path = new File(xpath);
			if( !path.exists() ) {
				path.mkdir();
			}
			FileWriter writer = new FileWriter(xpath + "alipay_log"
					+ System.currentTimeMillis() + ".txt");
			writer.write(signBefore);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// *********************************************************************
			return AlipayMd5Encrypt.md5(signBefore);

	}

	/** 
	 * 功能：对交易返回参数按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * @param properties
	 * @return
	 */
	public static String getSignatureContent(Properties properties) {
		StringBuffer content = new StringBuffer();
		List keys = new ArrayList(properties.keySet());
		Collections.sort(keys);

		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = properties.getProperty(key);

			content.append((i == 0 ? "" : "&") + key + "=" + value);
		}
		
		return content.toString();
	}

	/** 
	 * 功能：将安全校验码和参数排序 形成需要签名的字符串 参数集合
	 * @param params
	 *            安全校验码
	 * @param privateKey
	 */
	public static String getContent_public(Map params, String privateKey) {
		List keys = new ArrayList(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = (String) params.get(key);

			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		

		return prestr + privateKey;
	}

	/**
	 * *功能：验证返回URL, ATN的正确性 check URL
	 * @param urlvalue
	 * @return
	 */

	public static String checkurl(String urlvalue) {

		String inputLine = "";

		try {
			URL url = new URL(urlvalue);

			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));

			inputLine = in.readLine().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		// 系统打印出抓取得验证结果
		/*
		 * 输出对应的参数对应错误： 1.invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 2.true
		 * 返回正确信息 3.false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
		 */
		return inputLine;
	}

	/**
	 * 功能：形成调用 alipay时间戳接口的url
	 * @return
	 */
	 
	public String creatteInvokeUrl() {
		Map params = new HashMap();
		params.put("service", "query_timestamp");
		params.put("partner", AlipayConfig.partner);
		params.put("_input_charset", AlipayConfig.input_charset);

		// 获的md5后的签名
		String prestr = "";
		prestr = prestr + AlipayConfig.key;
		String sign = AlipayMd5Encrypt.md5(getContent_public(params,
				AlipayConfig.key));

		// 拼接调用的url
		String parameter = "";
		parameter = parameter + "https://mapi.alipay.com/gateway.do?";
		List keys = new ArrayList(params.keySet());

		for (int i = 0; i < keys.size(); i++) {
			String value = (String) params.get(keys.get(i));
			if (value == null || value.trim().length() == 0) {
				continue;
			}
			try {
				parameter = parameter + keys.get(i) + "="
						+ URLEncoder.encode(value, AlipayConfig.input_charset) + "&";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}// for end
		parameter = parameter + "sign=" + sign + "&sign_type=" + "MD5";
		
		return parameter;
	}


	
	/**
	 * 功能：解析xml
	 * @param result
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @throws MalformedURLException
	 */

	public String parseAlipayTimestampResultXml(String filepath)
			throws MalformedURLException, DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new URL(filepath).openStream());

		List<Node> nodeList = doc.selectNodes("//alipay/*");
		StringBuffer buf1 = new StringBuffer();
		for (Node node : nodeList) {
			// 截取部分不需要解析的信息
			if (node.getName().equals("is_success")
					&& node.getText().equals("T")) {
				// 判断是否有成功标示
				List<Node> nodeList1 = doc
						.selectNodes("//response/timestamp/*");
				for (Node node1 : nodeList1) {
					buf1.append(node1.getText());
				}
			}
		}
		
		return buf1.toString();
	}
	

}
