package com.example.backgroundservice.model;

public class ResponseModel {

    private String message;

    private String id;

    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseModel [message = " + message + ", id = " + id + ", status = " + status + "]";
    }

}
