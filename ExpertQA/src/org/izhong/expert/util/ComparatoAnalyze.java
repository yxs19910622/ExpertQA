package org.izhong.expert.util;

import java.util.Comparator;

import org.izhong.expert.model.Analyze;

public class ComparatoAnalyze implements Comparator{

	 public int compare(Object arg0, Object arg1) {
	  Analyze user0=(Analyze)arg0;
	  Analyze user1=(Analyze)arg1;

	  int flag = 0;
	  //按oid进行排序
	  flag=user0.getOid().compareTo(user1.getOid());
	  if(flag==0){
		  return user0.getCreatetime().compareTo(user1.getCreatetime());
	  }else{
		  return flag;
		  
	  }
	  
	 }
}
