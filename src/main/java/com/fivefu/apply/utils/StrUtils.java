package com.fivefu.apply.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 字符工具类
 * 
 * @author Administrator
 * 
 */
public class StrUtils {

    /**
     * 判断字符串是否为空 如果为空返回true 如果不为空返回false
     * 
     * @param str
     *            传入要判断的字符串
     * @return [true | false]
     */
    public static boolean isNull(String str) {
        // System.out.println("!!!");
        if (null == str || str.length() <= 0 || str.equals("null")) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否不为空,如果不为空返回true 如果为空false
     * 
     * @param str
     *            传入要判断的字符串
     * @return [true | false]
     */
    public static boolean isNotNull(String str) {
        // System.out.println("!!!");
        if (null == str || str.length() <= 0 || str.equals("null")) {
            return false;
        }
        return true;
    }

    /**
     * 检测字符串,如果字符串为null的话，将null替换成 ""
     * 
     * @param str
     *            要替换的字符串
     * @return ["" | str]
     */
    public static String isCheckNull(String str) {
        // System.out.println("!!!");
        if (null == str || str.length() <= 0 || str.equals("null") || str.equals("NULL")) {
            return "";
        }
        str = str.replaceAll("NULL", "").replaceAll("null", "");
        return str;
    }

    public static String getCtime2() {// 返回类似2008-3-13 15:51:23
        Calendar dt = Calendar.getInstance();
        dt.setTime(new Date());
        String tmp = String.valueOf(dt.get(Calendar.YEAR));
        int m = dt.get(Calendar.MONTH) + 1;
        String mm = "";
        mm += String.valueOf(m);

        int d = dt.get(Calendar.DAY_OF_MONTH);
        String dd = "";
        dd += String.valueOf(d);

        int h = dt.get(Calendar.HOUR_OF_DAY);
        String hh = "";
        hh += String.valueOf(h);

        int min = dt.get(Calendar.MINUTE);
        String minute = "";
        minute += String.valueOf(min);

        int s = dt.get(Calendar.SECOND);
        String ss = "";
        ss += String.valueOf(s);

        return tmp + "-" + mm + "-" + dd + " " + hh + ":" + minute + ":" + ss;
    }
    /**
	 * 空格检测
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
        if(StrUtils.isEmpty(str)) {
            return true;
        }
        for(int i = 0; i < str.length(); i++ ) {
            if(!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
	}
	/**
	 * 空值检测
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0;
	}
	/**
	 * 获取固定长度的随机码
	 * 
	 * @param length
	 * @return
	 */
	public static String getFixedLengthCaptcha(int length) {
		return String.valueOf((1 + new Random().nextDouble()) * Math.pow(10, length)).substring(1, length + 1);
	}
	
	
}
