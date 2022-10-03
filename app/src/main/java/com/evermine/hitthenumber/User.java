package com.evermine.hitthenumber;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private int tries;
    private int time;

    public User(String username, int tries, int time) {
        this.username = username;
        this.tries = tries;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public int getTries() {
        return tries;
    }

    public int getTime() {
        return time;
    }
}
