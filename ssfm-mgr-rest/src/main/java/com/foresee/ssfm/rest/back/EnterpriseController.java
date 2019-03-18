/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.rest.back;


import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ssfm.dto.EnterpriseDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.qo.EnterpriseQO;
import com.foresee.ssfm.service.IEnterpriseService;
import com.google.gson.Gson;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 企业信息 前端控制器
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-11
 */
@Validated
@RestController
@RequestMapping("/ssfm/enterprise")
public class EnterpriseController {

    @Resource
    private IEnterpriseService iEnterpriseService;

    @RequestMapping(value = "/getenterprisebyid", method = RequestMethod.POST)
    public Response<EnterpriseDTO> getEnterpriseByID(@RequestBody @Validated EnterpriseQO enterpriseQO) {
        EnterpriseDTO enterpriseDTO  = iEnterpriseService.getEnterpriseByID(enterpriseQO.getEnterpriseId());
        System.out.println(enterpriseDTO.getEnterpriseName());
        System.out.println(enterpriseDTO);
        System.out.println(enterpriseDTO);
        System.out.println(enterpriseDTO);
        System.out.println(enterpriseDTO);
        return Response.successData(enterpriseDTO);
    }
}
