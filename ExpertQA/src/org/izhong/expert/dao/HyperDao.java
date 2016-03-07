package org.izhong.expert.dao;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.HypertextLinkExtends;

public interface HyperDao {
	
	public abstract List<Map<String,Object>> getAllHyperRecord();
    public abstract int addHyperRecord(Map map);
    public abstract int updateHyperRecord(Map map);
    public abstract int deleteHyperRecord(long id);
    
    /**
     * 查询所有新闻速递
     * @return
     * @author whz
     */
    public List<HypertextLinkExtends> getAllHyper();
    /**
     * 新增新闻速递
     * @return
     * @author whz
     */
    public void addHyper(HypertextLinkExtends hyper);
    /**
     * 修改新闻速递
     * @param hyper
     * @author whz
     */
    public void modHyper(HypertextLinkExtends hyper);
    /**
     * 删除新闻速递
     * @param tid
     * @author whz
     */
    public void delHyper(int tid);

}
