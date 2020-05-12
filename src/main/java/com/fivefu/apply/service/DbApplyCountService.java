package com.fivefu.apply.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fivefu.apply.entity.DbApplyCount;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DELL
 * @since 2020-01-08
 */
public interface DbApplyCountService extends IService<DbApplyCount> {

	public List<DbApplyCount> fuwuzhanbi(); 
	
	public int leijifuwucount(String strtime);
}
