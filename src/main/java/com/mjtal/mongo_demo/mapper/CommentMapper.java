package com.mjtal.mongo_demo.mapper;

import com.mjtal.mongo_demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

@Mapper
public interface CommentMapper extends MongoRepository<Comment,String> {
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
