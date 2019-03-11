package com.foresee.ssfm.exception;

import com.foresee.icap.common.exception.IcapRuntimeException;

/**
 * <pre>
 *     自定义异常类
 * </pre>
 *
 * @author longying@foresee.com.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 * @date 2019年01月10日
 */
public class DemoException extends IcapRuntimeException {

    public DemoException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}