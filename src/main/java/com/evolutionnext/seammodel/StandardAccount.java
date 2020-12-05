package com.evolutionnext.seammodel;

public class StandardAccount implements Account {
    private double balance;

    @Override
    public synchronized void deposit(double amt) {
        this.balance += amt;
    }

    @Override
    public synchronized double withdrawal(double amt) {
        if (balance - amt >= 0) {
            this.balance -= amt;
            return amt;
        }
        return 0;
    }
}
