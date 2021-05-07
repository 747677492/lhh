package com.lhh.volunteerservicemanagement;

import com.lhh.volunteerservicemanagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VolunteerServiceManagementApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        List list = userService.searchAll();
        System.out.println(list.size());
    }

}
