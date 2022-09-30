package com.evermine.hitthenumber;

public class User {
    private String username;
    private int tries;

    public User(String username, int tries) {
        this.username = username;
        this.tries = tries;
    }

    @Override
    public String toString() {
        return "User: "+this.username+" Tries: "+this.tries;
    }
}
