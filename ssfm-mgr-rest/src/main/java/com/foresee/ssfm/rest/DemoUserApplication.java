package com.foresee.ssfm.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <pre>
 *     系统启动类
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
@SpringBootApplication(scanBasePackages = {"com.foresee"})
@EnableEurekaClient
public class DemoUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoUserApplication.class, args);
    }
}