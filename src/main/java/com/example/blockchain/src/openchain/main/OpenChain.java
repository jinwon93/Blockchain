package com.example.blockchain.src.openchain.main;


import com.example.blockchain.src.openchain.core.Block;
import com.example.blockchain.src.openchain.core.TransactionOutput;

import java.util.ArrayList;
import java.util.HashMap;

//https://github.com/comnics/openchain
public class OpenChain {

    public static ArrayList<Block> blocks = new ArrayList<Block>();
    public static HashMap<String , TransactionOutput> UTXOs = new HashMap<String , TransactionOutput>();

}
