package com.ngiveu.cloud.common.vo;

import java.io.Serializable;

import com.ngiveu.cloud.common.entity.SysLog;

/**
 * @author gaz
 * @date 2017/11/20
 */
public class LogVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private SysLog sysLog;
    private String token;
	public SysLog getSysLog() {
		return sysLog;
	}
	public void setSysLog(SysLog sysLog) {
		this.sysLog = sysLog;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
}
