package me.fered.cactus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Orderr extends BaseEntity {

    @Column(nullable = false, updatable = false)
    private int coffeeId;

    @Column(nullable = false, updatable = false)
    private int tableId;

    @Column(nullable = false, columnDefinition = "number(1) default 0")
    private boolean paid;

    @Column(nullable = false, columnDefinition = "number(1) default 0")
    private boolean delivered;

    public Orderr() {
    }

    public Orderr(int coffeeId, int tableId) {
        this.coffeeId = coffeeId;
        this.tableId = tableId;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}