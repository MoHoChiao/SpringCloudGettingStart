package com.example.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.user.entity.User;

@RestController		//宣告一個Restful Web Service的Resource
public class TestRestController {
  @Autowired	//自動注入RestTemplate物件
  private RestTemplate restTemplate;

  @GetMapping("/user/getById/{id}")		//對應client端的一個Http Get請求,路徑為user,其參數為id
  public User getById(@PathVariable Long id) {
	//使用RestTemplate來建立一個http連線之呼叫
    return this.restTemplate.getForObject("http://localhost:8000/findById/" + id, User.class);
  }
}
