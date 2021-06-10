package pl.Grupa1.Item;

import java.math.BigDecimal;
import java.util.UUID;

public final class Item {
    private final UUID itemId;
    private String name;
    private BigDecimal price;
    private int quantity;
    private Float weight;

    public Item(String name, BigDecimal price, int quantity, Float weight) {
        this.itemId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPrice() {return price.multiply(BigDecimal.valueOf(quantity));}

    public int getQuantity() {
        return quantity;
    }

    public Float getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
