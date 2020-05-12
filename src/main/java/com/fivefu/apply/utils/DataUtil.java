package com.fivefu.apply.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/** 
 * yyyy 代表年份（注意是小写） yy 显示年份的后两位 
 * MM 代表月份   
 * dd 代表天数 （小写） 
 * mm 代表分钟   
 * HH 代表小时（24小时制） 
 * hh 代表小时（12小时制） 
 * ss 代表秒 
 */
public class DataUtil {

	/**   
	  * 获得当前日期与本周一相差的天数
	  */
	public  int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    } 
    
	/** 获得当前周- 周一的日期
	 * 
	 * @return
	 */
    public  String getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }
    
    /** 获得当前周- 周日  的日期
     * 
     * @return
     */
    public String getPreviousSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus +6);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday;
    }
    
    public  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



    /** 获得当前月--开始日期
     * 
     * @param date
     * @return
     */
    public  String getMinMonthDate(String date) {   
	     Calendar calendar = Calendar.getInstance();   
	      try {
	         calendar.setTime(dateFormat.parse(date));
	         calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
	         return dateFormat.format(calendar.getTime());
	       } catch (java.text.ParseException e) {
	       e.printStackTrace();
	      }
	    return null;
    }
    
    /** 获得当前月--结束日期
     * 
     * @param date
     * @return
     */
    public  String getMaxMonthDate(String date){   
         Calendar calendar = Calendar.getInstance();   
         try {
                calendar.setTime(dateFormat.parse(date));
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                return dateFormat.format(calendar.getTime());
         }  catch (java.text.ParseException e) {
                e.printStackTrace();
          }
        return null;
    }
    /**获取当前日期的前几天或者后几天
     * calendar.add(Calendar.DAY_OF_MONTH, -1); 前n天就减n，后n天就加n
     * */
    public Date getNextDate(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -1); //今天的时间加一天  
        date = calendar.getTime();  
        return date;          
    }
    
    /**获取当前的前几天或者后几天
     * calendar.add(Calendar.DAY_OF_MONTH, -1); 前n天就减n，后n天就加n
     * */
    public Date getNextDateqi(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -7); //今天的时间加一天  
        date = calendar.getTime();  
        return date;          
    }
    
    /**获得当前日期的上月时间
     * 
     * @return
     */
    public String getLastMonth(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        String createtime=dateFormat.format(date);
        return createtime;
    }
    /**获得当前日期的上月的月份
     * 
     * @return
     */
    public String getLastMonthM(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        String createtime=dateFormat.format(date);
        return createtime;
    }
    
    /**获得当前日期的上上月的月份
     * 
     * @return
     */
    public String getLastLastMonthM(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 2); // 设置为上一个月
        date = calendar.getTime();
        String createtime=dateFormat.format(date);
        return createtime;
    }
    
    /**获取的系统时间上推迟一年的后一个月
     * 
     * @return
     */
    public String getLastYearNextMonth(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        date = calendar.getTime();
        System.out.println("上个年月的时间11111111111111： " + dateFormat.format(date));
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date); // 设置为当前时间
        calendar1.set(Calendar.MONTH, calendar1.get(Calendar.MONTH) + 1); // 设置为上一个月
        date = calendar1.getTime();
        String createtime=dateFormat.format(date);
        return createtime;
    }
    
    /**循环两个日期之间的所有天数
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public List<String> getAllDate(String startDate,String endDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> strlist=new ArrayList<String>();
		try {
			Long startM = sdf.parse(startDate).getTime();
			Long endM = sdf.parse(endDate).getTime();
	        long result = (endM - startM) / (24 * 60 * 60 * 1000) + 1;
	        System.out.println("起止日期相差:" + result + "天");
	 
	        Date startDay = sdf.parse(startDate);
	        Calendar startTime = Calendar.getInstance();
	        startTime.clear();
	        startTime.setTime(startDay);
	        for (int i = 0; i < (int) result; i++) {
	            String date = String.format("%1$04d-%2$02d-%3$02d", startTime.get(Calendar.YEAR), (startTime.get(Calendar.MONTH) + 1), startTime.get(Calendar.DAY_OF_MONTH));
	            strlist.add(date);
	            startTime.add(Calendar.DAY_OF_YEAR, 1);
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return strlist;
    }
    
    /**循环两个月之间的所有月
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public List<String> getAllMonth(String startDate,String endDate){
    	ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		try {
			min.setTime(sdf.parse(startDate));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

			max.setTime(sdf.parse(endDate));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

			Calendar curr = min;
			while (curr.before(max)) {
			 result.add(sdf.format(curr.getTime()));
			 curr.add(Calendar.MONTH, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
    }
    
    
    /**循环两个月之间的所有月
     * 
     * @return
     */
    public List<String> getAllMonth(){
    	List<String> strlist=new ArrayList<String>();
    	String startDate="2016-01";String endDate="2017-01";
		try {
			Date d1 = new SimpleDateFormat("yyyy-MM").parse(startDate);
			Date d2=new SimpleDateFormat("yyyy-MM").parse(endDate);
	    	Calendar dd=Calendar.getInstance();
	    	dd.setTime(d1);
	    	while (dd.getTime().before(d2)) {
				SimpleDateFormat sdf=new SimpleDateFormat("MM");
				String str=sdf.format(dd.getTime());
				strlist.add(str);
				dd.add(Calendar.MONTH, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strlist;
    }
    
    /**
     * 给定年月，判断该月有多少天
     * **/
    public int getdaynumber(String createtime){
    	String a[] = createtime.split("-");  
    	int year = Integer.valueOf(a[0]);
    	int month = Integer.valueOf(a[1]);
    	Calendar c = Calendar.getInstance();
    	c.set(year, month, 0); //输入类型为int类型

    	int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
    	System.out.println(year + "年" + month + "月有" + dayOfMonth + "天");
		return dayOfMonth;
    	
    }
    
    /**
     * 获取当前上月的第一天
     * **/
    public  String findMonthFirstDay(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00"); 
        //获取前月的第一天
        Calendar   cal_1=Calendar.getInstance();//获取当前日期 
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        String firstDay = format.format(cal_1.getTime());
      //  System.out.println("-----1------firstDay:"+firstDay);
    	return firstDay;
    }
    
    /**
     * 获取当前上月的最后一天
     * **/
    public  String findMonthLastDay(){
    	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
    	Calendar calendar=Calendar.getInstance();
    	int month=calendar.get(Calendar.MONTH);
    	calendar.set(Calendar.MONTH, month-1);
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    	System.out.println("上个月最后一天："+sf.format(calendar.getTime()));
    	return sf.format(calendar.getTime());
    }
    
    /**
     * 获取当前日期的第一天
     * **/
    public String findNowMonthFirstDay(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00"); 
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        String first = format.format(c.getTime());
        return first;
    }
    
    /**
     * 获取前12月的日期（月）
     * **/
    public  String getfirsttwelveMonth(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        date = calendar.getTime();
        return  dateFormat.format(date);
    }
    
    public static List<String> getBETWEENYearandMonth(String startDate,String endDate){
 	   List<String> strlist=new ArrayList<String>();
 		try {
 			Date d1 = new SimpleDateFormat("yyyy-MM").parse(startDate);
 			Date d2=new SimpleDateFormat("yyyy-MM").parse(endDate);
 	    	Calendar dd=Calendar.getInstance();
 	    	dd.setTime(d1);
 	    	while (dd.getTime().before(d2)) {
 				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
 				String str=sdf.format(dd.getTime());
 				strlist.add(str);
 				dd.add(Calendar.MONTH, 1);
 			}
 		} catch (ParseException e) {
 			e.printStackTrace();
 		}
 		return strlist;
    }
  
    /**
     * 微城管服务访问统计
     * **/
    public List<String> wcgfuwu(){
    	List<String> list = new ArrayList<String>();
    	list.add("城市大家管");list.add("办事大厅");list.add("帮停车");
    	list.add("找公厕");list.add("新闻动态");list.add("便民通知");
    	list.add("城市照明");list.add("公共自行车");list.add("个人中心");
    	list.add("人行道违停");list.add("市民热线");list.add("每日一题");
    	list.add("智慧环卫");list.add("智慧渣土");list.add("垃圾分类");
    	list.add("锦旗排行榜");list.add("数据发布");list.add("专题报送");
    	list.add("优秀案卷");list.add("活动");list.add("评论");
    	list.add("我的账单");list.add("志愿者服务");
    	return list;
    }
    
    
}
