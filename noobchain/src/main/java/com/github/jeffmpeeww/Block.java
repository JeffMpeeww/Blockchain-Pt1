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
        this.hash = calculateHash();  // Making sure we do this after we set the other values.
    }

    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(previousHash + Long.toString(timeStamp) + data);
        return calculatedHash;
    }

}
