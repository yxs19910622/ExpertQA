package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.MessageDao;
import org.izhong.expert.model.Messages;


public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao;
	
	@Override
	public List<Map<String, Object>> getAllMessageRecord() {
		// TODO Auto-generated method stub
		return this.messageDao.getAllMessageRecord();
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void addMessage(Messages message) {
		messageDao.addMessage(message);
	}

	@Override
	public void delMessage(int tid) {
		messageDao.delMessage(tid);
	}

	@Override
	public void modMessageStatus(int tid, int status) {
		messageDao.modMessageStatus(tid, status);
	}

	@Override
	public List<Messages> getAllMessage() {
		return messageDao.getAllMessage();
	}
}
