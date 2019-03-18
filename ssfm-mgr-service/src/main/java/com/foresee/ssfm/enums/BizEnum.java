package com.foresee.ssfm.enums;/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */

import com.foresee.icap.framework.core.error.IBaseErrorEnum;

/**
 * <pre>
 * 。
 * </pre>
 *
 * @author @foresee.com.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 * @date
 */


public enum BizEnum implements IBaseErrorEnum {

    OBJECT_IS_NULL("2001", "根据用户ID=[%s]没有查询到相关的用户信息");

    private BizEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private String errorCode;

    private String errorMessage;

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }}
