package com.evolutionnext.seammodel;

public class Payroll {

    public void addFunds() {
        Account account = AccountService.getAccount(
                "jndi:/account/30120");
        account.deposit(4000);
    }
}
