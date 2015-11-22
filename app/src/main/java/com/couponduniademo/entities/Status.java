package com.couponduniademo.entities;

/**
 * Created by Miten on 11/21/2015.
 */
public class Status {

    private String rcode;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    @Override
    public String toString() {
        return "Status [message = " + message + ", rcode = " + rcode + "]";
    }
}
