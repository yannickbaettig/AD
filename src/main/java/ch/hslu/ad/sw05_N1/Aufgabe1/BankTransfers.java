package ch.hslu.ad.sw05_N1.Aufgabe1;

import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class BankTransfers {
    private final static org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BankTransfers.class);

    public static void main(String[] args){
        List<BankAccount> sourceBankAccounts = new ArrayList<>();
        List<BankAccount> targetBankAccounts = new ArrayList<>();

        sourceBankAccounts.add(new BankAccount(100));
        sourceBankAccounts.add(new BankAccount(100));
        targetBankAccounts.add(new BankAccount(100));
        targetBankAccounts.add(new BankAccount(100));


        int number = 2;
        int amount = 10000;

        final Thread[] threads = new Thread[number * 2];
        amount = amount / number;
        for (int i = 0; i < number; i++) {
            threads[i] = new Thread(new AccountTask(sourceBankAccounts.get(i), targetBankAccounts.get(i), amount));
            threads[i + number] = new Thread(new AccountTask(targetBankAccounts.get(i), sourceBankAccounts.get(i), amount));
        }
        for (final Thread thread : threads) {
            thread.start();
        }

        for (final Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LOG.info("sourceBankAccounts: " + sourceBankAccounts.toString());
        LOG.info("targetBankAccounts: " + targetBankAccounts.toString());
    }
}
