package Test;

import java.io.Serializable;
import java.util.Arrays;

public class Savings extends Account implements Serializable{

    private final double interestRate = .001;

    public Savings(){

    }

    public Savings(String firstName, String lastName, String username, String password, int ss, int [] accountNumber, double value, final double interestRate){
        this.firstName = firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.ss=ss;
        this.accountNumber=accountNumber;
        this.value=value;

    }



    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {

        return "Savings:" +
                "Account Balance: " + value +"\n"+
                "Interest Rate: " + interestRate+"\n" +
                "First Name: " + firstName + "\n" +
                "Last Name" + lastName + "\n" +
                "Social Security Number: " + ss +"\n"+
                "Username: " + username + "\n" +
                "Password" + password + "\n" +
                "Account Number: " + Arrays.toString(accountNumber);
    }
}
