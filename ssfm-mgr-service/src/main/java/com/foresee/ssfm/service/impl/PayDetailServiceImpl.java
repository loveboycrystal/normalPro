/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.service.impl;

import com.foresee.ssfm.dto.PayDetaiDTO;
import com.foresee.ssfm.enums.BizEnum;
import com.foresee.ssfm.model.PayDetail;
import com.foresee.ssfm.dao.PayDetailMapper;
import com.foresee.ssfm.qo.PayDetailQO;
import com.foresee.ssfm.service.IPayDetailService;
import com.foresee.icap.framework.data.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 企业纳税记录 服务实现类
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-12
 */
@Service
public class PayDetailServiceImpl extends BaseServiceImpl<PayDetailMapper, PayDetail> implements IPayDetailService {

    @Resource
    private PayDetailMapper payDetailMapper;

    @Override
    public List<PayDetaiDTO> getEnterprisePayDetailList(PayDetailQO payDetailQO) {
        if( null == payDetailQO  || null == payDetailQO.getEnterpriseId()){
            throw BizEnum.OBJECT_IS_NULL.toRuntimeException("NULL");
        }
        return payDetailMapper.getEnterprisePayDetailList(payDetailQO);
    }
}
