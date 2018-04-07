package ch.hslu.ad.sw05_N1.Aufgabe1;

import java.util.stream.IntStream;

public class AccountTask implements Runnable {
    private BankAccount sourceBankAccount;
    private BankAccount targetBankAccount;
    private int amount;

    public AccountTask(BankAccount sourceBankAccount, BankAccount targetBankAccount, int amount) {
        this.sourceBankAccount = sourceBankAccount;
        this.targetBankAccount = targetBankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
            //System.out.println(amount);
        //    sourceBankAccount.transfer(targetBankAccount, amount);
        IntStream.range(0,amount).forEach(i -> sourceBankAccount.transfer(targetBankAccount,1));
        }
}
