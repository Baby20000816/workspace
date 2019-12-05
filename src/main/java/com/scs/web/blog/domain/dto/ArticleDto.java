package com.scs.web.blog.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jh_wu
 * @ClassName ArticleDto
 * @Description TODO
 * @Date 2019/12/4:11:40
 * @Version 1.0
 **/
@Data
public class ArticleDto implements Serializable {
    private String title;
    private String content;
}
