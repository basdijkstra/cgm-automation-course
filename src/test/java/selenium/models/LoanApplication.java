package selenium.models;

public class LoanApplication {

    private String amount;
    private String downPayment;
    private String fromAccountId;
    private String expectedResult;

    public LoanApplication(String amount, String downPayment, String fromAccountId, String expectedResult) {
        this.amount = amount;
        this.downPayment = downPayment;
        this.fromAccountId = fromAccountId;
        this.expectedResult = expectedResult;
    }

    public String getAmount() {
        return amount;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    @Override
    public String toString() {
        return String.format("Amount: %s, down payment: %s, from account: %s should result in %s", this.amount, this.downPayment, this.fromAccountId, this.expectedResult);
    }
}
