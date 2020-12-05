package com.evolutionnext.seammodel;

public class AccountService {
    public static Account getAccount(String location) {
        //Do some network call that
        // goes out and it takes a lot
        // of time and it's a pain
        return new StandardAccount();
    }
}
