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
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论父级ID 如果没有则默认为0
     */
    @TableField("comment_pid")
    private Integer commentPid;
    /**
     * 评论名称
     */
    @TableField("comment_pname")
    private String commentPname;
    /**
     * 文章ID
     */
    @TableField("comment_article_id")
    private Integer commentArticleId;
    /**
     * 作者名称
     */
    @TableField("comment_author_name")
    private String commentAuthorName;
    /**
     * 作者电子邮件
     */
    @TableField("comment_author_email")
    private String commentAuthorEmail;
    /**
     * 作者连接
     */
    @TableField("comment_author_url")
    private String commentAuthorUrl;
    /**
     * 评论内容
     */
    @TableField("comment_content")
    private String commentContent;
    /**
     * 客户端类型
     */
    @TableField("comment_agent")
    private String commentAgent;
    /**
     * IP
     */
    @TableField("comment_ip")
    private String commentIp;
    @TableField("comment_create_time")
    private Date commentCreateTime;
    @TableField("comment_role")
    private Integer commentRole;
    @TableField("comment_status")
    private Integer commentStatus;
    @TableField("update_time")
    private Date updateTime;
    @TableField("del_flag")
    private String delFlag;

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public String getCommentPname() {
        return commentPname;
    }

    public void setCommentPname(String commentPname) {
        this.commentPname = commentPname;
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public String getCommentAuthorName() {
        return commentAuthorName;
    }

    public void setCommentAuthorName(String commentAuthorName) {
        this.commentAuthorName = commentAuthorName;
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public Integer getCommentRole() {
        return commentRole;
    }

    public void setCommentRole(Integer commentRole) {
        this.commentRole = commentRole;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Comment{" +
        ", commentId=" + id +
        ", commentPid=" + commentPid +
        ", commentPname=" + commentPname +
        ", commentArticleId=" + commentArticleId +
        ", commentAuthorName=" + commentAuthorName +
        ", commentAuthorEmail=" + commentAuthorEmail +
        ", commentAuthorUrl=" + commentAuthorUrl +
        ", commentContent=" + commentContent +
        ", commentAgent=" + commentAgent +
        ", commentIp=" + commentIp +
        ", commentCreateTime=" + commentCreateTime +
        ", commentRole=" + commentRole +
        ", commentStatus=" + commentStatus +
        "}";
    }
}
