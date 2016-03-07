package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.HypertextLinkExtends;


public interface HyperService {
	
	public abstract List<Map<String,Object>> getAllHyperRecord();
    public abstract boolean addHyperRecord(Map map);
    public abstract boolean updateHyperRecord(Map map);
    public abstract boolean deleteHyperRecord(long id);
    
    public List<HypertextLinkExtends> getAllHyper();
    
    public void addHyper(HypertextLinkExtends hyper);

    public void modHyper(HypertextLinkExtends hyper);
    
    public void delHyper(int tid);

}
