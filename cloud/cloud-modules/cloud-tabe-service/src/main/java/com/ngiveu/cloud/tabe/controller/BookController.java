package com.ngiveu.cloud.tabe.controller;
import java.util.Date;
import java.util.Map;

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
import com.ngiveu.cloud.tabe.entity.Book;
import com.ngiveu.cloud.tabe.service.IBookService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaz
 * @since 2018-05-13
 */
@RestController
@RequestMapping("/book")
public class BookController extends BaseController {
    @Autowired private IBookService bookService;
    
    /**
    * 通过ID查询
    *
    * @param id ID
    * @return Book
    */
    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return bookService.selectById(id);
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public Page<Book> page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return bookService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  book  实体
     * @return success/false
     */
    @PostMapping
    public Boolean add(@RequestBody Book book) {
        return bookService.insert(book);
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        Book book = new Book();
        book.setId(id);
        book.setUpdateTime(new Date());
        book.setDelFlag(CommonConstant.STATUS_DEL);
        return bookService.updateById(book);
    }

    /**
     * 编辑
     * @param  book  实体
     * @return success/false
     */
    @PutMapping
    public Boolean edit(@RequestBody Book book) {
        book.setUpdateTime(new Date());
        return bookService.updateById(book);
    }
}
