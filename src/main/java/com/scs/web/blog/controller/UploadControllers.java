//package com.scs.web.blog.controller;
//
//import com.scs.web.blog.util.AliOssUtil;
//import com.scs.web.blog.util.Result;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author jh_wu
// * @ClassName UploadControllers
// * @Description TODO
// * @Date 2019/12/14:13:59
// * @Version 1.0
// **/
//@WebServlet(urlPatterns = {"/api/upload"})
//@Slf4j
//public class UploadControllers extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        MultipartFile file=req.getParameter("file");
//        String url = AliOssUtil.upload(file);
//        System.out.println(file);
//        return Result.success(url);
//    }
//}