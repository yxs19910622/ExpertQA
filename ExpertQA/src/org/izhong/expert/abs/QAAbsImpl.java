package org.izhong.expert.abs;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.Questions;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.Page;
import org.izhong.web.util.SendMail;

public class QAAbsImpl extends QAAbs {

	private List<Map> addUserName(List<Map> res){
		List<Map<String,String>> list = this.replysService.getUserNameByQuestionId();
		Map map = new HashMap();
		for(int i = 0;i < list.size(); i++){
			Map uname = list.get(i);
			map.put(uname.get("QUESTIONID"), uname.get("ALIASNAME"));
		}
		for(int i = 0;i < res.size(); i++){
			Map obj = res.get(i);
			obj.put("ANSWER", map.get(obj.get("QUESTIONID")) == null?"尚未回答": map.get(obj.get("QUESTIONID")));
		}
		return res;
	}
	public List<Map> getQuestionsList(Map<String,String> map){
		String temp = map.get("captionText");
		String sql = manageSql(temp);
		map.put("captionText", sql);
		
		page=new Page();
		page.setPagesize(10);//可以设置每页的记录数
		page.setPages(Integer.parseInt(map.get("p").toString()));
		
		if(map.get("sum").equals("0")){
			page.setCount(getQuestionsListCount(map));
		}else{
			page.setCount(Long.parseLong(map.get("sum")));
		}
		map.put("seek", String.valueOf(page.getSeek()));
		map.put("pagesize", String.valueOf(page.getSeek()+page.getPagesize()));//oracle分页开始记录数加上分页记录数
		
		List<Map> reslist= addUserName(this.questionService.getQuestionsList(map));
		//System.out.println("temp:"+temp);
		ManageColor(temp,reslist);
		Map<String,String> m=new HashMap<String,String>();
		m.put("pagebreak", page.getPagebreakToJs());//
		m.put("hitCount", page.getCount()+"");
		map.put("isAlreadyClosed", "0 or isAlreadyClosed = 1 ");//计算出所有命中的数量
		long count = getQuestionsListCount(map);
		m.put("count", (count - page.getCount())+"");
		reslist.add(m);
		return reslist;
	}
	private String manageSql(String sql){
		//and (question.CAPTIONTEXT like '%'||#{captionText}||'%' or question.QUESTIONCONTENT like '%'||#{captionText}||'%')
		StringBuffer sb = new StringBuffer(" and ( ");
		String   regEx= "[' ']+";   //一个或多个空格
        Pattern  p = Pattern.compile(regEx);
        Matcher  m = p.matcher(sql);
        sql = m.replaceAll(" ");
        String[] arrs = sql.split(" ");
        for(int i = 0;i < arrs.length;i++){
        	sb.append(" or lower(question.CAPTIONTEXT||question.QUESTIONCONTENT) like '%"+arrs[i]+"%' ");
        }
        sb.append(") ");
        //System.out.println(sb.toString());
		return sb.toString().replaceFirst("or", "");
	}
	private void ManageColor(String keyValue,List<Map> reslist){

		String   regEx= "[' ']+";   //一个或多个空格
		Pattern  p = Pattern.compile(regEx);
		Matcher  m = p.matcher(keyValue);
		keyValue = m.replaceAll(" ");
		String[] arrs = keyValue.split(" ");
		for(int i = 0;i < reslist.size(); i++){
			Map res = reslist.get(i);
			res.put("caption", res.get("CAPTIONTEXT").toString());
			res.put("content", res.get("QUESTIONCONTENT").toString());
			if(!keyValue.equals("")){
				for(int j = 0;j < arrs.length; j++){
					res.put("CAPTIONTEXT", res.get("CAPTIONTEXT").toString().replace(arrs[j], "<font color=\"#DD4B39\">"+arrs[j]+"</font>"));
					res.put("QUESTIONCONTENT", res.get("QUESTIONCONTENT").toString().replace(arrs[j], "<font color=\"#DD4B39\">"+arrs[j]+"</font>"));
				}    
			}
		}
	}
	/**
	 * 获取问题的记录数
	 */
	public long getQuestionsListCount(Map<String,String> map){
		return this.questionService.getQuestionsListCount(map);
	}
	public void addQuestion(Questions question){
		question.setQuestionID(BaseUtil.generateIdentifier());
		question.setIsExigentQuestion("0");
		question.setCreateTime(DateUtil.getCurrTime());
		question.setReplyCount(0);
		question.setStatus("0");
		questionService.addQuestion(question);
	}
	public HashMap<String,String> getOneQuestion(String questionId){
		HashMap map = this.questionService.getOneQuestion(questionId);
		long num = this.questionService.getFavoritesCountByQuestionId(questionId);
		if(map != null){
	       map.put("favoriteCount",num);
		}
		return map;
	}
	@Override
	public List<QueryHotWords> findHotWordsAll() {
		return keyWordService.qryHotWordsAll();
	}
	
