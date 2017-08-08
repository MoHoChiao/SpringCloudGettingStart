package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/*
 * Spring Boot啟動的核心,它會開啟所有的自動配置以及載入相關的annotation(@Bean,@Entity...)進入Spring IOC Container
 * @SpringBootApplication為@Configuration,@EnableAutoConfiguration,@ComponentScan這些annotation的組合式annotation
 * @SpringBootApplication程式所在的package,其底下所有類別及子package底下所有類別都會被套用掃瞄,載入所有的@Bean
 */
@SpringBootApplication
public class Part1UserConsumerSimpleApplication {

	@Bean
	public RestTemplate restTemplate() { //宣告一個@Bean,它表示建立一個RestTemplate restTemplate = new RestTemplate()
	  return new RestTemplate();
	}
	
	public static void main(String[] args) { //Spring Boot 主程式入口
		SpringApplication.run(Part1UserConsumerSimpleApplication.class, args);
	}
}
