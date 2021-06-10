package pl.sda.tdd;

final class CompanyRegistration {

    private final CompanyDao companyDao;

    CompanyRegistration(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public RegisteredCompany register(RegisterCompanyForm form) {
        final var company = new Company(form);
        companyDao.save(company);
        return new RegisteredCompany(company.getName(),
            company.getEmail(),
            company.getVat(),
            company.isVerified(),
            null);
    }
}
