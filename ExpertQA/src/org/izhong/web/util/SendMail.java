package org.izhong.web.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.izhong.expert.model.order.OrderDetails;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMail {

	public void send_reply(String email) throws Exception  {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qiye.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		message.setFrom(new InternetAddress("ask@haufe.cn"));
		message.setRecipients(Message.RecipientType.TO, email);
		message.setSubject("您在浩富的问题已有回复");
		helper.setText("您的问题已有答案，请登录<a href='http://zhuanjia.haufe.cn/index.action'>http://zhuanjia.haufe.cn/index.action</a>查询", true);//true表示设定html格式
		//message.setText("您的问题已有答案，请登录<a href='http://zhuanjia.haufe.cn/index.action'>http://zhuanjia.haufe.cn/index.action</a>查询");
		
		message.saveChanges();
		
		
		Transport ts = session.getTransport();
		ts.connect("smtp.qiye.163.com", "ask@haufe.cn", "haufe123");
		ts.sendMessage(message,  message.getAllRecipients());
		
		ts.close();
		
	}

	public void send_reg(String email,String code) throws Exception  {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qiye.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		message.setFrom(new InternetAddress("certification@haufe.cn"));
		message.setRecipients(Message.RecipientType.TO, email);
		message.setSubject("浩富中国帐号注册激活邮件");
		helper.setText("您好！感谢您注册浩富帐号，请点击下面的链接即可完成注册<br>" +
				"<a href='http://zhuanjia.haufe.cn/email_reg.action?email="+email+"&code="+code+"'>http://zhuanjia.haufe.cn/email_reg.action?email="+email+"&code="+code+"</a><br>" +
				"(如链接无法点击，可以将此链接复制到浏览器地址栏打开页面)<br><br>" +
				"本邮件是系统自动发送的，请勿直接回复！感谢您的注册，祝您使用愉快！<br><br><br><br><br>" +
				"浩富中国<br>" +
				"<a href='http://www.haufe.cn'>http://www.haufe.cn/</a>", true);//true表示设定html格式
		
		message.saveChanges();
		
		
		Transport ts = session.getTransport();
		ts.connect("smtp.qiye.163.com", "certification@haufe.cn", "123456Q");
		ts.sendMessage(message,  message.getAllRecipients());
		
		ts.close();
		
	}	
	
	
	public void send_buy(String email,String code) throws Exception  {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qiye.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		message.setFrom(new InternetAddress("certification@haufe.cn"));
		message.setRecipients(Message.RecipientType.TO, email);
		message.setSubject("新的订单支付");
		helper.setText("有客户完成支付,订单编号:"+code, true);//true表示设定html格式
		
		message.saveChanges();
		
		
		Transport ts = session.getTransport();
		ts.connect("smtp.qiye.163.com", "certification@haufe.cn", "123456Q");
		ts.sendMessage(message,  message.getAllRecipients());
		
		ts.close();
		
	}
	
	public void send_psw(String email,String code) throws Exception  {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qiye.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		message.setFrom(new InternetAddress("certification@haufe.cn"));
		message.setRecipients(Message.RecipientType.TO, email);
		message.setSubject("浩富中国重置密码激活邮件");
		helper.setText("您好！您申请重置浩富帐号密码，如非本人操作，请忽略此邮件。<br><br>" +
				"请点击以下链接进行密码重置<br>" +
				"<a href='http://zhuanjia.haufe.cn/password_page.action?email="+email+"&code="+code+"'>http://zhuanjia.haufe.cn/password_page.action?email="+email+"&code="+code+"</a><br>" +
				"(如链接无法点击，可以将此链接复制到浏览器地址栏打开页面)<br><br>" +
				"本邮件是系统自动发送的，请勿直接回复！感谢您的注册，祝您使用愉快！<br><br><br><br><br>" +
				"浩富中国<br>" +
				"<a href='http://www.haufe.cn'>http://www.haufe.cn/</a>", true);//true表示设定html格式
		
		message.saveChanges();
		
		
		Transport ts = session.getTransport();
		ts.connect("smtp.qiye.163.com", "certification@haufe.cn", "123456Q");
		ts.sendMessage(message,  message.getAllRecipients());
		
		ts.close();
		
	}	
	

	
	public static void send_test() throws Exception{
		Properties props = new Properties();
		Session session = Session.getInstance(props);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("certification@haufe.cn"));
		message.setRecipients(Message.RecipientType.TO, "yxs19910622@163.com");
		message.setSubject("最复杂的邮件");
		
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("bb<img src='cid:mm'/>bb", "text/html");
		
		MimeBodyPart imagePart = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("d:\\1.jpg"));
		imagePart.setDataHandler(dh);
		imagePart.setContentID("mm");
		
		MimeBodyPart attachmentPart = new MimeBodyPart();
		dh = new DataHandler(new FileDataSource("d:\\1.zip"));
		String name = dh.getName();
