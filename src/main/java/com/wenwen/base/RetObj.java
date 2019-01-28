package com.wenwen.base;

import lombok.Data;

@Data
public class RetObj {
	private boolean flag = true;
	private String msg;
	private Object obj;
	public RetObj() {

	}
	public RetObj(boolean flag, String msg, Object obj) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
	}
	public RetObj(boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}
	
}
