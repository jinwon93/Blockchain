package com.example.blockchain;

import com.example.blockchain.src.service.BlockchainService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;

import java.util.logging.Logger;

@SpringBootApplication
public class BlockchainApplication {




    private static  final Logger LOGGER = LoggerFactory.getLogger(BlockchainService.class);


    private final Web3j web3j;

    public BlockchainApplication(Web3j web3j) {
        this.web3j = web3j;
    }


    public static void main(String[] args) {
        SpringApplication.run(BlockchainApplication.class, args);
    }
}
