package com.example.sample.repository;

import com.example.sample.entity.LoginEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.sample.entity.QLoginEntity.loginEntity;

@Repository
public class LoginQuerydsl {

    private final JPAQueryFactory jpaQueryFactory;

    public LoginQuerydsl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Optional<LoginEntity> findById(String email) {
        List<LoginEntity> list = jpaQueryFactory
            .selectFrom(loginEntity)
            .where(loginEntity.email.eq(email))
            .limit(1)
            .fetch();

        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }
}
