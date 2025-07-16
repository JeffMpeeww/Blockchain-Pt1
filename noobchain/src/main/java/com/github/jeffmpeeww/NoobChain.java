package com.github.jeffmpeeww;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {

    public static ArrayList<Block> blockChain = new ArrayList<Block>(); 

    public static void main(String[] args) {

        blockChain.add(new Block("Hi im the first block", "0"));

        blockChain.add(new Block("Yo im the second block", blockChain.get(blockChain.size()-1).hash));

        blockChain.add(new Block("Hey im the third block", blockChain.get(blockChain.size()-1).hash));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockchainJson);
    }
}
