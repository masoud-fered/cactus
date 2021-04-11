package me.fered.cactus.dao;


import me.fered.cactus.entity.CoffeeTable;

import java.util.List;

public class TableDao extends BaseDao<CoffeeTable> implements SignatureDao<CoffeeTable> {

    @Override
    public CoffeeTable create(CoffeeTable table) {
        return super.create(table);
    }

    @Override
    public CoffeeTable read(long id) {
        return super.read(CoffeeTable.class, id);
    }

    @Override
    public CoffeeTable update(CoffeeTable table) {
        return super.update(table);
    }

    @Override
    public void delete(CoffeeTable table) {
        super.delete(table);
    }

    @Override
    public List<CoffeeTable> readAll() {
        return super.readAll(CoffeeTable.class);
    }

    @Override
    public long getCount() {
        return super.getCount(CoffeeTable.class);
    }

}
