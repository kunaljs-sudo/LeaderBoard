package com.example.leaderboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leaderboard.exception.BadDataProvidedException;
import com.example.leaderboard.exchanges.GetAllUserResponse;
import com.example.leaderboard.exchanges.GetUserResponse;
import com.example.leaderboard.exchanges.PostUserRequest;
import com.example.leaderboard.exchanges.UpdateUserRequest;
import com.example.leaderboard.service.UserService;

@RestController
@RequestMapping(LeaderBoardController.leaderboardAPI)
public class LeaderBoardController {
    public static final String leaderboardAPI = "/users";

    @Autowired
    private UserService userService;

    @GetMapping
    public GetAllUserResponse getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public GetUserResponse getUserById(@PathVariable String userId) {
        if (userId == null || userId.isBlank()) {
            throw new BadDataProvidedException("UserId cannot be empty and must not contain spaces");
        }
        return userService.getUserById(userId);
    }

    @PostMapping
    public GetUserResponse createNewUser(@RequestBody PostUserRequest postUserRequest) {
        if (postUserRequest == null || postUserRequest.getUsername() == null
                || postUserRequest.getUsername().isBlank()) {
            throw new BadDataProvidedException("Username is invalid or cannnot be empty");
        }
        return userService.createUser(postUserRequest);
    }

    @PutMapping("/{userId}")
    public GetUserResponse updateUserScore(@PathVariable String userId,
            @RequestBody UpdateUserRequest updateUserRequest) {
        if (userId == null || userId.isEmpty()) {
            throw new BadDataProvidedException("UserId cannot be null or empty");
        }
        if (updateUserRequest == null) {
            throw new BadDataProvidedException("Request Body cannot be null");
        }
        if (updateUserRequest.getScore() == null) {
            updateUserRequest.setScore(0.0);
        }
        if (updateUserRequest.getScore() < 0 || updateUserRequest.getScore() > 100) {
            throw new BadDataProvidedException("Score must be between 0<=score<=100");
        }
        return userService.updateUser(userId, updateUserRequest);

    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
    }
}
