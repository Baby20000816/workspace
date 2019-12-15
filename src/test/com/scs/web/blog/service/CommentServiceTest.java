package com.scs.web.blog.service;

import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.util.Result;
import org.junit.Test;

public class CommentServiceTest {
    private CommentService commentService = ServiceFactory.getCommentServiceInstance();
    @Test
    public void batchDelete() {
        Result result =  commentService.batchDelete((long) 8);
        System.out.println(result);
    }

    @Test
    public void selectByPage() {
        Result result =  commentService.selectByPage(1,5);
        System.out.println(result);
    }

    @Test
    public void addArtComments() {
        CommentDto userDao = new CommentDto();
        userDao.setNickname("13166667777");
        userDao.setUserid("222");
        userDao.setContent("222");
        Result result = commentService.addArtComments(userDao);
        System.out.println("code:" + result.getCode() + "," + "msg:" + result.getMsg());
    }
}