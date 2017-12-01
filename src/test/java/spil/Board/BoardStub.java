package spil.Board;

import gui_fields.GUI_Field;

import java.awt.Color;

public class BoardStub extends Board {

    private Field[] fields = new Field[] {
            new StartField(),
            new HouseField("Test house", 1, Color.WHITE),
            new ChanceField(),
            new PrisonField(false),
            new PrisonField(true),
            new ParkingField(),
    };


    @Override
    public Field[] getFields()
    {
        return this.fields;
    }


    @Override
    public Field getFieldByTitle(String title)
    {
        for (Field field: this.fields) {
            if (field.getTitle().equals(title)) {
                return field;
            }
        }

        return null;
    }


    @Override
    public GUI_Field[] getGuiFields()
    {
        GUI_Field[] fields = new GUI_Field[this.fields.length];

        for (int i = 0; i < this.fields.length; i++) {
            fields[i] = this.fields[i].getGuiField();
        }

        return fields;
    }

}
