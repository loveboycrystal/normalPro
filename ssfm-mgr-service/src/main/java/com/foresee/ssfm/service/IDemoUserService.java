package com.foresee.ssfm.service;

import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.icap.framework.api.page.IPage;

/**
 * <pre>
 *     业务层接口类
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
public interface IDemoUserService {
    /**
     * 分页查询用户信息
     *
     * @param demoUserQO:用户QO类
     * @return: 封装了用户数据的实体类
     */
    IPage<DemoUserDTO> pageDemoUserAllDTO(DemoUserQO demoUserQO);

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId:用户ID
     * @return 用户数据传输类
     */
    DemoUserDTO getDemoUserByUserId(Long userId);

    /**
     * 根据用户ID删除用户数据
     *
     * @param userId:用户ID
     */
    void deleteDemoUserByUserId(Long userId);


    /**
     * 保存或者修改用户信息
     *
     * @param demoUserDTO
     */
    void saveOrUpdateDemoUser(DemoUserDTO demoUserDTO);

    /**
     * 根据用户名查询用户
     * @param userName:用户名
     * @return
     */
    DemoUserDTO findDemoUserByUserName(String userName);

}