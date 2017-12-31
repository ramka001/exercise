package com.heavenhr.exercise.data.model;

public enum ApplicationStatus {

    APPLIED("APPLIED"), INVITED("INVITED"), REJECTED("REJECTED"), HIRED("HIRED");

    private final String status;

    ApplicationStatus(String status) {
        this.status = status;
    }

    public String getApplicationStatus() {
        return status;
    }
}
