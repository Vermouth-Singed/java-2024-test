package com.example.sample.repository;

import com.example.sample.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameJPA extends JpaRepository<NameEntity, Integer> {
    @Query("SELECT n " +
            "FROM name n")
    List<NameEntity> selectAll();
}
