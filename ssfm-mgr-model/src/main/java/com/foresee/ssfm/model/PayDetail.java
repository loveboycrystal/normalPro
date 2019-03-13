/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业纳税记录
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_ssfm_pay_detail")
public class PayDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 企业纳税明细编号
     */
    @TableId
    private Integer payDetailId;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 缴费月份
     */
    private String payMonth;

    /**
     * 缴费时间
     */
    private LocalDate payTime;


}
