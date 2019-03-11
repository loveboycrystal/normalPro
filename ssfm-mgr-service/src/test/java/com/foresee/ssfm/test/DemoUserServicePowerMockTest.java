/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */
package com.foresee.ssfm.test;

import com.foresee.icap.common.exception.IcapRuntimeException;
import com.foresee.ssfm.dao.DemoUserMapper;
import com.foresee.ssfm.config.DataConfigHelper;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.foresee.icap.framework.api.page.IPage;
import com.foresee.icap.framework.test.BasePowerMockTest;
import org.junit.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * <pre>
 * SampleUserController模拟测试
 * </pre>
 *
 * @author chenqiang@foresee.com.cn
 * @version 1.00.00
 * @date 2018年12月21日
 */
@PrepareForTest({DemoUserMapper.class, IDemoUserService.class})
@Profile("dev")
public class DemoUserServicePowerMockTest extends BasePowerMockTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoUserServicePowerMockTest.class);


    @Autowired
    private IDemoUserService demoUserService;

    @Autowired
    private DataConfigHelper dataConfigHelper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        dataConfigHelper.initData();
    }

    /**
     * 测试分页方法
     */
    @Test
    public void testPageDemoUserAllDTO() {
        DemoUserQO demoUserQO = new DemoUserQO();
        IPage<DemoUserDTO> pageQueryResult = this.demoUserService.pageDemoUserAllDTO(demoUserQO);
        assertNotNull(pageQueryResult);
    }

    @Test
    @Transactional
    public void testAddDemoUserDTO() {
        DemoUserDTO demoUserDTO = dataConfigHelper.getDemoUserDTO();
        demoUserDTO.setUserName(dataConfigHelper.createUserName("张三", 200));
        this.demoUserService.saveOrUpdateDemoUser(demoUserDTO);
        DemoUserDTO dbDemoUserDTO = this.demoUserService.findDemoUserByUserName(demoUserDTO.getUserName());
        assertNotNull(dbDemoUserDTO);
    }

    @Test
    @Transactional
    public void testUpdateDemoUserDTO() {
        DemoUserDTO demoUserDTO = dataConfigHelper.getDemoUserDTO();
        String oldUserName = demoUserDTO.getUserName();
        demoUserDTO.setUserName(oldUserName);
        this.demoUserService.saveOrUpdateDemoUser(demoUserDTO);
        demoUserDTO = this.demoUserService.findDemoUserByUserName(oldUserName);
        assertNotNull(demoUserDTO);
        String newUserName = dataConfigHelper.createUserName("王五", 300);
        demoUserDTO.setUserName(newUserName);
        this.demoUserService.saveOrUpdateDemoUser(demoUserDTO);
        demoUserDTO = this.demoUserService.findDemoUserByUserName(newUserName);
        assertNotNull(demoUserDTO);
    }

    @Test
    public void testDemoUserByUserId() {
        DemoUserDTO dbDemoUserDTO = this.demoUserService.findDemoUserByUserName(dataConfigHelper.getUserName());
        assertNotNull(dbDemoUserDTO);
        assertNotNull(this.demoUserService.getDemoUserByUserId(dbDemoUserDTO.getUserId()));
    }

    @Test
    public void testDeleteDemoUserByUserId() {
        DemoUserDTO dbDemoUserDTO = this.demoUserService.findDemoUserByUserName(dataConfigHelper.getUserName());
        assertNotNull(dbDemoUserDTO);
        Long userId = dbDemoUserDTO.getUserId();
        this.demoUserService.deleteDemoUserByUserId(userId);
        try {
            assertNull(this.demoUserService.getDemoUserByUserId(userId));
        } catch (IcapRuntimeException e) {
            String errorCode = e.getErrorCode();
            LOGGER.error("return errorCode:[{}],errorMsg:[{}]", errorCode, e.getErrorMsg());
            assertEquals(errorCode, "2001");
        }

    }

    @After
    public void tearDown() {
        this.dataConfigHelper.destroyData();
    }

}
