package com.foresee.ssfm.rest.back;/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */

import com.foresee.ssfm.config.DataConfigHelper;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.dto.SimpleDemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.qo.SimpleDemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.icap.framework.rest.RestRequestBuilder;
import com.foresee.icap.framework.web.test.BaseSpringWebTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * <pre>
 * 。back接口测试
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


public class DemoUserControllerTest extends BaseSpringWebTest {

    @Autowired
    private DataConfigHelper dataConfigHelper;

    @Autowired
    private IDemoUserService demoUserService;

    /**
     * 日志记录
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(DemoUserControllerTest.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
        dataConfigHelper.initData();
    }

    @Test
    public void pageDemoUserDTO() throws Exception {
        DemoUserQO demoUserDTO=new DemoUserQO();
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001").post("/back/DemoUserService/pageDemoUserAllDTO").userId("111111111111")
                .body(demoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
    }

    @Test
    @Transactional
    public void saveDemoUserDTO() throws Exception {
        DemoUserDTO demoUserDTO=dataConfigHelper.getDemoUserDTO();
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001").post("/back/DemoUserService/saveOrUpdateDemoUserDTO").userId("111111111111")
                .body(demoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
        DemoUserDTO dbDemoUserDTO=this.demoUserService.findDemoUserByUserName(demoUserDTO.getUserName());
        assertNotNull(dbDemoUserDTO);
    }

    @Test
    @Transactional
    public void updateDemoUserDTO() throws Exception {
        DemoUserDTO demoUserDTO=dataConfigHelper.getDemoUserDTO();
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001").post("/back/DemoUserService/saveOrUpdateDemoUserDTO").userId("111111111111")
                .body(demoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
        DemoUserDTO dbDemoUserDTO=this.demoUserService.findDemoUserByUserName(demoUserDTO.getUserName());
        dbDemoUserDTO.setUserName(dataConfigHelper.createUserName("李四",300));
        mockRestRequest = RestRequestBuilder.create("100010001").post("/back/DemoUserService/saveOrUpdateDemoUserDTO").userId("111111111111")
                .body(dbDemoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);
        response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
        dbDemoUserDTO=this.demoUserService.findDemoUserByUserName(dbDemoUserDTO.getUserName());
        assertNotNull(dbDemoUserDTO);

    }

    @Test
    public void deleteDemoUserByUserId() throws Exception {
        //第一步:新增数据
        DemoUserDTO demoUserDTO=dataConfigHelper.getDemoUserDTO();
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001").post("/back/DemoUserService/saveOrUpdateDemoUserDTO").userId("111111111111")
                .body(demoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
        //第二步：根据用户名查询用户ID信息
        DemoUserDTO dbDemoUserDTO=this.demoUserService.findDemoUserByUserName(demoUserDTO.getUserName());
        assertNotNull(dbDemoUserDTO);
        //第三步：根据用户ID删除数据
        SimpleDemoUserDTO simpleDemoUserDTO=new SimpleDemoUserDTO();
        simpleDemoUserDTO.setUserId(dbDemoUserDTO.getUserId());
        mockRestRequest = RestRequestBuilder.create("100010001").post("/back/DemoUserService/deleteDemoUserByUserId").userId("111111111111")
                .body(simpleDemoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);
        response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
        //第四步:根据用户名查询数据
        dbDemoUserDTO=this.demoUserService.findDemoUserByUserName(demoUserDTO.getUserName());
        assertNull(dbDemoUserDTO);

    }

    @Test
    public void getDemoUserByUserId() throws Exception {
        DemoUserDTO demoUserDTO = demoUserService.findDemoUserByUserName(dataConfigHelper.getUserName());
        assertNotNull(demoUserDTO);
        SimpleDemoUserQO simpleDemoUserQO = new SimpleDemoUserQO();
        simpleDemoUserQO.setUserId(demoUserDTO.getUserId());
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001").post("/back/DemoUserService/getDemoUserByUserId").userId("111111111111")
                .body(simpleDemoUserQO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
    }

    @After
    public void tearDown() {
        this.dataConfigHelper.destroyData();
    }
}
