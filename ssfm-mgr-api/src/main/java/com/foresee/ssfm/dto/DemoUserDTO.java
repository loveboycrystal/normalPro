package com.foresee.ssfm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

/**
 * <pre>
 *     用户功能数据传输类
 * </pre>
 *
 * @author longying@foresee.com.cn
 * @version 1.00.00
 * @date 2019年01月10日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoUserDTO {

    private Long userId;

    @NotBlank(message = "userName不能为空")
    private String userName;

    @NotBlank(message = "password不能为空")
    private String password;

    private Integer status;

}
