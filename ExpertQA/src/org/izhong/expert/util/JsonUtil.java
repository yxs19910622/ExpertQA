package org.izhong.expert.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.AnalyzeTimes;
import org.izhong.expert.model.Stat_1;
import org.izhong.expert.model.Stat_2;
import org.izhong.expert.model.Stat_3;

public class JsonUtil {
	
	/**
	 * 生成表格数据
	 * @param response
	 * @param startStr
	 * @param limitStr
	 * @param list
	 * @param model
	 * @author whz
	 */
	public static void GenerateGrid(HttpServletResponse response,
			String startStr,String limitStr,List list,GridDataModel model)
	{
		int start = Integer.parseInt(StringUtils.isBlank(startStr)?"0":startStr);
		int limit = Integer.parseInt(StringUtils.isBlank(limitStr)?"50":limitStr);
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		int end = start + limit;
		int total = list.size();end = end > total ? total : end;
		if(start <= end) {
			model.setRows(list.subList(start, end));
		}
		model.setTotal(list.size());
		ServletUtil.writerToClient(response, JSONObject.fromObject(model).toString());
	}
	
	/**
	 * 生成表格数据(日期类型已格式化)
	 * @param response
	 * @param startStr
	 * @param limitStr
	 * @param list
	 * @param model
	 * @author whz
	 */
	public static void GenerateGridsfDate(HttpServletResponse response,
			String startStr,String limitStr,List list,GridDataModel model)
	{
		int start = Integer.parseInt(StringUtils.isBlank(startStr)?"0":startStr);
		int limit = Integer.parseInt(StringUtils.isBlank(limitStr)?"50":limitStr);
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		int end = start + limit;
		int total = list.size();end = end > total ? total : end;
		if(start <= end) {
			model.setRows(list.subList(start, end));
		}
		model.setTotal(list.size());

		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl());
		ServletUtil.writerToClient(response, JSONObject.fromObject(model,jc).toString());
	}
	
	//全局排序的表格
	public static void GenerateGridsfDate(HttpServletResponse response,
			String startStr,String limitStr,List list,GridDataModel model,String sortBy,final String sortDir)
	{
		int start = Integer.parseInt(StringUtils.isBlank(startStr)?"0":startStr);
		int limit = Integer.parseInt(StringUtils.isBlank(limitStr)?"50":limitStr);
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		int end = start + limit;
		int total = list.size();end = end > total ? total : end;
		List lstan = list;
		if(sortBy!=null){//需要全局排序
			Comparator<Analyze> comparator=null;
			if("operationtype".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Analyze>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getOperationtype().compareTo(o2.getOperationtype()));
					}
                };
			}
			if("currentuserstate".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Analyze>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getCurrentuserstate().compareTo(o2.getCurrentuserstate()));
					}
                };
			}
			if("operatuserstate".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Analyze>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getOperatuserstate().compareTo(o2.getOperatuserstate()));
					}
                };
			}
			if("loginname".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Analyze>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getLoginname().compareTo(o2.getLoginname()));
					}
                };
			}
			if("deviceserial".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Analyze>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getDeviceserial().compareTo(o2.getDeviceserial()));
					}
                };
			}
			if("operationarea".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Analyze>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getOperationarea().compareTo(o2.getOperationarea()));
					}
				};
			}
			if("createtime".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Analyze>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getCreatetime().compareTo(o2.getCreatetime()));
					}
				};
			}
			if("time".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Analyze>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(new Integer(o1.getTime()).compareTo(new Integer(o2.getTime())));
					}
				};
			}
			if("projectname".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Analyze>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Analyze o1, Analyze o2) {
						return k*(o1.getProjectname().compareTo(o2.getProjectname()));
					}
                };
			}
			
