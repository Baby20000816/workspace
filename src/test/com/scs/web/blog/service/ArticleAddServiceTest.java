package com.scs.web.blog.service;

import com.scs.web.blog.domain.dto.ArticleDto;
import com.scs.web.blog.entity.ArticleAdd;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.util.Result;
import org.junit.Test;

public class ArticleAddServiceTest {
    private ArticleAddService articleAddService = ServiceFactory.getArticleAddServiceInstance();
    @Test
    public void addArticle() {
        ArticleAdd article = new ArticleAdd();
        article.setUserId((long)4);
        article.setTopicId((long)4);
        article.setThumbnail("缩略图");
        article.setTitle("标题");
        article.setContent("内容");
        article.setSummary("摘要");
        Result result = articleAddService.addArticle(article);
        System.out.println(result);
    }

    @Test
    public void upDate() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle("功夫");
        articleDto.setSummary("一位作家这样总结写作者的三个阶段，第一阶段是自我表达期，第二阶段是刻意训练期，第三阶段是风格成熟期。 简单来说，第一阶段专注于个人世界的表达，写...");
        articleDto.setThumbnail("https:https://upload-images.jianshu.io/upload_images/117091-a610afc7da36aa80.png");
        articleDto.setContent("");
        articleDto.setId((long) 1);
        Result rs= articleAddService.upDate(articleDto);
        System.out.println(rs);
    }
}