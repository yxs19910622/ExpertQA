
<%@page import="org.izhong.expert.util.Alipay_fuction"%>
<%@page import="org.izhong.expert.util.AlipayConfig"%>
<%
	/* *
	 功能：支付宝主动通知调用的页面（通知页）
	 版本：3.0
	 日期：2010-06-22
	 说明：
	 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
	 //***********页面功能说明***********
	*创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
	*该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
	*该页面调试工具请使用写文本函数log_result，该函数已被默认开启，见Alipay_fuction.java中的函数sign
	*TRADE_FINISHED(表示交易已经成功结束，通用即时到帐反馈的交易状态成功标志);
	*TRADE_SUCCESS(表示交易已经成功结束，高级即时到帐反馈的交易状态成功标志);
	*该通知页面主要功能是：对于返回页面（return_url.jsp）做补单处理。如果没有收到该页面返回的 success 信息，支付宝会在24小时内按一定的时间策略重发通知
	 //********************************
	 * */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	String partner = AlipayConfig.partner; //支付宝合作伙伴id (账户内提取)
	String privateKey = AlipayConfig.key; //支付宝安全校验码(账户内提取)
	//**********************************************************************************
	//如果您服务器不支持https交互，可以使用http的验证查询地址
	/*注意下面的注释，如果在测试的时候导致response等于空值的情况，请将下面一个注释，打开上面一个验证连接，另外检查本地端口，
	  请挡开80或者443端口*/
	//String alipayNotifyURL = "https://www.alipay.com/cooperate/gateway.do?service=notify_verify"
	String alipayNotifyURL = "http://notify.alipay.com/trade/notify_query.do?"
			+ "partner="
			+ partner
			+ "&notify_id="
			+ request.getParameter("notify_id");
	//**********************************************************************************

	//获取支付宝ATN返回结果，true是正确的订单信息，false 是无效的
	String responseTxt = Alipay_fuction.checkurl(alipayNotifyURL);

	Map params = new HashMap();
	//获得POST 过来参数设置到新的params中
	Map requestParams = request.getParameterMap();
	for (Iterator iter = requestParams.keySet().iterator(); iter
			.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//*乱码解决，这段代码在出现乱码时使用,但是不一定能解决所有的问题，所以建议写过滤器实现编码控制。
		//如果mysign和sign不相等也可以使用这段代码转化*/
		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8"); //乱码解决
		params.put(name, valueStr);
	}

	String mysign = Alipay_fuction.sign(params, privateKey, request);
	//最好是在异步做日志动作，可以记录mysign、sign、resposenTXT和其他值，方便以后查询错误。
	if (mysign.equals(request.getParameter("sign"))
			&& responseTxt.equals("true")) {
		/*可以在不同状态下获取订单信息，操作商户数据库使数据同步*/
		//以下输出测试时候用，可以删除
		String get_order = request.getParameter("out_trade_no");
		String get_total_fee = request.getParameter("total_fee");
		String get_subject = new String(request.getParameter("subject")
				.getBytes("ISO-8859-1"), "UTF-8");
		String get_body = new String(request.getParameter("body")
				.getBytes("ISO-8859-1"), "UTF-8");
		if (request.getParameter("trade_status").equals(
				"WAIT_BUYER_PAY")) {
			//等待买家付款
			//在这里可以写入数据库处理
			out.println("success"); //注意一定要返回给支付宝一个成功的信息(不包含HTML脚本语言)
		} else if (request.getParameter("trade_status").equals(
				"TRADE_FINISHED")
				|| request.getParameter("trade_status").equals(
						"TRADE_SUCCESS")) {
			//支付成功，在这里可以写入数据处理,
			out.println("success"); //注意一定要返回给支付宝一个成功的信息(不包含HTML脚本语言)
		}
	} else {
		out.println("fail");
		//打印，收到消息比对sign的计算结果和传递来的sign是否匹配
		out.println(mysign + "-------"
				+ request.getParameter("sign") + "<br>");
	}
%>
