package com.fivefu.apply.task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fivefu.apply.entity.DbApplyCount;
import com.fivefu.apply.mongodb.services.UrlINterceptorStatisticsService;
import com.fivefu.apply.service.DbApplyCountService;
import com.fivefu.apply.utils.DataUtil;

@Component
public class ApplyTask {

	private Logger logger = LoggerFactory.getLogger(ApplyTask.class);
	
	
	@Autowired
	private UrlINterceptorStatisticsService urlINterceptorStatisticsService;
	@Autowired
	private DbApplyCountService dbApplyCountService;
	
	@Scheduled(cron="0 0 0 1 * ? ")
	public void applyData() {
		logger.info("==========================启动应用分析线程开始=============================");
		System.out.println("==========================启动应用分析线程开始=============================");
		List<DbApplyCount> list = new ArrayList<DbApplyCount>();
		try {
			DataUtil dataUtil = new DataUtil();
			List<String> fuwulist = dataUtil.wcgfuwu();   //获取微城管所有服务
			String tjtime = dataUtil.getLastMonthM(); //获取当前日期上月时间
			LocalDateTime createtime = LocalDateTime.now();
			//查询上月各服务统计量
			Map<String, Integer> map = urlINterceptorStatisticsService.findByurlname();
			if(map != null && map.size() > 0){
				for (String str : fuwulist) {
					DbApplyCount applyCount = new DbApplyCount();
					applyCount.setApplyName(str);
					Integer value = map.get(str);
					if(value == null) {
						value = 0;
					}
					applyCount.setApplycount(value);
					applyCount.setTjtime(tjtime);
					applyCount.setCreatetime(createtime);
					list.add(applyCount);
				}
			}
			dbApplyCountService.saveBatch(list);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		logger.info("==========================应用分析线程结束=============================");
		System.out.println("==========================应用分析线程结束=============================");
	}
}
