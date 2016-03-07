package org.izhong.expert.util;

/* *
 *功能：设置帐户有关信息及返回路径（基础配置页面）
 *版本：3.0
 *日期：2010-06-18
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.访问支付宝首页(www.alipay.com)，然后用您的签约支付宝账号登陆.
 *2.点击导航栏中的“商家服务”，即可查看
	
 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 * */



public class AlipayConfig {
	// partner和key提取方法：登陆签约支付宝账户--->点击“商家服务”就可以看到
	public static String partner = "2088201395250311"; // 合作身份者ID@@@@@@@@@@@@@@@@@@@不同
	public static String key = "ze106kdrsulgsncuxbsl1nsqfuhdk5z4"; // 安全检验码
	public static String sellerEmail = "zhangdj@izhong.com"; // 签约支付宝账号或卖家收款支付宝帐户
//	public static String partner = "2088012023823605";
//	public static String key = "1rcvlagdo6cxw6iypg16wfx0zba6md7b";
//	public static String sellerEmail = "wyayw007@126.com";
	public static String input_charset = "UTF-8";
    public static String transport = "http";
	public static String sign_type = "MD5"; // 加密方式 不需修改
	// notify_url 交易过程中服务器通知的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	public static String notify_url = "http://www.xue24.com/payment/notify_url.jsp";
	public static String HAUFE_NOTIFY_URL="http://zhuanjia.izhong.com/payment/notify_url.jsp";
//	public static String HAUFE_NOTIFY_URL="http://127.0.0.1:8999/ExpertQA/payment/notify_url.jsp";
	
	// 付完款后跳转的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	//public static String return_url = "http://www.izhong.com/alipaycallbackforshoppingcart"; 
	//public static String return_url = "http://192.168.50.165:8080/iws/alipaycallbackforshoppingcart"; 
	//public static String return_url = "http://192.168.50.165:8080/iws/alipaycallbackforshoppingcart";
	//在线支付返回地址
	public static String return_url = "http://192.168.50.24:8080/ExpertQA/alipaycallback";
	//快捷登录跳转地址
	public static String return_LoginUrl = "192.168.50.165:8080/iws/accounts/loginAlipay"; 
	//支付宝快捷登录物流地址返回地址
	public static String return_AddressUrl = "192.168.50.165:8080/iws/accounts/addressAlipay"; 
	// 原izhong在线支付，付款后返回页面
	/*public static String return_OnlineUrl = "http://192.168.50.105:8080/information/onlinePayment_paymentTakeOrderWith.action";*/
	//public static String return_OnlineUrl = "http://192.168.50.165:8080/iws/order/alipaycallback";
	//public static String return_OnlineUrl = "http://192.168.50.24/ExpertQA/alipaycallback";
	public static String return_OnlineUrl = "http://zhuanjia.haufe.cn/alipaycallback";
//	public static String return_BuyOnline = "http://zhuanjia.haufe.cn/buyOnlineCallback";
	public static String return_BuyOnline = "http://127.0.0.1:8080/ExpertQA/buyOnlineCallback";
	//用于LP的boss定价landingPage，返回调用
	public static String return_OnlineUrlForBosscp = "http://zhuanjia.haufe.cn/order/alipaycallbackforbosscp";
	
	// LandingPage用，付款后返回页面
	/*public static String return_LPUrl = "http://192.168.50.198/lp_friendRecommend.action";*/
	
								//"http://192.168.3.138:8080/college/payment/return_url.jsp"; 
	
	public static String show_url = "http://www.izhong.com"; // 网站商品的展示地址，不允许加?id=123这类自定义参数
	public static String HAUFE_SHOW_URL = "http://www.haufe.cn";
	
	public static String antiphishing  = "0";     //防钓鱼功能开关，'0'表示该功能关闭，'1'表示该功能开启。默认为关闭
	/*
	 * '一旦开启，就无法关闭，根据商家自身网站情况请慎重选择是否开启。
	 * '申请开通方法：联系我们的客户经理或拨打商户服务电话0571-88158090，帮忙申请开 '若要使用防钓鱼功能，建议使用POST方式请求数据
	 * 开启防钓鱼功能后，服务器、本机电脑必须支持远程XML解析，请配置好该环境。
	 * 若要使用防钓鱼功能，建议使用POST方式请求数据，且请打开class文件夹中Alipay_fuction.java文件，找到该文件最下方的creatteInvokeUrl函数
	 */
	
	/**
	 * 支付宝接口参数，不能修改
	 */
	public static String paygateway = "https://mapi.alipay.com/gateway.do?"; //支付接口（不可以修改）
	public static String service = "create_direct_pay_by_user";//快速付款交易服务（不可以修改）
	public static String payment_type = "1";//支付宝类型.1代表商品购买（目前填写1即可，不可以修改）
	public static String paymethod = ""; //默认支付方式，四个值可选：bankPay(网银); cartoon(卡通); directPay(余额); CASH(网点支付)
	public static String defaultbank = ""; //默认网银代号，代号列表见http://club.alipay.com/read.php?tid=8681379
//	
	/**
	 * 扩展参数·
	 */
	//扩展功能参数——防钓鱼功能控制参数
	//使用一下参数需要导入dom4j包，以及打开alipay_fuction类中的parseAlipayTimestampResultXml方法
	//若使用此参数，功能自动打开，若要关闭需要联系签约客户经理进行关闭。
	public static String exter_invoke_ip = "";
	public static String anti_phishing_key = "";
	
//	if(AlipayConfig.antiphishing.equals("1"))
//	{
//		exter_invoke_ip = request.getRemoteAddr();//"10.5.20.4";   //用户在外部系统创建交易时，由外部系统记录的用户IP地址
//		anti_phishing_key = new Alipay_fuction().parseAlipayTimestampResultXml(new Alipay_fuction().creatteInvokeUrl()); //通过时间戳查询接口（见文档4）获取的加密支付宝系统时间戳，有效时间：30秒。
//	}
	
	//扩展功能参数——分润(若要使用，请按照注释要求的格式赋值)
	//提成信息集，与需要结合商户网站自身情况动态获取每笔交易的各分润收款账号、各分润金额、各分润说明。最多只能设置10条
	//提成信息集格式为：收款方Email_1^金额1^备注1|收款方Email_2^金额2^备注2
	//如：
	//royalty_type = "10"
	//royalty_parameters	= "111@126.com^0.01^分润备注一|222@126.com^0.01^分润备注二"

	//扩展功能参数——自定义超时(若要使用，请按照注释要求的格式赋值)
	//该功能默认不开通，需联系客户经理咨询
	public static String it_b_pay = "1"; //超时时间，不填默认是15天。八个值可选：1h(1小时),2h(2小时),3h(3小时),1d(1天),3d(3天),7d(7天),15d(15天),1c(当天

	//扩展功能参数——其他
	public static String buyer_email = "";   //买家账户，例如：alipay@alipay.com
	public static String extra_common_param = "买家账户ID：";//+ userId; //自定义参数，可存放任何内容（除=、&等特殊字符外），不会显示在页面上
	
}
