package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Messages;

public interface MessageService {
	
	public  List<Map<String,Object>> getAllMessageRecord();
	
	public void addMessage(Messages message);
	
	public void delMessage(int tid);
	
	public void modMessageStatus(int tid,int status);
	
	public List<Messages> getAllMessage();
}
