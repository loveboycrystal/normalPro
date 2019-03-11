package com.foresee.ssfm.model;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_demo_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoUser implements Serializable {
    /**
     * 主键
     * 表 : t_demo_user
     * 对应字段 : user_id
     */
    @TableId
    private Long userId;

    /**
     * 姓名
     * 表 : t_demo_user
     * 对应字段 : user_name
     */
    private String userName;

    /**
     * 密码
     * 表 : t_demo_user
     * 对应字段 : password
     */
    private String password;

    /**
     * 状态
     * 表 : t_demo_user
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 创建人
     * 表 : t_demo_user
     * 对应字段 : CREATE_USER
     */
    private String createUser;

    /**
     * 创建日期
     * 表 : t_demo_user
     * 对应字段 : CREATE_DATE
     */
    private Date createDate;

    /**
     * 修改人
     * 表 : t_demo_user
     * 对应字段 : UPDATE_USER
     */
    private String updateUser;

    /**
     * 修改日期
     * 表 : t_demo_user
     * 对应字段 : UPDATE_DATE
     */
    private Date updateDate;
}