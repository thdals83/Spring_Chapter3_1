package com.chapter3_1.spring_chapter3_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing // 시간 자동 변경 가능하게
@SpringBootApplication // 스프링 부트 선언
public class SpringChapter31Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringChapter31Application.class, args);
    }

}
