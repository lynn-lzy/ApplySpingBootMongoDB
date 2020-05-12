package com.fivefu.apply.mongodb.services;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fivefu.apply.mongodb.dao.UrlINterceptorStatisticsDao;


@Service
public class UrlINterceptorStatisticsService {

	@Resource
	private UrlINterceptorStatisticsDao urlINterceptorStatisticsDao;
	
	public Map<String, Integer> findByurlname(){
		return urlINterceptorStatisticsDao.findByurlname();
	}
}
