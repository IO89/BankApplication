package JavaBankApplication;

// ************************************************************************
// Account.java	  Template created on15.9.2016
// - The class for Account objects
// ************************************************************************
public class Account 
{
    // Fields
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    // Constructor

    public Account(String accountNumber, String holderName) 
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = holderName;
    }

    // Methods
    public void deposit(double amount) 
    {
        this.balance += amount;
    }

    public String getAccountHolderName()
    {
        return this.accountHolderName;
    }

    public String getAccountNumber() 
    {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        double remainedBalance = balance - amount;
        if (remainedBalance < 0) {
            return false;
        } else {
            balance=remainedBalance;
            return true;
        }
    }
}
// End