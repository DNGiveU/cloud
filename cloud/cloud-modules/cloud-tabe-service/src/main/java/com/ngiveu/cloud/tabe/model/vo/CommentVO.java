package com.ngiveu.cloud.tabe.model.vo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author gaz
 * @date 2018年4月22日
 */
@Data
public class CommentVO {

	/** 评论主键 */
	private Integer id;
	/** 评论父级ID 如果没有则默认为0 */
	private Integer pid;
	/** 评论文章标题 */
	private String articleTitle;
	/** 评论作者名称 */
	private String author;
	/** 评论作者电子邮件 */
	private String email;
	/** 评论作者连接 */
	private String url;
	/** 评论内容 */
	private String content;
	/** 评论客户端类型 */
	private String agent;
	/** 评论IP */
	private String ip;
	/** 创建时间 */
	private Date createTime;
}
