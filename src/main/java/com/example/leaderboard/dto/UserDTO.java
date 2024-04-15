package com.example.leaderboard.dto;

import java.util.List;

public class UserDTO {
    private String userId;
    private String username;
    private Double score;
    private List<String> badges;

    public UserDTO() {
    }

    public UserDTO(String userId, String username, Double score, List<String> badges) {
        this.userId = userId;
        this.username = username;
        this.score = score;
        this.badges = badges;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<String> getBadges() {
        return badges;
    }

    public void setBadges(List<String> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", username=" + username + ", score=" + score + ", badge="
                + badges.toString() + "]";
    }
}
