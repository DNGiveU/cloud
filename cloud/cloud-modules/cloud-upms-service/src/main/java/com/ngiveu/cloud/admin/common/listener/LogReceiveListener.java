package com.ngiveu.cloud.admin.common.listener;

import com.ngiveu.cloud.admin.service.SysLogService;
import com.ngiveu.cloud.common.constant.MqQueueConstant;
import com.ngiveu.cloud.common.entity.SysLog;
import com.ngiveu.cloud.common.util.UserUtils;
import com.ngiveu.cloud.common.vo.LogVO;

import org.slf4j.MDC;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lengleng
 * @date 2017/11/17
 */
@Component
@RabbitListener(queues = MqQueueConstant.LOG_QUEUE)
public class LogReceiveListener {
    private static final String KEY_USER = "user";

    @Autowired
    private SysLogService sysLogService;

    @RabbitHandler
    public void receive(LogVO logVo) {
        SysLog sysLog = logVo.getSysLog();
        String username = UserUtils.getUserName(logVo.getToken());
        MDC.put(KEY_USER, username);
        sysLog.setCreateBy(username);
        sysLogService.insert(sysLog);
        MDC.remove(KEY_USER);
    }
}
