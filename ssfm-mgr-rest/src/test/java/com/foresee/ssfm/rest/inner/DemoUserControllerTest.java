package com.foresee.ssfm.rest.inner;

import com.foresee.ssfm.config.DataConfigHelper;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.qo.SimpleDemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.foresee.icap.framework.entity.api.Response;
import com.foresee.icap.framework.rest.RestRequestBuilder;
import com.foresee.icap.framework.web.test.BaseSpringWebTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * /**
 * <pre>
 * 。提供给内部rest接口测试类
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

@Rollback
public class DemoUserControllerTest extends BaseSpringWebTest {

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
     * 根据用户名查询数据
     */
    @Test
    public void getDemoUserByUserId() throws Exception {
        DemoUserDTO demoUserDTO = demoUserService.findDemoUserByUserName(dataConfigHelper.getUserName());
        assertNotNull(demoUserDTO);
        SimpleDemoUserQO simpleDemoUserQO = new SimpleDemoUserQO();
        simpleDemoUserQO.setUserId(demoUserDTO.getUserId());
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001").post("/inner/DemoUserService/getDemoUserByUserId").userId("111111111111")
                .body(simpleDemoUserQO).contentType(MediaType.APPLICATION_JSON_UTF8);
        Response response = mockRest(mockRestRequest);
        assertTrue(response.isSuccess());
    }

    @After
    public void tearDown() {
        this.dataConfigHelper.destroyData();
    }
}
