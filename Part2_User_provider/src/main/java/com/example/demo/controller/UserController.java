package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  
  @GetMapping("/findByIdAndName") //對應client端的一個Http Get請求
  public User findByIdAndName(User user) {
	  User value = this.userRepository.findByIdAndName(user.getId(), user.getName());  //使用JPA,根據Id及Name找到一筆資料
	  return value;
  }
  
  @GetMapping("/findByUsernameAndName") //對應client端的一個Http Get請求
  public List<User> findByUsernameAndName(User user) {
	  List<User> values = this.userRepository.withUsernameAndNameQuery(user.getUsername(), user.getName());  //使用JPA,根據Username及Name找到資料
	  return values;
  }

  @PostMapping("/saveUser") //對應client端的一個Http Get請求
  public User saveUser(@RequestBody User user) {
	User value = this.userRepository.save(user);
    return value;
  }
  
  @GetMapping("/delete/{id}") //對應client端的一個Http Get請求,其參數為id
  public String delete(@PathVariable Long id) {
	this.userRepository.delete(id);  //使用JPA,根據ID刪除一筆資料
    return "Delete Success!";
  }
}
