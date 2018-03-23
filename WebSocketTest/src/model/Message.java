package model;

import java.time.LocalTime;

public class Message {

    private String userId;
    private LocalTime time;
    private String message;

    public Message(String userId, LocalTime time, String message) {
        this.userId = userId;
        this.time = time;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
