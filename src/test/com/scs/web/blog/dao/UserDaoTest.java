package com.scs.web.blog.dao;

import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.SpiderUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserDaoTest {
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Test
    public void insert() throws SQLException {
        User user = new User("13912758321","111","可爱如猪","https://pic.cnblogs.com/face/1646268/20191016095414.png","男", LocalDate.of(2000,8,16),"中国,苏州市,吴江区,七都镇","就是可爱","https://img2018.cnblogs.com/blog/1646268/201908/1646268-20190807204419622-1770363151.jpg","1273163614@qq.com","www.baidu.com",1,1,1, LocalDateTime.now(), (short) 1);
        userDao.insert(user);
    }

    @Test
    public void batchInsert() throws SQLException {
        userDao.batchInsert(SpiderUtil.getUsers());
    }

    @Test
    public void findUserByMobile() throws SQLException {
        User user = userDao.findUserByMobile("13951905171");
        System.out.println(user);
    }

    @Test
    public void selectHotUsers() throws SQLException {
        List<User> userList = userDao.selectHotUsers();
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByKeywords() throws SQLException{
        List<User> userList = userDao.selectByKeywords("王");
        System.out.println(userList.size());
    }
}