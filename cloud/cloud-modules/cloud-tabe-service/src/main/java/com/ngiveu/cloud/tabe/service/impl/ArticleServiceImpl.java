package com.ngiveu.cloud.tabe.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ngiveu.cloud.tabe.entity.Article;
import com.ngiveu.cloud.tabe.mapper.ArticleMapper;
import com.ngiveu.cloud.tabe.service.IArticleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

	@Override
	public List<Article> listTitleByBatchIds(Collection<Integer> batchIds) {
		if (batchIds == null || batchIds.isEmpty()) {
			return new ArrayList<Article>(0);
		}
		return this.baseMapper.listTitleByBatchIds(batchIds);
	}

}
