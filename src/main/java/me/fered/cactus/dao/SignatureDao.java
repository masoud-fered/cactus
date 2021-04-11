package me.fered.cactus.dao;

import java.util.List;

public interface SignatureDao<T> {
    T create(T t);
    T read(long id);
    T update(T t);
    void delete(T t);
    List<T> readAll();
    long getCount();
}
