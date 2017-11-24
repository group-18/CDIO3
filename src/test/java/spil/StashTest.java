package spil;

import org.junit.Assert;
import org.junit.Test;

public class StashTest {
    @Test
    public void addAmount() throws Exception {
        Stash stash = new Stash();

        stash.addAmount(100);

        Assert.assertEquals(100, stash.getAmount());
    }

    @Test
    public void getAmount() throws Exception {
        Stash stash1 = new Stash();
        Stash stash2 = new Stash(100);

        Assert.assertEquals(0, stash1.getAmount());
        Assert.assertEquals(100, stash2.getAmount());
    }

}