package org.izhong.expert.abs;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.izhong.expert.service.HyperService;

public abstract class HyperAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected HyperService hyperService;
	
	public abstract List<Map<String,Object>> getAllHyperRecord();
    public abstract boolean addHyperRecord(Map map);
    public abstract boolean updateHyperRecord(Map map);
    public abstract boolean deleteHyperRecord(long id);
    
	public HyperService getHyperService() {
		return hyperService;
	}
	public void setHyperService(HyperService hyperService) {
		this.hyperService = hyperService;
	}
	
}
