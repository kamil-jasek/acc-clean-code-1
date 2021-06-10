package pl.sda.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class EmailTest {

    @ParameterizedTest()
    @ValueSource(strings = {"test@test.com", "cdc@test.com"})
    void shouldCreateValidEmail(String emailAddress) {
        // when
        final var email = new Email(emailAddress);
        // then
        assertThat(email.getAddress()).isEqualTo(emailAddress);
    }

    @Test
    void shouldCompareEmails() {
        // given
        final var firstEmail = new Email("first@test.com");
        final var secondEmail = new Email("second@test.com");
        final var thirdEmail = new Email("first@test.com");

        // then
        assertThat(thirdEmail).isEqualTo(firstEmail);
        assertThat(firstEmail).isNotEqualTo(secondEmail);
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid address", "invalid@", "@test"})
    void shouldNotCreateInvalidEmail(String emailAddress) {
        assertThatCode(() -> new Email(emailAddress))
            .hasMessage("Invalid email address: " + emailAddress);
    }

    @Test
    void shouldNotCreateEmailWithNull() {
        assertThatCode(() -> new Email(null))
            .hasMessage("Email address is null");
    }
}
