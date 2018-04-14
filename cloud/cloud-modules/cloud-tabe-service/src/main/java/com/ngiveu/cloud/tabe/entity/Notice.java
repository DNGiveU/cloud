package com.ngiveu.cloud.tabe.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 通知
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public class Notice extends Model<Notice> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("notice_title")
    private String noticeTitle;
    @TableField("notice_content")
    private String noticeContent;
    @TableField("notice_create_time")
    private Date noticeCreateTime;
    @TableField("notice_update_time")
    private Date noticeUpdateTime;
    @TableField("notice_status")
    private Integer noticeStatus;
    @TableField("notice_order")
    private Integer noticeOrder;
    @TableField("del_flag")
    private String delFlag;

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public Date getNoticeUpdateTime() {
        return noticeUpdateTime;
    }

    public void setNoticeUpdateTime(Date noticeUpdateTime) {
        this.noticeUpdateTime = noticeUpdateTime;
    }

    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public Integer getNoticeOrder() {
        return noticeOrder;
    }

    public void setNoticeOrder(Integer noticeOrder) {
        this.noticeOrder = noticeOrder;
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

    @Override
    public String toString() {
        return "Notice{" +
        ", noticeId=" + id +
        ", noticeTitle=" + noticeTitle +
        ", noticeContent=" + noticeContent +
        ", noticeCreateTime=" + noticeCreateTime +
        ", noticeUpdateTime=" + noticeUpdateTime +
        ", noticeStatus=" + noticeStatus +
        ", noticeOrder=" + noticeOrder +
        "}";
    }
}
