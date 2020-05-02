package com.example.demo.model;

import org.neo4j.ogm.annotation.NodeEntity;


import javax.persistence.GenerationType;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NodeEntity(label = "User")
public class UserNode implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String username;

    public UserNode() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public UserNode(String username) {
        this.username = username;
    }
    //
//    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
//    public Set<User> teammates;
//
//    public void worksWith(User person) {
//        if (teammates == null) {
//            teammates = new HashSet<>();
//        }
//        teammates.add(person);
//    }
//
//    public String toString() {
//        return this.username + "'s teammates => "
//                + Optional.ofNullable(this.teammates).orElse(
//                Collections.emptySet()).stream()
//                .map(User::getUsername)
//                .collect(Collectors.toList());
//    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
