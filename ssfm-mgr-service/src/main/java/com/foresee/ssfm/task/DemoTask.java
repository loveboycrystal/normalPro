package com.foresee.ssfm.task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *     调度类
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
@Component
public class DemoTask {
    /**
     * 每一分钟执行获取网关配置
     */
    @Scheduled(cron = "${scheduled.time:0/1 * * * * ?}")
    public void remoteGetGatewayConfig() {
        System.err.println("test task ");
    }
}