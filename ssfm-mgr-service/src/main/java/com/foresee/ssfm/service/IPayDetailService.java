/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.service;

import com.foresee.ssfm.dto.PayDetaiDTO;
import com.foresee.ssfm.model.PayDetail;
import com.foresee.icap.framework.data.service.IBaseService;
import com.foresee.ssfm.qo.PayDetailQO;

import java.util.List;

/**
 * <p>
 * 企业纳税记录 服务类
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-12
 */
public interface IPayDetailService extends IBaseService<PayDetail> {
    List<PayDetaiDTO> getEnterprisePayDetailList(PayDetailQO payDetailQO);
}
