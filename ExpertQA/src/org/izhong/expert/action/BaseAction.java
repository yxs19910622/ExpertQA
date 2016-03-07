package org.izhong.expert.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.izhong.expert.util.CookieUtil;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	
	/**
	 * 公共Action类，只能存放公用信息
	 * @author whz
	 */
	private static final long serialVersionUID = 1L;
	
	protected Logger log = Logger.getLogger(getClass());
	
	protected static String SUCCESS = "success";
	protected static String ERROR = "error";
	protected static String INPUT = "input";
	protected String errurl = null; //错误提示跳转地址
	protected String errmsg = null; //错误提示信息
	
	public String getUserID()
	{
		Cookie cuser = CookieUtil.getCookieByName(getRequest(), "EUserID");
		if(cuser!=null)
		{
			
			return cuser.getValue();
		}
		return null;
	}
	
	public String getUserName()
	{
		Cookie cuser = CookieUtil.getCookieByName(getRequest(), "EUserID");
		if(cuser!=null)
		{
			cuser.getName();
			return cuser.getName();
		}
		return null;
	}
	
	public Object getSession(String name) {
		return ServletActionContext.getRequest().getSession()
				.getAttribute(name);
	}

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public void setSession(String name, Object value) {
		ServletActionContext.getRequest().getSession()
				.setAttribute(name, value);
	}
	
	public String[] getParameterValues(String name)
	{
		return getRequest().getParameterValues(name);
	}
	
	public String getParameter(String name)
	{
		return getRequest().getParameter(name);
	}
	
	public String getRemoteAddr()
	{
		return getRequest().getRemoteAddr();
	}

	public String getErrurl() {
		return errurl;
	}

	public void setErrurl(String errurl) {
		this.errurl = errurl;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
