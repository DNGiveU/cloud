package com.ngiveu.cloud.tabe.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("article_user_id")
    private Integer articleUserId;
    @TableField("article_title")
    private String articleTitle;
    @TableField("article_content")
    private String articleContent;
    @TableField("article_parent_category_id")
    private Integer articleParentCategoryId;
    @TableField("article_child_category_id")
    private Integer articleChildCategoryId;
    @TableField("article_tags")
    private String articleTags;
    @TableField("article_view_count")
    private Integer articleViewCount;
    @TableField("article_comment_count")
    private Integer articleCommentCount;
    @TableField("article_like_count")
    private Integer articleLikeCount;
    @TableField("article_post_time")
    private Date articlePostTime;
    @TableField("article_update_time")
    private Date articleUpdateTime;
    @TableField("article_is_comment")
    private Integer articleIsComment;
    @TableField("article_status")
    private Integer articleStatus;
    @TableField("article_order")
    private Integer articleOrder;
    @TableField("del_flag")
    private String delFlag;



    public Integer getArticleUserId() {
        return articleUserId;
    }

    public void setArticleUserId(Integer articleUserId) {
        this.articleUserId = articleUserId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticleParentCategoryId() {
        return articleParentCategoryId;
    }

    public void setArticleParentCategoryId(Integer articleParentCategoryId) {
        this.articleParentCategoryId = articleParentCategoryId;
    }

    public Integer getArticleChildCategoryId() {
        return articleChildCategoryId;
    }

    public void setArticleChildCategoryId(Integer articleChildCategoryId) {
        this.articleChildCategoryId = articleChildCategoryId;
    }

    public Integer getArticleViewCount() {
        return articleViewCount;
    }

    public void setArticleViewCount(Integer articleViewCount) {
        this.articleViewCount = articleViewCount;
    }

    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    public Date getArticlePostTime() {
        return articlePostTime;
    }

    public void setArticlePostTime(Date articlePostTime) {
        this.articlePostTime = articlePostTime;
    }

    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    public Integer getArticleIsComment() {
        return articleIsComment;
    }

    public void setArticleIsComment(Integer articleIsComment) {
        this.articleIsComment = articleIsComment;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleOrder() {
        return articleOrder;
    }

    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getArticleTags() {
		return articleTags;
	}

	public void setArticleTags(String articleTags) {
		this.articleTags = articleTags;
	}

	@Override
    public String toString() {
        return "Article{" +
        ", id=" + id +
        ", articleUserId=" + articleUserId +
        ", articleTitle=" + articleTitle +
        ", articleContent=" + articleContent +
        ", articleParentCategoryId=" + articleParentCategoryId +
        ", articleChildCategoryId=" + articleChildCategoryId +
        ", articleTagIds=" + articleTags +
        ", articleViewCount=" + articleViewCount +
        ", articleCommentCount=" + articleCommentCount +
        ", articleLikeCount=" + articleLikeCount +
        ", articlePostTime=" + articlePostTime +
        ", articleUpdateTime=" + articleUpdateTime +
        ", articleIsComment=" + articleIsComment +
        ", articleStatus=" + articleStatus +
        ", articleOrder=" + articleOrder +
        "}";
    }
}
