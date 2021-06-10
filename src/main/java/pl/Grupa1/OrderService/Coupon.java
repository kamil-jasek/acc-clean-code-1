package pl.Grupa1.OrderService;

public class Coupon {
    private final int discountValue;

    public Coupon(int discountValue) {
        this.discountValue = discountValue;
    }

    public int getDiscountValue() {
        return discountValue;
    }
}
