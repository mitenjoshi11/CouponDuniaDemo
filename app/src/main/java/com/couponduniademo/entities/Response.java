package com.couponduniademo.entities;

import java.util.ArrayList;

/**
 * Created by Miten on 11/21/2015.
 */
public class Response {

    private Status status;
    private ArrayList<Data> data;
    private String hash;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
