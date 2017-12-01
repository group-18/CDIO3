package spil.Board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import spil.Player;


public class HouseFieldTest {

    private HouseField field;


    @Before
    public void setUp() throws Exception
    {
        this.field = new HouseField("Test name", "10");
    }


    @Test
    public void getGuiField() throws Exception
    {
        Assert.assertTrue(this.field.getGuiField() != null);
    }


    @Test
    public void setName() throws Exception
    {
        this.field.setTitle("Changed name");
        Assert.assertTrue(this.field.getTitle().equals("Changed name"));
    }


    @Test
    public void setDescription() throws Exception
    {
        this.field.setDescription("Changed description");
        Assert.assertTrue(this.field.getDescription().equals("Changed description"));
    }


    @Test
    public void setSubDescription() throws Exception
    {
        this.field.setSubText("Changed sub description");
        Assert.assertTrue(this.field.getSubText().equals("Changed sub description"));
    }


    @Test
    public void getRent() throws Exception
    {
        Assert.assertTrue(this.field.getRent().equals("10"));
    }


    @Test
    public void isOwned() throws Exception
    {
        Assert.assertFalse(this.field.isOwned());
    }


    @Test
    public void isOwnedByPlayer() throws Exception
    {
        Player player = new Player("Test Player");

        Assert.assertFalse(this.field.isOwnedByPlayer(player));

        this.field.setOwner(player);

        Assert.assertTrue(this.field.isOwnedByPlayer(player));
    }


    @Test
    public void setOwner() throws Exception
    {
        Assert.assertFalse(this.field.isOwned());

        this.field.setOwner(new Player("Test Player"));

        Assert.assertTrue(this.field.isOwned());
    }

}