/*
* Copyright(c) Foresee Science & Technology Ltd.
*/
package com.foresee.ssfm.rest.back;


import com.foresee.icap.common.exception.IcapRuntimeException;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ssfm.dto.PayDetaiDTO;
import com.foresee.ssfm.qo.PayDetailQO;
import com.foresee.ssfm.service.IPayDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 企业纳税记录 前端控制器
 * </p>
 *
 * @author chenensheng@foresee.com.cn
 * @since 2019-03-12
 */
@RestController
@RequestMapping("/ssfm/paydetail")
public class PayDetailController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PayDetailController.class);

    @Resource
    private IPayDetailService iPayDetailService;


    @RequestMapping(value = "/getenterprisepaydetaillist", method = RequestMethod.POST)
    public Response<List<PayDetaiDTO>> getEnterprisePayDetailList(@RequestBody @Validated PayDetailQO payDetailQO) {
        return Response.successData(iPayDetailService.getEnterprisePayDetailList(payDetailQO));
    }
}
