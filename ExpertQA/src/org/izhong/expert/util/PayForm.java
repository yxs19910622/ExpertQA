package org.izhong.expert.util;




/**
 * 封装了支付宝的参数
 * 
 * @author Liping
 * 
 */
public class PayForm
{
	/**
	 * 用户id(回显)
	 */
	private String userId;
	
	/**
	 * 订单名称
	 */
	private String paySubject;
	
	/**
	 * 订单总金额
	 */
	private String totalFee;
	
	/**
	 * 支付（产品）描述
	 */
	private String body;

	// 隐藏域参数

	/**
	 * extra_common_param
	 * 自定义参数，这里存放订单id，用于修改支付状态
	 */
	private String orderId;
	/**
	 * 我们的订单号（同orderCode）
	 */
	private String outTradeNo;
	
	/**
	 * 通知页
	 */
	private String notifyUrl = AlipayConfig.notify_url;
	
	/**
	 * 合作伙伴ID（支付宝提供给我们卖家）
	 */
	private String partner = AlipayConfig.partner;
	
	/**
	 * 支付宝类型.1代表商品购买（目前填写1即可，不可以修改）
	 */
	private String paymentType = "1";
	
	/**
	 * 卖家Email
	 */
	private String sellerEmail = AlipayConfig.sellerEmail;
	
	/**
	 * 快速付款交易服务（不可以修改）
	 */
	private String service = "create_direct_pay_by_user";
	
	/**
	 * 所有的参数通过加密后得到的值
	 */
	private String sign;
	
	/**
	 * 加密方式
	 */
	private String signType = AlipayConfig.sign_type;
	
	/**
	 * 产品展示页，在淘宝支付页，作为产品名称的链接
	 */
	private String showUrl = AlipayConfig.show_url;
	
	/**
	 * 分润
	 */
	// private String royaltyParameters;
	
	/**
	 * 分 润备注,不需要填写
	 */
	// private String royaltyType;
	
	/**
	 * 支付成功返回页面
	 */
	private String returnUrl = AlipayConfig.return_url;
	
	/**
	 * 默认支付方式，四个值可选：bankPay(网银); cartoon(卡通); directPay(余额); CASH(网点支付)
	 */
	private String payMethod = "bankPay";
	
	/**
	 * 默认网银代号，代号列表见http://club.alipay.com/read.php?tid=8681379
	 */
	private String defaultBank = "CMB";

	// 生成url的参数
	/**
	 * 支付接口（不可以修改）
	 */
	private String paygateway = "https://www.alipay.com/gateway.do?";
	
	/**
	 * 编码，跟在paygateway后面。
	 */
	private String inputCharset = AlipayConfig.input_charset;
	
	/**
	 * 支付宝提供的安全检验码
	 */
	private String key = AlipayConfig.key;

	/*
	 * constructors
	 */
	public PayForm()
	{}
	
	/**
	 * 存放传给页面隐藏域的参数
	 * @param userId 用户ID（买家）
	 * @param orderCode 订单号
	 * @param paySubject 订购产品名称
	 * @param totalFee 总金额
	 * @param payDesc 产品备注
	 */
	public PayForm(String orderId, String userId, String orderCode, String paySubject, String totalFee, String payDesc)
	{
		this.orderId = orderId;
		this.userId = userId;
		this.outTradeNo = orderCode;
		this.paySubject = paySubject;
		this.totalFee = totalFee;
		this.body = payDesc;
		this.sign = Payment.CreateUrl_Post(orderId, this.paygateway, this.service, this.signType, orderCode, this.inputCharset, this.partner, this.key, this.showUrl, payDesc, totalFee, this.paymentType,this.sellerEmail, paySubject, this.notifyUrl, this.returnUrl, this.payMethod, this.defaultBank);
	}

	/*
	 * getters and setters
	 */
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getPaySubject()
	{
		return paySubject;
	}

	public void setPaySubject(String paySubject)
	{
		this.paySubject = paySubject;
	}

	public String getTotalFee()
	{
		return totalFee;
	}

	public void setTotalFee(String totalFee)
	{
		this.totalFee = totalFee;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public String getOutTradeNo()
	{
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo)
	{
		this.outTradeNo = outTradeNo;
	}

	public String getNotifyUrl()
	{
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl)
	{
		this.notifyUrl = notifyUrl;
	}

	public String getPartner()
	{
		return partner;
	}

	public void setPartner(String partner)
	{
		this.partner = partner;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	public String getSellerEmail()
	{
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail)
	{
		this.sellerEmail = sellerEmail;
	}

	public String getService()
	{
		return service;
	}

	public void setService(String service)
	{
		this.service = service;
	}

	public String getSign()
	{
		return sign;
	}

	public void setSign(String sign)
	{
		this.sign = sign;
	}

	public String getSignType()
	{
		return signType;
	}

	public void setSignType(String signType)
	{
		this.signType = signType;
	}

	public String getShowUrl()
	{
		return showUrl;
	}

	public void setShowUrl(String showUrl)
	{
		this.showUrl = showUrl;
	}

	public String getReturnUrl()
	{
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl)
	{
		this.returnUrl = returnUrl;
	}

	public String getPayMethod()
	{
		return payMethod;
	}

	public void setPayMethod(String payMethod)
	{
		this.payMethod = payMethod;
	}

	public String getDefaultBank()
	{
		return defaultBank;
	}

	public void setDefaultBank(String defaultBank)
	{
		this.defaultBank = defaultBank;
	}

	public String getPaygateway()
	{
		return paygateway;
	}

	public void setPaygateway(String paygateway)
	{
		this.paygateway = paygateway;
	}

	public String getInputCharset()
	{
		return inputCharset;
	}

	public void setInputCharset(String inputCharset)
	{
		this.inputCharset = inputCharset;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getOrderId()
	{
		return orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

}
