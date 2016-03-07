package org.izhong.expert.util;

public class Page {

	/**
	 * pagesize = 12;//每页显示记录数
	 * liststep = 20;//最多显示分页页数
	 * pages = 1;//默认显示第一页
	 * count = 40;//假设取出记录总数
	 * */
	public Page(){}
	public Page(int pagesize,int liststep,int pages){
		this.pages=pages;
		this.pagesize=pagesize;
		this.liststep=liststep;
		this.seek=(pages-1)*pagesize;
	}
	private int pagesize = 12;//每页显示记录数
    private int liststep = 10;//最多显示分页页数
    private int pages = 1;//默认显示第一页
    private long count = 40;//假设取出记录总数
    private int seek=0;
    private String parameter;
    /**
     * java分页类
     * @return
     */
	public String getPagebreak(){
	    int pagescount = (int) Math.ceil((double)count/pagesize);//求总页数，ceil（num）取整不小于num
	    if(pagescount<=1)return "&nbsp;";
	    if (pagescount < pages){
	        pages = pagescount;//如果分页变量大总页数，则将分页变量设计为总页数
	    }
	    if (pages < 1){
	        pages = 1;//如果分页变量小于１,则将分页变量设为１
	    }
	    int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//从第几页开始显示分页信息
	    if (listbegin < 1){
	        listbegin = 1;
	    }
	    int listend = pages + liststep/2;//分页信息显示到第几页
	    if (listend > pagescount){
	        listend = pagescount + 1;
	    }
	    
	    //显示数据部分
        int recordbegin = (pages - 1) * pagesize;//起始记录
        int recordend = 0;
        recordend = recordbegin + pagesize;
        //最后一页记录显示处理
        if (pages == pagescount){
            recordend = (int) (recordbegin + pagesize * (count % pagesize) * 0.1);
        }
        
        StringBuilder pagebreak=new StringBuilder();//分页页码串
        
        //显示上一页
        if (pages > 1){
        	pagebreak.append("<a  style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#272727;font-family:宋体;font-size:12px;text-decoration:none;'  href='javascript:void(0);' href=?p="+(pages-1)+parameter+">上一页</a>&nbsp;");
        }
        
        //显示分页码
        for (int i = listbegin; i < listend; i++){
            if (i != pages){//如果i不等于当前页
            	pagebreak.append("<a style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#272727;font-family:宋体;font-size:12px;text-decoration:none;' href='javascript:void(0);' href=?p="+i+parameter+">["+i+"]</a>");
            } else{
            	pagebreak.append("<a style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#FFFFFF;background-color:#CCCCCC;font-family:宋体;font-size:12px;text-decoration:none;' >"+i+"</a>");
            }
        }
        //显示下一页
        if (pages != pagescount){
        	pagebreak.append("<a style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#272727;font-family:宋体;font-size:12px;text-decoration:none;' href='javascript:void(0);' href='javascript:void(0);' href=?p="+(pages+1)+parameter+">下一页</a>");
        }
        return pagebreak.toString();
	}
	 /**
     * javascript分页类
     * @return
     */
	public String getPagebreakToJs(){
		
	    int pagescount = (int) Math.ceil((double)count/pagesize);//求总页数，ceil（num）取整不小于num
	    if(pagescount<=1)return "&nbsp;";
	    if (pagescount < pages){
	        pages = pagescount;//如果分页变量大总页数，则将分页变量设计为总页数
	    }
	    if (pages < 1){
	        pages = 1;//如果分页变量小于１,则将分页变量设为１
	    }
	    int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//从第几页开始显示分页信息
	    if (listbegin < 1){
	        listbegin = 1;
	    }
	    int listend = pages + liststep/2;//分页信息显示到第几页
	    if (listend > pagescount){
	        listend = pagescount + 1;
	    }
	    //显示数据部分
        int recordbegin = (pages - 1) * pagesize;//起始记录
        int recordend = 0;
        recordend = recordbegin + pagesize;
        //最后一页记录显示处理
        if (pages == pagescount){
            recordend = (int) (recordbegin + pagesize * (count % pagesize) * 0.1);
        }       
        StringBuilder pagebreak=new StringBuilder();//分页页码串
        //显示上一页
        if (pages > 1){
        	pagebreak.append("<a style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#272727;font-family:宋体;font-size:12px;text-decoration:none;'  href='javascript:void(0);' onclick='getShareList("+(pages-1)+","+count+");'>上一页</a>");
        	//pagebreak.append("<span style='color:#0066FF;cursor:pointer;' onclick='javascript:getShareList("+(pages-1)+","+count+");'>上一页</span>&nbsp;");
        }    
        //显示分页码
        for (int i = listbegin; i < listend; i++){
            if (i != pages){//如果i不等于当前页
            	pagebreak.append("<a style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#272727;font-family:宋体;font-size:12px;text-decoration:none;' href='javascript:void(0);' onclick='getShareList("+i+","+count+");'>"+i+"</a>");
            	//pagebreak.append("<span style='color:#0066FF;cursor:pointer;' onclick='javascript:getShareList("+i+","+count+")'>["+i+"]</span>&nbsp;");
            } else{
            	pagebreak.append("<a style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#FFFFFF;background-color:#CCCCCC;font-family:宋体;font-size:12px;text-decoration:none;' href='javascript:void(0);'>"+i+"</a>");
            	//pagebreak.append("<span style='color:#CC0000; font-weight:bold;'>"+i+"</span>&nbsp;");
            }
        }
        //显示下一页 
        if (pages != pagescount){
        	pagebreak.append("<a style='margin:0 10px;padding:4px;border:1px solid #CCCCCC;color:#272727;font-family:宋体;font-size:12px;text-decoration:none;' href='javascript:void(0);' href='javascript:void(0);' onclick='getShareList("+(pages+1)+","+count+");'>下一页</a>");
        	//pagebreak.append("<span style='color:#0066FF;cursor:pointer;' onclick='javascript:getShareList("+(pages+1)+","+count+");'>下一页</span>");
        }
        return pagebreak.toString();
	}
	 /**
     * javascript分页类
     * @return
     */
	public String getPagebreakToJsTwo(){
	    int pagescount = (int) Math.ceil((double)count/pagesize);//求总页数，ceil（num）取整不小于num
	    if(pagescount<=1)return "&nbsp;";
	    if (pagescount < pages){
	        pages = pagescount;//如果分页变量大总页数，则将分页变量设计为总页数
	    }
	    if (pages < 1){
	        pages = 1;//如果分页变量小于１,则将分页变量设为１
	    }
	    int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//从第几页开始显示分页信息
	    if (listbegin < 1){
	        listbegin = 1;
	    }
	    int listend = pages + liststep/2;//分页信息显示到第几页
	    if (listend > pagescount){
	        listend = pagescount + 1;
	    }
	    
	    //显示数据部分
        int recordbegin = (pages - 1) * pagesize;//起始记录
        int recordend = 0;
        recordend = recordbegin + pagesize;
        //最后一页记录显示处理
        if (pages == pagescount){
            recordend = (int) (recordbegin + pagesize * (count % pagesize) * 0.1);
        }
        
        StringBuilder pagebreak=new StringBuilder();//分页页码串
        
        //显示上一页
        if (pages > 1){
        	//pagebreak.append("<a href=javascript:getShareList("+(pages-1)+","+count+");>上一页</a>&nbsp;");
        	pagebreak.append("<span style='color:#0066FF;cursor:pointer;' onclick='javascript:getShareList1("+(pages-1)+","+count+");'>上一页</span>&nbsp;");
        }
        
        //显示分页码
        for (int i = listbegin; i < listend; i++){
            if (i != pages){//如果i不等于当前页
            	pagebreak.append("<span style='color:#0066FF;cursor:pointer;' onclick='javascript:getShareList1("+i+","+count+")'>["+i+"]</span>&nbsp;");
            } else{
            	pagebreak.append("<span style='color:#CC0000; font-weight:bold;'>"+i+"</span>&nbsp;");
            }
        }
        //显示下一页
        if (pages != pagescount){
        	pagebreak.append("<span style='color:#0066FF;cursor:pointer;' onclick='javascript:getShareList1("+(pages+1)+","+count+");'>下一页</span>");
        }
        return pagebreak.toString();
	}
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getListstep() {
		return liststep;
	}

	public void setListstep(int liststep) {
		this.liststep = liststep;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		seek=(pages-1)*pagesize;
		this.pages = pages;
	}
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	public int getSeek() {
		return seek;
	}
	public void setSeek(int seek) {
		this.seek = seek;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
}                             