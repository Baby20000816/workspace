package com.scs.web.blog.dao.impl;


import com.scs.web.blog.dao.CommentDao;
import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.util.BeanHandler;
import com.scs.web.blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zh_yan
 * @ClassName CommentDaoImpl
 * @Description TODO
 * @Date 2019/12/3
 * @Version 1.0
 **/
public class CommentDaoImpl implements CommentDao {
    private static Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class);
    @Override
    public List<Comment> selectByPage(int currentPage, int count) throws SQLException {
        Connection connection = DbUtil.getConnection();
        //分页语句的两个参数，分别表示当前页第一行记录的索引，每页的数据量
        //比如每页10条数据，第一页0-9，第二页10-19，从而可以推算一下关系
        String sql = "SELECT * FROM t_comment  ORDER BY id LIMIT ?,? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, (currentPage - 1) * count);
        pst.setInt(2, count);
        ResultSet rs = pst.executeQuery();
        List<Comment>commentList = BeanHandler.convertComment(rs);
        DbUtil.close(connection, pst, rs);
        return commentList;
    }
    @Override
    public int insert(CommentDto user) throws SQLException{
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_comment (userid,nickname,content,create_time) VALUES (?,?,?,?) ";
        PreparedStatement pst = connection.prepareStatement(sql);
        System.out.println(user);
       pst.setString(1,user.getUserid());
//        pst.setLong(2,user.getArticleId());
        pst.setString(2, user.getNickname());
        pst.setString(3, user.getContent());
        pst.setObject(4, LocalDateTime.now());

        int n = pst.executeUpdate();
        DbUtil.close(connection, pst);
        return n;
    }

    @Override
    public int batchDelete(Long id) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "DELETE FROM t_comment WHERE id = ? " ;
        int n = 0;
        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setLong(1,id);
        n = pst.executeUpdate();
        connection.commit();
        DbUtil.close(connection,pst);
        return n;
    }

    @Override
    public List<Comment> selectHotComments() throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_comment ORDER BY follows DESC LIMIT 8 ";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<Comment> commentList = BeanHandler.convertComment(rs);
        DbUtil.close(connection, pst, rs);
        return commentList;
    }
    @Override
    public List<Comment> selectAll() throws SQLException {
        List<Comment> commentList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_comment ORDER BY id DESC ";
        PreparedStatement pstmt = connection.prepareStatement(sql) ;
        ResultSet rs = pstmt. executeQuery();
        while (rs.next()) {
            Comment comment = new Comment();
            comment. setId(rs.getLong("id"));
            comment.setUserid(rs.getString("userid"));
            comment. setNickname (rs.getString("nickname"));
            comment. setContent(rs.getString("content"));
            Timestamp timestamp = rs.getTimestamp("create_time");
            comment.setCreateTime (timestamp.toLocalDateTime());
            commentList.add(comment);
        }
        return commentList ;
    }



}
/*
public class CommentDaoImpl implements CommentDao {
    private static Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class);
    @Override
    public int AddComments(CommentDto commentDto) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_comment (nickname,content,createTime) VALUES (?,?,?) ";
        PreparedStatement pst = connection.prepareStatement(sql);
        System.out.println(commentDto);
        pst.setString(1, commentDto.getNickname());
        pst.setString(2, commentDto.getContent());
        pst.setObject(3, commentDto.getCreateTime());
        System.out.println(23333);
        int n = pst.executeUpdate();
        DbUtil.close(connection, pst);
        return n;
    }
*/




