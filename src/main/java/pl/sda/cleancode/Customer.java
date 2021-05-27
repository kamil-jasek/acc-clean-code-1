package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

abstract class Customer {

    private final UUID id;
    private final LocalDateTime createTime;
    private final Email email;
    private CustomerVerification customerVerification;
    private Address address;

    protected Customer(Email email) {
        this.id = UUID.randomUUID();
        this.createTime = LocalDateTime.now();
        this.email = requireNonNull(email);
    }

    protected Customer(Email email, CustomerVerification customerVerification) {
        this(email);
        this.customerVerification = requireNonNull(customerVerification);
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Email getEmail() {
        return email;
    }

    public CustomerVerification getCustomerVerification() {
        return customerVerification;
    }

    public boolean isVerified() {
        return customerVerification != null;
    }

    public Address getAddress() {
        return this.address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return id.equals(customer.id) && createTime.equals(customer.createTime) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, email);
    }
}
