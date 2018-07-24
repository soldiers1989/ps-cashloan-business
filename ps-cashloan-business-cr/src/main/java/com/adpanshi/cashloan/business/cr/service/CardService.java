package com.adpanshi.cashloan.business.cr.service;

import com.adpanshi.cashloan.business.core.common.exception.CreditException;
import com.adpanshi.cashloan.business.core.common.service.BaseService;
import com.adpanshi.cashloan.business.cr.domain.Card;
import com.github.pagehelper.Page;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

/**
 * 评分卡Service
 * 
 * @author
 * @version 1.0.0
 * @date 2017-01-04 15:06:51
 * Copyright 粉团网路  creditrank All Rights Reserved
 *
 * 
 *
 */
public interface CardService extends BaseService<Card, Long>{

	/**
	 * 分页查询
	 * @param secreditrankhMap
	 * @param current
	 * @param pageSize
	 * @return
	 */
	Page<Card> page(Map<String, Object> secreditrankhMap, int current, int pageSize);

	/**
	 * 查询所有评分卡
	 * @return
	 */
	List<Card> findAll();

	/**
	 * 保存数据
	 * @param cardName
	 * @return
	 * @throws CreditException
	 */
	Map<String, Object> save(String cardName) throws CreditException;

	/**
	 * 主键查询
	 * @param cardId
	 * @return
	 */
	Card findByPrimary(long cardId);

	/**
	 * 修改状态
	 * @param map
	 * @return
	 * @throws ServerException
	 * @throws CreditException
	 */
	Map<String, Object> updateState(long id, String state) throws ServerException, CreditException;

	/**
	 * 修改
	 * @param cardMap
	 */
	void updateSelective(Map<String, Object> cardMap);

	/**
	 * 修改评分卡名称
	 * @param cardMap
	 */
	Map<String, Object> update(long id, String cardName);
}
