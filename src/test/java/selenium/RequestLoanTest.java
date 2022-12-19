package selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import selenium.models.LoanApplication;
import selenium.models.User;
import selenium.pages.*;

import java.util.stream.Stream;

public class RequestLoanTest extends TestBase {

    @ParameterizedTest
    @MethodSource("provideLoanApplications")
    public void requestLoan(LoanApplication loanApplication) {

        User user = new User("john", "demo");

        new LoginPage(driver)
                .loginAs(user);

        // Go to Request Loan page
        new AccountsOverviewPage(driver)
                .selectMenuItem("Request Loan");

        // Fill in loan application form
        new RequestLoanPage(driver)
                .applyForLoan(
                        loanApplication.getAmount(),
                        loanApplication.getDownPayment(),
                        loanApplication.getFromAccountId()
                );

        String result = new RequestLoanResultPage(driver)
                .getLoanApplicationResult();

        Assertions.assertEquals(loanApplication.getExpectedResult(), result);
    }

    private static Stream<Arguments> provideLoanApplications() {
        return Stream.of(
                Arguments.of(new LoanApplication("10000", "1000", "12345", "Denied")),
                Arguments.of(new LoanApplication("5000", "500", "12345", "Denied")),
                Arguments.of(new LoanApplication("300", "50", "54321", "Approved"))
        );
    }
}
