package com.ngiveu.cloud.tabe.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaz
 * @since 2018-05-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 删除标识
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 书名
     */
    @TableField("book_name")
    private String bookName;
    /**
     * 作者
     */
    @TableField("book_author")
    private String bookAuthor;
    /**
     * 链接
     */
    @TableField("book_url")
    private String bookUrl;
    /**
     * 封面
     */
    @TableField("book_avatar")
    private String bookAvatar;
    /**
     * 简介
     */
    @TableField("book_introducation")
    private String bookIntroducation;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 创建作者
     */
    @TableField("create_by")
    private Integer createBy;
    /**
     * 更新作者
     */
    @TableField("update_by")
    private Integer updateBy;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
