package com.ngiveu.cloud.tabe.service.impl;

import com.ngiveu.cloud.tabe.entity.Book;
import com.ngiveu.cloud.tabe.mapper.BookMapper;
import com.ngiveu.cloud.tabe.service.IBookService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaz
 * @since 2018-05-13
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
