package com.scs.web.blog.service.impl;

import com.scs.web.blog.dao.ArticleDao;
import com.scs.web.blog.dao.CommentDao;
import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.service.CommentService;
import com.scs.web.blog.util.Result;
import com.scs.web.blog.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zh_yan
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
public class CommentServiceImpl implements CommentService {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private CommentDao commentDao = DaoFactory.getCommentDaoInstance();
    private Logger logger = LoggerFactory.getLogger(CommentService.class);
    @Override
    public Result addArtComments(CommentDto comment) {
        int n = 0;
        try {
            comment.setCreateTime(LocalDateTime.now());
            n = commentDao.insert(comment);

            System.out.println(n);
        } catch (SQLException e) {
            logger.error("评论内容添加失败");
        }
        if(n != 0){
            return Result.success(n);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result selectByPage(int currentPage, int count) {
        List<Comment> commentList = null;
        try {
            commentList = commentDao.selectByPage(currentPage, count);
        } catch (SQLException e) {
            logger.error("分页查询留言出现异常");
        }
        if (commentList != null) {
            return Result.success(commentList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result batchDelete(Long id) {

        int n =0 ;
        try {
            n = commentDao.batchDelete(id);
        } catch (SQLException e) {
            logger.error("根据nickname删除留言出现异常");
        }
        if (n != 0) {
            return Result.success(n);
        } else {
            return Result.failure(ResultCode.COMMENT_DELETE_FAIL);
        }
    }


    @Override
    public List<Comment> listComment() {
        List<Comment> comments = null;
        try {
            comments=commentDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询所有学生异常");
        }
        return comments;
    }


}
