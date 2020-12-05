package com.evolutionnext.subclassandoverride;

import java.io.IOException;

public interface InterestService {
    void addToAccount(int months, int amount) throws IOException;

    float getBalance();
}
