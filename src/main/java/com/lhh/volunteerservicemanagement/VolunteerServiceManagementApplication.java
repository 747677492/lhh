package com.lhh.volunteerservicemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.lhh.volunteerservicemanagement.dao")//扫描继承了TKMapper Mapper<T>
public class VolunteerServiceManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolunteerServiceManagementApplication.class, args);
    }

}
