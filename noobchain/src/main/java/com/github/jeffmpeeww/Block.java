package com.github.jeffmpeeww;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    public String data; // our data will be a simple message
    public long timeStamp; // as number of milliseconds

    // Block Constructor
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }

}
