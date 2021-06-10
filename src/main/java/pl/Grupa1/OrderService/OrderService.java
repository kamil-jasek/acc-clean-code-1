package pl.Grupa1.OrderService;

import pl.Grupa1.Item.Item;
import pl.Grupa1.Order.Order;
import pl.Grupa1.Dao.CustomerDao;
import pl.Grupa1.Dao.DiscountCouponsDao;
import pl.Grupa1.Dao.OrderDao;

import javax.mail.MessagingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public final class OrderService {

    private CustomerDao customerDao;
    private DiscountCouponsDao couponsDao;
    private OrderDao orderDao;

    public OrderService(CustomerDao customerDao, DiscountCouponsDao couponsDao, OrderDao orderDao) {
        this.customerDao = customerDao;
        this.couponsDao = couponsDao;
        this.orderDao = orderDao;
    }

    public void makeOrder(UUID customerID, List<Item> orderedItems ) throws ConsumerUnknownException{

        if(!customerDao.findByID(customerID)) throw new ConsumerUnknownException();

            Coupon discountCoupon = couponsDao.findDiscountByCustomerID(customerID);
            Order placedOrder = new Order(customerID, orderedItems, discountCoupon);

            BigDecimal deliveryCosts = calculateDeliveryCosts(orderedItems, placedOrder);
            placedOrder.setDeliveryCosts(deliveryCosts);

            try{
                Email.sendEmail(placedOrder);
            } catch (MessagingException e){
                e.printStackTrace();
            }

    }

    private BigDecimal calculateDeliveryCosts(List<Item> orderedItems, Order order){
        BigDecimal totalPrice = BigDecimal.ZERO;
        int totalWeight = 0;

        for(Item i : orderedItems){
            totalPrice = totalPrice.add(i.getTotalPrice());
            totalWeight += i.getWeight();
        }
        //TO DO zastanowić sie na switch

        if(totalWeight<1){
            return (totalPrice.compareTo(new BigDecimal(250))>0)? new BigDecimal(0) : new BigDecimal(15);
        } else if(totalWeight<5){
            return new BigDecimal(35);
        } else {
            return new BigDecimal(50);
        }
    }


}
