package com.system.process.controller;

import com.system.process.domain.TransactionObject;
import com.system.process.repository.TransactionObjectRepository;
import com.system.process.service.TransactionObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
public class TansactionObjectController {

    @Autowired
    protected TransactionObjectService transactionObjectService;

    @Autowired
    TransactionObjectRepository transactionObjectRepository;

    @PostMapping(value = "/create")
    public ResponseEntity saveTransaction(@RequestBody TransactionObject transaction){
        transactionObjectService.create(transaction);
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping(value="/getAmount",produces = "application/json")
    public List<TransactionObject> getTransactions() {
        return  transactionObjectService.getAllItems();
    }

}
