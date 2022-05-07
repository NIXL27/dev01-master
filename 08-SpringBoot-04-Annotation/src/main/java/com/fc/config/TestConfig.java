package com.fc.config;

import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = true)
@Import(Cat.class)
public class TestConfig {
    @Bean({"car","car1","car2"})
    public Car getCar() {
        return new Car("马自达", "红色");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化~~");
    }

    @Bean("person")
    public Person getPerson(Car car) {
        return new Person("泡泡", getCar());
    }

    public User getUser() {
        return new User();
    }

    public TestConfig() {
        System.out.println("构造方法被执行~~");
    }

    public String test() {
        System.out.println("测试方法被执行");
        return "测试";
    }
}
