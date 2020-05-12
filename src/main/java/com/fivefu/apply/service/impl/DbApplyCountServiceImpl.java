package com.fivefu.apply.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fivefu.apply.entity.DbApplyCount;
import com.fivefu.apply.mapper.DbApplyCountMapper;
import com.fivefu.apply.service.DbApplyCountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DELL
 * @since 2020-01-08
 */
@Service
public class DbApplyCountServiceImpl extends ServiceImpl<DbApplyCountMapper, DbApplyCount> implements DbApplyCountService {

	@Autowired
	private DbApplyCountMapper dbApplyCountMapper;
	
	@Override
	public List<DbApplyCount> fuwuzhanbi() {
		// TODO Auto-generated method stub
		return dbApplyCountMapper.fuwuzhanbi();
	}

	@Override
	public int leijifuwucount(String strtime) {
		// TODO Auto-generated method stub
		return dbApplyCountMapper.leijifuwucount(strtime);
	}

}
