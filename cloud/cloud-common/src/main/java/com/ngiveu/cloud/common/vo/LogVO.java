package com.ngiveu.cloud.common.vo;

import lombok.Data;

import java.io.Serializable;

import com.ngiveu.cloud.common.entity.SysLog;

/**
 * @author lengleng
 * @date 2017/11/20
 */
@Data
public class LogVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private SysLog sysLog;
    private String token;
}
