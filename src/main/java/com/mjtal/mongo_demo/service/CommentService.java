package com.mjtal.mongo_demo.service;

import com.mjtal.mongo_demo.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService{
    Page<Comment> findByParentid(String parentid,  int page , int size);
}
