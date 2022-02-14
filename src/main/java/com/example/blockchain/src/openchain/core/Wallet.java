package com.example.blockchain.src.openchain.core;

import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {

    public PrivateKey privateKey;
    public PublicKey publicKey;

    public void generateKeyPair(){
        try {

            KeyPairGenerator key  = KeyPairGenerator.getInstance("ECDSA" , "BC");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
