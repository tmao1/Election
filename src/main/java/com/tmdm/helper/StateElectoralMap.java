package com.tmdm.helper;


import java.util.HashMap;

public class StateElectoralMap {
    private HashMap<String, Integer> electoralVotes;

    public StateElectoralMap() {
        this.electoralVotes = new HashMap<>();
       // this.electoralVotes.put("AL", 9);
        this.electoralVotes.put("IL", 20);
        this.electoralVotes.put("FL", 29);
    }

    public HashMap<String, Integer> getElectoralVotes() {
        return electoralVotes;
    }

    public void setElectoralVotes(HashMap<String, Integer> electoralVotes) {
        this.electoralVotes = electoralVotes;
    }
}

