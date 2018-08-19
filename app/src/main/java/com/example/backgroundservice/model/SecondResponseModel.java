package com.example.backgroundservice.model;

public class SecondResponseModel {

    private String status;
    private String device_status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDevice_status() {
        return device_status;
    }

    public void setDevice_status(String device_status) {
        this.device_status = device_status;
    }

    @Override
    public String toString() {
        return "SecondResponseModel{" +
                "status='" + status + '\'' +
                ", device_status='" + device_status + '\'' +
                '}';
    }
}
