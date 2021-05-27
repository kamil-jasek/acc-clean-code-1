package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

final class Address {

    private final String street;
    private final String city;
    private final String postalCode;
    private final String country;

    Address(String street, String city, String postalCode, String country) {
        this.street = requireNonNull(street);
        this.city = requireNonNull(city);
        this.postalCode = requireNonNull(postalCode);
        this.country = requireNonNull(country);
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return street.equals(address.street) && city.equals(address.city) && postalCode.equals(address.postalCode)
            && country.equals(address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, postalCode, country);
    }
}
