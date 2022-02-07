package com.example.blockchain.src.openchain.core;

import javax.xml.crypto.Data;
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data;
    private long timestamp;


    private  int nonce;

    public Block(String data , String previousHash){

        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash  = previousHash;
    }



}
