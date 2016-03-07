package org.izhong.web.expert;

import java.text.ParseException;

import org.izhong.web.model.DownloadPackage;

public interface UserService{

	public boolean TestConnection();

	public long GetSystemDataTime(DownloadPackage connectParamPack) throws Exception;

	public DownloadPackage VerifyFirstLogin(DownloadPackage connectParamPack) throws Exception;

	public boolean VerifyUser(DownloadPackage connectParamPack) throws Exception;

	public boolean AddClientAccessLog(DownloadPackage connectParamPack) throws Exception;

	public boolean AddClientAccessLogs(DownloadPackage connectParamPack) throws Exception, ParseException;

	public boolean IsExistsUserNewReply(DownloadPackage connectParamPack) throws Exception; 

	public DownloadPackage DownloadUserInfo(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadSystemInfos(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadDocumentInfos(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadSystemFiles(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadDocumentFiles(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadUpdateTableInfos(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadUpdateTableData(DownloadPackage connectParamPack) throws Exception;
	
	public DownloadPackage DownloadAnnouncementInfo(DownloadPackage connectParamPack) throws Exception;
}
