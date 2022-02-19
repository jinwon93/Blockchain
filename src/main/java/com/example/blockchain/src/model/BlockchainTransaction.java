package com.example.blockchain.src.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
