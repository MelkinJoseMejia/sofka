package com.system.process.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "Amount")
public class Amount {
    @Id
    private String id;
    private Date timestamp;
    private double amounts;
}
