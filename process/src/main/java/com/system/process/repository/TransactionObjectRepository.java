package com.system.process.repository;

import com.system.process.domain.TransactionObject;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

@Repository
public interface TransactionObjectRepository extends MongoRepository<TransactionObject, Integer> {

    @Aggregation("{ $group: { _id : $timestamp, names : { $addToSet : ?0 } } }")
    List<TransactionObject> groupByTimestamp();



}
