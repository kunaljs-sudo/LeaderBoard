package com.example.leaderboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.leaderboard.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
