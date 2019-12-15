package com.scs.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scs.web.blog.dao.CommentDao;
import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.service.CommentService;
import com.scs.web.blog.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author zh_yan
 * @ClassName CommentController
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/

@WebServlet(urlPatterns = {"/api/comment","/api/comment/*"})
public class CommentController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(CommentController.class);
    private CommentDao commentDao = DaoFactory.getCommentDaoInstance();
    private CommentService commentService = ServiceFactory.getCommentServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommentService commentService = ServiceFactory.getCommentServiceInstance();
        List<Comment> comments = commentService.listComment();
        Gson gson = new Gson();
        resp.setContentType("application/json;charset='utf-8'");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(comments));
        out.close();

        String uri = req.getRequestURI().trim();
        if ("/api/comment/get".equals(uri)) {
            String page = req.getParameter("page");
            String count = req.getParameter("count");
            if (page != null) {
                getTopicsByPage(resp, Integer.parseInt(page), Integer.parseInt(count));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI().trim();
        if ("/api/comment/con".equals(uri)) {
            Connect(req, resp);
        }
    }

    private void Connect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //请求字符集设置
        req.setCharacterEncoding("UTF-8");
        //接送客户端船体的Json数据，通过缓冲字符流按行读取，存入可变长字符串中
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while((line = reader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder.toString());
        //将接受到的客户端JSON字符串转成User对象
        Gson gson = new GsonBuilder().create();
        CommentDto user =gson.fromJson(stringBuilder.toString(), CommentDto.class);
        System.out.println(user);
        //插入数据库，并返回该行主键
        Result rs = commentService.addArtComments(user);
        //补全user的id字段信息
        //通过response对象返回Json信息
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(rs));
        out.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getRequestURI().trim();
        String id = info.substring(info.lastIndexOf("/") + 1);
        System.out.println(id);
        Result result = commentService.batchDelete(Long.parseLong(id));
        Gson gson = new GsonBuilder().create();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    private void getTopicsByPage(HttpServletResponse resp, int page, int count) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        Result result = commentService.selectByPage(page, count);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

}