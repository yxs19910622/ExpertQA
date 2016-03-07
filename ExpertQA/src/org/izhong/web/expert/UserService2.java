package org.izhong.web.expert;

import org.izhong.web.model.DownloadPackage;

public interface UserService2 {

	public boolean TestConnection();
	
	public long GetSystemDateTime(DownloadPackage connectParamPack) throws Exception;	
	
	public boolean AddAccessLogs(DownloadPackage connectParamPack) throws Exception;
	
	public boolean VerifyUser(DownloadPackage connectParamPack) throws Exception;
	
	public boolean IsPrepareTryEnd(DownloadPackage connectParamPack) throws Exception;
	
	public boolean IsTryEnd(DownloadPackage connectParamPack) throws Exception;	
	
	public boolean IsPayEnd(DownloadPackage connectParamPack) throws Exception;	
	
	public boolean IsRepeatLogin(DownloadPackage connectParamPack) throws Exception;	
	
	public boolean Logout(DownloadPackage connectParamPack) throws Exception;	
	
	public boolean IsExistsUserNewReply(DownloadPackage connectParamPack) throws Exception; 
	
	public DownloadPackage DownloadUserInfo(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadSystemInfos(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadDocumentInfos(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadSystemFiles(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadDocumentFiles(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadUpdateTableInfos(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadUpdateTableData(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadUserAnnouncementInfo(DownloadPackage connectParamPack) throws Exception;

	/*
	 * 下载指定文件编号的文件
	 */
	public DownloadPackage DownloadSingleNodeFiles(DownloadPackage connectParamPack) throws Exception;
	
	/*
	 * 批量下载指资源编号组的文件组
	 */
	public DownloadPackage DownloadMultiNodeFiles(DownloadPackage connectParamPack) throws Exception;
	/*
	 * 下载法律法规的XML文件
	 */
	public DownloadPackage DownloadLawXmlDocuments(DownloadPackage connectParamPack) throws Exception;	
	/*
	 * 首次登录之后下载试看文件（当前为劳动合同部分的问答及法规类文件）
	 */
	public DownloadPackage DownloadTryDocuments(DownloadPackage connectParamPack) throws Exception;
	
	/*
	 * 依指定关键字获取专家问答部分的问题列表
	 */
	public DownloadPackage GetLABQAQuestionList(DownloadPackage connectParamPack) throws Exception;
}
