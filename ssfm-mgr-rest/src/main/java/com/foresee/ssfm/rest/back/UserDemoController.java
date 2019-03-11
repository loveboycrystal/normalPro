package com.foresee.ssfm.rest.back;

import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.dto.SimpleDemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.foresee.icap.framework.api.page.IPage;
import com.foresee.icap.framework.entity.api.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 *     提供给管理后台界面的rest接口
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
@Validated
@RestController("/back/DemoUserService")
@RequestMapping("/back/DemoUserService")
public class UserDemoController {

    @Resource
    private IDemoUserService demoUserService;


    /**
     * 分页查询用户信息
     *
     * @param demoUserQO:查询QO对象
     * @return
     */
    @RequestMapping(value = "/pageDemoUserAllDTO", method = RequestMethod.POST)
    public Response<IPage<DemoUserDTO>> pageDemoUserDTO(@RequestBody @Validated DemoUserQO demoUserQO) {
        return Response.successData(this.demoUserService.pageDemoUserAllDTO(demoUserQO));
    }

    /**
     * 新增或者修改数据
     *
     * @param demoUserDTO
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateDemoUserDTO", method = RequestMethod.POST)
    public Response saveOrUpdateDemoUserDTO(@RequestBody @Validated DemoUserDTO demoUserDTO) {
        this.demoUserService.saveOrUpdateDemoUser(demoUserDTO);
        return Response.successMessage("操作成功");
    }

    /**
     * 根据用户ID删除用户信息
     *
     * @param simpleDemoUserDTO:封装删除ID的DTO
     * @return
     */
    @RequestMapping(value = "/deleteDemoUserByUserId", method = RequestMethod.POST)
    public Response<String> deleteDemoUserByUserId(@RequestBody @Validated SimpleDemoUserDTO simpleDemoUserDTO) {
        this.demoUserService.deleteDemoUserByUserId(simpleDemoUserDTO.getUserId());
        return Response.successMessage("删除成功");
    }

    /**
     * 根据用户ID获取用户信息
     *
     * @param demoUserQO:封装查询ID的DTO
     * @return
     */
    @RequestMapping(value = "/getDemoUserByUserId", method = RequestMethod.POST)
    public Response<DemoUserDTO> getDemoUserByUserId(@RequestBody @Validated DemoUserQO demoUserQO) {
        DemoUserDTO demoUserDTO = this.demoUserService.getDemoUserByUserId(demoUserQO.getUserId());
        return Response.successData(demoUserDTO);
    }




}