package com.lee.article.repository;

import com.lee.article.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName: CommentRepository
 * @Description: 评论的持久层接口
 * @Author: LZX
 * @Date: 2023/10/31 21:08
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
}
