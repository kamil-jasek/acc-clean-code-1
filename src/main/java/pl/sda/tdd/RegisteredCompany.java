package pl.sda.tdd;

import java.time.LocalDateTime;
import java.util.Objects;

final class RegisteredCompany {

    private String name;
    private String email;
    private String vat;
    private boolean verified;
    private LocalDateTime verificationTime;

    public RegisteredCompany(String name, String email, String vat, boolean verified, LocalDateTime verificationTime) {
        this.name = name;
        this.email = email;
        this.vat = vat;
        this.verified = verified;
        this.verificationTime = verificationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegisteredCompany that = (RegisteredCompany) o;
        return verified == that.verified && Objects.equals(name, that.name) && Objects
            .equals(email, that.email) && Objects.equals(vat, that.vat) && Objects
            .equals(verificationTime, that.verificationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, vat, verified, verificationTime);
    }
}
