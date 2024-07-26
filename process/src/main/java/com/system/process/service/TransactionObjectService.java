package com.system.process.service;

import com.system.process.domain.TransactionObject;
import com.system.process.repository.TransactionObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TransactionObjectService   implements ITransactionObjectService<TransactionObject> {

    @Autowired
    TransactionObjectRepository transactionObjectRepository;

    private final TransactionObjectEventsService transactionObjectEventsService;

    public TransactionObjectService(TransactionObjectEventsService transactionObjectEventsService){
        super();
        this.transactionObjectEventsService = transactionObjectEventsService;
    }

    @Override
    public void create(TransactionObject transactionObject) {
        System.out.println("Message received: " + transactionObject);
        Date fecha = new Date();
        transactionObject.setTimestamp(fecha);
        transactionObjectRepository.save(transactionObject);
        this.transactionObjectEventsService.publish(transactionObject);
    }

    public List<TransactionObject> getAllItems() {
        return transactionObjectRepository.findAll();
    }
}
