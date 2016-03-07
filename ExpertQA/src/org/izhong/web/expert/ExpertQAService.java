package org.izhong.web.expert;

public interface ExpertQAService {
	
	/**
	 * 从ICream取客户订购相关信息
	 * @param xmlOrderData
	 * @return
	 * @author whz
	 */
	public boolean InsertOnedayOrderData(String  xmlOrderData);
}
