package com.example.blockchain.src.openchain.core;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class Wallet {

    public PrivateKey privateKey;
    public PublicKey publicKey;

    public void generateKeyPair(){
        try {

            KeyPairGenerator key  = KeyPairGenerator.getInstance("ECDSA" , "BC");
            SecureRandom  random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");

            key.initialize(ecSpec , random);
            KeyPair keyPair = key.generateKeyPair();

            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
