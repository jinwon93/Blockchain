package com.example.blockchain.src.model;

public class BlockchainTransaction {

    private String id;
    private int fromId;
    private int toId;
    private long value;
    private boolean accepted;

    public BlockchainTransaction(int fromId , int toId , long value){
        this.fromId = fromId;
        this.toId = toId;
        this.value = value;
    }
}
