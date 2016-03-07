package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.UserProficients;

public interface QATypeService {

	public List<QATypes> qryQATypeValid();

	public List<QATypes> qryQATypeByParent();

	public List<QATypes> qryQATypesByChild();
	
	public List<Map> getQATypeByParent();

	public List<Map> getQATypesByChild();

	public void addUserProfiType(String userId,String typeId);

	public void delUserProfiType(String userId,String typeId);
	
	public List<UserProficients> qryUserProfiByUserID(String userId);

}
