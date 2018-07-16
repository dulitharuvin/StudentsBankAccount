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
public class BankingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        CurrentBankAccount ba1 = new CurrentBankAccount(1, "Jims account");
        CurrentBankAccount ba2 = new CurrentBankAccount(2, "Sues account");
        
        ThreadGroup tg1 = new ThreadGroup("Student's Group");           
        ThreadGroup tg2 = new ThreadGroup("Account Handler Group");           

        Student std1 = new Student("Jim", ba1.getAccountNumber() + ba1.getAccountHolder(), tg1, ba1);
        std1.start();       
        Student std2 = new Student("Sue", ba2.getAccountNumber() + ba2.getAccountHolder(), tg1, ba2);
        std2.start();        
        
        StudentLoanCompany std1Loan = new StudentLoanCompany("Loan Company 1", tg2, new CurrentBankAccount[] { ba1, ba2 });
        std1Loan.start();                
        University uni  = new University("name", tg2, new CurrentBankAccount[] { ba1, ba2 });
        uni.start();
    }

}
