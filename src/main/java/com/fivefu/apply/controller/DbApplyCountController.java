package com.fivefu.apply.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fivefu.apply.controller.BaseController;
import com.fivefu.apply.entity.DbApplyCount;
import com.fivefu.apply.service.DbApplyCountService;
import com.fivefu.apply.task.ApplyTask;
import com.fivefu.apply.utils.DataUtil;
import com.fivefu.apply.utils.ResultInfo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DELL
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/db-apply-count")
public class DbApplyCountController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(ApplyTask.class);
	@Autowired
	private DbApplyCountService dbApplyCountService;
	
	/**
	 * 系统服务访问次数占比
	 * **/
	@RequestMapping("/xitongfuwuzhanbi")
	public ResultInfo xitongfuwuzhanbi(HttpServletRequest request) {
		List<DbApplyCount> list = dbApplyCountService.fuwuzhanbi();
		return renderSuccess(list);
	}
	
	
	/**
	 * 累计服务次数
	 * **/
	@RequestMapping("/leijifuwucount")
	public ResultInfo leijifuwucount(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DataUtil dataUtil = new DataUtil();
		String endtime = sdf.format(new Date());
		String starttime = dataUtil.getfirsttwelveMonth()+"-01 23:59:59";
		List<String> strlist = DataUtil.getBETWEENYearandMonth(starttime, endtime);
		List<DbApplyCount> list = new ArrayList<DbApplyCount>();
		for (String strtime : strlist) {
			DbApplyCount applyCount = new DbApplyCount();
			applyCount.setTjtime(strtime);
			int value = dbApplyCountService.leijifuwucount(strtime);
			int applycount = (value + 12000000);
			applyCount.setApplycount(applycount);
			list.add(applyCount);
		}
		return renderSuccess(list);
	}
}

