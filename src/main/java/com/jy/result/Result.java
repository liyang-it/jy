package com.jy.result;

public class Result {
    private int status;
    private String message;
    private boolean se;

    public Result(int status, String message, boolean se) {
        this.status = status;
        this.message = message;
        this.se = se;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSe() {
        return se;
    }

    public void setSe(boolean se) {
        this.se = se;
    }
}
