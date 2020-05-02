package com.example.demo.dao;



import com.example.demo.model.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserNodeRepository extends Neo4jRepository<UserNode, Long> {
    UserNode findByUsername(String username);
}