/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.dao;

import com.foresee.ssfm.dto.PayDetaiDTO;
import com.foresee.ssfm.model.PayDetail;
import com.foresee.icap.framework.data.mybatis.IBaseMapper;
import com.foresee.ssfm.qo.PayDetailQO;

import java.util.List;

/**
 * <p>
 * 企业纳税记录 Mapper 接口
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-12
 */
public interface PayDetailMapper extends IBaseMapper<PayDetail> {
    
    /**
     *
     * 功能描述: 
     *
     * @param: 
     * @return: 
     * @auther: chenensheng@foresee.com.cn
     * @date: 2019/3/12 17:17
     */    
     List<PayDetaiDTO> getEnterprisePayDetailList(PayDetailQO payDetailQO);
}
