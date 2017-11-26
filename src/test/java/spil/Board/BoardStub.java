package spil.Board;

import gui_fields.GUI_Field;

public class BoardStub extends Board {

    private Field[] fields = new Field[] {
            new StartField(),
            new HouseField("Test house", "1"),
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
    public Field getFieldByName(String name)
    {
        for (Field field: this.fields) {
            if (field.getName().equals(name)) {
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
