package com.adpanshi.cashloan.business.system.mapper;

import com.adpanshi.cashloan.business.core.common.exception.PersistentDataException;
import com.adpanshi.cashloan.business.core.common.mapper.BaseMapper;
import com.adpanshi.cashloan.business.core.common.mapper.RDBatisDao;
import com.adpanshi.cashloan.business.system.domain.SysConfig;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

/**
* User:    mcwang
* DateTime:2016-08-04 03:26:22
* details: 系统参数表,Dao接口层
* source:  代码生成器
*/
@RDBatisDao
public interface SysConfigMapper extends BaseMapper<SysConfig,Long> {


    /**
     * 系统参数表表,查询数据
     * @param map,pageBounds
     * @return List<SysConfig>
     * @throws PersistentDataException
     */
    List<SysConfig> select(Map<String, Object> map, PageBounds pageBounds);

    /**
     * 系统参数表表,总数
     * @param map
     * @return Integer
     * @throws PersistentDataException
     */
    Integer total(Map<String, Object> map);
    
    /**
     * 查询所有系统配置
     * @return
     */
    List<SysConfig> findAll();
    
    /**
     * 根据code查询系统配置
     * @return
     */
    SysConfig selectByCode(String code);
    
    /**
     * 根据code模糊查询系统配置
     * @return list
     */
	List<SysConfig> listByCode(String code);
    
}
