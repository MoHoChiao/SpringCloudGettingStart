package com.example.demo.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.user.entity.User;

@RestController		//宣告一個Restful Web Service的Resource
public class TestRestController {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestRestController.class); //引入log4j
	
  @Autowired	//自動注入RestTemplate物件
  private RestTemplate restTemplate;
  
  @Autowired	//自動注入DiscoveryClient物件
  private DiscoveryClient discoveryClient;
  
  @Autowired	//自動注入LoadBalancerClient物件
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/user/getById/{id}")		//對應client端的一個Http Get請求,路徑為user,其參數為id
  public User getById(@PathVariable Long id) {
	//使用RestTemplate來建立一個http連線之呼叫
    //return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
	
	//如果使用了ribbon的load balanced,則呼叫時一定要用virtual host name,在此為user-provider
	return this.restTemplate.getForObject("http://user-provider/findById/" + id, User.class);
  }
  
  /**
   * 利用DiscoveryClient找user-provider這個服務的資訊
   * @return user-provider這個服務的instance
   */
  @GetMapping("/user-instance")
  public List<ServiceInstance> showInfo() {
    return this.discoveryClient.getInstances("user-provider");
  }
  
  /*
   * 利用LoadBalancerClient找user-provider這個服務的資訊
   */
  @GetMapping("/log-user-instance")
  public void logUserInstance() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("user-provider");
    // 顯示這個呼叫,當前選擇的是provider的那一個instance
    TestRestController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
  }
}
