package com.scs.web.blog.dao;

import com.scs.web.blog.domain.vo.ArticleVo;
import com.scs.web.blog.entity.Article;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.SpiderUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ArticleDaoTest {

    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();

    @Test
    public void batchInsert() throws SQLException {
        articleDao.batchInsert(SpiderUtil.getArticles());
    }

    @Test
    public void selectHotArticles() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectHotArticles();
        System.out.println(articleVoList.size());
    }

    @Test
    public void getArticle() throws SQLException {
        ArticleVo article = articleDao.getArticle(1);
        System.out.println(article);
    }

    @Test
    public void selectByKeywords() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectByKeywords("微");
        System.out.println(articleVoList.size());
    }

    @Test
    public void selectByPage() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectByPage(1, 10);
        articleVoList.forEach(System.out::println);
    }

    @Test
    public void insert() throws SQLException {
        Article article = new Article("猫和老鼠", "tom and jerry", "https://p.ssl.qhimg.com/d/dy_3c86e579284368c51343acfbd60dde9f.", "猫和老鼠全集 全185集 收藏已收藏 全网儿童排名第50名 类型 : 搞笑益智亲子 年代 :1940 地区 : 美国 简介 : 这个机灵老鼠与笨猫的故事,堪与米老鼠和唐老鸭的故事相媲美。", 0, 0, LocalDateTime.now());
        articleDao.insert(article);
    }
}