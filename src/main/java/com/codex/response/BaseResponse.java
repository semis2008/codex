package com.codex.response;

import java.io.Serializable;



public class BaseResponse implements Serializable{
	/** 
	 * 变量说明描述
	 *
	 * long BaseResponse.java serialVersionUID
	 */
	private static final long serialVersionUID = 138017443550236549L;
	
	private int retcode = 0;
	private String retdesc;
	private Object data;
	/**
	 * 方法执行时间
	 */
	private long ticks;

	public int getRetcode() {
		return retcode;
	}

	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}

	public String getRetdesc() {
		return retdesc;
	}

	public void setRetdesc(String retdesc) {
		this.retdesc = retdesc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getTicks() {
		return ticks;
	}

	public void setTicks(long ticks) {
		this.ticks = ticks;
	}

}
