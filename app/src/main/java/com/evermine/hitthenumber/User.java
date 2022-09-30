package com.evermine.hitthenumber;

import java.io.Serializable;
import java.util.Comparator;

public class User implements Serializable, Comparable<User> {
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

    @Override
    public String toString() {
        return "User: "+this.username+" Tries: "+this.tries;
    }

    public int compareTo(User e){
        if(this.tries==e.tries)
            return 0;
        else if(this.tries>e.tries)
            return 1;
        else
            return -1;
    }

}
