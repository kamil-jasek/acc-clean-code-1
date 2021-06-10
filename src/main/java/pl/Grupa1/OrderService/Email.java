package pl.Grupa1.OrderService;

import pl.Grupa1.Dao.CustomerDao;
import pl.Grupa1.Order.Order;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import java.util.Properties;
import java.util.UUID;

public class Email {
    private static final String SHOP_SIGNATURE = "BestShopEver@CleanCode.org";

    public static void sendEmail(Order createdOrder) throws MessagingException {
        UUID customerID = createdOrder.getCustomerId();
        Properties emailProperties = setEmailProperties(customerID);
        Address customerAddress = CustomerDao.provideAddress(customerID);
        String emailBody = createdOrder.getStatusMessage();
        Message emailMessage = configureMessage(emailBody);

        Transport.send(emailMessage);



    }

    private static Properties setEmailProperties(UUID customerID){
        //TODO
        return new Properties();
    }
    private static Message configureMessage(String emailBody){
        //TODO
        return null;
    }
}
