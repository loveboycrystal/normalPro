package com.foresee.ssfm.qo;
/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 。简易的DTO，主要根据ID查询操作
 * </pre>
 *
 * @author @foresee.com.cn
 * @date
 * @version 1.00.00
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleDemoUserQO {
    @NotNull(message = "userId不能为空")
    private Long userId;

}
