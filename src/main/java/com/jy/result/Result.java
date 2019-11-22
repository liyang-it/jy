package com.jy.result;

public class Result {
    private int status;
    private String message;
    private boolean success;
    private Object data;

    public Result(int status, String message, boolean success) {
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result() {
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(int status, String message, boolean success, Object data) {
        this.status = status;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
