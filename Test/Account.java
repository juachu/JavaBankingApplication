package Test;

import java.io.Serializable;

public class Account implements Serializable {
    String firstName;
    String lastName;
    int ss;
    String username;
    String password;
    int[] accountNumber = new int[7];
    double value;

    public Account() {

    }

    public Account(String firstName, String lastName, String username, String password, int ss, int[] accountNumber, double value) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.ss = ss;
        this.accountNumber = accountNumber;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[] getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int[] accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= value) {
            value -= amount;
        } else {
            double needs = amount - value;
            throw new InsufficientFundsException(needs);
        }


    }
    public void deposit(double amount)
    {
        value += amount;
    }

    public boolean credentials(String username, String password){
        if(this.username == username && this.password == password)
            return true;
        else
            return false;

    }


}

