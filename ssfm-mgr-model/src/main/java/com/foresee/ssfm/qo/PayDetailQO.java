/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.qo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

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
public class PayDetailQO implements Serializable {

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



    /**
     * 企业纳税识别号
     */
    private String payNo;

}