//			List<Analyze> list1=new ArrayList<Analyze>();
            Collections.sort(lstan, comparator);
		}
		
		
		if(start <= end) {
			model.setRows(lstan.subList(start, end));
		}
		
		model.setTotal(list.size());
		
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl());
		ServletUtil.writerToClient(response, JSONObject.fromObject(model,jc).toString());
	}
	
	
	//特制_1
	public static void GenerateGridsfDate_1(HttpServletResponse response,
			String startStr,String limitStr,List list,GridDataModel model,String sortBy,final String sortDir)
	{
		int start = Integer.parseInt(StringUtils.isBlank(startStr)?"0":startStr);
		int limit = Integer.parseInt(StringUtils.isBlank(limitStr)?"50":limitStr);
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		int end = start + limit;
		int total = list.size();end = end > total ? total : end;
		List lstan = list;
		if(sortBy!=null){//需要全局排序
			Comparator<AnalyzeTimes> comparator=null;
			if("status".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<AnalyzeTimes>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(AnalyzeTimes o1, AnalyzeTimes o2) {
						return k*(o1.getStatus().compareTo(o2.getStatus()));
					}
                };
			}
			if("dev".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<AnalyzeTimes>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(AnalyzeTimes o1, AnalyzeTimes o2) {
						return k*(o1.getDev().compareTo(o2.getDev()));
					}
                };
			}
			if("time".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<AnalyzeTimes>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(AnalyzeTimes o1, AnalyzeTimes o2) {
						
						return k*(new Integer(o1.getTime()).compareTo(new Integer(o2.getTime())));
					}
                };
			}
			if("loginname".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<AnalyzeTimes>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(AnalyzeTimes o1, AnalyzeTimes o2) {
						return k*(o1.getLoginname().compareTo(o2.getLoginname()));
					}
				};
			}
			if("sum".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<AnalyzeTimes>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(AnalyzeTimes o1, AnalyzeTimes o2) {
						return k*(Integer.valueOf(o1.getSum()).compareTo(Integer.valueOf(o2.getSum())));
					}
				};
			}
			if("allsum".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<AnalyzeTimes>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(AnalyzeTimes o1, AnalyzeTimes o2) {
						return k*(Integer.valueOf(o1.getAllsum()).compareTo(Integer.valueOf(o2.getAllsum())));
					}
                };
			}
			
			
//			List<Analyze> list1=new ArrayList<Analyze>();
            Collections.sort(lstan, comparator);
		}
		
		
		if(start <= end) {
			model.setRows(lstan.subList(start, end));
		}
		
		model.setTotal(list.size());
		
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl());
		ServletUtil.writerToClient(response, JSONObject.fromObject(model,jc).toString());
	}
	
	public static void GenerateGridsfDate_Stat_1(HttpServletResponse response,
			String startStr,String limitStr,List list,GridDataModel model,String sortBy,final String sortDir)
	{
		int start = Integer.parseInt(StringUtils.isBlank(startStr)?"0":startStr);
		int limit = Integer.parseInt(StringUtils.isBlank(limitStr)?"50":limitStr);
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		int end = start + limit;
		int total = list.size();end = end > total ? total : end;
		List lstan = list;
		if(sortBy!=null){//需要全局排序
			Comparator<Stat_1> comparator=null;
			if("category".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_1>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_1 o1, Stat_1 o2) {
						return k*(o1.getCategory().compareTo(o2.getCategory()));
					}
                };
			}
			if("headcount".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_1>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_1 o1, Stat_1 o2) {
						return k*(new Integer(o1.getHeadcount()).compareTo(new Integer(o2.getHeadcount())));
					}
                };
			}
			if("durationcount".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_1>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_1 o1, Stat_1 o2) {
						
						return k*(new Integer(o1.getDurationcount()).compareTo(new Integer(o2.getDurationcount())));
					}
                };
			}
			if("avgduration".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_1>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_1 o1, Stat_1 o2) {
						return k*(new Integer(o1.getAvgduration()).compareTo(new Integer(o2.getAvgduration())));
					}
				};
			}
			if("timescount".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_1>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_1 o1, Stat_1 o2) {
						return k*(new Integer(o1.getTimescount()).compareTo(new Integer(o2.getTimescount())));
					}
				};
			}
			if("avgtimes".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_1>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_1 o1, Stat_1 o2) {
						return k*(new Integer(o1.getAvgtimes()).compareTo(new Integer(o2.getAvgtimes())));
					}
                };
			}
			
			
