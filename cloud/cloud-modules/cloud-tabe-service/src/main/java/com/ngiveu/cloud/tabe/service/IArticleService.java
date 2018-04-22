package com.ngiveu.cloud.tabe.service;

import java.util.Collection;
import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.ngiveu.cloud.tabe.entity.Article;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public interface IArticleService extends IService<Article> {

	/**
	 * 批量获取标题
	 * @param batchIds
	 * @return
	 * @author gaz
	 */
	List<Article> listTitleByBatchIds(Collection<Integer> batchIds);
}
