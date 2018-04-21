package com.ngiveu.cloud.tabe.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
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
import org.springframework.web.client.RestTemplate;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ngiveu.cloud.common.constant.CommonConstant;
import com.ngiveu.cloud.common.util.Query;
import com.ngiveu.cloud.common.vo.UserVO;
import com.ngiveu.cloud.common.web.BaseController;
import com.ngiveu.cloud.tabe.entity.Article;
import com.ngiveu.cloud.tabe.entity.Category;
import com.ngiveu.cloud.tabe.model.vo.ArticleVO;
import com.ngiveu.cloud.tabe.service.IArticleService;
import com.ngiveu.cloud.tabe.service.ICategoryService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-04-09
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    private IArticleService articleService;
    
    @Autowired
    private ICategoryService categoryService;
    
    @Autowired
    private RestTemplate restTemplate;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Article
    */
    @GetMapping("/{id}")
    public Article get(@PathVariable Integer id) {
        return articleService.selectById(id);
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
	@RequestMapping("/page")
    public Page<ArticleVO> page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        Page<Article> page = articleService.selectPage(new Query<>(params), new EntityWrapper<>());
        
        List<Integer> categoryIds = new ArrayList<Integer>();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Article item : page.getRecords()) {
        	NameValuePair nvp = new BasicNameValuePair("userIds", item.getArticleUserId().toString());
        	nvps.add(nvp);
        	categoryIds.add(item.getArticleChildCategoryId());
        }
        
        List<Category> categorys = categoryService.selectBatchIds(categoryIds);
        List userVOs = null;
        try {
			URI uri = new URIBuilder("http://cloud-upms-service/user/listUsersByIds").addParameters(nvps).build();
			userVOs = this.restTemplate.getForObject(uri, List.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        List<ArticleVO> articleVOs = new ArrayList<ArticleVO>();
        
        ArticleVO vo = null;
        for (Article item : page.getRecords()) {
        	vo = new ArticleVO();
        	vo.setId(item.getId());
        	vo.setCommentCount(item.getArticleCommentCount());
        	vo.setCreateTime(item.getArticlePostTime());
        	vo.setLikeCount(item.getArticleLikeCount());
        	vo.setTitle(item.getArticleTitle());
        	vo.setUpdateTime(item.getArticleUpdateTime());
        	vo.setViewCount(item.getArticleViewCount());
        	vo.setTags(item.getArticleTags());
        	if (userVOs != null && !userVOs.isEmpty()) {
        		if (userVOs.get(0) instanceof LinkedHashMap) {
        			for (LinkedHashMap<String, Object> map : (List<LinkedHashMap<String, Object>>) userVOs) {
        				if (map.get("userId").equals(item.getArticleUserId())) {
        					vo.setAuthor((String) map.get("username"));
        					break ;
        				}
        			}
        		} else if (userVOs.get(0) instanceof UserVO) {
        			for (UserVO userVO : (List<UserVO>) userVOs) {
        				if (userVO.getUserId().equals(item.getArticleUserId())) {
        					vo.setAuthor(userVO.getUsername());
        					break ;
        				}
        			}
        		}
        	}
        	if (categorys != null && !categorys.isEmpty()) {
        		for (Category category : categorys) {
        			if (category.getId().equals(item.getArticleChildCategoryId())) {
        				vo.setCategory(category.getCategoryName());
        				break ;
        			}
        		}
        	}
        	articleVOs.add(vo);
        }
        Page<ArticleVO> articleVOPage = new Page<ArticleVO>(page.getCurrent(), page.getSize());
        articleVOPage.setRecords(articleVOs);
        return articleVOPage;
    }

    /**
     * 添加
     * @param  article  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Article article) {
        return articleService.insert(article);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Article article = new Article();
        article.setId(id);
        article.setArticleUpdateTime(new Date());
        article.setDelFlag(CommonConstant.STATUS_DEL);
        return articleService.updateById(article);
    }

    /**
     * 编辑
     * @param  article  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Article article) {
    	// 先判断是否存在记录
    	Article articlePO = null;
    	if ((articlePO = this.articleService.selectById(article.getId())) != null) {
    		articlePO.setArticleTitle(article.getArticleTitle()); // 标题
    		articlePO.setArticleContent(article.getArticleContent()); // 内容
    		articlePO.setArticleChildCategoryId(article.getArticleChildCategoryId()); // 类别
    		articlePO.setArticleTags(article.getArticleTags());	// 标签
    		articlePO.setArticleUpdateTime(new Date());
    		return articleService.updateById(articlePO);
    	} else {
    		return false;
    	}
    }
    
    /**
     * 获取文章数量
     * 
     * @return
     * @author gaz
     */
    @GetMapping("/count")
    public int count() {
    	return this.articleService.selectCount(null);
    }
}
