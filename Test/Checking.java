package Test;

import java.io.Serializable;
import java.util.Arrays;

public class Checking extends Test.Account implements Serializable{

    private int cardNum;

    public Checking(){

    }

    public Checking(String firstName, String lastName, String username, String password, int ss, int value, int cardNum, int [] accountNumber){
        this.firstName = firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.ss=ss;
        this.accountNumber=accountNumber;
        this.value=value;
        this.cardNum=cardNum;
    }



    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }


    @Override
    public String toString() {
        return "Checking:" +
                "Account Balance: " + value +"\n"+
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Social Security Number: " + ss +"\n"+
                "Username: " + username + "\n" +
                "Password: " + password + "\n" +
                "Account Number: " + Arrays.toString(accountNumber);
    }
}

