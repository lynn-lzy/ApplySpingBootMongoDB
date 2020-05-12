package com.fivefu.apply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivefu.apply.utils.ResultInfo;




/**
 * 基础控制器
 */
@RestController
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;

	@RequestMapping({ "/" })
	public ResultInfo index() {
		return renderSuccess("success");
	}

	/**
	 * 渲染失败数据
	 *
	 * @return result
	 */
	protected ResultInfo renderError() {
		ResultInfo result = new ResultInfo();
		result.setSuccess(false);
		result.setCode(500);
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg 需要返回的消息
	 * @return result
	 */
	protected ResultInfo renderError(String msg) {
		ResultInfo result = renderError();
		result.setMsg(msg);
		return result;
	}

	/**
	 * 渲染成功数据
	 *
	 * @return result
	 */
	protected ResultInfo renderSuccess() {
		ResultInfo result = new ResultInfo();
		result.setSuccess(true);
		result.setCode(200);
		return result;
	}

	/**
	 * 渲染成功数据（带信息）
	 *
	 * @param msg 需要返回的信息
	 * @return result
	 */
	protected ResultInfo renderSuccess(String msg) {
		ResultInfo result = renderSuccess();
		result.setMsg(msg);
		return result;
	}

	/**
	 * 渲染成功数据（带数据）
	 *
	 * @param obj 需要返回的对象
	 * @return result
	 */
	protected ResultInfo renderSuccess(Object obj) {
		ResultInfo result = renderSuccess();
		result.setObj(obj);
		return result;
	}

}
