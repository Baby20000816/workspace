package com.scs.web.blog.dao;

import com.scs.web.blog.entity.ArticleAdd;
import com.scs.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ArticleAddDaoTest {
private ArticleAddDao articleAddDao = DaoFactory.getArticleAddDaoInstance();
    @Test
    public void insert() throws SQLException {
        ArticleAdd articleAdd = new ArticleAdd();
        articleAdd.setUserId((long)1);
        articleAdd.setTopicId((long)2);
        articleAdd.setTitle("标题");
        articleAdd.setSummary("摘要");
        articleAdd.setThumbnail("缩略图");
        articleAdd.setContent("文章内容");
        articleAdd.setLikes(0);
        articleAdd.setComments(0);
        articleAdd.setCreateTime(LocalDateTime.now());
        int n = articleAddDao.insert(articleAdd);
        System.out.println(n);
    }
}