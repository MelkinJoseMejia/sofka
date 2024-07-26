package com.system.process.service;

import com.system.process.domain.TransactionObject;
import com.system.process.events.Event;
import com.system.process.events.EventType;
import com.system.process.events.TransactionObjectCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.UUID;

@Component
public class TransactionObjectEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.transactionObject.name:transactionObjects}")
    private String topicTransactio0nObject;

    public void publish(TransactionObject transactionObject) {

        TransactionObjectCreatedEvent created = new TransactionObjectCreatedEvent();
        created.setData(transactionObject);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicTransactio0nObject, created);
    }



}
