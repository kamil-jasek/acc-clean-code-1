package pl.sda.cleancode;

import java.util.Objects;

public final class RegisterCompanyForm {

    private final String email;
    private final String name;
    private final String vat;
    private final boolean verified;

    public RegisterCompanyForm(String email, String name, String vat, boolean verified) {
        this.email = email;
        this.name = name;
        this.vat = vat;
        this.verified = verified;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getVat() {
        return vat;
    }

    public boolean isVerified() {
        return verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegisterCompanyForm that = (RegisterCompanyForm) o;
        return verified == that.verified && email.equals(that.email) && name.equals(that.name) && vat.equals(that.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, vat, verified);
    }
}
