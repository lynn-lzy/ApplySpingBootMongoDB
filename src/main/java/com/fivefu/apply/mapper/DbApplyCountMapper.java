package com.fivefu.apply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fivefu.apply.entity.DbApplyCount;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DELL
 * @since 2020-01-08
 */
public interface DbApplyCountMapper extends BaseMapper<DbApplyCount> {

	public List<DbApplyCount> fuwuzhanbi(); 
	
	public int leijifuwucount(@Param("strtime") String strtime);
}
