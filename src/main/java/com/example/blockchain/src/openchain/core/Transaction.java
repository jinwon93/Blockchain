package com.example.blockchain.src.openchain.core;

import com.example.blockchain.src.openchain.util.StringUtil;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Transaction {

    public String transactionId;
    public PublicKey sender;
    public PublicKey  reciepient;
    public float value;
    public byte[] signature;


    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputts = new ArrayList<TransactionOutput>();


    private static int sequence = 0;

    public  Transaction(PublicKey from  , PublicKey to  , float value , ArrayList<TransactionInput> inputs){
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs  = inputs;
    }


    private String caluateHash(){
        sequence++;
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(reciepient) +
                        Float.toHexString(value) + sequence
        );
    }

    public void  generateSignature(PrivateKey privateKey){
        String data  = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) +Float.toString(value);
        signature = StringUtil.applyECDASAig(privateKey ,data);
    }

    public boolean verifiySignature(){
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        return StringUtil.verifyECDSASig(sender , data , signature);
    }
}
