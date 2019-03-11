package com.foresee.ssfm.rest.outer;

import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.dto.SimpleDemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.foresee.icap.framework.entity.api.Response;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
/**
 * <pre>
 *     提供给给第三方系统调用的rest接口
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
@RestController("/outer/DemoUserService")
@RequestMapping("/outer/DemoUserService")
public class UserDemoController {

    @Resource
    private IDemoUserService demoUserService;

    /**
     * 根据用户ID查询用户信息
     * @param simpleDemoUserDTO:封装查询ID的实体类
     * @return
     */
    @RequestMapping(value = "/getDemoUserByUserId", method = RequestMethod.POST)
    public Response<DemoUserDTO> getDemoUserByUserId(@RequestBody @Validated SimpleDemoUserDTO simpleDemoUserDTO) {
        return Response.successData(this.demoUserService.getDemoUserByUserId(simpleDemoUserDTO.getUserId()));
    }
}