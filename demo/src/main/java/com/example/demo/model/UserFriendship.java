package com.example.demo.model;

import org.neo4j.ogm.annotation.*;

import java.io.Serializable;


@RelationshipEntity(type = "friendship")
public class UserFriendship implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

   @Property
   private String friendship;

    @StartNode
    private UserNode userNode1;

    @EndNode
    private UserNode userNode2;

    public UserFriendship(){

    }

    public UserFriendship(UserNode userNode1,UserNode userNode2){
        this.userNode1=userNode1;
        this.userNode2=userNode2;
    }
    public Long getId() {
        return id;
    }
public String getFriendship(){return friendship;}
    public UserNode getUserNode1() {
        return userNode1;
    }

    public UserNode getUserNode2() {
        return userNode2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFriendship(String friendship){this.friendship=friendship;}
    public void setUserNode1(UserNode userNode1) {
        this.userNode1 = userNode1;
    }

    public void setUserNode2(UserNode userNode2) {
        this.userNode2 = userNode2;
    }
}
