package me.fered.cactus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CoffeeTable extends BaseEntity {

    @Column(nullable = false, columnDefinition = "number(2) default 2")
    private int chairCount;

    @Column(nullable = false, columnDefinition = "number(1) default 0")
    private boolean VIP;

    public CoffeeTable() {
    }

    public CoffeeTable(int chairCount, boolean VIP) {
        this.chairCount = chairCount;
        this.VIP = VIP;
    }

    public int getChairCount() {
        return chairCount;
    }

    public void setChairCount(int chairCount) {
        this.chairCount = chairCount;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }
}