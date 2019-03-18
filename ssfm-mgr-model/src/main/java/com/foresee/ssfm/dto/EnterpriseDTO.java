/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 企业信息
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnterpriseDTO {

    /**
     * 企业id
     */
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