//		System.out.println(name);
		attachmentPart.setDataHandler(dh);
		attachmentPart.setFileName(name);
		
		MimeMultipart mmpart = new MimeMultipart();
		mmpart.addBodyPart(textPart);
		mmpart.addBodyPart(imagePart);
		mmpart.setSubType("related");
		
		MimeBodyPart textImagePart = new MimeBodyPart();
		textImagePart.setContent(mmpart);
		
		MimeMultipart mmpart1 = new MimeMultipart();
		mmpart1.addBodyPart(textImagePart);
		mmpart1.addBodyPart(attachmentPart);
		mmpart1.setSubType("mixed");
		
/*		message.setContent(mmpart1);
		message.saveChanges();
		message.writeTo(new FileOutputStream("d:\\3.eml"));*/
	}
	


	public void send_buy(String email, OrderDetails message4Email,String notes)throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qiye.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		message.setFrom(new InternetAddress("certification@haufe.cn"));
		message.setRecipients(Message.RecipientType.TO, email);
		message.setSubject("新的订单支付");
		helper.setText("有客户完成支付<br>"+
				"客户名:"+message4Email.getUsername()+"<br>"+
				"邮箱:"+message4Email.getEmail()+"<br>"+
				"订单编号:"+message4Email.getOrderMasterNo()+"<br>"+
				"地址:"+message4Email.getProvince()+message4Email.getPrefecturelevelcity()+message4Email.getArea()+message4Email.getStreet()+"<br>"+
				"电话:"+message4Email.getMobile()+"<br>"+
				"发票类型:"+message4Email.getTitletype()+"<br>"+
				"发票抬头:"+message4Email.getInvoicetitle()+"<br>"+
				"备注:"+notes, true);//true表示设定html格式
		
		message.saveChanges();
		
		
		Transport ts = session.getTransport();
		ts.connect("smtp.qiye.163.com", "certification@haufe.cn", "123456Q");
		ts.sendMessage(message,  message.getAllRecipients());
		
		ts.close();
		
	}
	
	public static void send_snake() throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qiye.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		Address address = new InternetAddress("315182821@qq.com","战网"); 
		message.setFrom(address);
		message.setRecipients(Message.RecipientType.TO, "yxs19910622@163.com");
		message.setSubject("浩富中国帐号注册激活邮件");
		helper.setText("您好！感谢您注册浩富帐号，请点击下面的链接即可完成注册<br>", true);//true表示设定html格式
		
		message.saveChanges();
		
		
		Transport ts = session.getTransport();
//		ts.connect("smtp.exmail.qq.com", "1368117055@qq.com", "12345yxs");
		ts.connect("smtp.qiye.163.com", "certification@haufe.cn", "123456Q");
		ts.sendMessage(message,  message.getAllRecipients());
		
		ts.close();
	}
	
	public static void send_snake_1() throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.qiye.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		message.setFrom(new InternetAddress("marketing@haufe.cn"));
		message.setRecipients(Message.RecipientType.TO, "yangxs@haufe.cn");
		message.setSubject("浩富中国帐号注册激活邮件");
		helper.setText("您好！感谢您注册浩富帐号，请点击下面的链接即可完成注册<br>" +
				"<a href='http://zhuanjia.haufe.cn/email_reg.action?email=&code='>http://zhuanjia.haufe.cn/email_reg.action?email=&code=</a><br>" +
				"(如链接无法点击，可以将此链接复制到浏览器地址栏打开页面)<br><br>" +
				"本邮件是系统自动发送的，请勿直接回复！感谢您的注册，祝您使用愉快！<br><br><br><br><br>" +
				"浩富中国<br>" +
				"<a href='http://www.haufe.cn'>http://www.haufe.cn/</a>", true);//true表示设定html格式
		
		message.saveChanges();
		
		
		Transport ts = session.getTransport();
//		ts.connect("smtp.qiye.163.com", "certification@haufe.cn", "123456Q");
		ts.connect("smtp.qiye.163.com", "marketing@haufe.cn", "123456!");
		ts.sendMessage(message,  message.getAllRecipients());
		
		ts.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		send_snake_1();
	}
	

}
