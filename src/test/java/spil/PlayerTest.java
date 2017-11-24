package spil;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() throws Exception {
        this.player = new Player("Test name");
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getName() throws Exception {
        Assert.assertTrue(this.player.getName().equals("Test name"));
    }

    @Test
    public void getBalance() throws Exception {
        Assert.assertEquals(0, this.player.getBalance());
    }

    @Test
    public void addBalance() throws Exception {
        Assert.assertEquals(0, this.player.getBalance());

        this.player.addBalance(100);

        Assert.assertEquals(100, this.player.getBalance());
    }

}