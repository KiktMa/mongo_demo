package com.mjtal.mongo_demo.service;

import com.mjtal.mongo_demo.MongoDemoApplication;
import com.mjtal.mongo_demo.entity.Comment;
import com.mjtal.mongo_demo.service.impl.CommentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

//SpringBoot的Junit集成测试
@RunWith(SpringRunner.class)
//SpringBoot的测试环境初始化，参数：启动类
@SpringBootTest(classes = MongoDemoApplication.class)
public class CommentServiceTest {
    //注入Service
    @Autowired
    private CommentServiceImpl commentService;

    /**
     * 保存一个评论
     */
    @Test
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    /**
     * 查询所有数据
     */
    @Test
    public void testFindAll() {
        List<Comment> list = commentService.findCommentList();
        System.out.println(list);
    }

    /**
     * 测试根据id查询
     */
    @Test
    public void testFindCommentById() {
        Comment comment = commentService.findCommentById("63f266bc89abc04b9f16a397");
        System.out.println(comment);
    }

    /**
     * 测试根据父id查询子评论的分页列表
     */
    @Test
    public void testFindCommentListPageByParentid(){
        Page<Comment> pageResponse = commentService.findByParentid("3", 1, 2);
        System.out.println("----总记录数："+pageResponse.getTotalElements());
        System.out.println("----当前页数据："+pageResponse.getContent());
    }
}