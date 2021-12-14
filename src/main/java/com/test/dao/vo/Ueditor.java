package com.test.dao.vo;

import lombok.Data;

@Data
public class Ueditor {
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;        // mybatisPlus 默认雪花算法
    private String contentHtml;
    private String content;
    private String contentKey;
}
