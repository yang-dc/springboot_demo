package com.test.dao.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("user_info")
@Data           // getter setter toString eq hc
@NoArgsConstructor      // 无参构造
@AllArgsConstructor     // 有参构造
public class User {

    @TableField("userName")
    private String userName;
    @TableField("passWord")
    private String passWord;
    private String url;

}
