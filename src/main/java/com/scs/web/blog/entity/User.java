package com.scs.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author mq_xu
 * @ClassName User
 * @Description 用户实体类
 * @Date 9:47 2019/11/9
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String introduction;
    private String banner;
    private String email;
    private String homepage;
    private Integer follows;
    private Integer fans;
    private Integer articles;
    private LocalDateTime createTime;
    private Short status;

    public User(String mobile, String password, String nickname, String avatar, String gender, LocalDate birthday, String address, String introduction, String banner, String email, String homepage, Integer follows, Integer fans, Integer articles, LocalDateTime createTime, Short status) {

        this.mobile = mobile;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.introduction = introduction;
        this.banner = banner;
        this.email = email;
        this.homepage = homepage;
        this.follows = follows;
        this.fans = fans;
        this.articles = articles;
        this.createTime = createTime;
        this.status = status;
    }
}
