package com.scs.web.blog.dao;

import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;

public class CommentDaoTest {
   private CommentDao commentDao = DaoFactory.getCommentDaoInstance();

    @Test
    public void insert() throws SQLException {
        CommentDto comment = new CommentDto();
        comment.setUserid("13166667777");
        comment.setContent("222");
        comment.setNickname("111");
        int n = commentDao.insert(comment);
        System.out.println(n);
    }
}