package org.izhong.expert.abs;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.QueryHotWords;

public class HyperAbsImpl extends HyperAbs {

	@Override
	public boolean addHyperRecord(Map map) {
		map.put("hypertextName","HYPERTEXT_TRUNDLEADVERTAREA");
		map.put("projectName","劳动法");
		map.put("mustLogin", map.get("mustLogin").toString().toUpperCase());
		return hyperService.addHyperRecord(map);
	}

	@Override
	public boolean deleteHyperRecord(long id) {
		return hyperService.deleteHyperRecord(id);
	}

	@Override
	public List<Map<String, Object>> getAllHyperRecord() {
		return hyperService.getAllHyperRecord();
	}

	@Override
	public boolean updateHyperRecord(Map map) {
		map.put("mustLong", map.get("mustLong").toString().toUpperCase());
		return hyperService.updateHyperRecord(map);
	}
	
}
