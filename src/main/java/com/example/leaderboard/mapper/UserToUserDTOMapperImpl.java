package com.example.leaderboard.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.leaderboard.dto.UserDTO;
import com.example.leaderboard.models.User;

@Component
public class UserToUserDTOMapperImpl implements UserToUserDTOMapper {

    @Override
    public UserDTO convertUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setScore(user.getScore());
        userDTO.setBadges(user.getBadges());
        return userDTO;
    }

    @Override
    public List<UserDTO> convertUsers(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(convertUser(user));
        }
        return userDTOs;
    }

}
