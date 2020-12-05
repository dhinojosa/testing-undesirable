package com.evolutionnext.seammodel;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AccountService.class)
public class PayrollTest {
    @Test
    public void depositTest() throws Exception {
        mockStatic(AccountService.class);
        Account account = createMock(StandardAccount.class);
        expect(AccountService.getAccount
                ("jndi:/account/30120")).andReturn(account);
        account.deposit(4000.0);

        //Setup mocks
        replay(AccountService.class);
        EasyMock.replay(account);

        //Run test
        //SUT
        Payroll payroll = new Payroll();
        payroll.addFunds();

        //Verify
        verify(AccountService.class);
        verify(Payroll.class);
    }
}