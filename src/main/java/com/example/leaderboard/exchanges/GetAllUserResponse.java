package com.example.leaderboard.exchanges;

import java.util.List;

import com.example.leaderboard.dto.UserDTO;

public class GetAllUserResponse {
    private List<UserDTO> users;

    public GetAllUserResponse() {
    }

    public GetAllUserResponse(List<UserDTO> users) {
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

}
