package com.ngiveu.cloud.tabe.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ngiveu.cloud.tabe.entity.Page;
import com.ngiveu.cloud.tabe.mapper.PageMapper;
import com.ngiveu.cloud.tabe.service.IPageService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 页面(用于静态页面,如: 关于本站/申请友链等待) 服务实现类
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements IPageService {

}
