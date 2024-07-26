package com.system.process.service;

import java.util.List;

public interface ITransactionObjectService<T> {

    public abstract void create(T t );

    public abstract List<T> getAllItems();
}
