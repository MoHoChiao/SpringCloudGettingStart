package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository  //宣告這是一個DAO類別
public interface UserRepository extends JpaRepository<User, Long> {  //自動繼承JapRepository下的所有方法
}