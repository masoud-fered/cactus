package me.fered.cactus.dao;


import me.fered.cactus.entity.Coffee;

import java.util.List;

public class CoffeeDao extends BaseDao<Coffee> implements SignatureDao<Coffee> {

    @Override
    public Coffee create(Coffee coffee) {
        return super.create(coffee);
    }

    @Override
    public Coffee read(long id) {
        return super.read(Coffee.class, id);
    }

    @Override
    public Coffee update(Coffee coffee) {
        return super.update(coffee);
    }

    @Override
    public void delete(Coffee coffee) {
        super.delete(coffee);
    }

    @Override
    public List<Coffee> readAll() {
        return super.readAll(Coffee.class);
    }

    @Override
    public long getCount() {
        return super.getCount(Coffee.class);
    }
}
