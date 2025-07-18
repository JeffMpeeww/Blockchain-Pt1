package com.github.jeffmpeeww;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

import javax.management.RuntimeErrorException;

public class Wallet {
    public PrivateKey privateKey;
    public PublicKey publicKey;

    public Wallet() {
        generateKeyPair();
    }

    public void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");

            // Initialise the key generator and generate a KeyPair
            keyGen.initialize(ecSpec, random);  // 256 bytes provides and acceptable security level
            KeyPair keyPair = keyGen.generateKeyPair();
            
            // Set the public and private keys from the keypair
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
