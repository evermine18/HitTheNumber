package com.evermine.hitthenumber;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private int tries;

    public User(String username, int tries) {
        this.username = username;
        this.tries = tries;
    }

    public String getUsername() {
        return username;
    }

    public int getTries() {
        return tries;
    }
}
