package com.example.cleanarchitecture.databuilders;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public abstract class DataBuilderBase<T> {

    protected Faker faker;

    public abstract T build();

    public DataBuilderBase() {
        faker = new Faker();
    }
    
    public List<T> buildList(Integer lenght) {
        List<T> objects = new ArrayList<T>();
        for (int size = 1; size <= lenght; size++) {
            objects.add(this.build());
        }
        return objects;
    } 
}
