package com.adpanshi.cashloan.business.rc.mapper;

import com.adpanshi.cashloan.business.core.common.mapper.BaseMapper;
import com.adpanshi.cashloan.business.core.common.mapper.RDBatisDao;
import com.adpanshi.cashloan.business.rc.domain.TppBusiness;
import com.adpanshi.cashloan.business.rc.model.ManageTppBusinessModel;
import com.adpanshi.cashloan.business.rc.model.TppBusinessModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 第三方征信接口信息Dao
 * 

 * @version 1.0.0
 * @date 2017-03-14 13:41:57
 *
 *
 *
 *
 */
@RDBatisDao
public interface TppBusinessMapper extends BaseMapper<TppBusiness,Long> {

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<TppBusinessModel> listAll();

	/**
	 * 条件查询第三方征信接口信息
	 * 
	 * @param paramMap
	 * @return
	 */
	List<ManageTppBusinessModel> list(Map<String, Object> paramMap);

	/**
	 * 据tppId查询第三方征信接口信息
	 * 
	 * @param tppId
	 * @return
	 */
	ManageTppBusinessModel findByTppId(long tppId);
	
	/**
	 * 根据Nid查找
	 * @param nid
	 * @return
	 */
	TppBusiness findByNid(@Param("nid") String nid, @Param("tppId") Long tppId);
}
