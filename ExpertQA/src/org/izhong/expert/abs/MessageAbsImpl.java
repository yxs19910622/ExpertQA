package org.izhong.expert.abs;

import java.util.List;
import java.util.Map;


public class MessageAbsImpl extends MessageAbs {

	
	@Override
	public List<Map<String, Object>> getAllMessageRecord() {
		return messageService.getAllMessageRecord();
	}

	
	
}
