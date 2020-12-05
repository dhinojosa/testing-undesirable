package com.evolutionnext.extractinterface;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertTrue;

public class DieTest {

    @Test
    public void testDieDefaultIsDieDefaultPip() {
        Random dieStub = new Random() {
            @Override
            public int nextInt(int bound) {
                fail("This should not be called");
                return 4;
            }
        };
        Die die = new Die(dieStub);
        assertThat(die.getPip()).isEqualTo(1);
    }

    @Test
    public void testARollWillBe4() {
        Random dieStub = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        Die die = new Die(dieStub);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPip()).isEqualTo(4);
    }

    @Test
    public void testARollWillBe6andWillAlwaysBeA6() {
        Random dieStub = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };

        Die die = new Die(dieStub);
        Die rolledDie = die.roll();
        assertThat(rolledDie.getPip()).isEqualTo(6);
        assertThat(rolledDie.getPip()).isEqualTo(6);
        assertThat(rolledDie.getPip()).isEqualTo(6);
    }

    @Test
    public void testBUG30201() {

        //1. Setup mock
        Random random = createMock(Random.class);

        //2. Setup expectations
        expect(random.nextInt(6)).andReturn(4);

        replay(random);
        //3. Run Test against: Subject Under Test
        Die die = new Die(random);
        assertThat(die.roll().getPip()).isEqualTo(5);
        verify(random);
    }

    @Test
    public void testBUG30204() {
        //import static org.mockito.Mockito.*;

        //1. Setup mock
        Random random = createMock(Random.class);

        //2. Setup expectations
        expect(random.nextInt(6)).andReturn(0);

        //3. Run Test against: Subject Under Test
        Die die = new Die(random);
        assertThat(die.roll().getPip()).isEqualTo(1);
    }

    @Test
    public void testIntegrationTestWithRealRandom(){
        Die die = new Die(new Random());
        for (int i = 0; i < 10000; i++) {
            int actualPip = die.roll().getPip();
            assertTrue("Pip was " + actualPip, actualPip > 0);
            assertTrue("Pip was " + actualPip, actualPip < 7);
        }
    }

    @Test
    public void testThatItCantAcceptNullRandom() {
        try {
            new Die(null);
            fail("Expected Null Pointer Exception");
        } catch (NullPointerException e) {
            assertThat(e.getMessage()).isEqualTo("A Random is required");
        }
    }
}
