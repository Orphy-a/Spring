package kr.co.ch07.repository;

import kr.co.ch07.entity.User5;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User5RepositoryTest {


    @Autowired
    private User5Repository user5Repository;

    @Test
    public void test1(){

        User5 user5 = User5.builder()
                .name("test1")
                .gender("F")
                .age(11)
                .addr("부산")
                .build();

        user5Repository.save(user5);
    }

}