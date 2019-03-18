/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业信息
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_ssfm_enterprise")
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 企业id
     */
    @TableId
    private Integer enterpriseId;

    /**
     * 企业纳税识别号
     */
    private String payNo;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 企业地址
     */
    private String address;


}
