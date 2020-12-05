package com.evolutionnext.liskovsubstitution;

public class BankAccount implements JSONOutputable {

    private String accountNo;

    public BankAccount(String accountNo) {

        this.accountNo = accountNo;
    }

    @Override
    public String outputJSON() {
        return "{\"account\": "
                + accountNo + "}";
    }
}
