package com.ngiveu.cloud.tabe.model.vo;

import java.util.Date;

import lombok.Data;

/**
 * article vo
 * 
 * @author gaz
 * @date 2018年4月20日
 */
@Data
public class ArticleVO {

	/** 主键 */
	private Integer id;
	/** 作者 */
	private String author;
	/** 标题 */
	private String title;
	/** 类别 */
	private String category;
	/** 游览数量 */
	private Integer viewCount;
	/** 评论数量 */
	private Integer commentCount;
	/** 喜爱数量 */
	private Integer LikeCount;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** tag标签 */
	private String tags;
}
