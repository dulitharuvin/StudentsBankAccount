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
public class University extends Thread {

    private final String universityName;
    private final String threadGroup;
    private final CurrentBankAccount[] account;

    // private volatile ThreadState state;
    public University(String universityName, ThreadGroup threadGroup, CurrentBankAccount[] account) {
        super(threadGroup, universityName);

        this.universityName = universityName;
        this.threadGroup = threadGroup.getName();
        this.account = account;
    }

    @Override
    public void run() {
        for(int j = 0; j < account.length ; j++){   
        for (int i = 0; i < 3; i++) {
            Transaction courseFee = new Transaction(getName(), 2500);
            account[j].withdrawal(courseFee);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        }
    }
}
