package com.foresee.ssfm.qo;
import com.foresee.icap.framework.api.page.BasePageQueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <pre>
 *     用户功能查询QO类
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoUserQO extends BasePageQueryParam {

    private Long userName;

    /**
     * 用户Id
     */
    private Long userId;

}
