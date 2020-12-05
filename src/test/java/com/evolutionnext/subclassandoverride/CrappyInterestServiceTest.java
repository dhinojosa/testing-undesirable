package com.evolutionnext.subclassandoverride;


import org.assertj.core.data.Offset;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CrappyInterestServiceTest extends CrappyInterestService {
    @Override
    protected Float lookupLatestInterestRate() throws IOException {
        return .02f;
    }

    @Test
    public void testAddAmount() throws Exception {
        this.addToAccount(5, 100);
        assertThat(this.getBalance())
                .isEqualTo((float) ((100 * .02 * 5) + 100),
                        Offset.offset(.01f));
        assertThat(this.getBalance())
                .isEqualTo((float) ((100 * .02 * 5) + 100),
                        Offset.offset(.01f));
    }
}
