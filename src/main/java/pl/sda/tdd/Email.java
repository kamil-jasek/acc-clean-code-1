package pl.sda.tdd;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

final class Email {

    private final String emailAddress;

    public Email(String emailAddress) {
        this.emailAddress = requireNonNull(emailAddress, "Email address is null");
        verifyAddressEmail();
    }

    private void verifyAddressEmail() {
        if (!this.emailAddress.matches("[\\w-]+(\\.[\\w-])*@[\\w-]+\\.[\\w-]+")) {
            throw new IllegalArgumentException("Invalid email address: " + this.emailAddress);
        }
    }

    public String getAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return Objects.equals(emailAddress, email.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }
}
