package com.foresee.ssfm.rest.back;

import com.foresee.icap.framework.api.page.IPage;
import com.foresee.icap.framework.core.redis.IRedisClient;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.dto.SimpleDemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.google.gson.Gson;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 *     提供给管理后台界面的rest接口
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
@Validated
@RestController("/back/testservice")
@RequestMapping("/back/testservice")
public class TestController {

    @Resource
    private IRedisClient iRedisClient;

    /**
     * 根据用户ID获取用户信息
     *
     * @param demoUserQO:封装查询ID的DTO
     * @return
     */
    @RequestMapping(value = "/testparam", method = RequestMethod.GET)
    public Response testparam(@RequestBody @Validated DemoUserQO demoUserQO) {
        //iRedisClient.set("chenes","hello world");
        iRedisClient.set("demoUserQO",new Gson().toJson(demoUserQO));
        System.out.println(iRedisClient.get("demoUserQO"));
        return Response.successData(demoUserQO);
    }




}