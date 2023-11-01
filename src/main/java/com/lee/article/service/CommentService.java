package com.lee.article.service;

import com.lee.article.entity.Comment;
import com.lee.article.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CommentService
 * @Description: 评论的业务层
 * @Author: LZX
 * @Date: 2023/10/31 21:10
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment) {
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
        //设置一些默认初始值。。。
        //调用dao
        repository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
        //调用dao
        repository.save(comment);
    }
    /**
     * 根据id删除评论
     * @param id
     */
    public void deleteCommentById(String id){
        //调用dao
        repository.deleteById(id);
    }
    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> findCommentList(){
        //调用dao
        return repository.findAll();
    }
    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        //调用dao
        return repository.findById(id).get();
    }

    /**
     * 根据父评论查找相关的子评论
     * @param parentId
     * @param page
     * @param pageSize
     * @return
     */
    public Page<Comment> findCommentListByParentId(String parentId, int page, int pageSize) {
        return repository.findByParentid(parentId, PageRequest.of(page - 1, pageSize));
    }

    /**
     * 根据id将该评论的点赞数+1
     * @param id
     */
    public void updateCommentLikenum(String id) {

        // 查询条件:当字段_id = id
        Query query = Query.query(Criteria.where("articleid").is(id));

        // 更新条件:likenum字段 + 1
        Update update = new Update();
        update.inc("likenum");

        // 执行
        mongoTemplate.updateFirst(query, update, Comment.class);

    }

}
