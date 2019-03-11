/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.service;

import com.foresee.ssfm.dao.EnterpriseMapper;
import com.foresee.ssfm.dto.EnterpriseDTO;
import com.foresee.ssfm.model.Enterprise;
import com.foresee.icap.framework.data.service.IBaseService;

import javax.annotation.Resource;

/**
 * <p>
 * 企业信息 服务类
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-11
 */
public interface IEnterpriseService extends IBaseService<Enterprise> {

        public EnterpriseDTO getEnterpriseByID(Integer enterpriseId);

}
