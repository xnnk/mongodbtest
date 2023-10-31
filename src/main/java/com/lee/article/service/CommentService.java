package com.lee.article.service;

import com.lee.article.entity.Comment;
import com.lee.article.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
