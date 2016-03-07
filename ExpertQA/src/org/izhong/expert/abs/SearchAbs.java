package org.izhong.expert.abs;

import org.apache.log4j.Logger;
import org.izhong.expert.service.SearchService;

public abstract class SearchAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected SearchService searchService;
	
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}
