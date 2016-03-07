package org.izhong.expert.action;

import java.util.List;

import org.izhong.expert.abs.FreeOrderAbs;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.UserTryInfos;
import org.izhong.expert.util.BaseUtil;

public class FreeOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FreeOrderAbs freeOrderAbs;
	private List<QueryHotWords> lstqhw;
	private UserTryInfos info;
	
	public String init_freeOrder()
	{
		info = new UserTryInfos();
		lstqhw = freeOrderAbs.findHotWordsAll();
		String userId = getUserID();
		if(BaseUtil.isNotEmpty(userId))
		{
			LabUsers labuser = freeOrderAbs.findLabUser(userId);
			if(labuser!=null)
			{
				info.setConsigneeName(labuser.getUserName());
				info.setMobile(labuser.getMobile());
				info.setEmail(labuser.getEmail());
				info.setUserId(userId);
				if(null!=labuser.getCompany())
				{
					info.setProvince(labuser.getCompany().getProvince());
					info.setPrefectureLevelCity(labuser.getCompany().getPrefecturelevelCity());
					info.setArea(labuser.getCompany().getArea());
					info.setStreet(labuser.getCompany().getStreet());
					info.setPostCode(labuser.getCompany().getPostcode());
					info.setTelephone(labuser.getCompany().getTelephone());
				}
			}
		}
		return SUCCESS;
	}
	
	public String freeOrderSave()
	{
		info.setVisitorIP(getRequest().getRemoteAddr());
		freeOrderAbs.addFreeOrder(info);
		return SUCCESS;
	}

	public List<QueryHotWords> getLstqhw() {
		return lstqhw;
	}

	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}

	public void setFreeOrderAbs(FreeOrderAbs freeOrderAbs) {
		this.freeOrderAbs = freeOrderAbs;
	}

	public UserTryInfos getInfo() {
		return info;
	}

	public void setInfo(UserTryInfos info) {
		this.info = info;
	}
}
