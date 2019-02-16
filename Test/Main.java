package Test;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

    public class Main extends Test.Savings implements Serializable {

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            String firstName = "";
            String lastName = "";
            int ss = 0;
            double value = 0;
            String username = "";
            String password = "";
            char choice = 'n';
            Test.Account existingChecking = new Checking();
            Test.Account existingSavings= new Test.Savings();
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            File AccountMap = new File("hashmap.ser");
            HashMap<String, Test.Account> savingsAccount = new HashMap<String, Test.Account>();
            HashMap<String, Test.Account> checkingAccount = new HashMap<String, Account>();
            savingsAccount = readSerialSavings(savingsAccount);
            checkingAccount = readSerialChecking(checkingAccount);
            String userInput;
            userInput = JOptionPane.showInputDialog("1. Log In \n2. Create new Account \n3. Cancel");
            choice = userInput.charAt(0);



            switch (choice) {

                case '1':
                    boolean isValid = false;
                    try{
                        username = JOptionPane.showInputDialog("Enter your username");
                        password = JOptionPane.showInputDialog("Enter your password");
                        existingSavings = savingsAccount.get(username);
                        existingChecking =  checkingAccount.get(username);
                        isValid = logIn(username,password,existingChecking,existingSavings);


                    }catch (NullPointerException ex){}

                    if(existingChecking != null || existingSavings != null){try {
                        isValid = true;
                        while (isValid) {
                            userInput = JOptionPane.showInputDialog("What would you like to do?\n1.Deposit\n2.Withdraw\n3.Check Account Balance\n4.Display all Information\n5.Change Username\n6.Change Password\n7.Exit ");
                            choice = userInput.charAt(0);
                            switch (choice) {
                                case '1':
                                    userInput = JOptionPane.showInputDialog("What account would you like to deposit to?\n1.Checking\n2.Savings");
                                    choice = userInput.charAt(0);
                                    userInput = JOptionPane.showInputDialog("How much would you like to deposit?");
                                    double transaction = Double.parseDouble(userInput);
                                    if (choice == '1') {
                                        existingChecking.deposit(transaction);
                                         JOptionPane.showMessageDialog(null, "New checking account balance: " + existingChecking.getValue());
                                        break;
                                    } else {
                                        try {
                                            existingSavings.deposit(transaction);
                                        } catch (NullPointerException ex) {
                                            JOptionPane.showMessageDialog(null, "That account does not exist");
                                            break;
                                        }

                                       JOptionPane.showMessageDialog(null, "New savings account balance: " + existingSavings.getValue());
                                    }
                                    break;
                                case '2':
                                    userInput = JOptionPane.showInputDialog("What account would you like to withdraw from?\n1.Checking\n2.Savings");
                                    choice = userInput.charAt(0);
                                    userInput = JOptionPane.showInputDialog("How much would you like to withdraw?");
                                    transaction = Double.parseDouble(userInput);
                                    if (choice == '1') {
                                        try{ try {
                                            existingChecking.withdraw(transaction);

                                        } catch (InsufficientFundsException e) {
                                            JOptionPane.showMessageDialog(null, "Insufficient Funds");
                                            break;
                                        }}catch (NullPointerException ex){
                                            JOptionPane.showMessageDialog(null, "That account does not exist");
                                            break;
                                        }
                                        JOptionPane.showMessageDialog(null, "New checking account balance: " + existingChecking.getValue());

                                    } else {
                                        try{ try {
                                            existingSavings.withdraw(transaction);
                                        } catch (InsufficientFundsException e) {
                                            JOptionPane.showMessageDialog(null, "Insufficient Funds");
                                            break;
                                        }}catch (NullPointerException ex){System.out.println("That account does not exist"); break;}
                                        JOptionPane.showMessageDialog(null, "New savings account balance: " + existingSavings.getValue());
                                    }
                                    break;
                                case '3':
                                    userInput = JOptionPane.showInputDialog ("What account would you like to view?\n1.Checking\n2.Savings");
                                    choice = userInput.charAt(0);
                                    try{if (choice == '1')
                                        JOptionPane.showMessageDialog(null,"Checking Account Balance: " + existingChecking.getValue());
                                    else
                                        JOptionPane.showMessageDialog(null, "Savings Account Balance: " + existingSavings.getValue());}catch (NullPointerException ex) {
                                        JOptionPane.showMessageDialog(null, "That account does not exist");
                                        break;
                                    }
                                    break;
                                case '4':
                                    try{ JOptionPane.showMessageDialog(null, existingChecking.toString());
                                        JOptionPane.showMessageDialog(null, existingSavings.toString());}catch (NullPointerException ex){break;}
                                    break;
                                case '5':
                                    username = JOptionPane.showInputDialog("Enter the new Username you would like to use.");
                                    try{
                                        existingChecking.setUsername(username);
                                        existingSavings.setUsername(username);
                                        JOptionPane.showMessageDialog(null, "Username Set");}catch (NullPointerException ex){break;}
                                    break;
                                case '6':
                                    try{password = JOptionPane.showInputDialog("Enter the new Password you would like to use.");
                                        existingChecking.setPassword(password);
                                        existingSavings.setPassword(password);
                                        JOptionPane.showMessageDialog(null, "Password set");}catch (NullPointerException ex){break;}
                                    break;
                                default:
                                    System.exit(0);

                            }
                            userInput = JOptionPane.showInputDialog("Would you like to perform another transaction?\n1.Yes\n2.No");
                            choice = userInput.charAt(0);
                            if (choice == '1') {
                                isValid = true;
                            } else {
                                isValid = false;
                            }

                        }
                        savingsAccount.put(username, existingSavings);
                        checkingAccount.put(username, existingChecking);
                    }catch(NullPointerException ex){} } else{System.out.println("Account does not exist");}


                    break;
                case '2':
                    userInput = JOptionPane.showInputDialog("What type of account would you like to open?" + "\n" + "1. Checking \n" + "2. Savings");
                    choice = userInput.charAt(0);
                    switch (choice) {


                        case ('1'):
                            isValid = true;
                            firstName = JOptionPane.showInputDialog("Enter your first name");

                           lastName = JOptionPane.showInputDialog("Enter your last name");

                            try {
                                userInput = JOptionPane.showInputDialog("Enter your Social Security number");
                                ss = Integer.parseInt(userInput);
                            } catch (InputMismatchException ex) {
                                isValid = false;
                                JOptionPane.showMessageDialog(null, "Please enter numbers only");
                            }

                            username = JOptionPane.showInputDialog("Enter a username for the account");

                            password = JOptionPane.showInputDialog("Enter a password for the account");


                            Checking newChecking = new Checking();
                            newChecking.setFirstName(firstName);
                            newChecking.setLastName(lastName);
                            newChecking.setSs(ss);
                            newChecking.setUsername(username);
                            newChecking.setPassword(password);

                            int checkingAccountNumber[] = new int[7];
                            for (int i = 0; i < 6; i++) {
                                checkingAccountNumber[i] = (int) (Math.random() * 9);
                                checkingAccountNumber[6] = 0;
                            }
                            newChecking.setAccountNumber(checkingAccountNumber);
                            System.out.println(newChecking.toString());
                            checkingAccount.put(newChecking.getUsername(), newChecking);
                            writeSerialChecking(checkingAccount);
                            break;

                        case ('2'):
                            firstName = JOptionPane.showInputDialog("Enter your first name");

                            lastName =  JOptionPane.showInputDialog("Enter your last name");

                            try {
                                userInput = JOptionPane.showInputDialog("Enter your Social Security number");
                                ss = Integer.parseInt(userInput);
                            } catch (InputMismatchException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter numbers only");
                            }

                            username = JOptionPane.showInputDialog("Enter a username for the account");
                            password = JOptionPane.showInputDialog("Enter a password for the account");
                            userInput = JOptionPane.showInputDialog("How much would you like to deposit? \n $100 Minimum");
                            value = Double.parseDouble(userInput);

                            Savings newSavings = new Savings();
                            newSavings.setFirstName(firstName);
                            newSavings.setLastName(lastName);
                            newSavings.setSs(ss);
                            newSavings.setUsername(username);
                            newSavings.setPassword(password);
                            newSavings.setValue(value);
                            int accountNumber[] = new int[7];
                            for (int i = 0; i < 6; i++) {
                                accountNumber[i] = (int) (Math.random() * 9);
                                accountNumber[6] = 1;
                            }
                            newSavings.setAccountNumber(accountNumber);
                            System.out.println(newSavings.toString());
                            savingsAccount.put(newSavings.getUsername(), newSavings);
                            writeSerialSavings(savingsAccount);
                            break;
                        default:
                            System.exit(0);
                    }
                default:System.exit(0);
            }
            writeSerialChecking(checkingAccount);
            writeSerialSavings(savingsAccount);
        }







        public static HashMap readSerialSavings(HashMap<String, Account> savingAccount) throws IOException {
            JOptionPane.showMessageDialog(null, "Savings Read \n");
            Map<String, Account> savingsAccount = new HashMap<String, Account>();
            try {
                FileInputStream fis = new FileInputStream("savingshashmap.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                try {
                    savingsAccount = (HashMap) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                ois.close();
                fis.close();
                JOptionPane.showMessageDialog(null, "Deserialized HashMap..");
                // Display content using Iterator
                Iterator iterator = savingsAccount.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next().toString();
                    Account info = savingsAccount.get(key);
                    System.out.println(key + " " + info);
                    continue;
                }
            } catch (FileNotFoundException ex) {

            }

            return (HashMap) savingsAccount;
        }

        public static void writeSerialSavings(HashMap<String, Account> savingAccount) throws IOException {
            JOptionPane.showMessageDialog(null, "Savings Write \n");
            Map<String, Account> savingsAccount = new HashMap<String, Account>();
            FileOutputStream fos = new FileOutputStream("savingshashmap.ser", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(savingAccount);
            oos.close();
            fos.close();
           JOptionPane.showMessageDialog(null, "Serialized HashMap data is saved in savingshashmap.ser");
            JOptionPane.showMessageDialog(null, savingAccount.toString());


        }

        public static HashMap readSerialChecking(HashMap<String, Account> checkingAccount) throws IOException {
           JOptionPane.showMessageDialog(null, "Checking Read \n");
            Map<String, Account> map = new HashMap<String, Account>();
            try {
                FileInputStream fis = new FileInputStream("checkinghashmap.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                try {
                    map = (HashMap) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                ois.close();
                fis.close();
               JOptionPane.showMessageDialog(null, "Deserialized HashMap..");
                // Display content using Iterator
                Iterator iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next().toString();
                    Account info = map.get(key);
                    System.out.println(key + " " + info);
                    continue;
                }
            } catch (FileNotFoundException ex) {

                JOptionPane.showMessageDialog(null, "File not found!");

            }

            return (HashMap) map;
        }

        public static void writeSerialChecking(HashMap<String, Account> checkingAccount) throws IOException {
            JOptionPane.showMessageDialog(null, "Checking Write \n");
            Map<String, Account> map = new HashMap<String, Account>();
            FileOutputStream fos = new FileOutputStream("checkinghashmap.ser", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(checkingAccount);
            oos.close();
            fos.close();
           JOptionPane.showMessageDialog(null, "Serialized HashMap data is saved in checkinghashmap.ser");
            System.out.println(checkingAccount.toString());

        }

        public static boolean logIn(String username, String password, Account existingChecking, Account existingSavings) {
            boolean checkUser = false;
            if (username == existingChecking.getUsername()) {
                checkUser = true;
            }
            boolean checkPass = false;
            if (password == existingChecking.getPassword()) {
                checkPass = true;
            }
            boolean saveUser = false;
            if (username == existingSavings.getUsername()) {
                saveUser = true;
            }
            boolean savePass = false;
            if (password == existingSavings.getPassword()) {
                savePass = true;
            }

            if (savePass == true && saveUser == true)
                return true;
            else if (checkUser == true && checkPass == true) {
                return true;
            }else{
                return false;}
        }
    }