//			List<Analyze> list1=new ArrayList<Analyze>();
            Collections.sort(lstan, comparator);
		}
		
		
		if(start <= end) {
			model.setRows(lstan.subList(start, end));
		}
		
		model.setTotal(list.size());
		
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl());
		ServletUtil.writerToClient(response, JSONObject.fromObject(model,jc).toString());
	}
	
	public static void GenerateGridsfDate_Stat_2(HttpServletResponse response,
			String startStr,String limitStr,List list,GridDataModel model,String sortBy,final String sortDir)
	{
		int start = Integer.parseInt(StringUtils.isBlank(startStr)?"0":startStr);
		int limit = Integer.parseInt(StringUtils.isBlank(limitStr)?"50":limitStr);
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		int end = start + limit;
		int total = list.size();end = end > total ? total : end;
		List lstan = list;
		if(sortBy!=null){//需要全局排序
			Comparator<Stat_2> comparator=null;
			if("category".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_2>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						return k*(o1.getCategory().compareTo(o2.getCategory()));
					}
                };
			}
			if("headcount1".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						return k*(new Integer(o1.getHeadcount1()).compareTo(new Integer(o2.getHeadcount1())));
					}
				};
			}
			if("timescount1".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						
						return k*(new Integer(o1.getTimescount1()).compareTo(new Integer(o2.getTimescount1())));
					}
				};
			}
			if("headcount2".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						return k*(new Integer(o1.getHeadcount2()).compareTo(new Integer(o2.getHeadcount2())));
					}
				};
			}
			if("timescount2".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						
						return k*(new Integer(o1.getTimescount2()).compareTo(new Integer(o2.getTimescount2())));
					}
				};
			}
			if("headcount3".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						return k*(new Integer(o1.getHeadcount3()).compareTo(new Integer(o2.getHeadcount3())));
					}
				};
			}
			if("timescount3".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						
						return k*(new Integer(o1.getTimescount3()).compareTo(new Integer(o2.getTimescount3())));
					}
				};
			}
			if("headcount4".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						return k*(new Integer(o1.getHeadcount4()).compareTo(new Integer(o2.getHeadcount4())));
					}
				};
			}
			if("timescount4".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						
						return k*(new Integer(o1.getTimescount4()).compareTo(new Integer(o2.getTimescount4())));
					}
				};
			}
			if("headcount5".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						return k*(new Integer(o1.getHeadcount5()).compareTo(new Integer(o2.getHeadcount5())));
					}
				};
			}
			if("timescount5".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_2>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						
						return k*(new Integer(o1.getTimescount5()).compareTo(new Integer(o2.getTimescount5())));
					}
				};
			}
			if("headcount6".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_2>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						return k*(new Integer(o1.getHeadcount6()).compareTo(new Integer(o2.getHeadcount6())));
					}
                };
			}
			if("timescount6".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_2>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_2 o1, Stat_2 o2) {
						
						return k*(new Integer(o1.getTimescount6()).compareTo(new Integer(o2.getTimescount6())));
					}
                };
			}
			
			