	public long addFavorite(HashMap favorite){
		long num = this.questionService.checkFavorite(favorite);
		if(num > 0){
			return 0;
		}else{
			return this.questionService.addFavorite(favorite);
		}
	}
	/**
	 * 根据问题id查询所有对该问题的回复
	 * @param userID
	 * @return
	 * @author whz
	 */
	public List<Map> getAllReplysByQuestionId(HashMap map){
		return this.replysService.getAllReplysByQuestionId(map);
	}
	/**
	 * 添加一条专家回复数据
	 * @param map
	 * @return
	 * @author fwy
	 */
	public boolean addReplyContent(Map map){
		map.put("replyId", BaseUtil.generateIdentifier());
		map.put("replyTime", DateUtil.getCurrTime());
		map.put("pollCount", 0);
		map.put("isalreadyDeleted", "0");
		map.put("istop", "0");
		int num = this.replysService.addReplyContent(map);
		this.questionService.swithQuestion(0, (String)map.get("questionId"));
		//查邮箱,通过questionId
		String questionId = (String)map.get("questionId");
		String email = this.questionService.getEmailByquestionId(questionId);
		//添加邮件提醒
	    SendMail sm = new SendMail();
	    try {
			sm.send_reply(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.questionService.updateReplyCount(map.get("questionId")+"");
		return num > 0?true:false;
	}
	//赞同次数
	public int updatePollCount(String replyId){
		return this.replysService.updatePollCount(replyId);
	}
	/**
	 * 获取提问问题最多的前10个用户
	 * @param 
	 * @return
	 */
	public List<Map> getActiveUser(){
		return this.questionService.getActiveUser();
	}
	/**
	 * 根据问题的类型获取所有问题
	 * @param String typeId
	 * @return List<Map>
	 */
	public List<Map> getQuestionListByTypeId(String typeId){
		HashMap map = new HashMap();
		map.put("typeId", typeId);
		map.put("isAlreadyClosed", "1");//关闭 热门问题
		return this.questionService.getQuestionListByTypeId(map);
	}
	public List<Map> getQuestionListByTypeIdCopy(String typeId){
		HashMap map = new HashMap();
		map.put("typeId", typeId);
		map.put("isAlreadyClosed", "0");//关闭 热门问题
		return this.questionService.getQuestionListByTypeId(map);
	}
	public List<Map> getQaTypeParent(){
		return this.qatypeService.getQATypeByParent();
	}
	public List<Map> getQaTypeChild(){
		return this.qatypeService.getQATypesByChild();
	}
	/**
	 * 根据问题id修改该问题
	 * @param questionId
	 */
	public boolean upateQuestion(HashMap map){
		this.questionService.upateQuestion(map);
		return true;
	}
	/**
     * 根据回复id获取改回复记录
     * @param replyId
     * @return
     */
    public HashMap getOneReply(String replyId){
    	return this.replysService.getOneReply(replyId);
    }
    /**
     * 根据回复id修改回复内容
     * @param map
     */
    public boolean updateReply(HashMap map){
    	this.replysService.updateReply(map);
    	return true;
    }
    /**
     * 根据userid和questionid获取回复内容
     * @param map
     * @return
     */
    public HashMap getReplyContentByUserIdAndQuestionId(HashMap map){
    	return this.replysService.getReplyContentByUserIdAndQuestionId(map);
    }
}
