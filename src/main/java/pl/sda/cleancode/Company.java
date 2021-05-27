package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

final class Company extends Customer {

    private final Name name;
    private final Vat vat;

    protected Company(Email email, Name name, Vat vat) {
        super(email);
        this.name = requireNonNull(name);
        this.vat = requireNonNull(vat);
    }

    public Name getName() {
        return name;
    }

    public Vat getVat() {
        return vat;
    }

    static Company from(RegisterCompanyForm form) {
        final var company = new Company(new Email(form.getEmail()),
            new Name(form.getName()),
            new Vat(form.getVat()));
        if (form.isVerified()) {
            company.markVerified();
        }
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Company company = (Company) o;
        return name.equals(company.name) && vat.equals(company.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, vat);
    }
}
