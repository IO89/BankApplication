package JavaBankApplication;

// ************************************************************************
// BankProgram.java	 Template created on 15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BankProgram {

    private static ArrayList<Account> accountList = new ArrayList<Account>();

    // *** DO NOT change anything in the main method ***
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int choice = -1;
       try
       {
        do 
        {
            displayMenu();
            choice = Integer.parseInt(input.nextLine());
                        switch (choice) {
                            case 1:
                                listAccounts();
                                break;
                            case 2:
                                addAccount();
                                break;
                            case 3:
                                depositMoney();
                                break;
                            case 4:
                                withdrawMoney();
                                break;
                            case 5:
                                deleteAccount();
                                break;
                        }
            
                        
                    }while(choice != 0);
       }
       catch(Exception ex)
       {
            System.out.println("Something went wrong " + ex.getMessage());
       }

        System.out.println("\nThe program ends now. Bye!");
        
    }

    private static void displayMenu() 
    {
         String line = "-----------------------------------------------------"
                + "---------------------------------------------------------------";
        System.out.println(line);
        System.out.println("1. List accounts");
        System.out.println("2. Add an account");
        System.out.println("3. Deposite Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Delete an account");
        System.out.println("0. Quit");
        System.out.println(line);
        System.out.print("Enter your choice: ");
    }

    // *** NB! Edit only the methods below. DO NOT add any other methods! ***

    private static void listAccounts() 
    {
        if(accountList.size() == 0)
        {
            System.out.println("No accounts in bank");
        }
        else
        {
            System.out.print("\n*** Account list ***\n");
            for (Account account : accountList) 
            {
                System.out.println();
                System.out.println("Name : " + account.getAccountHolderName());
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Balance : " + account.getBalance());
                System.out.println();
            }
        }
       
    }

    private static void addAccount() 
    {
        System.out.print("\n*** Add an account ***\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter account holder name");
        String name = input.nextLine();
        int no = new Random().nextInt(10000);  // this will generate random account number
        String accountNumber = Integer.toString(no);
        if (findAccount(accountNumber) == null) 
        {
            Account newAccount = new Account(accountNumber,name);
            accountList.add(newAccount);
            System.out.println("Account created successfully");
            System.out.println("Your account number is " + no);
        } 
        else 
        {
            System.out.println("Account not created. Account  " + accountNumber + " already exists!");
        }
        
    }

    // Finds an account in accountList by given account number.
    // Returns either a reference to the account object
    // OR null if the account is not found in accountList.
    private static Account findAccount(String accountNumber) {
        Account myAccount = null;
        for (Account account : accountList) {
            if (accountNumber.equals(account.getAccountNumber())) {
                myAccount = account;
                break;
            }
        }
        return myAccount;
    }

    private static void depositMoney() 
    {
        System.out.print("\n*** Deposit money to an account ***\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an account number: ");
        try
        {
            String accountNumber = input.nextLine();
            if (findAccount(accountNumber) == null) {
                System.out.println("Account " + accountNumber + " does not exists!");
            } else {
                System.out.println("Enter amount to be deposited: ");
                double amount = Double.parseDouble(input.nextLine());
                if (amount > 0) {
                    findAccount(accountNumber).deposit(amount);
                } else {
                    System.out.println("Cannot deposit a negative amount!");
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("Something went wrong. Deposit failed " + ex.getMessage());
        }

    }

    private static void withdrawMoney() {
        System.out.print("\n*** Withdraw money from an account ***\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an account number: ");
        String accountNumber = input.nextLine();
        if (findAccount(accountNumber) == null) {
            System.out.println("Account " + accountNumber + " does not exists!");
        } else {
            System.out.println("Enter amount to be withdrawn");
            double amount = Double.parseDouble(input.nextLine());
            boolean availableWithdraw = findAccount(accountNumber).withdraw(amount);
            if (amount > 0) {
                if (!availableWithdraw) {
                    System.out.println("Withdraw  not completed. Available balance is too low!");
                } else {
                    System.out.println("Withdraw completed successfully!");
                }
            } else {
                System.out.println("Cannot withdraw a negative amount!");
            }
        }

    }

    private static void deleteAccount() {
        System.out.print("\n*** Delete an account ***\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an account number");
        String accountNumber = input.nextLine();
        if (findAccount(accountNumber) == null) {
            System.out.println("Account " + accountNumber + " does not exists!");
        } else {
            accountList.remove(findAccount(accountNumber));
            System.out.println("Account deleted successfully!");
        }
    }
}
// End
