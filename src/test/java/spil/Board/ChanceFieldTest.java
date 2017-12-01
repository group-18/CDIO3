package spil.Board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ChanceFieldTest {

    private ChanceField field;


    @Before
    public void setUp() throws Exception
    {
        this.field = new ChanceField();
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
        this.field.setSubDescription("Changed sub description");
        Assert.assertTrue(this.field.getSubDescription().equals("Changed sub description"));
    }

}