package com.foresee.ssfm.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *     配置相关的类
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
@Configuration
public class DemoConfig {
    /**
     * 当前登录用户ID
     */
    @Value("${current.login.user.id:1}")
    public String currentLoginUserId;

    public String getCurrentLoginUserId() {
        return currentLoginUserId;
    }
}