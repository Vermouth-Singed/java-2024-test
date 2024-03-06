package com.example.sample.service;

import com.example.sample.entity.NameEntity;
import com.example.sample.repository.NameJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private final NameJPA nameJPA;

    public SampleService(NameJPA nameJPA) {
        this.nameJPA = nameJPA;
    }

    public List<NameEntity> list() {
        return nameJPA.findAll();
    }

    public List<NameEntity> list2() {
        return nameJPA.selectAll();
    }
}
