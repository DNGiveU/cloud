package com.ngiveu.cloud.tabe.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ngiveu.cloud.tabe.entity.Category;
import com.ngiveu.cloud.tabe.mapper.CategoryMapper;
import com.ngiveu.cloud.tabe.service.ICategoryService;

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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
