/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsbankaccount;

/**
 *
 * @author dulit
 */
public class CurrentBankAccount implements BankAccount {

    private int accountBalance = 0;
    private Statement statement;
    private int accountNumber = 0;
    private String accountHolder = "";

    public CurrentBankAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        statement = new Statement(accountHolder, accountNumber);
    }

    @Override
    public int getBalance() {
        return accountBalance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolder() {
        return accountHolder;
    }

    @Override
    public synchronized void deposit(Transaction t) {
        accountBalance += t.getAmount();
        statement.addTransaction(accountHolder, accountNumber, accountBalance);
        notify();
    }

    @Override
    public synchronized void withdrawal(Transaction t) {
        
        while (t.getAmount() >= accountBalance) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        accountBalance -= t.getAmount();
        statement.addTransaction(accountHolder, accountNumber, accountBalance);
    }

    @Override
    public boolean isOverdrawn() {
        return accountBalance < 0;
    }

    @Override
    public void printStatement() {
        statement.print();
    }
}
