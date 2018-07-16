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
public class Student extends Thread {

    private final String studentName;
    private final String accountNumber;
    private final String threadGroup;
    private final CurrentBankAccount account;

    // private volatile ThreadState state;
    public Student(String studentName, String accountNumber, ThreadGroup threadGroup, CurrentBankAccount account) {
        super(threadGroup, studentName);

        this.studentName = studentName;
        this.accountNumber = accountNumber;
        this.threadGroup = threadGroup.getName();
        this.account = account;
    }

    @Override
    public void run() {
        Transaction lottery = new Transaction(getName(), 100000);
        account.deposit(lottery);
        account.printStatement();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }
}
