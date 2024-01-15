package com.example.sample.repository;


import com.example.sample.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginJPA extends JpaRepository<LoginEntity, String> {
}
