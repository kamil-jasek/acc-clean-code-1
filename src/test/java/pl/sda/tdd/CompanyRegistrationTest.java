package pl.sda.tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

final class CompanyRegistrationTest {

    @Test
    void shouldRegisterNotVerifiedCompany() {
        // given
        final var companyDao = new CompanyDao();
        final var companyRegistration = new CompanyRegistration(companyDao);

        // when
        final var registeredCompany = companyRegistration.register(new RegisterCompanyForm(
            "Test S.A.",
            "test.sa@test.com",
            "VAT32030303",
            false
        ));

        // then
        assertThat(registeredCompany).isEqualTo(new RegisteredCompany(
            "Test S.A.",
            "test.sa@test.com",
            "VAT32030303",
            false,
            null
        ));
    }
}
