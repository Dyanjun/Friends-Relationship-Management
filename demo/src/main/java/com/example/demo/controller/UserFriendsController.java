package com.example.demo.controller;


import com.example.demo.service.UserNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFriendsController {
    @Autowired
    UserNodeService userNodeService;

    @PostMapping(value = "/user/friendship")
    public void createFriendship(@RequestParam(name = "username1") String username1,
                                 @RequestParam(name = "username2") String username2){
        userNodeService.createFriendship(username1,username2);
    }

    @PostMapping(value = "/user/npfriendship")
    public void  deleteFriendship(@RequestParam(name = "username1") String username1,
                                  @RequestParam(name = "username2") String username2){
        userNodeService.deleteFriendship(username1,username2);
    }

}
