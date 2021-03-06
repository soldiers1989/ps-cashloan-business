package com.adpanshi.cashloan.business.system.service.impl;

import com.adpanshi.cashloan.business.core.common.mapper.BaseMapper;
import com.adpanshi.cashloan.business.core.common.service.impl.BaseServiceImpl;
import com.adpanshi.cashloan.business.system.domain.SysAccessCode;
import com.adpanshi.cashloan.business.system.domain.SysUser;
import com.adpanshi.cashloan.business.system.mapper.SysAccessCodeMapper;
import com.adpanshi.cashloan.business.system.model.SysAccessCodeModel;
import com.adpanshi.cashloan.business.system.service.SysAccessCodeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 访问码ServiceImpl
 * 

 * @version 1.0.0
 * @date 2017-03-24 17:37:49 Copyright 粉团网路 arc All Rights Reserved
 *
 */

@Service("sysAccessCodeService")
public class SysAccessCodeServiceImpl extends BaseServiceImpl<SysAccessCode, Long> implements SysAccessCodeService {

	@Resource
	private SysAccessCodeMapper sysAccessCodeMapper;

	@Override
	public BaseMapper<SysAccessCode, Long> getMapper() {
		return sysAccessCodeMapper;
	}

	@Override
	public Page<SysAccessCodeModel> listAccessCodeModel(Map<String, Object> params, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<SysAccessCodeModel> list = sysAccessCodeMapper.listAccessCodeModel(params);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SysAccessCodeModel code = new SysAccessCodeModel();
				code.setState(list.get(i).getState());
				list.get(i).setStateStr(code.getStateStr());
			}
		}
		return (Page<SysAccessCodeModel>) list;
	}

	@Override
	public int save(SysAccessCode accessCode, String time) {
		Date exceedTime = null;
		Calendar ca = Calendar.getInstance();
		Date now = ca.getTime(); 
		switch(time){
		case SysAccessCode.TWO_HOUR:
			ca.add(Calendar.HOUR_OF_DAY, 2);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.HALF_DAY:
			ca.add(Calendar.HOUR_OF_DAY, 12);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.ONE_DAY:
			ca.add(Calendar.DATE, 1);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.TWO_DAY:
			ca.add(Calendar.DATE, 2);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.SEVEN_DAY:
			ca.add(Calendar.DATE, 7);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.ONE_MOUNTH:
			ca.add(Calendar.DATE, 30);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.THREE_MOUNTH:
			ca.add(Calendar.DATE, 90);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.SIX_MOUNTH:
			ca.add(Calendar.DATE, 180);
			exceedTime = ca.getTime();
			break;
		}
		accessCode.setExceedTime(exceedTime);
		accessCode.setCreateTime(now);
		accessCode.setState("10");
		return sysAccessCodeMapper.save(accessCode);
	}

	@Override
	public int update(SysAccessCode ac,String time) {
		Date exceedTime = null;
		Calendar ca = Calendar.getInstance();
		ca.setTime(ac.getCreateTime());
		switch(time){
		case SysAccessCode.TWO_HOUR:
			ca.add(Calendar.HOUR_OF_DAY, 2);
			exceedTime = ca.getTime();
		case SysAccessCode.HALF_DAY:
			ca.add(Calendar.HOUR_OF_DAY, 12);
		case SysAccessCode.ONE_DAY:
			ca.add(Calendar.DATE, 1);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.TWO_DAY:
			ca.add(Calendar.DATE, 2);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.SEVEN_DAY:
			ca.add(Calendar.DATE, 7);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.ONE_MOUNTH:
			ca.add(Calendar.DATE, 30);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.THREE_MOUNTH:
			ca.add(Calendar.DATE, 90);
			exceedTime = ca.getTime();
			break;
		case SysAccessCode.SIX_MOUNTH:
			ca.add(Calendar.DATE, 180);
			exceedTime = ca.getTime();
			break;
		}
		ac.setExceedTime(exceedTime);
		return sysAccessCodeMapper.update(ac);
	}

	@Override
	public int countCode(long sysUserId, String code) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("sysUserId", sysUserId);
		data.put("code", code);
		return sysAccessCodeMapper.countCode(data);
	}

	@Override
	public List<SysAccessCode> listSysAccessCode(Long sysUserId) {
		return sysAccessCodeMapper.listSysAccessCode(sysUserId);
	}

	@Override
	public SysAccessCode findSysAccessCode(Map<String,Object> map) {
		return sysAccessCodeMapper.findSysAccessCode(map);
	}

	@Override
	public int updateState(SysAccessCode ac) {
		return sysAccessCodeMapper.update(ac);
	}

	@Override
	public List<SysUser> listUserName() {
		return sysAccessCodeMapper.listUserName();
	}
}