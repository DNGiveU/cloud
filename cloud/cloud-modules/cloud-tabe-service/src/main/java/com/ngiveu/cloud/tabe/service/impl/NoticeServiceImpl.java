package com.ngiveu.cloud.tabe.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ngiveu.cloud.tabe.entity.Notice;
import com.ngiveu.cloud.tabe.mapper.NoticeMapper;
import com.ngiveu.cloud.tabe.service.INoticeService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知 服务实现类
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
