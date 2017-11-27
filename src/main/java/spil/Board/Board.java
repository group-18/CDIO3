package spil.Board;

import gui_fields.GUI_Field;
import spil.Translate;

import java.awt.*;


public class Board {

    /**
     * Fields in this Board
     */
    private Field[] fields;


    /**
     * Constructs a Board
     */
    public Board()
    {
        this.fields = this.createFields();
    }


    /**
     * Get this Boards fields
     *
     * @return The fields of this board
     */
    public Field[] getFields()
    {
        return this.fields;
    }


    /**
     * Get a specific field by name on this Board
     *
     * @param name The name of a field
     * @return The field
     */
    public Field getFieldByName(String name)
    {
        for (Field field: this.fields) {
            if (field.getName().equals(name)) {
                return field;
            }
        }

        return null;
    }


    /**
     * Get alle fields GUI fields for use in the GUI
     *
     * @return This Boards GUI fields
     */
    public GUI_Field[] getGuiFields()
    {
        GUI_Field[] fields = new GUI_Field[this.fields.length];

        for (int i = 0; i < this.fields.length; i++) {
            fields[i] = this.fields[i].getGuiField();
        }

        return fields;
    }


    /**
     * Construct all the fields for this Board
     *
     * @return Array of all fields in this Board
     */
    private Field[] createFields()
    {
        return new Field[] {
            new StartField() .setBackgroundColor(Color.GREEN),
            new HouseField(Translate.t("board.field.burgerbaren.description"), "1").setBackgroundColor(Color.gray),
            new HouseField(Translate.t("board.field.pizzeriaet.description"), "1").setBackgroundColor(Color.gray),
            new ChanceField(),
            new HouseField(Translate.t("board.field.slikbutikken.description"), "1").setBackgroundColor(Color.cyan),
            new HouseField(Translate.t("board.field.iskiosken.description"), "1").setBackgroundColor(Color.cyan),
            new PrisonField(true),
            new HouseField(Translate.t("board.field.museet.description"), "2").setBackgroundColor(Color.pink),
            new HouseField(Translate.t("board.field.biblioteket.description"), "2").setBackgroundColor(Color.pink),
            new ChanceField(),
            new HouseField(Translate.t("board.field.skaterparken.description"), "2").setBackgroundColor(Color.orange),
            new HouseField(Translate.t("board.field.swimmingpoolen.description"), "2").setBackgroundColor(Color.orange),
            new ParkingField(),
            new HouseField(Translate.t("board.field.spillehallen.description"), "3").setBackgroundColor(Color.red),
            new HouseField(Translate.t("board.field.biografen.description"), "3").setBackgroundColor(Color.red),
            new ChanceField(),
            new HouseField(Translate.t("board.field.legetøjsbutikken.description"), "3").setBackgroundColor(Color.yellow),
            new HouseField(Translate.t("board.field.dyrehandlen.description"), "3").setBackgroundColor(Color.yellow),
            new PrisonField(false),
            new HouseField(Translate.t("board.field.bowlinghallen.description"), "4").setBackgroundColor(Color.green),
            new HouseField(Translate.t("board.field.zoo.description"), "4").setBackgroundColor(Color.green),
            new ChanceField(),
            new HouseField(Translate.t("board.field.vandlandet.description"), "5").setBackgroundColor(Color.blue),
            new HouseField(Translate.t("board.field.strandpromenaden.description"), "5").setBackgroundColor(Color.blue),
        };
    }

}
