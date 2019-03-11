package com.foresee.ssfm.dto;
/**
 * Copyright(c) Foresee Science & Technology Ltd.
 */
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 简易的DTO，主要用于删除操作
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
public class SimpleDemoUserDTO {
        @NotNull(message = "userId不能为空")
        private Long userId;
}
