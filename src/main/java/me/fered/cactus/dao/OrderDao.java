package me.fered.cactus.dao;


import me.fered.cactus.entity.Orderr;

import java.util.List;

public class OrderDao extends BaseDao<Orderr> implements SignatureDao<Orderr> {

    @Override
    public Orderr create(Orderr orderr) {
        return super.create(orderr);
    }

    @Override
    public Orderr read(long id) {
        return super.read(Orderr.class, id);
    }

    @Override
    public Orderr update(Orderr orderr) {
        return super.update(orderr);
    }

    @Override
    public void delete(Orderr orderr) {
        super.delete(orderr);
    }

    @Override
    public List<Orderr> readAll() {
        return super.readAll(Orderr.class);
    }

    @Override
    public long getCount() {
        return super.getCount(Orderr.class);
    }

}
