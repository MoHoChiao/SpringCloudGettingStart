package com.example.demo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

import config.RibbonConfiguration;

/**
 * 使用RibbonClient，為特定name的Ribbon Client自定義配置.
 * 使用@RibbonClient的configuration，指定Ribbon的配置類別.
 */
@Configuration
@RibbonClient(name = "user-provider", configuration = RibbonConfiguration.class)
public class TestConfiguration {
}