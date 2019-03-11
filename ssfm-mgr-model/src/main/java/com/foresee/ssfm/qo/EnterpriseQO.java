/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.qo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class EnterpriseQO implements Serializable {

    private static final long serialVersionUID = 1L;

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