//			List<Analyze> list1=new ArrayList<Analyze>();
            Collections.sort(lstan, comparator);
		}
		
		
		if(start <= end) {
			model.setRows(lstan.subList(start, end));
		}
		
		model.setTotal(list.size());
		
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl());
		ServletUtil.writerToClient(response, JSONObject.fromObject(model,jc).toString());
	}
	
	
	public static void GenerateGridsfDate_Stat_3(HttpServletResponse response,
			String startStr,String limitStr,List list,GridDataModel model,String sortBy,final String sortDir)
	{
		int start = Integer.parseInt(StringUtils.isBlank(startStr)?"0":startStr);
		int limit = Integer.parseInt(StringUtils.isBlank(limitStr)?"50":limitStr);
		if (limit == 0) {
			limit = Integer.MAX_VALUE;
		}
		int end = start + limit;
		int total = list.size();end = end > total ? total : end;
		List lstan = list;
		if(sortBy!=null){//需要全局排序
			Comparator<Stat_3> comparator=null;
			if("learningContent".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_3>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						return k*(o1.getLearningContent().compareTo(o2.getLearningContent()));
					}
                };
			}
			if("headcount1".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						return k*(new Integer(o1.getHeadcount1()).compareTo(new Integer(o2.getHeadcount1())));
					}
				};
			}
			if("timescount1".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getTimescount1()).compareTo(new Integer(o2.getTimescount1())));
					}
				};
			}
			if("headcount2".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						return k*(new Integer(o1.getHeadcount2()).compareTo(new Integer(o2.getHeadcount2())));
					}
				};
			}
			if("timescount2".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getTimescount2()).compareTo(new Integer(o2.getTimescount2())));
					}
				};
			}
			if("headcount3".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						return k*(new Integer(o1.getHeadcount3()).compareTo(new Integer(o2.getHeadcount3())));
					}
				};
			}
			if("timescount3".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getTimescount3()).compareTo(new Integer(o2.getTimescount3())));
					}
				};
			}
			if("headcount4".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						return k*(new Integer(o1.getHeadcount4()).compareTo(new Integer(o2.getHeadcount4())));
					}
				};
			}
			if("timescount4".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getTimescount4()).compareTo(new Integer(o2.getTimescount4())));
					}
				};
			}
			if("headcount5".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						return k*(new Integer(o1.getHeadcount5()).compareTo(new Integer(o2.getHeadcount5())));
					}
				};
			}
			if("timescount5".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getTimescount5()).compareTo(new Integer(o2.getTimescount5())));
					}
				};
			}
			if("headcount6".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_3>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						return k*(new Integer(o1.getHeadcount6()).compareTo(new Integer(o2.getHeadcount6())));
					}
                };
			}
			if("timescount6".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_3>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getTimescount6()).compareTo(new Integer(o2.getTimescount6())));
					}
                };
			}
			if("learningTime1".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getLearningTime1()).compareTo(new Integer(o2.getLearningTime1())));
					}
				};
			}
			if("learningTime2".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getLearningTime2()).compareTo(new Integer(o2.getLearningTime2())));
					}
				};
			}
			if("learningTime3".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getLearningTime3()).compareTo(new Integer(o2.getLearningTime3())));
					}
				};
			}
			if("learningTime4".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getLearningTime4()).compareTo(new Integer(o2.getLearningTime4())));
					}
				};
			}
			if("learningTime5".equals(sortBy)){
				//这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
				comparator=new Comparator<Stat_3>(){
					final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getLearningTime5()).compareTo(new Integer(o2.getLearningTime5())));
					}
				};
			}
			if("learningTime6".equals(sortBy)){
                //这里使用了简单的字符串比较，实际应用中可能要用比较复杂的算法
                	comparator=new Comparator<Stat_3>(){
                	final int k="asc".equals(sortDir)?1:-1;
					@Override
					public int compare(Stat_3 o1, Stat_3 o2) {
						
						return k*(new Integer(o1.getLearningTime6()).compareTo(new Integer(o2.getLearningTime6())));
					}
                };
			}
			
//			List<Analyze> list1=new ArrayList<Analyze>();
            Collections.sort(lstan, comparator);
		}
		
		
		if(start <= end) {
			model.setRows(lstan.subList(start, end));
		}
		
		model.setTotal(list.size());
		
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImpl());
		ServletUtil.writerToClient(response, JSONObject.fromObject(model,jc).toString());
	}
	
	public static JSONObject buildPerson(String id,String name){
        JSONObject result=new JSONObject();
        result.put("value", id);
        result.put("text", name);
        return result;
    }
}
