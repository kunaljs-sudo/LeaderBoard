package com.example.leaderboard.service;

import com.example.leaderboard.exchanges.GetAllUserResponse;
import com.example.leaderboard.exchanges.GetUserResponse;
import com.example.leaderboard.exchanges.PostUserRequest;
import com.example.leaderboard.exchanges.UpdateUserRequest;

public interface UserService {
    public GetAllUserResponse getAllUsers();

    public GetUserResponse getUserById(String userId);

    public GetUserResponse createUser(PostUserRequest postUserRequest);

    public GetUserResponse updateUser(String userId, UpdateUserRequest updateUserRequest);

    public void deleteUserById(String userId);
}
