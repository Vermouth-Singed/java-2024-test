package com.example.sample.repository;

import com.example.sample.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListJPA extends JpaRepository<ListEntity, Integer> {
}
