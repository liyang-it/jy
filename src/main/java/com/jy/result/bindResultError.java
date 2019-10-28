package com.jy.result;

public class bindResultError {
    private boolean isBind;
    private String message;

    public bindResultError(boolean isBind, String message) {
        this.isBind = isBind;
        this.message = message;
    }

    public boolean isBind() {
        return isBind;
    }

    public void setBind(boolean bind) {
        isBind = bind;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
