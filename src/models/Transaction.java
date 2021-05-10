package models;

import jdk.jfr.Category;

import java.util.List;

public class Transaction {
    //Common
    String date;
    double amount;
    int type;
    String description;

    /**
     * constructor for transaction
     * @param date date of transaction
     * @param amount amount of transaction
     * @param type type of transaction
     * @param description description of transaction
     */
    public Transaction(String date, double amount, int type, String description) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}
