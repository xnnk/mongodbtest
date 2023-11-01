package com.lee.article.repository;

import com.lee.article.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName: CommentRepository
 * @Description: 评论的持久层接口
 * @Author: LZX
 * @Date: 2023/10/31 21:08
 */
public interface CommentRepository extends MongoRepository<Comment, String> {

    /**
     * 通过父级评论查询子评论
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Comment> findByParentid(String parentid, Pageable pageable);

}
