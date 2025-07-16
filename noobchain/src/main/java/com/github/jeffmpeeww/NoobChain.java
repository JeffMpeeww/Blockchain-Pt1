package com.github.jeffmpeeww;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class NoobChain {

    public static ArrayList<Block> blockChain = new ArrayList<Block>(); 
    public static int difficulty = 6;

    public static void main(String[] args) {

        blockChain.add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1...");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("Yo im the second block", blockChain.get(blockChain.size()-1).hash));
        System.out.println("Trying to Mine block 2...");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("Hey im the third block", blockChain.get(blockChain.size()-1).hash));
        System.out.println("Trying to Mine block 3...");
        blockChain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println("\nThe blockchain:");
        System.out.println(blockchainJson);
    }


    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        // Loop through blockchain to check hashes:
        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);

            // compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current hashes not equal");
                return false;
            }

            // compare previous registered and calculated hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous hashes not equal");
                return false;
            }

            // check if hash is solved
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }

        return true;
    }
}
