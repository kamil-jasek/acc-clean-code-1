package pl.sda.cleancode;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public final class CustomerService {

    private final CustomerDao customerDao;
    private final MailService mailService;

    public CustomerService(CustomerDao customerDao, MailService mailService) {
        this.customerDao = requireNonNull(customerDao);
        this.mailService = requireNonNull(mailService);
    }

    public void registerCompany(RegisterCompanyForm form) {
        if (customerDao.companyExists(form.getEmail(), form.getVat())) {
            throw new CompanyAlreadyExists(format(
                "company with email %s or vat %s already exists", form.getEmail(), form.getVat()));
        }
        final var company = Company.from(form);
        customerDao.save(company);
        sendMail(company);
    }

    private void sendMail(Company company) {
        // TODO - send mail logic
        if (company.isVerified()) {
            mailService.send();
        } else {
            mailService.send();
        }
    }
}
