package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController  //宣告一個Restful Web Service的Resource
public class UserController {
  @Autowired  //自動注入UserRepository物件
  private UserRepository userRepository;

  @GetMapping("/findById/{id}") //對應client端的一個Http Get請求,其參數為id
  public User findById(@PathVariable Long id) {
    User findOne = this.userRepository.findOne(id);  //使用JPA,根據ID找到一筆資料
    return findOne;
  }
}
