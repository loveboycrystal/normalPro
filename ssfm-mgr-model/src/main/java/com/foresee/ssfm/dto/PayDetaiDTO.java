/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 企业纳税记录
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayDetaiDTO implements Serializable {

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
    private Date payTime;

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
