package com.adpanshi.cashloan.business.cl.model;

import java.util.Date;


/**
 * 催款统计列表字段
 * 

 * @version 1.0.0
 * @date 2017-03-07 14:28:22 Copyright 粉团网路 arc All Rights Reserved
 *
 */
public class UrgeRepayCountModel {

	/**
	 * 催款人用户名
	 */
	private String userName;

	/**
	 * 催款人登录名
	 */
	private String loginName;

	/**
	 * 催款人姓名
	 */
	private String realName;

	/**
	 * 催款人工作号
	 */
	private String jobNum;
 
	/**
	 * 催款人状态
	 */
	private String status;

	/**
	 * 催收总数
	 */
	private int count;
	
	/**
	 * 待催收数
	 */
	private int waitCount;
	/**
	 * 催收成功数
	 */
	private int successCount;
	/**
	 * 昨日催收数
	 */
	private int yesterdayCount;
	/**
	 * 订单总数
	 */
	private int orderCount;
	/**
	 * 坏账数
	 */
	private int failCount;
	/**
	 * 催回率
	 */
	private double backRate;
	/**
	 * 时间
	 */
	private Date createTime;
	/**
	 * 承诺还款数
	 */
	private int promisCount;
	
	/**
	 * 累计订单总数
	 */
	private int allOrderCount;
	/**
	 * 累计坏账数
	 */
	private int allFailCount;
	/**
	 * 累计催回率
	 */
	private double allBackRate;
	/**
	 * 累计催收成功率
	 */
	private int allSuccessCount;
 
	
	public int getPromisCount() {
		return promisCount;
	}
	public void setPromisCount(int promisCount) {
		this.promisCount = promisCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getJobNum() {
		return jobNum;
	}
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getWaitCount() {
		return waitCount;
	}
	public void setWaitCount(int waitCount) {
		this.waitCount = waitCount;
	}
	public int getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}
	public int getYesterdayCount() {
		return yesterdayCount;
	}
	public void setYesterdayCount(int yesterdayCount) {
		this.yesterdayCount = yesterdayCount;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	public double getBackRate() {
		return backRate;
	}
	public void setBackRate(double backRate) {
		this.backRate = backRate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getAllOrderCount() {
		return allOrderCount;
	}
	public void setAllOrderCount(int allOrderCount) {
		this.allOrderCount = allOrderCount;
	}
	public int getAllFailCount() {
		return allFailCount;
	}
	public void setAllFailCount(int allFailCount) {
		this.allFailCount = allFailCount;
	}
	public double getAllBackRate() {
		return allBackRate;
	}
	public void setAllBackRate(double allBackRate) {
		this.allBackRate = allBackRate;
	}
	public int getAllSuccessCount() {
		return allSuccessCount;
	}
	public void setAllSuccessCount(int allSuccessCount) {
		this.allSuccessCount = allSuccessCount;
	}
	
	
}