package com.evolutionnext.liskovsubstitution;

public class SecretBankAccount extends BankAccount  {
    private boolean cleared;

    public SecretBankAccount(String accountNo, boolean cleared) {
        super(accountNo);
        this.cleared = cleared;
    }

    @Override
    public String outputJSON() {
        if (! cleared)
            throw new RuntimeException("You cannot print JSON");
        return super.outputJSON();
    }
}
