package org.izhong.expert.action;

import java.util.List;

import org.izhong.expert.abs.UserAbs;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.util.BaseUtil;

public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserAbs userAbs;
	private List<QueryHotWords> lstqhw;
	private LabUsers totalUser;
	
	/**
	 * 
	 * @return
	 * @author whz
	 */
	public String init_expert()
	{
		lstqhw = userAbs.findHotWordsAll();
		String userId = getParameter("userId");
		if(userId=="2012082209082278050771"||"2012082209082278050771".equals(userId)){//曹老师和浩富编辑是同一个
			userId = "2012082409150806691358";
		}
		if(BaseUtil.isEmpty(userId))
		{
			return ERROR;
		}
		totalUser = userAbs.findTotalExpertInfo(userId);
		return SUCCESS;
	}
	
	public void setUserAbs(UserAbs userAbs) {
		this.userAbs = userAbs;
	}

	public List<QueryHotWords> getLstqhw() {
		return lstqhw;
	}

	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}

	public LabUsers getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(LabUsers totalUser) {
		this.totalUser = totalUser;
	}
}
