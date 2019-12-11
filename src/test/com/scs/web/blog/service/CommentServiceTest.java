package com.scs.web.blog.service;

import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.util.Result;
import org.junit.Test;

public class CommentServiceTest {
    private CommentService commentService = ServiceFactory.getCommentServiceInstance();
    @Test
    public void batchDelete() {
        Result result =  commentService.batchDelete((long) 20);
        System.out.println(result);
    }
}