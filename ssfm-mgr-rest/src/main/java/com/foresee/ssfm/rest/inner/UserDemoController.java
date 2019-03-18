package com.foresee.ssfm.rest.inner;

import com.foresee.ssfm.api.inner.DemoUserInnerApi;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.qo.SimpleDemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.foresee.icap.framework.entity.api.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.annotation.Resource;
/**
 * <pre>
 *     提供给服务间内部调用的rest接口
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
@RestController
@Validated
public class UserDemoController implements DemoUserInnerApi {

    @Resource
    private IDemoUserService demoUserService;

    /**
     * simpleDemoUserDTO
     * @param simpleDemoUserDTO:封装查询ID的实体类
     * @return 返回实体类
     */
    @Override
    public Response<DemoUserDTO> getByUserId(@Valid SimpleDemoUserQO simpleDemoUserQO) {
        return Response.successData(this.demoUserService.getDemoUserByUserId(simpleDemoUserQO.getUserId()));
        System.out.println("");
    }
}