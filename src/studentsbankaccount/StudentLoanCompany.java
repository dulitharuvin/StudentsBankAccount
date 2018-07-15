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
public class StudentLoanCompany extends Thread {

    private final String companyName;
    private final String accountNumber;
    private final String threadGroup;
    private final CurrentBankAccount account;

    // private volatile ThreadState state;
    public StudentLoanCompany(String companyName, String accountNumber, ThreadGroup threadGroup, CurrentBankAccount account) {
        super(threadGroup, companyName);

        this.companyName = companyName;
        this.accountNumber = accountNumber;
        this.threadGroup = threadGroup.getName();
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Transaction loan = new Transaction(getName(), 2000);
            account.deposit(loan);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
