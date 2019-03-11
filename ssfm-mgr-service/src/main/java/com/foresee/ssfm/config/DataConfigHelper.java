package com.foresee.ssfm.config; /**
 * Copyright(c) Foresee Science & Technology Ltd.
 */

import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.service.IDemoUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <pre>
 * 。测试数据提供类
 * </pre>
 *
 * @author @foresee.com.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 *          </pre>
 * @date
 */


@Component
public class DataConfigHelper {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataConfigHelper.class);

    @Resource
    private IDemoUserService demoUserService;

    private static final Random RANDOM = new Random();

    /**
     * 用户名
     */
    public static String userName;

    /**
     * 获取用户名数据
     *
     * @return
     */
    public String getUserName() {
        return DataConfigHelper.userName;
    }

    /**
     * 获取DemoUserDTO实例
     *
     * @return
     */
    public DemoUserDTO getDemoUserDTO() {
        DataConfigHelper.userName = createUserName("张三", 113);
        DemoUserDTO demoUserDTO = new DemoUserDTO();
        demoUserDTO.setUserName(this.getUserName());
        demoUserDTO.setStatus(1);
        demoUserDTO.setPassword("123456789");
        return demoUserDTO;
    }

    /***
     * 生产用户名
     * @param userName:用户名
     * @param bound:随机种子
     * @return
     */
    public String createUserName(String userName, int bound) {
        return userName + (RANDOM.nextInt(1000)*bound) + "";
    }

    /**
     * 初始化数据
     */
    public void initData() {
        DemoUserDTO demoUserDTO = this.getDemoUserDTO();
        this.demoUserService.saveOrUpdateDemoUser(demoUserDTO);
        LOGGER.info("add data name:[{}]", demoUserDTO.getUserName());
    }

    /**
     * 销毁数据
     */
    public void destroyData() {
        DemoUserDTO dbDemoUserDTO = this.demoUserService.findDemoUserByUserName(this.getUserName());
        if (dbDemoUserDTO != null) {
            Long userId = dbDemoUserDTO.getUserId();
            LOGGER.info("need delete data user name:[{}]", dbDemoUserDTO.getUserName());
            this.demoUserService.deleteDemoUserByUserId(userId);
        }

    }
}