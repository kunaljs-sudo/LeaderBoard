package com.example.leaderboard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leaderboard.common.Badge;
import com.example.leaderboard.dto.UserDTO;
import com.example.leaderboard.exception.BadDataProvidedException;
import com.example.leaderboard.exchanges.GetAllUserResponse;
import com.example.leaderboard.exchanges.GetUserResponse;
import com.example.leaderboard.exchanges.PostUserRequest;
import com.example.leaderboard.exchanges.UpdateUserRequest;
import com.example.leaderboard.mapper.UserToUserDTOMapper;
import com.example.leaderboard.models.User;
import com.example.leaderboard.repositoryService.UserRepositoryService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoryService userRepositoryService;

    @Autowired
    private UserToUserDTOMapper mapper;

    @Override
    public GetAllUserResponse getAllUsers() {
        List<User> users = userRepositoryService.getAllUsers();
        Collections.sort(users);
        List<UserDTO> userDTos = mapper.convertUsers(users);
        GetAllUserResponse response = new GetAllUserResponse(userDTos);
        return response;
    }

    @Override
    public GetUserResponse getUserById(String userId) {
        User user = userRepositoryService.getUser(userId);
        UserDTO userDTO = mapper.convertUser(user);
        return new GetUserResponse(userDTO);
    }

    @Override
    public GetUserResponse createUser(PostUserRequest postUserRequest) {
        User user = new User();
        user.setUsername(postUserRequest.getUsername());
        user.setScore(0.0);
        user.setBadges(new ArrayList<>());
        User returnedUser = userRepositoryService.createUser(user);
        UserDTO userDTO = mapper.convertUser(returnedUser);
        return new GetUserResponse(userDTO);

    }

    @Override
    public GetUserResponse updateUser(String userId, UpdateUserRequest updateUserRequest) {
        if (updateUserRequest == null) {
            throw new BadDataProvidedException("Wrong data provided please check again");
        }

        // get score from request body
        double score = updateUserRequest.getScore();

        // set score in User data
        User user = userRepositoryService.getUser(userId);
        user.setScore(score);

        // if score is greater than 0 then set badge
        if (score > 0 && score <= 100) {
            List<String> badges = user.getBadges();
            // get badge accroding to the score
            String badge = getBadgeFromScore(score).toString();
            // if given badge in not in badges then add it
            if (!badges.contains(badge)) {
                badges.add(badge);
                user.setBadges(badges);
            }
        }

        // recieve updated user here
        user = userRepositoryService.updateUser(user);

        UserDTO userDTO = mapper.convertUser(user);
        return new GetUserResponse(userDTO);
    }

    @Override
    public void deleteUserById(String userId) {
        userRepositoryService.deleteUser(userId);
    }

    private Badge getBadgeFromScore(Double score) {
        if (score >= 1 && score < 30)
            return Badge.CodeNinja;
        else if (score >= 30 && score < 60)
            return Badge.CodeMaster;
        else if (score >= 60 && score <= 100)
            return Badge.CodeChamp;

        return null;
    }

}
