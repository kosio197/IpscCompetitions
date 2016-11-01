package competition.bg.softuni.model.user;

import competition.bg.softuni.model.enumeration.PaymentStatus;
import competition.bg.softuni.model.enumeration.ResultStatus;

public abstract class RegisteredCompetitor {
    protected User user;

    private PaymentStatus paymentStatus;
    private ResultStatus resultStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
