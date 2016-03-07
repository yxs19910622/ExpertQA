package org.izhong.expert.util;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;



/**
 *类名：alipay_service
 *功能：支付宝外部服务接口控制
 *详细：该页面是请求参数核心处理文件，不需要修改
 *版本：3.0
 *修改日期：2010-06-22
 *说明：
  以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
  该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class Payment {
	/**
	 * 功能：生成网关url方法
	 * 
	 * @param paygateway
	 *            服务参数
	 * @param service
	 *            签名类型
	 * @param sign_type
	 *            外部订单号
	 * @param out_trade_no
	 *            编码机制
	 * @param input_charset
	 *            合作者ID
	 * @param partner
	 *            安全校验码
	 * @param key
	 *            商品展示地址
	 * @param show_url
	 *            商品描述
	 * @param body
	 *            商品价格
	 * @param total_fee
	 *            支付类型
	 * @param payment_type
	 *            卖家账户
	 * @param seller_email
	 *            商品名称
	 * @param subject
	 *            异步返回地址
	 * @param notify_url
	 *            同步返回地址
	 * @param return_url
	 *            支付方式
	 * @param paymethod
	 *            默认银行
	 * @param defaultbank
	 * @return
	 * 
	 */
	
	private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    public static String alipay_auth_authorize(Map<String, String> sParaTemp) {

    	//增加基本配置
        sParaTemp.put("service", "alipay.auth.authorize");
        sParaTemp.put("target_service", "user.auth.quick.login");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("return_url", AlipayConfig.return_LoginUrl);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);

        String strButtonName = "确认";

        return AlipaySubmit.buildForm(sParaTemp, ALIPAY_GATEWAY_NEW, "get", strButtonName);
    }
	
	
    public static String user_logistics_address_query(Map<String, String> sParaTemp) {

    	//增加基本配置
        sParaTemp.put("service", "user.logistics.address.query");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("return_url", AlipayConfig.return_AddressUrl);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        String strButtonName = "确认";

        return AlipaySubmit.buildForm(sParaTemp, ALIPAY_GATEWAY_NEW, "get", strButtonName);
    }
    
    
	public static String CreateUrl_Get(String extra_common_param, String paygateway, String service,
			String sign_type, String out_trade_no, String input_charset,
			String partner, String key, String show_url, String body,
			String total_fee, String payment_type, String seller_email,
			String subject, String notify_url, String return_url,
			String paymethod, String defaultbank
			) {// , String it_b_pay

		Map params = new HashMap();
		params.put("service", service);
		params.put("partner", partner);
		params.put("subject", subject);
		params.put("body", body);
		params.put("out_trade_no", out_trade_no);
		params.put("total_fee", total_fee);
		params.put("show_url", show_url);
		params.put("payment_type", payment_type);
		params.put("seller_email", seller_email);
		params.put("return_url", return_url);
		params.put("notify_url", notify_url);
		params.put("paymethod", paymethod);
		params.put("defaultbank", defaultbank);
		params.put("_input_charset", input_charset);
		// 增加自定义参数
		params.put("extra_common_param", extra_common_param);
		// params.put("it_b_pay", it_b_pay);

		Map<String, String> paramsNew= AlipayCore.paraFilter(params);  //去除空字符串，王金川、
		
		// 调用MD5加密方法生成sign值，
		// 公式:MD5(对待加密参数字母升序排序+key)]
		// String sign = com.alipay.util.Md5Encrypt.md5(getContent(params,
		// key));
		Alipay_fuction af = new Alipay_fuction();
		// String content= af.getContent_public(params,key);
		String sign = org.izhong.expert.util.AlipayMd5Encrypt.md5(af.getContent_public(
				paramsNew, key));

		// 对所有参数进行连接并编译
		String parameter = "";
		parameter = parameter + paygateway;
		List keys = new ArrayList(params.keySet());
		for (int i = 0; i < keys.size(); i++) {
			try {
				parameter = parameter
						+ keys.get(i)
						+ "="
						+ URLEncoder.encode((String) params.get(keys.get(i)),
								input_charset) + "&";
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}
		}

		parameter = parameter + "sign=" + sign + "&sign_type=" + sign_type;

		return parameter;

	}

	
	public static String CreateUrl_Get_Token(String extra_common_param, String paygateway, String service,
			String sign_type, String out_trade_no, String input_charset,
			String partner, String key, String show_url, String body,
			String total_fee, String payment_type, String seller_email,
			String subject, String notify_url, String return_url,
			String paymethod, String defaultbank,String token
			) {// , String it_b_pay,token为快捷登录即时到帐改造！

		Map params = new HashMap();
		params.put("service", service);
		params.put("partner", partner);
		params.put("subject", subject);
		params.put("body", body);
		params.put("out_trade_no", out_trade_no);
		params.put("total_fee", total_fee);
		params.put("show_url", show_url);
		params.put("payment_type", payment_type);
		params.put("seller_email", seller_email);
		params.put("return_url", return_url);
		params.put("notify_url", notify_url);
		params.put("paymethod", paymethod);
		params.put("defaultbank", defaultbank);
		params.put("_input_charset", input_charset);
		//token 快捷登录授权令牌
		params.put("token", token);
		// 增加自定义参数
		params.put("extra_common_param", extra_common_param);
		// params.put("it_b_pay", it_b_pay);

		Map<String, String> paramsNew= AlipayCore.paraFilter(params);  //去除空字符串，王金川、
		
		// 调用MD5加密方法生成sign值，
		// 公式:MD5(对待加密参数字母升序排序+key)]
		// String sign = com.alipay.util.Md5Encrypt.md5(getContent(params,
		// key));
		Alipay_fuction af = new Alipay_fuction();
		// String content= af.getContent_public(params,key);
		String sign = org.izhong.expert.util.AlipayMd5Encrypt.md5(af.getContent_public(
				paramsNew, key));

		// 对所有参数进行连接并编译
		String parameter = "";
		parameter = parameter + paygateway;
		List keys = new ArrayList(params.keySet());
		for (int i = 0; i < keys.size(); i++) {
			try {
				parameter = parameter
						+ keys.get(i)
						+ "="
						+ URLEncoder.encode((String) params.get(keys.get(i)),
								input_charset) + "&";
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}
		}

		parameter = parameter + "sign=" + sign + "&sign_type=" + sign_type;

		return parameter;

	}
	
	
	
	/**
	 * get方式，只需要得到返回的url既可，
	 * 点击此url链接地址，既可跳转到支付宝支付页面
	 * 
	 * @author Liping
	 * 
	 * @param out_trade_no
	 *            订单号
	 * @param body
	 *            产品描述
	 * @param total_fee
	 *            总金额
	 * @param subject
	 *            产品名称
	 * @return 构造好的url
	 */
	public static String CreateUrl_Get(String extra_common_param, String out_trade_no, String body, String total_fee, String subject)
	{
		String url = CreateUrl_Get(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.show_url, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.notify_url,AlipayConfig.return_url, AlipayConfig.paymethod,AlipayConfig.defaultbank);
		return url;
	}
	//网银直连wangjc20120222
	
	public static String CreateUrl_Get_Online(String extra_common_param, String out_trade_no, String body, String total_fee, String subject,String paymethod, String defaultbank)
	{
		String url = CreateUrl_Get(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.show_url, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.notify_url,AlipayConfig.return_url,paymethod,defaultbank);
		return url;
	}
	
	
	//快捷登录后的支付宝即时到帐支付，含token免登陆支付宝
	
	public static String CreateUrl_Get_Token(String extra_common_param, String out_trade_no, String body, String total_fee, String subject,String token)
	{
		String url = CreateUrl_Get_Token(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.show_url, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.notify_url,AlipayConfig.return_url, AlipayConfig.paymethod,AlipayConfig.defaultbank,token);
		return url;
	}
	
	
	/**
	 * get方式，只需要得到返回的url既可，
	 * 点击此url链接地址，既可跳转到支付宝支付页面
	 * url 与上一个不同此处用于原izhong在线支付
	 * @author zhaoqs
	 * 
	 * @param out_trade_no
	 *            订单号
	 * @param body
	 *            产品描述
	 * @param total_fee
	 *            总金额
	 * @param subject
	 *            产品名称
	 * @return 构造好的url
	 */
	public static String CreateUrl_Get1(String extra_common_param, String out_trade_no, String body, String total_fee, String subject)
	{
		String url = CreateUrl_Get(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.show_url, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.notify_url, AlipayConfig.return_OnlineUrl, AlipayConfig.paymethod, AlipayConfig.defaultbank);
		return url;
	}
	//wanjc  首页支付
	
	public static String CreateUrl_Get_1(String extra_common_param, String out_trade_no, String body, String total_fee, String subject,String paymethod, String defaultbank)
	{
		String url = CreateUrl_Get(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.show_url, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.notify_url, AlipayConfig.return_OnlineUrl,paymethod,defaultbank);
		return url;
	}
	
	/**
	 * haufe.com
	 * @param extra_common_param
	 * @param out_trade_no
	 * @param body
	 * @param total_fee
	 * @param subject
	 * @return
	 * @author whz
	 */
	public static String CreateUrl_Get_2(String extra_common_param, String out_trade_no, String body, String total_fee, String subject)
	{
		String url = CreateUrl_Get(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.HAUFE_SHOW_URL, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.HAUFE_NOTIFY_URL, AlipayConfig.return_BuyOnline, AlipayConfig.paymethod, AlipayConfig.defaultbank);
		return url;
	}
	/**
	 * haufe.com
	 * @param extra_common_param
	 * @param out_trade_no
	 * @param body
	 * @param total_fee
	 * @param subject
	 * @param paymethod
	 * @param defaultbank
	 * @return
	 * @author whz
	 */
	public static String CreateUrl_Get_3(String extra_common_param, String out_trade_no, String body, String total_fee, String subject,String paymethod, String defaultbank)
	{
		String url = CreateUrl_Get(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.HAUFE_SHOW_URL, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.HAUFE_NOTIFY_URL, AlipayConfig.return_BuyOnline,paymethod,defaultbank);
		return url;
	}
	/**
	 * get方式，只需要得到返回的url既可，
	 * 点击此url链接地址，既可跳转到支付宝支付页面
	 * url 此处用lp定价在线支付，
	 * @author zhaoqs
	 * 
	 * @param out_trade_no
	 *            订单号
	 * @param body
	 *            产品描述
	 * @param total_fee
	 *            总金额
	 * @param subject
	 *            产品名称
	 * @return 构造好的url
	 */
	public static String CreateUrl_Get2(String extra_common_param, String out_trade_no, String body, String total_fee, String subject)
	{
		String url = CreateUrl_Get(extra_common_param, AlipayConfig.paygateway, AlipayConfig.service, AlipayConfig.sign_type, out_trade_no, AlipayConfig.input_charset, AlipayConfig.partner, AlipayConfig.key, AlipayConfig.show_url, body, total_fee, AlipayConfig.payment_type, AlipayConfig.sellerEmail, subject, AlipayConfig.notify_url, AlipayConfig.return_OnlineUrlForBosscp,AlipayConfig.paymethod, AlipayConfig.defaultbank);
		return url;
	}
	
	/**
	 * post方式提交，以表单的方式提交，参数需要存放在表单的隐藏域中
	 * 此方法是为了构造表单隐藏域中的其中一个参数 “sign”
	 * @param paygateway
	 * @param service
	 * @param sign_type
	 * @param out_trade_no
	 * @param input_charset
	 * @param partner
	 * @param key
	 * @param show_url
	 * @param body
	 * @param total_fee
	 * @param payment_type
	 * @param seller_email
	 * @param subject
	 * @param notify_url
	 * @param return_url
	 * @param paymethod
	 * @param defaultbank
	 * @return 计算出来的sign
	 */
	public static String CreateUrl_Post(String extra_common_param, String paygateway, String service,
			String sign_type, String out_trade_no, String input_charset,
			String partner, String key, String show_url, String body,
			String total_fee, String payment_type, String seller_email,
			String subject, String notify_url, String return_url,
			String paymethod, String defaultbank) {// , String it_b_pay

		Map<String, String> params = new HashMap<String, String>();
		params.put("service", service);
		params.put("partner", partner);
		params.put("subject", subject);
		params.put("body", body);
		params.put("out_trade_no", out_trade_no);
		params.put("total_fee", total_fee);
		params.put("show_url", show_url);
		params.put("payment_type", payment_type);
		params.put("seller_email", seller_email);
		params.put("return_url", return_url);
		params.put("notify_url", notify_url);
		params.put("defaultbank", defaultbank);
		params.put("defaultbank", defaultbank);
		params.put("_input_charset", input_charset);
		// 增加自定义参数
		params.put("extra_common_param", extra_common_param);

		Map<String, String> paramsNew= AlipayCore.paraFilter(params);
		
		String prestr = "";
		prestr = prestr + key;
		Alipay_fuction af = new Alipay_fuction();
		// String content= af.getContent_public(params,key);
		String sign = org.izhong.expert.util.AlipayMd5Encrypt.md5(af.getContent_public(
				paramsNew, key));
		return sign;

	}

}
