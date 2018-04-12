package com.ngiveu.cloud.common.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.ngiveu.cloud.common.util.UserUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lengleng
 * @date 2017/10/28
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;
    protected org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    /**
     * 根据请求heard中的token获取用户角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        return UserUtils.getRole(request);
    }


}
