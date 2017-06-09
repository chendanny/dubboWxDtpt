package com.dt.dtpt.util;

import java.io.Serializable;

/**
 * 返回对象
 * 
 * 
 */
public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3780029263034183599L;
	/**
	 * 是否成功
	 */
	private boolean success;
	/**
	 * 返回原因类型名称
	 */
	private String title;
	/**
	 * 返回原因内容
	 */
	private String reason;
	/**
	 * 返回结果
	 */
	private Object result;

	public Result() {
	}

	/**
	 * 
	 * @param success
	 *            是否成功
	 * @param title
	 *            返回原因类型名称
	 * @param reason
	 *            返回原因内容
	 */
	public Result(boolean success, String title, String reason, Object result) {
		this.success = success;
		this.title = title;
		this.reason = reason;
		this.result = result;
	}

	public Result(boolean success, String title, String reason) {
		this.success = success;
		this.title = title;
		this.reason = reason;
		this.result = null;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public static Result success(String title,Object result) {
		return new Result(true, title, title, result);
	}
	public static Result success(Object result) {
		return new Result(true, null, null, result);
	}

	public static Result success(String title) {
		return new Result(true, title, title);
	}

	public static Result success() {
		return new Result(true, "操作成功", "",true);
	}

	public static Result success(String title, String reason) {
		return new Result(true, title, reason);
	}
	
	public static Result failure(String reason) {
		return new Result(false, "操作发生异常", reason);
	}
	public static Result failure(String title, String reason) {
		return new Result(false, title, reason);
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
