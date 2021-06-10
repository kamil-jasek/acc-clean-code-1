package pl.Grupa1.Dao;

import javax.mail.Address;
import java.util.UUID;

public class CustomerDao {

    public boolean findByID(UUID consumerID){
        //TO DO
        return true;
    }

    public static Address provideAddress(UUID consumerID){
        //TO DO
        return new Address() {
            @Override
            public String getType() {
                return null;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }
        };
    }
}
