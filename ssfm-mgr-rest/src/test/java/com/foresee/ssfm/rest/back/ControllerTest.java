package com.foresee.ssfm.rest.back;/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */

import com.foresee.icap.framework.entity.api.Response;
import com.foresee.icap.framework.rest.RestRequestBuilder;
import com.foresee.icap.framework.web.test.BaseSpringWebTest;
import com.foresee.ssfm.config.DataConfigHelper;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.dto.SimpleDemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.qo.EnterpriseQO;
import com.foresee.ssfm.qo.SimpleDemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
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


public class ControllerTest extends BaseSpringWebTest {


    /**
     * 测试问题
     *  1.
     */


    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerTest.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testparam() throws Exception {
        DemoUserQO demoUserDTO=new DemoUserQO();
        demoUserDTO.setUserId(4444444444L);
        demoUserDTO.setUserName("Chenes");
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001")
                .get("/back/testservice/testparam").userId("111111111111")
                .body(demoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());

    }

    @Test
    public void getEnterpriseByID() throws Exception {
        EnterpriseQO enterpriseQO = new EnterpriseQO();
        enterpriseQO.setEnterpriseId(1);
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001")
                .post("/ssfm/enterprise/getenterprisebyid").userId("111111111111")
                .body(enterpriseQO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());

    }


    @After
    public void tearDown() {
    }
}
