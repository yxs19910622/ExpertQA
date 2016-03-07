package org.izhong.expert.util;

import java.util.Comparator;

import org.izhong.expert.model.SYS_AccessLog;

public class ComparatoAccessLog implements Comparator<Object>{

	 public int compare(Object arg0, Object arg1) {
	  SYS_AccessLog user0=(SYS_AccessLog)arg0;
	  SYS_AccessLog user1=(SYS_AccessLog)arg1;

	  //int flag = 0;
	  int flag1 = 0;
	  //flag=user0.getLoginName().compareTo(user1.getLoginName());//用户名
	  flag1=user0.getDeviceSerial().compareTo(user1.getDeviceSerial());//设备号
	  
	  //先比较设备号,一样的话比较时间
	  
	  if(flag1==0){
		 return user0.getOperationDate().compareTo(user1.getOperationDate());
	  }else{
		 return flag1;
	  }
	  
	 }
}
