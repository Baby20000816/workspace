package com.scs.web.blog.dao;

import com.scs.web.blog.domain.dto.ArticleDto;
import com.scs.web.blog.entity.ArticleAdd;
import com.scs.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
public class ArticleAddDaoTest {
private ArticleAddDao articleAddDao = DaoFactory.getArticleAddDaoInstance();
    @Test
    public void insert() throws SQLException {
        ArticleAdd articleAdd = new ArticleAdd();
        articleAdd.setUserId((long)4);
        articleAdd.setTopicId((long)4);
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
    @Test
    public void selectAll() throws SQLException
    {
        List<ArticleAdd> articleAddList = articleAddDao.selectAll();
        articleAddList.forEach(System.out::println);
    }

    @Test
    public void update() throws SQLException{
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle("功夫");
        articleDto.setSummary("一位作家这样总结写作者的三个阶段，第一阶段是自我表达期，第二阶段是刻意训练期，第三阶段是风格成熟期。 简单来说，第一阶段专注于个人世界的表达，写...");
        articleDto.setThumbnail("https:https://upload-images.jianshu.io/upload_images/117091-a610afc7da36aa80.png");
        articleDto.setContent("");
        articleDto.setId((long) 2);
        int n = articleAddDao.update(articleDto);
        System.out.println(n);
    }
}