package in.technexus.pojo;

import java.sql.Date;

public class TransactionPojo {

    private String transactionId;
    private String userEmail;
    private Date transTime;
    private double amount;

    public TransactionPojo() {
    }

    public TransactionPojo(String transactionId, String userEmail, Date transTime, double amount) {
        this.transactionId = transactionId;
        this.userEmail = userEmail;
        this.transTime = transTime;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionPojo{" +
                "transactionId='" + transactionId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", transTime=" + transTime +
                ", amount=" + amount +
                '}';
    }
}
