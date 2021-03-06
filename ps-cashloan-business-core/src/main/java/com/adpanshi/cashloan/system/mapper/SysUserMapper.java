package com.adpanshi.cashloan.system.mapper;

import com.adpanshi.cashloan.core.common.mapper.BaseMapper;
import com.adpanshi.cashloan.core.common.mapper.RDBatisDao;
import com.adpanshi.cashloan.system.domain.SysUser;

import java.util.List;
import java.util.Map;


/**
 * 
 * 用户DAO
 * 
 * @version 1.0
 * @author 8452
 * @created 2014年9月22日 下午2:53:15
 */
@RDBatisDao
public interface SysUserMapper extends BaseMapper<SysUser, Long>{

	/**
	 * 编辑用户登录信息
	 * @param sysUser
	 *            用户实体
	 * @return Boolean
	 * @version 1.0

	 * @created 2014年9月22日
	 */
	Boolean editUserLoginInfo(SysUser sysUser);

	/**
	 * 编辑用户密码
	 * @param sysUser
	 *            用户实体
	 * @return Boolean
	 * @version 1.0

	 * @created 2014年9月22日
	 */
	Boolean editUserPassWord(SysUser sysUser);

    /**
     *根据ID更新  通用更新
     *@param map
     *@return Boolean
     */ 
    int updateSysUserById(Map<String, Object> map);

	/**
	 * 根据机构获取客户专员
	 * @param paramMap
	 * @return 
	 * @version 1.0

	 * @created 2015年1月15日
	 */
	List<Map<String, Object>> getCustomerServiceStaffList(Map<String, Object> paramMap);
	
	int queryRoleUserIsUse(Map<String, Object> data);

    SysUser getUserByUserName(String userName);

    SysUser getUserByNumber(String number);

	int getPageCountOracle(Map<String, Object> map);

	List<Map<String, Object>> getUserInfoOracle(Map<String, Object> mapdata);

	Map<String, Object> queryTheLeastBusyUserByMap(Map<String, Object> params);

	Map<String, Object> queryTheUserWhoDidThisTask(Map<String, Object> paramMap);

	SysUser getUserByMap(Map<String, Object> paramMap);

	List<Map<String, Object>> getUserInfo(Map<String, Object> params);
	
	List<Map<String, Object>> listUserInfo(Map<String, Object> mapdata);

	void updateState(Map<String, Object> result);
	/**zy 查询用户名称*/
	List<SysUser> findUserName(Map<String, Object> params);

	List<SysUser> getSysUserByMap(Map<String, Object> params);
}
