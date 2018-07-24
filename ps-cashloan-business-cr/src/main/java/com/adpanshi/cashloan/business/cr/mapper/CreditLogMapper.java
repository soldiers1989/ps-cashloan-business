package com.adpanshi.cashloan.business.cr.mapper;

import com.adpanshi.cashloan.business.core.common.mapper.BaseMapper;
import com.adpanshi.cashloan.business.core.common.mapper.RDBatisDao;
import com.adpanshi.cashloan.business.cr.domain.CreditLog;
import com.adpanshi.cashloan.business.cr.model.CreditLogModel;

import java.util.List;
import java.util.Map;

/**
 * 授信额度记录Dao
 * 
 * @author
 * @version 1.0.0
 * @date 2016-12-16 10:31:23
 *
 *
 * 
 *
 */
@RDBatisDao
public interface CreditLogMapper extends BaseMapper<CreditLog,Long> {

	/**
	 * 分页查询
	 * @param searchMap
	 * @return
	 */
	List<CreditLogModel> findLog(Map<String, Object> searchMap);

}
