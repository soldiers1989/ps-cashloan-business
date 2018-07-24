package com.adpanshi.cashloan.business.cr.service.impl;

import com.adpanshi.cashloan.business.core.common.context.Constant;
import com.adpanshi.cashloan.business.core.common.exception.CreditException;
import com.adpanshi.cashloan.business.core.common.mapper.BaseMapper;
import com.adpanshi.cashloan.business.core.common.service.impl.BaseServiceImpl;
import com.adpanshi.cashloan.business.cr.domain.Card;
import com.adpanshi.cashloan.business.cr.domain.Factor;
import com.adpanshi.cashloan.business.cr.domain.FactorParam;
import com.adpanshi.cashloan.business.cr.domain.Item;
import com.adpanshi.cashloan.business.cr.mapper.CardMapper;
import com.adpanshi.cashloan.business.cr.mapper.FactorMapper;
import com.adpanshi.cashloan.business.cr.mapper.FactorParamMapper;
import com.adpanshi.cashloan.business.cr.mapper.ItemMapper;
import com.adpanshi.cashloan.business.cr.model.FactorParamModel;
import com.adpanshi.cashloan.business.cr.service.FactorParamService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 评分因子参数ServiceImpl
 * 
 * @author
 * @version 1.0.0
 * @date 2017-01-05 11:13:30
 * Copyright 粉团网路  creditrank All Rights Reserved
 *
 * 
 *
 */
 
@Service("factorParamService")
public class FactorParamServiceImpl extends BaseServiceImpl<FactorParam, Long> implements FactorParamService {
	
   
    @Resource
    private FactorParamMapper factorParamMapper;
    @Resource
    private FactorMapper factorMapper;
    @Resource
    private ItemMapper itemMapper;
	@Resource
	private CardMapper cardMapper;

	@Override
	public BaseMapper<FactorParam, Long> getMapper() {
		return factorParamMapper;
	}

	@Override
	public Page<FactorParam> page(Map<String, Object> secreditrankhMap, int current,
			int pageSize) {
		PageHelper.startPage(current, pageSize);
		List<FactorParam> list = factorParamMapper.listSelective(secreditrankhMap);
		return (Page<FactorParam>)list;
	}

	@Override
	public Map<String,Object> deleteSelective(long id) throws CreditException {
		int msg = 0;
		Map<String,Object> result = new HashMap<String,Object>();
		FactorParam fp = factorParamMapper.findByPrimary(id);
		Factor ft = factorMapper.findByPrimary(fp.getFactorId());
		Item item = itemMapper.findByPrimary(ft.getItemId());
		Card card = cardMapper.findByPrimary(item.getCardId());
		
		if ("10".equals(card.getType())) {
			msg = factorParamMapper.deleteSelective(id);
		}
		if (msg>0) {
			result.put(Constant.RESPONSE_CODE, Constant.SUCCEED_CODE_VALUE);
			result.put(Constant.RESPONSE_CODE_MSG, "删除成功");
			//修改评分因子分值
			long factorId = ft.getId();
			Map<String, Object> factorMap = new HashMap<>();
			factorMap.put("id", ft.getId());
			factorMap.put("factorScore", factorParamMapper.findMaxScore(factorId));
			factorMapper.updateSelective(factorMap);
			//修改评分项目分值
			long itemId = item.getId();
			Map<String, Object> itemMap = new HashMap<String,Object>();
			itemMap.put("id", item.getId());
			itemMap.put("score", factorMapper.findSumScore(itemId));
			itemMapper.updateSelective(itemMap);
			//修改评分卡分值
			long cardId = card.getId();
			Map<String, Object> cardMap = new HashMap<String,Object>();
			cardMap.put("id", card.getId());
			cardMap.put("score", itemMapper.findSumScore(cardId));
			cardMapper.updateSelective(cardMap);
			
		}else {
			result.put(Constant.RESPONSE_CODE, Constant.FAIL_CODE_VALUE);
			result.put(Constant.RESPONSE_CODE_MSG, "删除失败,请查看评分卡是否被使用");
		}
		return result;
	}
	
	@Override
	public int updateSelective(Map<String, Object> updateMap) {
		return factorParamMapper.updateSelective(updateMap);
	}

	@Override
	public List<FactorParamModel> listSelect(Map<String, Object> param) {
		return factorParamMapper.listSelect(param);
	}

	@Override
	public int save(FactorParam fp) {
		return factorParamMapper.save(fp);
	}

	@Override
	public FactorParam findByPrimary(long id) {
		return factorParamMapper.findByPrimary(id);
	}

	@Override
	public int deleteSelective(Long id) {
		return factorParamMapper.deleteSelective(id);
	}

	@Override
	public int findMaxScore(long factorId) {
		return factorParamMapper.findMaxScore(factorId);
	}

}