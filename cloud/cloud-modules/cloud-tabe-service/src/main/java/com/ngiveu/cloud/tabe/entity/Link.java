package com.ngiveu.cloud.tabe.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 第三方链接
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
public class Link extends Model<Link> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("link_url")
    private String linkUrl;
    @TableField("link_name")
    private String linkName;
    @TableField("link_image")
    private String linkImage;
    @TableField("link_description")
    private String linkDescription;
    @TableField("link_owner_nickname")
    private String linkOwnerNickname;
    @TableField("link_owner_contact")
    private String linkOwnerContact;
    @TableField("link_update_time")
    private Date linkUpdateTime;
    @TableField("link_create_time")
    private Date linkCreateTime;
    @TableField("link_order")
    private Integer linkOrder;
    @TableField("link_status")
    private Integer linkStatus;
    @TableField("del_flag")
    private String delFlag;

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getLinkOwnerNickname() {
        return linkOwnerNickname;
    }

    public void setLinkOwnerNickname(String linkOwnerNickname) {
        this.linkOwnerNickname = linkOwnerNickname;
    }

    public String getLinkOwnerContact() {
        return linkOwnerContact;
    }

    public void setLinkOwnerContact(String linkOwnerContact) {
        this.linkOwnerContact = linkOwnerContact;
    }

    public Date getLinkUpdateTime() {
        return linkUpdateTime;
    }

    public void setLinkUpdateTime(Date linkUpdateTime) {
        this.linkUpdateTime = linkUpdateTime;
    }

    public Date getLinkCreateTime() {
        return linkCreateTime;
    }

    public void setLinkCreateTime(Date linkCreateTime) {
        this.linkCreateTime = linkCreateTime;
    }

    public Integer getLinkOrder() {
        return linkOrder;
    }

    public void setLinkOrder(Integer linkOrder) {
        this.linkOrder = linkOrder;
    }

    public Integer getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(Integer linkStatus) {
        this.linkStatus = linkStatus;
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
        return "Link{" +
        ", linkId=" + id +
        ", linkUrl=" + linkUrl +
        ", linkName=" + linkName +
        ", linkImage=" + linkImage +
        ", linkDescription=" + linkDescription +
        ", linkOwnerNickname=" + linkOwnerNickname +
        ", linkOwnerContact=" + linkOwnerContact +
        ", linkUpdateTime=" + linkUpdateTime +
        ", linkCreateTime=" + linkCreateTime +
        ", linkOrder=" + linkOrder +
        ", linkStatus=" + linkStatus +
        "}";
    }
}
