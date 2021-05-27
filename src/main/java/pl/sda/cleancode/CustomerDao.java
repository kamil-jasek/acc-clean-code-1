package pl.sda.cleancode;

interface CustomerDao {

    boolean companyExists(String email, String vat);

    void save(Company company);
}
