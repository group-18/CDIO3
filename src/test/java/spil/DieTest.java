package spil;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DieTest {

    private Die die;

    @Before
    public void setUp() throws Exception {
        this.die = new Die();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void roll() throws Exception {
        this.die.roll();

        Assert.assertTrue("Dice faceValue to low", this.die.getFaceValue() >= 1);
        Assert.assertTrue("Dice faceValue to high", this.die.getFaceValue() <= 6);
    }

    @Test
    public void getNumberOfSides() throws Exception {
        Assert.assertEquals(6, this.die.getNumberOfSides());
    }

}