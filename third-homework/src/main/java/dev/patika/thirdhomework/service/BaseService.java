package dev.patika.thirdhomework.service;

import java.util.List;

public interface BaseService<T>{

    List<T> findAll();

    T findById(int id);

    T save(T object);

    void deleteById(int id);

    void deleteByName(String name);

    void delete(T object);

    T update(T object);


}
