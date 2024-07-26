package com.system.process.domain;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Document(collection = "TransactionObject")
public class TransactionObject implements Serializable {

    @Id
    private String id;
    private Date timestamp;
    private int deviceNumber;
    private int userId;
    private String geoPosition;
    private double amount;
}
