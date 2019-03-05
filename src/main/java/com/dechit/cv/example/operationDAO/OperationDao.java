package com.dechit.cv.example.operationDAO;

public interface OperationDao<T> {

    void add(T t);
    void update(T t);

}

