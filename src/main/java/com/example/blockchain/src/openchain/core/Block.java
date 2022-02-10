package com.example.blockchain.src.openchain.core;

import com.example.blockchain.src.openchain.util.StringUtil;

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
        this.hash  = calculateHash();
    }


    public String calculateHash(){
        String calculatehash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timestamp) +
                        Integer.toString(nonce)+
                        data
        );
        return calculatehash;
    }


    public void mineBlcok(int difficulty){
        String taget = new String(new char[difficulty]).replace('\0' ,'0');

        while (!hash.substring(0 , difficulty).equals(taget)){
            nonce ++;
            hash = calculateHash();
            System.out.printf("\nGEN Hash #%d : %s", nonce, hash);
        }
        System.out.println("\n채굴 성공!!! : " + hash);
    }
}
