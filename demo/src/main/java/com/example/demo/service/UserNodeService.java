package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserFriendshipRepository;
import com.example.demo.dao.UserNodeRepository;
import com.example.demo.model.UserFriendship;
import com.example.demo.model.UserNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Service;

@Service
public class UserNodeService {
    @Autowired
    UserDao userDao;

    @Autowired
    UserNodeRepository userNodeRepository;

    @Autowired
    UserFriendshipRepository userFriendshipRepository;

    public void createFriendship(String username1, String username2) {
        if (userDao.findByUsername(username1) == null) {
            System.out.print("User1 does not exist");
            return;
        }
        if (userDao.findByUsername(username2) == null) {
            System.out.print("User2 does not exist");
            return;
        }
        UserNode usernode1 = new UserNode(username1);
        UserNode usernode2 = new UserNode(username2);
        UserFriendship userFriendship = new UserFriendship(usernode1, usernode2);
       if(userNodeRepository.findByUsername(username1)==null){
           userNodeRepository.save(usernode1);
           userFriendship.setUserNode1(usernode1);
       }
       else{
           UserNode userNode = userNodeRepository.findByUsername(username1);
           userFriendship.setUserNode1(userNode);
       }
        if(userNodeRepository.findByUsername(username2)==null){
            userNodeRepository.save(usernode2);
            userFriendship.setUserNode2(usernode2);
        }
        else{
            UserNode userNode = userNodeRepository.findByUsername(username2);
            userFriendship.setUserNode2(userNode);
        }

        String friendship=username1+"->"+username2;
        userFriendship.setFriendship(friendship);
        userFriendshipRepository.save(userFriendship);


    }
    public void deleteFriendship(String username1, String username2){
        UserFriendship userFriendship=new UserFriendship();
        if(userNodeRepository.findByUsername(username1)==null){
           System.out.print("User1 does not exist");
           return;
        }
        if(userNodeRepository.findByUsername(username2)==null){
            System.out.print("User2 does not exist");
            return;
        }

        userFriendship=userFriendshipRepository.findByFriendship(username1+"->"+username2);

       try{
           userFriendshipRepository.delete(userFriendship);
       }
       catch (Exception e){
           System.out.print("Friendship does not exist");
       }

    }
}
