package org.izhong.web.expert;

import org.izhong.web.model.DownloadPackage;
import org.izhong.web.services.ExpertService;

public class UserService2Impl implements UserService2 {
	private ExpertService impl;
	public UserService2Impl() {
		impl = new ExpertService();
	}

	@Override
	public boolean TestConnection() {
		return impl.TestConnection();
	}
	
	@Override
	public long GetSystemDateTime(DownloadPackage connectParamPack) throws Exception
	{
		return impl.GetSystemDateTime(connectParamPack);
	}
	
	@Override
	public boolean VerifyUser(DownloadPackage connectParamPack)
			throws Exception {
		return impl.VerifyUser2(connectParamPack);
	}
	
	@Override	
	public boolean IsPrepareTryEnd(DownloadPackage connectParamPack) throws Exception
	{
		return impl.IsPrepareTryEnd(connectParamPack);
	}
	
	@Override	
	public boolean IsTryEnd(DownloadPackage connectParamPack) throws Exception
	{
		return impl.IsTryEnd(connectParamPack);
	}
	
	@Override	
	public boolean IsPayEnd(DownloadPackage connectParamPack) throws Exception
	{
		return impl.IsPayEnd(connectParamPack);
	}
	
	@Override
	public boolean IsRepeatLogin(DownloadPackage connectParamPack) throws Exception
	{
		return impl.IsRepeatLogin(connectParamPack);
	}
	
	@Override
	public boolean Logout(DownloadPackage connectParamPack) throws Exception {
		return impl.Logout(connectParamPack);
	}

	@Override
	public boolean AddAccessLogs(DownloadPackage connectParamPack) throws Exception
	{
		return impl.AddAccessLogs(connectParamPack);
	}
	
	@Override
	public boolean IsExistsUserNewReply(DownloadPackage connectParamPack)
			throws Exception {
		return impl.IsExistsUserNewReply(connectParamPack);
	}

	@Override
	public DownloadPackage DownloadUserInfo(DownloadPackage connectParamPack)
			throws Exception {
		return impl.DownloadUserInfo2(connectParamPack);
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
	public DownloadPackage DownloadUserAnnouncementInfo(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadUserAnnouncementInfo(connectParamPack);
	}

	/* (non-Javadoc)
	 * @see org.izhong.web.expert.UserService2#DownloadSingleFile(org.izhong.web.model.DownloadPackage)
	 */
	@Override
	
	public DownloadPackage DownloadSingleNodeFiles(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadSingleNodeFiles(connectParamPack);
	}

	/* (non-Javadoc)
	 * @see org.izhong.web.expert.UserService2#DownloadMultiFiles(org.izhong.web.model.DownloadPackage)
	 */
	@Override
	public DownloadPackage DownloadMultiNodeFiles(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadMultiNodeFiles(connectParamPack);
	}
	
	@Override
	public DownloadPackage DownloadLawXmlDocuments(DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadLawXmlDocuments(connectParamPack);
	}

	/* (non-Javadoc)
	 * @see org.izhong.web.expert.UserService2#DownloadTryDocuments(org.izhong.web.model.DownloadPackage)
	 */
	@Override
	public DownloadPackage DownloadTryDocuments(
			DownloadPackage connectParamPack) throws Exception {
		return impl.DownloadTryDocuments(connectParamPack);
	}

	/* (non-Javadoc)
	 * @see org.izhong.web.expert.UserService2#GetLABQAQuestionList(org.izhong.web.model.DownloadPackage)
	 */
	@Override
	public DownloadPackage GetLABQAQuestionList(
			DownloadPackage connectParamPack) throws Exception {
		return impl.GetLABQAQuestionList(connectParamPack);
	}
}
