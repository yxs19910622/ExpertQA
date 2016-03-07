package org.izhong.web.expert;

import java.text.ParseException;
import org.izhong.web.model.DownloadPackage;
import org.izhong.web.services.ExpertService;

public class UserServiceImpl implements UserService {
	
	private ExpertService impl;

	public UserServiceImpl() {
		impl = new ExpertService();
	}

	@Override
	public boolean TestConnection() {
		return impl.TestConnection();
	}

	@Override
	public long GetSystemDataTime(DownloadPackage connectParamPack)
			throws Exception {
		return impl.GetSystemDataTime(connectParamPack);
	}

	@Override
	public DownloadPackage VerifyFirstLogin(DownloadPackage connectParamPack)
			throws Exception {
		return impl.VerifyFirstLogin(connectParamPack);
	}

	@Override
	public boolean VerifyUser(DownloadPackage connectParamPack)
			throws Exception {
		return impl.VerifyUser(connectParamPack);
	}

	@Override
	public boolean AddClientAccessLog(DownloadPackage connectParamPack)
			throws Exception {
		return impl.AddClientAccessLog(connectParamPack);
	}

	@Override
	public boolean AddClientAccessLogs(DownloadPackage connectParamPack)
			throws Exception, ParseException {
		return impl.AddClientAccessLogs(connectParamPack);
	}

	@Override
	public boolean IsExistsUserNewReply(DownloadPackage connectParamPack)
			throws Exception {
		return impl.IsExistsUserNewReply(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadUserInfo(DownloadPackage connectParamPack)
			throws Exception {
		return impl.DownloadUserInfo(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadSystemInfos(DownloadPackage connectParamPack)
			throws Exception {
		return impl.DownloadSystemInfos(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadDocumentInfos(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadDocumentInfos(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadSystemFiles(DownloadPackage connectParamPack)
			throws Exception {
		return impl.DownloadSystemFiles(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadDocumentFiles(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadDocumentFiles(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadUpdateTableInfos(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadUpdateTableInfos(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadUpdateTableData(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadUpdateTableData(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadAnnouncementInfo(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadAnnouncementInfo(connectParamPack);
	}
}
