package com.ngiveu.cloud.tabe.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ngiveu.cloud.tabe.entity.Comment;
import com.ngiveu.cloud.tabe.mapper.CommentMapper;
import com.ngiveu.cloud.tabe.service.ICommentService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
