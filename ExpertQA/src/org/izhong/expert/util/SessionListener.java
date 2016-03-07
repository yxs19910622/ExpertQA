package org.izhong.expert.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
	
	private static HashMap emails = new HashMap();

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		emails.remove(arg0.getSession().getId());
	}
	
	public static boolean isAlreadyLogin(HttpSession session,String email,String ip){
		boolean flag = false;
		if(emails.containsValue(email+ip)){
			Iterator it = emails.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry = (Map.Entry) it.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				if(((String)value).contains(email)){
					if(!((String)value).contains(ip)){
						flag=true;
					}
				}
			}
		}else{
			emails.put(session.getId(),email+ip);
		}
		return flag;
		
	}

}
