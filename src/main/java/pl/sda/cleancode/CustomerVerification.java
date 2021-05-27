package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.Objects;

final class CustomerVerification {

    private final LocalDateTime verificationTime;
    private final CustomerVerifier verifiedBy;

    CustomerVerification(LocalDateTime verificationTime, CustomerVerifier verifiedBy) {
        this.verificationTime = requireNonNull(verificationTime);
        this.verifiedBy = requireNonNull(verifiedBy);
    }

    public LocalDateTime getVerificationTime() {
        return verificationTime;
    }

    public CustomerVerifier getVerifiedBy() {
        return verifiedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerVerification that = (CustomerVerification) o;
        return verificationTime.equals(that.verificationTime) && verifiedBy == that.verifiedBy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(verificationTime, verifiedBy);
    }
}
