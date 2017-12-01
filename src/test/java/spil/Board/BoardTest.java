package spil.Board;

import gui_fields.GUI_Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception
    {
        this.board = new BoardStub();
    }


    @Test
    public void getFields() throws Exception
    {
        Assert.assertEquals(6, this.board.getFields().length);
    }


    @Test
    public void getFieldByTitle() throws Exception
    {
        Field field = this.board.getFieldByTitle("Test house");

        Assert.assertTrue(field != null && field instanceof HouseField);
    }


    @Test
    public void getGuiFields() throws Exception
    {
        GUI_Field[] guiFields = this.board.getGuiFields();

        Assert.assertEquals(this.board.getFields().length, guiFields.length);
    }

}