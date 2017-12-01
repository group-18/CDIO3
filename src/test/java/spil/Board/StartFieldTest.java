package spil.Board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StartFieldTest {

    private StartField field;


    @Before
    public void setUp() throws Exception
    {
        this.field = new StartField();
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

}