package com.foresee.ssfm.dao;

import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.model.DemoUser;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.icap.framework.api.page.IPage;
import com.foresee.icap.framework.data.mybatis.IBaseMapper;

public interface DemoUserMapper extends IBaseMapper<DemoUser> {
    /**
     * 分页查询用户信息
     *
     * @param queryUserQO
     * @return
     */
    IPage<DemoUserDTO> pageDemoUserAllDTO(DemoUserQO queryUserQO);

    /**
     * 根据用户名称查询用户信息
     * @param userName
     * @return
     */
    DemoUserDTO findDemoUserByUserName(String userName);
}