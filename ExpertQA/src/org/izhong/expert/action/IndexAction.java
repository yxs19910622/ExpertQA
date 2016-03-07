package org.izhong.expert.action;

import java.util.HashMap;
import java.util.List;

import org.izhong.expert.abs.IndexAbs;
import org.izhong.expert.abs.UserLoginAbs;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.util.CookieUtil;

public class IndexAction extends BaseAction {
	
	private IndexAbs indexAbs;
	private UserLoginAbs userLoginAbs;
	private List<QATypes> lstTypeParent;
	private List<QATypes> lstTypeChild;
	private List<QueryHotWords> lstqhw;
	private List<LabUsers> lstActiveUser;
	private LabUsers labuser;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		lstTypeParent = indexAbs.findQATypeByParent();
		lstTypeChild = indexAbs.findQATypesByChild();
		lstqhw = indexAbs.findHotWordsAll();//初始化关键词
		labuser = indexAbs.findRecommendExpert();
		//此处添加用户权限信息到session中
		String userId = this.getUserID();
		if(userId != null){
			HashMap userMap = this.userLoginAbs.getUserRoleByUserId(userId);
			if(userMap != null){
				//this.getSession().setAttribute("userMap", userMap);
				//this.getSession().setAttribute("operate", userMap.get("operate"));
				CookieUtil.addCookie(getResponse(), "operate", userMap.get("operate")+"");
			}
		}
		String milieu = getRequest().getHeader("user-agent");
		String ip = getRequest().getRemoteAddr();
		indexAbs.milieuCollect(ip, milieu);
		return SUCCESS;
	}
	
	public String index_mirror() {
		/*lstTypeParent = indexAbs.findQATypeByParent();
		lstTypeChild = indexAbs.findQATypesByChild();
		lstqhw = indexAbs.findHotWordsAll();//初始化关键词
		labuser = indexAbs.findRecommendExpert();
		//此处添加用户权限信息到session中
		String userId = this.getUserID();
		if(userId != null){
			HashMap userMap = this.userLoginAbs.getUserRoleByUserId(userId);
			if(userMap != null){
				//this.getSession().setAttribute("userMap", userMap);
				//this.getSession().setAttribute("operate", userMap.get("operate"));
				CookieUtil.addCookie(getResponse(), "operate", userMap.get("operate")+"");
			}
		}
		String milieu = getRequest().getHeader("user-agent");
		String ip = getRequest().getRemoteAddr();
		indexAbs.milieuCollect(ip, milieu);*/
		return SUCCESS;
	}
	
	
	/**
	 * 取活跃用户数据
	 * @return
	 * @author whz
	 */
	public String activeUser()
	{
		lstActiveUser = indexAbs.getActiveUser();
		return SUCCESS;
	}

	public void setIndexAbs(IndexAbs indexAbs) {
		this.indexAbs = indexAbs;
	}

	public List<QATypes> getLstTypeParent() {
		return lstTypeParent;
	}

	public void setLstTypeParent(List<QATypes> lstTypeParent) {
		this.lstTypeParent = lstTypeParent;
	}

	public List<QATypes> getLstTypeChild() {
		return lstTypeChild;
	}

	public void setLstTypeChild(List<QATypes> lstTypeChild) {
		this.lstTypeChild = lstTypeChild;
	}

	public List<QueryHotWords> getLstqhw() {
		return lstqhw;
	}

	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}

	public UserLoginAbs getUserLoginAbs() {
		return userLoginAbs;
	}

	public void setUserLoginAbs(UserLoginAbs userLoginAbs) {
		this.userLoginAbs = userLoginAbs;
	}

	public LabUsers getLabuser() {
		return labuser;
	}

	public void setLabuser(LabUsers labuser) {
		this.labuser = labuser;
	}

	public List<LabUsers> getLstActiveUser() {
		return lstActiveUser;
	}

	public void setLstActiveUser(List<LabUsers> lstActiveUser) {
		this.lstActiveUser = lstActiveUser;
	}
}
