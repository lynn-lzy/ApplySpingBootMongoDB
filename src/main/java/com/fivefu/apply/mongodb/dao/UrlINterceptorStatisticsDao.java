package com.fivefu.apply.mongodb.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.fivefu.apply.mongodb.pojo.UrlINterceptorStatistics;
import com.fivefu.apply.utils.DataUtil;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Repository
public class UrlINterceptorStatisticsDao  extends MongoDbDao<UrlINterceptorStatistics>{

	@Resource
	private  MongoTemplate mongoTemplate;
	
	@Override
	protected Class<UrlINterceptorStatistics> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Map<String, Integer> findByurlname(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		DataUtil dataUtil = new DataUtil();
		try {
			//查询条件
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String firest = dataUtil.findMonthFirstDay();
	    	String last = dataUtil.findMonthLastDay();
	    	Date starttime = sdf.parse(firest);
	    	Date endtime = sdf.parse(last);
			DBObject condition1 = new BasicDBObject("createtime",new  BasicDBObject("$gte",starttime).append("$lte", endtime));
			DBObject match = new BasicDBObject("$match", condition1); // $match相当于where
			//分组查询
			DBObject all = new BasicDBObject("_id","$urlname").append("count", new BasicDBObject("$sum",1));
			DBObject group = new BasicDBObject("$group",all);
			
			//显示属性
		    DBObject project1 = new BasicDBObject("urlname", new BasicDBObject("$toUpper","$_id"))
		    					.append("counts", "$count")
		    					.append("_id", 0);
		    DBObject project = new BasicDBObject("$project",project1);
		    // 排序
		    DBObject sortFields = new BasicDBObject("counts", -1);
		    // 注意此处排序是按照字段day升序,但是不能写day 需用_id代替,因为day是group用的字段
		    DBObject sort = new BasicDBObject("$sort", sortFields);
		    
		    //List需要按照顺序添加
		    List<DBObject> optionList = new ArrayList<>();
		    optionList.add(match);
		    optionList.add(group);
		    optionList.add(project);
		    optionList.add(sort);
		   
		    AggregationOutput output = mongoTemplate.getCollection("urlINterceptorStatistics").aggregate(optionList);
		    if(output.results() != null){
		    	for (DBObject obj : output.results()) {
			       if(obj.get("urlname") != null && obj.get("counts") != null){
			    	   map.put(obj.get("urlname").toString(), Integer.valueOf(obj.get("counts").toString()));
			       }
			    }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
