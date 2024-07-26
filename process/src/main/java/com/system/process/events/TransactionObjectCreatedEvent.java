package com.system.process.events;

import com.system.process.domain.TransactionObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionObjectCreatedEvent extends Event<TransactionObject> {

}
