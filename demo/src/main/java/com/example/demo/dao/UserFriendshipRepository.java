package com.example.demo.dao;

import com.example.demo.model.UserFriendship;
import com.example.demo.model.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;


public interface UserFriendshipRepository extends Neo4jRepository<UserFriendship, Long> {
//    Optional<UserFriendship> findById(Long id);
    UserFriendship findByUserNode1AndUserNode2(UserNode userNode1,UserNode userNode2);
    UserFriendship findByFriendship(String friendship);
}
