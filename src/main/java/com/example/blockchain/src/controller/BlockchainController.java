package com.example.blockchain.src.controller;

import com.example.blockchain.src.service.BlockchainService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockchainController {

    private final BlockchainService service;

    public BlockchainController(BlockchainService service){
        this.service = service;
    }
}
