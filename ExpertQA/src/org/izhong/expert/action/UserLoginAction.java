package org.izhong.expert.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.Cookie;

import net.sf.json.JSONObject;

import org.izhong.expert.abs.UserLoginAbs;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.CookieUtil;
import org.izhong.expert.util.RandomImage;
import org.izhong.expert.util.ServletUtil;
import org.izhong.expert.util.SessionListener;

public class UserLoginAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserLoginAbs userLoginAbs;
	private List<QueryHotWords> lstqhw;
	
	/**
	 * 订单信息确认中个人信息的修改
	 * @return
	 * @author yxs
	 */
	
	
	//购物车的弹出登录框
	public void myLogin(){
		String email = getParameter("email");
		String password = getParameter("password");
		String validatecode = getParameter("validatecode");
		if(!validatecode.equalsIgnoreCase(getRequest().getSession().getAttribute("VALIDATE_STRING").toString()))
		{
			PrintWriter out;
			try {
				out = getResponse().getWriter();
				out.print("code");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		boolean user = userLoginAbs.toLogin(getResponse(), email,password);
		
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//在后台做是否已登陆的验证
	public void yanzheng(){
		boolean flag = true;
		Cookie euserId = CookieUtil.getCookieByName(getRequest(), "EUserID");
		Cookie eshowName = CookieUtil.getCookieByName(getRequest(), "EUserName");
		String userId = null;
		String name = "";
		if(eshowName==null)
		{
			eshowName = CookieUtil.getCookieByName(getRequest(), "Eemail");
		}
		if(euserId!=null && eshowName!=null){
			userId = euserId.getValue();
			name = eshowName.getValue();
		}
		if(userId==null||userId==""||userId=="null"){
			flag = false;
		}
		
		PrintWriter out;
		try {
			out = getResponse().getWriter();
			out.print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//使用url登录到在线购买
	public String init_buyonline(){
		String u = getParameter("u");
		if(BaseUtil.isNotEmpty(u))
		{
			String strDecr = BaseUtil.Decryption(u.replaceAll(" ", "+"));
			if(BaseUtil.isNotEmpty(strDecr))
			{
				String strJson = strDecr.substring(0,strDecr.indexOf("}")+1);
				JSONObject object = JSONObject.fromObject(strJson);
				String email = object.getString("LoginName");
				String password = object.getString("PassWord");
				boolean user = userLoginAbs.toLogin(getResponse(), email, password);
				if(user)
				{
					return SUCCESS;
				}
			}
		}
		return SUCCESS;
	}
	
	//使用url登录到会员中心
	public String toUserEdit(){
		String u = getParameter("u");
		if(BaseUtil.isNotEmpty(u))
		{
			String strDecr = BaseUtil.Decryption(u.replaceAll(" ", "+"));
			if(BaseUtil.isNotEmpty(strDecr))
			{
				String strJson = strDecr.substring(0,strDecr.indexOf("}")+1);
				JSONObject object = JSONObject.fromObject(strJson);
				String email = object.getString("LoginName");
				String password = object.getString("PassWord");
				boolean user = userLoginAbs.toLogin(getResponse(), email, password);
				if(user)
				{
					return SUCCESS;
				}
			}
		}
		return SUCCESS;
	}
	
	
	public String init_qustion(){
		String u = getParameter("u");
		if(BaseUtil.isNotEmpty(u))
		{
			String strDecr = BaseUtil.Decryption(u.replaceAll(" ", "+"));
			if(BaseUtil.isNotEmpty(strDecr))
			{
				String strJson = strDecr.substring(0,strDecr.indexOf("}")+1);
				JSONObject object = JSONObject.fromObject(strJson);
				String email = object.getString("LoginName");
				String password = object.getString("PassWord");
				boolean user = userLoginAbs.toLogin(getResponse(), email, password);
				if(user)
				{
					return SUCCESS;
				}
			}
		}
		return SUCCESS;
	}
	public void validateImage() throws IOException
	{
		RandomImage validateImage = new RandomImage(6, 100, 22);
		OutputStream bos = getResponse().getOutputStream();
        getResponse().setHeader("cache-control", "no-store");
        ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
        ImageIO.write(validateImage.getValidateImage(), "JPEG", ios);
        getSession().setAttribute("VALIDATE_STRING",validateImage.getValidateString());
        ios.close();
        bos.close();
	}
	
	/**
	 * ajax提交
	 * @author whz
	 */
	public void SignIn()
	{
		String email = getParameter("email");
		String password = getParameter("loginPass");
		String validatecode = getParameter("validatecode");
		String flag = getParameter("flag");
		String ip = getParameter("ip");
		if(BaseUtil.isEmpty(email) || BaseUtil.isEmpty(password))
		{
			return;
		}
		if(!validatecode.equalsIgnoreCase(getRequest().getSession().getAttribute("VALIDATE_STRING").toString()))
		{
			ServletUtil.writerToClient(getResponse(), "验证码输入错误!");
			return;
		}
		/**
		 * 无重复登录验证代码块
		 */
		/*boolean user = userLoginAbs.toLogin(getResponse(), email,password);
		if(user){
			
			
//            getSession().setAttribute("email", email);
				if(!"".equals(flag)&&"online".equals(flag)){
//				 try {
//					this.getResponse().sendRedirect("onlinepay");
//					//this.getRequest().getRequestDispatcher("onlinepay").forward(this.getRequest(), this.getResponse());
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
					ServletUtil.writerToClient(getResponse(), "onlinepay");
				}else{
					ServletUtil.writerToClient(getResponse(), "true");
				}
		}else{
			lstqhw = userLoginAbs.findHotWordsAll();
			ServletUtil.writerToClient(getResponse(), "帐号或密码输入错误!");
		}*/
		
		
		/**
		 * 重复登录验证代码块
		 */
		boolean check = userLoginAbs.check(email, password);
		boolean reg_check = userLoginAbs.reg_check(email, password);
		if(check){
			if(!SessionListener.isAlreadyLogin(getSession(), email,ip)){
				boolean user = userLoginAbs.toLogin(getResponse(), email,password);
				if(user){
						
//		              getSession().setAttribute("email", email);
						if(!"".equals(flag)&&"online".equals(flag)){
//						 try {
//							this.getResponse().sendRedirect("onlinepay");
//							//this.getRequest().getRequestDispatcher("onlinepay").forward(this.getRequest(), this.getResponse());
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
							ServletUtil.writerToClient(getResponse(), "onlinepay");
						}else if("cartList".equals(flag)){
							ServletUtil.writerToClient(getResponse(), "cartList");
						}else{
							ServletUtil.writerToClient(getResponse(), "true");
						}
				}else{
					lstqhw = userLoginAbs.findHotWordsAll();
					ServletUtil.writerToClient(getResponse(), "帐号或密码输入错误!");
				}
			}else{
				lstqhw = userLoginAbs.findHotWordsAll();
				ServletUtil.writerToClient(getResponse(), "帐号已在其他地方登陆,请勿重复登录!");
			}
			
		}else if(reg_check){
			//未激活 跳转到发送邮箱页面 激活后要删除未激活表中数据
			lstqhw = userLoginAbs.findHotWordsAll();
			ServletUtil.writerToClient(getResponse(), "帐号尚未激活!<a href='toMail.action?email="+email+"'>点击去激活<a/>");
			return;
		}else{
			lstqhw = userLoginAbs.findHotWordsAll();
			ServletUtil.writerToClient(getResponse(), "帐号或密码错误!");
		}
		
		
	}
	
	public String init_login(){
		String u = getParameter("u");
		if(BaseUtil.isNotEmpty(u))
		{
			String strDecr = BaseUtil.Decryption(u.replaceAll(" ", "+"));
			if(BaseUtil.isNotEmpty(strDecr))
			{
				String strJson = strDecr.substring(0,strDecr.indexOf("}")+1);
				JSONObject object = JSONObject.fromObject(strJson);
				String email = object.getString("LoginName");
				String password = object.getString("PassWord");
				boolean user = userLoginAbs.toLogin(getResponse(), email, password);
				if(user)
				{
					getRequest().getSession().setAttribute("EUserID", email);//放入userID,不是email
					return INPUT;
				}
			}
		}
		lstqhw = userLoginAbs.findHotWordsAll();
		return SUCCESS;
	
	}
	
	
	/**
	 * 跳转用
	 * @author yxs
	 */
	public String toMail()
	{
		String email = getParameter("email");
		getRequest().setAttribute("email", email);
		return SUCCESS;
	}
	
	/**
	 * 退出登录
	 * @return
	 * @author whz
	 */
	public String logout()
	{
		getSession().setMaxInactiveInterval(0);
		CookieUtil.removeCookie(getRequest(),getResponse());
		return SUCCESS;
	}

	public void setUserLoginAbs(UserLoginAbs userLoginAbs) {
		this.userLoginAbs = userLoginAbs;
	}

	public List<QueryHotWords> getLstqhw() {
		return lstqhw;
	}

	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}

}
