package com.ngiveu.cloud.tabe.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ngiveu.cloud.tabe.entity.Link;
import com.ngiveu.cloud.tabe.mapper.LinkMapper;
import com.ngiveu.cloud.tabe.service.ILinkService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 第三方链接 服务实现类
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements ILinkService {

}
