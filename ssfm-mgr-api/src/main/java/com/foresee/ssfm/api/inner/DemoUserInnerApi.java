package com.foresee.ssfm.api.inner;

import javax.validation.Valid;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.qo.SimpleDemoUserQO;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.icap.framework.api.rest.annotation.Rest;

/**
 * 用户提供给内部的调用
 */
@Rest(service="ssfm", path="/inner/user/")
public interface DemoUserInnerApi {
    /**
     * 根据用户ID查询用户信息
     * @param userId
     * @return
     */
    Response<DemoUserDTO> getByUserId(@Valid SimpleDemoUserQO simpleDemoUserQO);


}
