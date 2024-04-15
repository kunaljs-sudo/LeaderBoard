package com.example.leaderboard.exchanges;

public class UpdateUserRequest {
    private Double score;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(Double score) {
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}
