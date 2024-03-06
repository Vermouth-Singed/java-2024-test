package com.example.sample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="name")
public class NameEntity {
    @Id
    private Integer num;
    private String name;

    @ManyToOne
    @JoinColumn(name = "num", insertable = false, updatable = false)
    private ListEntity list;
}
