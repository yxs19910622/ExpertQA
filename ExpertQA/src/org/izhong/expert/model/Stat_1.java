package org.izhong.expert.model;

import java.io.Serializable;
import java.util.Date;

public class Stat_1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String category;//分类类别
	private int headcount;//总人数
	private int durationcount;//总使用时长
	private int avgduration;//人平均使用时长
	private int timescount;//总操作次数
	private int avgtimes;//人平均操作次数
	private int usecount;//总使用次数
	private int avguse;//次平均操作次数
	private int avgusetime;//次平均使用时长
	
	public Stat_1() {
	}

	public int getHeadcount() {
		return headcount;
	}

	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}

	public int getDurationcount() {
		return durationcount;
	}

	public void setDurationcount(int durationcount) {
		this.durationcount = durationcount;
	}

	public int getAvgduration() {
		return avgduration;
	}

	public void setAvgduration(int avgduration) {
		this.avgduration = avgduration;
	}

	public int getTimescount() {
		return timescount;
	}

	public void setTimescount(int timescount) {
		this.timescount = timescount;
	}

	public int getAvgtimes() {
		return avgtimes;
	}

	public void setAvgtimes(int avgtimes) {
		this.avgtimes = avgtimes;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUsecount() {
		return usecount;
	}

	public void setUsecount(int usecount) {
		this.usecount = usecount;
	}

	public int getAvguse() {
		return avguse;
	}

	public void setAvguse(int avguse) {
		this.avguse = avguse;
	}

	public int getAvgusetime() {
		return avgusetime;
	}

	public void setAvgusetime(int avgusetime) {
		this.avgusetime = avgusetime;
	}
	
	
}
