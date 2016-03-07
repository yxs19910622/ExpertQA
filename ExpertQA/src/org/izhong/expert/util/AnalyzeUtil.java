package org.izhong.expert.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.izhong.expert.abs.MemberAbs;
import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.SYS_AccessLog;

public class AnalyzeUtil {
	
	private static List<SYS_AccessLog> List;
	private static MemberAbs memberAbs;
	
	
	public void time(){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		String hehe = dateFormat.format( now ); 
		System.out.println(hehe); 
	}
	
	public static void main(String[] args){  
		int x = (int) (46+4.64+4.54+46+18.3);
		int y = (int) (19.55+33.15+21.25+17+21.25+75.60+21.25+30+38.25+25.50+21.25+38.20+19.55);
		System.out.println(x+":::"+y);
	} 
	
	
	public static Analyze copy(SYS_AccessLog acc,Analyze ana){
		ana.setTid(acc.getTid());
		ana.setCreatetime(acc.getOperationDate());
		ana.setCurrentuserstate(acc.getCurrentUserState());
		ana.setDeviceserial(acc.getDeviceSerial());
		if(acc.getLoginName()==null){
			ana.setLoginname("");
		}else{
			ana.setLoginname(acc.getLoginName());
		}
		ana.setOperationtype(acc.getOperationType());
		ana.setOperationarea(acc.getOperationArea());
		ana.setOperatuserstate(acc.getOperatuserstate());
		ana.setProjectname(acc.getProjectName());
		ana.setWritetime(acc.getCreateTime());
		return ana;
	}
	
	public static boolean isNeed(String str){
		boolean flag =false;
		if(str=="阅读"||"阅读".equals(str)){
			flag = true;
		}
		return flag;
	}
	
	public static Date getDate(){
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		  Date date = new Date();
		  //定义开始时间字符串
		  String timeStr = "04:00:00"; 
		  timeStr = sdf.format(date)+timeStr;
		  //获得当天的指定时间的date对象
		  sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  try {
			  date = sdf.parse(timeStr);
		  } catch (ParseException e) {
			  e.printStackTrace();
		  }
		  
		  //判断今天的执行时间是否已经过去，如果过去则改为明天
		  if(date.getTime()<System.currentTimeMillis()){
		   date = new Date(date.getTime()+24*60*60*1000);
		  }
		  
		  TimerTask task = new TimerTask(){
		   @Override
		   public void run() {
		    //your task
		   }
		  };
		  
		  Timer timer = new Timer();
		  timer.schedule(task, date, 24*60*60*1000);
		return null;
	}
	
	public static void copyFile(String oldPath, String newPath,Boolean flag) { 
        try { 
            int bytesum = 0; 
            int byteread = 0; 
            File oldfile = new File(oldPath); 
            if (oldfile.exists()) { //文件存在时 
                InputStream inStream = new FileInputStream(oldPath); //读入原文件 
                FileOutputStream fs = null;
                if(!flag){
                	fs = new FileOutputStream(newPath, true); 
                }else{
                	fs = new FileOutputStream(newPath); 
                }
                byte[] buffer = new byte[1444]; 
                
                while ( (byteread = inStream.read(buffer)) != -1) { 
                    bytesum += byteread; //字节数 文件大小 
                    System.out.println(bytesum); 
                    fs.write(buffer, 0, byteread); 
                } 
                inStream.close(); 
            } 
        } 
        catch (Exception e) { 
            System.out.println("复制单个文件操作出错"); 
            e.printStackTrace(); 
        } 
    } 
	
	public static void snake(){
		String lujing = "d:\\snake4.xml";
		  File file = new File(lujing);
		  if (!file.getParentFile().exists()) {
		   file.getParentFile().mkdirs();
		  }
		  try {
		   file.createNewFile();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }

		  try {
		   FileWriter fw = new FileWriter(file);
		   BufferedWriter bw = new BufferedWriter(fw);
		   bw.write("123");
		   bw.newLine();
		   bw.write("456");
		   bw.newLine();
		   bw.flush();
		   bw.close();
		   fw.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  try {
		   FileReader fr = new FileReader(file);
		   BufferedReader bReader = new BufferedReader(fr);
		   String string = bReader.readLine();
		   System.out.println(string);

		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	}
	
}
