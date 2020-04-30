package com.example.schedulerdemo.service;

import com.example.schedulerdemo.dao.UserRepo;
import com.example.schedulerdemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class SchedulerService {

    @Autowired
    private UserRepo userRepo;

    @Scheduled(fixedDelay = 5000)
    public void saveUser(){
        User user = new User();
        user.setName("abcd" + new Random().nextInt(21232));
        userRepo.save(user);
        System.out.println("am at simple interval of 5 sec --"+ new Date().toString());
    }

    @Scheduled(cron = "0 * * ? * *")
    public void getUser() {
        List<User> list = userRepo.findAll();
        System.out.println("Size : "+ list.size());
        System.out.println("Fetching user after 10s ---");
    }
}
