package com.fivefu.apply.utils;

import java.io.Serializable;

public class ResultInfo implements Serializable{
	private static final long serialVersionUID = 9198443106600637875L;
	
	
	private Integer code;
	
	private String msg;
	
	private Object obj;
	
	
	private boolean flag;
	
	
	public ResultInfo(){
		
	}
	public ResultInfo(Integer code,String msg){
		this.code=code;
		this.msg=msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setSuccess(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
