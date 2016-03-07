package org.izhong.expert.abs;

import java.util.List;

import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.OperationLogs;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.UserTryInfos;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.StringUtil;
import org.izhong.web.util.RemoteService;

public class FreeOrderAbsImpl extends FreeOrderAbs {

	@Override
	public List<QueryHotWords> findHotWordsAll() {
		return keyWordService.qryHotWordsAll();
	}

	@Override
	public void addFreeOrder(UserTryInfos userTryInfo) {
		userTryInfo.setPreOrderNo(BaseUtil.generateIdentifier());
		userTryInfo.setApplyTryDate(DateUtil.getCurrTime());
		userTryInfo.setStatus("0");//默认发送失败 -0
		String productName = StringUtil.UnicodeToUTF8(userTryInfo.getTryProductName()); //处理中文乱码
		userTryInfo.setTryProductName(productName);
		freeOrderService.addFreeOrder(userTryInfo);
		String result = RemoteService.tWebLPORDER(userTryInfo);
		String result_Contact = null;
		if("1".equals(result))
		{
			result_Contact = RemoteService.tWebLPCONTACT(userTryInfo);
			freeOrderService.updateFreeOrderStatus(userTryInfo.getPreOrderNo(), result);
		}
		log.info("同步网站订单,订单返回:["+result+"],订单联系人返回:["+result_Contact+"]");
		String operationNotes = "同步[网站订单],订单发送"+("1".equals(result)?"成功":"失败")+",订单联系人发送:"+("1".equals(result_Contact)?"成功":"失败")+",发送的订单号为："+userTryInfo.getPreOrderNo(); 
		OperationLogs logs = new OperationLogs("同步数据", "自动发送", DateUtil.getCurrTime(), operationNotes, userTryInfo.getVisitorIP());
		logsService.addOperation(logs);
	}

	@Override
	public LabUsers findLabUser(String userId) {
		return userInfoService.qryLabUserInfo(userId);
	}
}
