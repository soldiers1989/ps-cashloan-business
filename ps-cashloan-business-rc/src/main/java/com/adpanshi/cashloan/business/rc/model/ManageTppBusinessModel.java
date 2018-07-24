package com.adpanshi.cashloan.business.rc.model;

import com.adpanshi.cashloan.business.rc.domain.TppBusiness;

/**
 * 第三方征信接口信息Model - 后台管理  
 * 

 * @version 1.0.0
 * @date 2017年3月18日 上午11:24:23
 * Copyright 粉团网路 Arc All Rights Reserved
 *
 *
 *
 */
public class ManageTppBusinessModel extends TppBusiness {

	private static final long serialVersionUID = 1L;

	/**
	 * 状态中文描述
	 */
	private String stateStr;

	/**
	 * 获取状态中文描述
	 * 
	 * @return stateStr
	 */
	public String getStateStr() {
		return stateStr;
	}

	/**
	 * 设置状态中文描述
	 * 
	 * @param stateStr
	 */
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	
}
