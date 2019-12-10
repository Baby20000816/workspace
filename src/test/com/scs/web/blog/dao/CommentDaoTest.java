package com.scs.web.blog.dao;

import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;

public class CommentDaoTest {
   private CommentDao commentDao = DaoFactory.getCommentDaoInstance();

    @Test
    public void insert() throws SQLException {
        Comment comment = new Comment();
        comment.setUserId((long) 1);
        comment.setArticleId((long) 2);
        comment.setContent("222");
        comment.setNickname("111");
        int n = commentDao.insert(comment);
        System.out.println(n);
    }
}