package com.ngiveu.cloud.tabe.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ngiveu.cloud.tabe.entity.Article;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public interface ArticleMapper extends BaseMapper<Article> {

	/**
	 * 批量获取标题
	 * @param batchIds
	 * @return
	 * @author gaz
	 */
	List<Article> listTitleByBatchIds(@Param("batchIds") Collection<Integer> batchIds);
}
