package pl.sda.tdd;

final class RegisterCompanyForm {

    private String name;
    private String email;
    private String vat;
    private boolean verified;

    public RegisterCompanyForm(String name, String email, String vat, boolean verified) {
        this.name = name;
        this.email = email;
        this.vat = vat;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getVat() {
        return vat;
    }

    public boolean isVerified() {
        return verified;
    }
}
