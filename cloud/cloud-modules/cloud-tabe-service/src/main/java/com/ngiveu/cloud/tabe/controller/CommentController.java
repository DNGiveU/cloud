package com.ngiveu.cloud.tabe.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ngiveu.cloud.common.constant.CommonConstant;
import com.ngiveu.cloud.common.util.Query;
import com.ngiveu.cloud.common.web.BaseController;
import com.ngiveu.cloud.tabe.entity.Article;
import com.ngiveu.cloud.tabe.entity.Comment;
import com.ngiveu.cloud.tabe.model.vo.ArticleVO;
import com.ngiveu.cloud.tabe.model.vo.CommentVO;
import com.ngiveu.cloud.tabe.service.IArticleService;
import com.ngiveu.cloud.tabe.service.ICommentService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    private ICommentService commentService;
    
    @Autowired
    private IArticleService articleService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Comment
    */
    @GetMapping("/{id}")
    public Comment get(@PathVariable Integer id) {
        return commentService.selectById(id);
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public Page<CommentVO> page(@RequestParam Map<String, Object> params) {
        Comment commentCondition = new Comment();
        commentCondition.setDelFlag(CommonConstant.STATUS_NORMAL);
        Page<Comment> commentPage = commentService.selectPage(new Query<>(params)); // selectPage(new Query<>(params), null);
        Page<CommentVO> commentVOPage = new Page<>(commentPage.getCurrent(), commentPage.getSize());
        List<CommentVO> commentVOs = new ArrayList<CommentVO>(commentPage.getRecords().size());
        Set<Integer> articleIds = new HashSet<Integer>(commentVOs.size());
        for (Comment comment : commentPage.getRecords()) {
        	if (comment.getCommentArticleId() != null) {        		
        		articleIds.add(comment.getCommentArticleId());
        	}
        }
        List<Article> articles = this.articleService.listTitleByBatchIds(articleIds);
        CommentVO vo = null;
        for (Comment comment : commentPage.getRecords()) {
        	vo = new CommentVO();
        	vo.setAgent(comment.getCommentAgent());
        	vo.setAuthor(comment.getCommentAuthorName());
        	vo.setContent(comment.getCommentContent());
        	vo.setCreateTime(comment.getCommentCreateTime());
        	vo.setEmail(comment.getCommentAuthorEmail());
        	vo.setId(comment.getId());
        	vo.setIp(comment.getCommentIp());
        	vo.setPid(comment.getCommentPid());
        	vo.setUrl(comment.getCommentAuthorUrl());
        	for (Article article : articles) {
        		if (article.getId().equals(comment.getCommentArticleId())) {
        			vo.setArticleTitle(article.getArticleTitle());
        			break ;
        		}
        	}
        	commentVOs.add(vo);
        }
        
        commentVOPage.setRecords(commentVOs);
        commentVOPage.setTotal(commentPage.getTotal());
        return commentVOPage;
    }

    /**
     * 添加
     * @param  comment  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Comment comment) {
        return commentService.insert(comment);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUpdateTime(new Date());
        comment.setDelFlag(CommonConstant.STATUS_DEL);
        return commentService.updateById(comment);
    }

    /**
     * 编辑
     * @param  comment  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Comment comment) {
        comment.setUpdateTime(new Date());
        return commentService.updateById(comment);
    }
}
