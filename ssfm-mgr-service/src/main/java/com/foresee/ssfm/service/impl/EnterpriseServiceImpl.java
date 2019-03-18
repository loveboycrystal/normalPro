/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.service.impl;

import com.foresee.ssfm.dto.EnterpriseDTO;
import com.foresee.ssfm.model.Enterprise;
import com.foresee.ssfm.dao.EnterpriseMapper;
import com.foresee.ssfm.service.IEnterpriseService;
import com.foresee.icap.framework.data.service.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 企业信息 服务实现类
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-11
 */
@Service
public class EnterpriseServiceImpl extends BaseServiceImpl<EnterpriseMapper, Enterprise> implements IEnterpriseService {
    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Override
    public EnterpriseDTO getEnterpriseByID(Integer enterpriseId) {
        Enterprise enterprise = enterpriseMapper.selectById(enterpriseId);

        EnterpriseDTO enterpriseDTO = new EnterpriseDTO();
        BeanUtils.copyProperties(enterprise,enterpriseDTO);
        return enterpriseDTO;
    }
}
