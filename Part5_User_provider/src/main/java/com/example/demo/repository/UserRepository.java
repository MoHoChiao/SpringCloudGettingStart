package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository  //宣告這是一個DAO類別
public interface UserRepository extends JpaRepository<User, Long> {  //自動繼承JapRepository下的所有方法
	List<User> findByAge(Integer age); //自定義一個根據User的屬性及方法名稱查詢
	
	User findByIdAndName(Long id, String name);	//自定義一個根據User的屬性及方法名稱查詢
	
	@Query("select u from User u where u.username=:username and u.name=:name") //使用@Query查詢
	List<User> withUsernameAndNameQuery(@Param("username")String username, @Param("name")String name);
	
}