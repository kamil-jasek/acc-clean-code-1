package pl.Grupa1.Order;

import pl.Grupa1.Item.Item;
import pl.Grupa1.Order.Status.DeliveredStatus;
import pl.Grupa1.Order.Status.OrderStatus;
import pl.Grupa1.Order.Status.SentStatus;
import pl.Grupa1.Order.Status.WaitingStatus;
import pl.Grupa1.OrderService.Coupon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class Order {
    private OrderStatus currentOrderStatus;
    private final UUID orderId;
    private final UUID consumerId;
    private final LocalDateTime createTime;
    private final ArrayList<Item> orderedItems;
    private Coupon discountAvailable;
    private BigDecimal deliveryCost;

    private OrderStatus waiting = new WaitingStatus();
    private OrderStatus sent = new SentStatus();
    private OrderStatus delivered = new DeliveredStatus();



    public Order(UUID customerID, List<Item> orderedItems, Coupon discount){
        this.orderedItems = new ArrayList<>(orderedItems); //wystarczająca kopia?
        this.orderId = UUID.randomUUID();
        this.consumerId = customerID;
        this.createTime = LocalDateTime.now();
        this.currentOrderStatus = waiting;
        this.discountAvailable = discount;
        this.deliveryCost = new BigDecimal(0);

    }
    public void setDeliveryCosts(BigDecimal deliveryCost){
        int discountApproved = discountAvailable.getDiscountValue();
        this.deliveryCost = (discountApproved>0)? deliveryCost.multiply(new BigDecimal(1-discountApproved)) : deliveryCost;
    }
    public String getStatusMessage() {
        return currentOrderStatus.provideMessage();
    }

    public OrderStatus getCurrentOrderStatus() {
        return currentOrderStatus;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getCustomerId() {
        return consumerId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ArrayList<Item> getOrderedItems() {
        ArrayList<Item> itemListCopy = new ArrayList<>();
        Collections.copy(itemListCopy, orderedItems);
        return itemListCopy;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
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
