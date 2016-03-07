package org.izhong.expert.abs;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.izhong.expert.service.MessageService;

public abstract class MessageAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected MessageService messageService;
	
	public abstract List<Map<String,Object>> getAllMessageRecord();

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
    
    
	
}
