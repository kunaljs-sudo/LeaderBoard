package com.example.leaderboard.repositoryService;

import java.util.List;

import com.example.leaderboard.models.User;

public interface UserRepositoryService {
    public List<User> getAllUsers();

    public User getUser(String userId);

    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(String userId);
}
