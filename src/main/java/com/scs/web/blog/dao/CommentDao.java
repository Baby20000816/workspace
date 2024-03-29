package com.scs.web.blog.dao;

import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.entity.Comment;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zh_yan
 * @ClassName Comment
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
/*
public interface CommentDao {
      int insert(Comment user) throws SQLException;

}*/
public interface CommentDao {
      /**
       * 添加新的评论
       * @param commentDto
       * @return
       * @throws SQLException
       */
    /*  int AddComments (CommentDto commentDto) throws SQLException;*/
      List<Comment> selectByPage(int currentPage, int count)throws SQLException;
      int insert(CommentDto user) throws SQLException;

      int batchDelete(Long id) throws SQLException;

      List<Comment> selectHotComments() throws SQLException;
      List<Comment> selectAll() throws SQLException;

}