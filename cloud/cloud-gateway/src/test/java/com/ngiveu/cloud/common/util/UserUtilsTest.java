package com.ngiveu.cloud.common.util;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.ngiveu.cloud.common.constant.CommonConstant;

import java.util.Optional;

/**
 * @author gaz
 * @date 2017/12/22
 */
public class UserUtilsTest {
    @Test
    public void getToken() throws Exception {
        String authorization = null;
        System.out.println(StringUtils.substringAfter(authorization, CommonConstant.TOKEN_SPLIT));
    }

    @Test
    public void optionalTest() {
        Optional<String> optional = Optional.ofNullable("");
        System.out.println(optional.isPresent());
    }

}