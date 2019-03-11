package com.foresee.ssfm.service.impl;

import com.foresee.ssfm.dao.DemoUserMapper;
import com.foresee.ssfm.model.DemoUser;
import com.foresee.ssfm.dto.DemoUserDTO;
import com.foresee.ssfm.qo.DemoUserQO;
import com.foresee.ssfm.service.IDemoUserService;
import com.foresee.ssfm.enums.ErrorEnum;
import com.foresee.icap.framework.core.id.IdGenerator;
import com.foresee.icap.framework.api.page.IPage;
import com.foresee.icap.framework.data.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
/**
 * <pre>
 *     业务层实现类
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
@Slf4j
@Transactional(propagation = Propagation.NESTED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = Exception.class)
@Service
public class DemoUserServiceImpl extends BaseServiceImpl<DemoUserMapper, DemoUser> implements IDemoUserService {

    @Resource
    private DemoUserMapper demoUserMapper;

    @Resource
    private IdGenerator idGenerator;

    @Override
    public IPage<DemoUserDTO> pageDemoUserAllDTO(DemoUserQO demoUserQO) {
        return this.demoUserMapper.pageDemoUserAllDTO(demoUserQO);
    }

    @Override
    public DemoUserDTO getDemoUserByUserId(Long userId) {
        DemoUser demoUser = this.demoUserMapper.selectById(userId);
        if (demoUser == null) {
            throw ErrorEnum.USER_NOTFOUND_BY_ID.toRuntimeException(userId);
        }
        DemoUserDTO demoUserDTO = new DemoUserDTO();
        BeanUtils.copyProperties(demoUser, demoUserDTO);
        return demoUserDTO;
    }

    @Override
    public void deleteDemoUserByUserId(Long userId) {
        this.demoUserMapper.deleteById(userId);
    }

    @Override
    @Transactional
    public void saveOrUpdateDemoUser(DemoUserDTO demoUserDTO) {
        Long userId = demoUserDTO.getUserId();
        DemoUser demoUser = new DemoUser();
        if (userId == null || userId == 0L) {
            BeanUtils.copyProperties(demoUserDTO, demoUser);
            demoUser.setUserId(idGenerator.getLong());
            this.demoUserMapper.insert(demoUser);
        } else {
            BeanUtils.copyProperties(demoUserDTO, demoUser);
            this.demoUserMapper.updateById(demoUser);
        }
    }

    @Override
    public DemoUserDTO findDemoUserByUserName(String userName) {
        return this.demoUserMapper.findDemoUserByUserName(userName);
    }
}