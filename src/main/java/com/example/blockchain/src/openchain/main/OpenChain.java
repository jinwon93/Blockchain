package com.example.blockchain.src.openchain.main;


import com.example.blockchain.src.openchain.core.Block;
import com.example.blockchain.src.openchain.core.Transaction;
import com.example.blockchain.src.openchain.core.TransactionOutput;
import com.example.blockchain.src.openchain.core.Wallet;
import com.example.blockchain.src.openchain.util.StringUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.thymeleaf.util.StringUtils;

import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://github.com/comnics/openchain
public class OpenChain {

    public static ArrayList<Block> blocks = new ArrayList<Block>();
    public static HashMap<String , TransactionOutput> UTXOs = new HashMap<String , TransactionOutput>();


    public static int difficulty = 3;
    public static float minumumTransaction = 0.1f;

    public static Wallet walletA;
    public static Wallet walletB;


    public static void  main(String[] arg){

        Security.addProvider(new BouncyCastleProvider());

        walletA  =  new Wallet();
        walletB  = new Wallet();

        System.out.println("test!!");
        System.out.println(StringUtil.getStringFromKey(walletA.privateKey));
        System.out.println(StringUtil.getStringFromKey(walletB.publicKey));

        Transaction transaction  = new Transaction(walletA.publicKey , walletB.publicKey , 5 , null);
        transaction.generateSignature(walletA.privateKey);
    }


    public static Boolean isChainVaild(){
        Block currentBlock;
        Block previousBlock;

        for (int i=1; i < blocks.size(); i++){
            currentBlock = blocks.get(i);
            previousBlock = blocks.get(i-1);


            if (!currentBlock.hash.equals(currentBlock.calculateHash())){
                return  false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)){
                return false;
            }
        }

        return false;
    }
}
