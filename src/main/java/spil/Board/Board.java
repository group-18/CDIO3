package spil.Board;

import gui_fields.GUI_Field;
import spil.Player;
import spil.Translate;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Board {

    /**
     * Fields in this Board
     */
    private Field[] fields;

    private HashMap<Player, Field> playerFieldMap = new HashMap<>();


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
     * @param title The title of a field
     * @return The field
     */
    public Field getFieldByTitle(String title)
    {
        for (Field field: this.fields) {
            if (field.getTitle().equals(title)) {
                return field;
            }
        }

        return null;
    }


    public HouseField[] getFieldsByTypes(Color ...types)
    {
        ArrayList<HouseField> fields = new ArrayList<>();

        for (HouseField field : this.getHouseFields()) {
            for (Color type : types) {
                if (field.getType() == type) {
                    fields.add(field);
                }
            }
        }

        return fields.toArray(new HouseField[] {});
    }


    public HouseField[] getHouseFields()
    {
        ArrayList<HouseField> fields = new ArrayList<>();

        for (Field field: this.fields) {
            if (field instanceof HouseField) {
                fields.add((HouseField) field);
            }
        }

        return fields.toArray(new HouseField[] {});
    }


    /**
     * Get all fields GUI fields for use in the GUI
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
     * Add a {@link Player} to a map between Player and Field
     *
     * @param player The Player to link
     */
    public void addPlayer(Player player)
    {
        Field startField = this.fields[0];
        this.playerFieldMap.put(player, startField);

        startField.setCar(player);
    }

    /**
     * Moves the players from the set location to the next location
     * @param player the current player
     * @param fieldToMove the integer to move from the set location.
     */

    public void movePlayer(Player player, int fieldToMove)
    {
        Field currentField = this.playerFieldMap.get(player);

        for (int i = 0; i < this.fields.length; i++) {
            if (currentField == this.fields[i]) {
                int nextFieldPos = i + fieldToMove;
                nextFieldPos = nextFieldPos % this.fields.length;

                Field nextField = this.fields[nextFieldPos];
                this.movePlayer(player, nextField);

                break;
            }
        }
    }


    public void movePlayer(Player player, Field fieldToMove)
    {
        Field currentField = this.playerFieldMap.get(player);

        this.playerFieldMap.replace(player, fieldToMove);

        currentField.removeCar(player);
        fieldToMove.setCar(player);
    }


    public Field getPlayerField(Player player)
    {
        return this.playerFieldMap.get(player);
    }


    public boolean isFieldBefore(Field newField, Field oldField)
    {
        if (newField == oldField) {
            return false;
        }

        for (int i = 0; i < this.fields.length; i++) {
            if (this.fields[i] == newField) {
                return true;
            } else if (this.fields[i] == oldField) {
                return false;
            }
        }

        return false;
    }


    /**
     * Construct all the fields for this Board
     *
     * @return Array of all fields in this Board
     */
    private Field[] createFields()
    {
        return new Field[] {
            new StartField() .setTitle("Start") .setSubText("") .setBackgroundColor(Color.GREEN),
            new HouseField(Translate.t("board.field.burgerbaren.description"), 1, Color.gray).setSubText("M1"),
            new HouseField(Translate.t("board.field.pizzeriaet.description"), 1, Color.gray).setSubText("M1"),
            new ChanceField() .setTitle("Chance"),
            new HouseField(Translate.t("board.field.slikbutikken.description"), 1, Color.cyan).setSubText("M1"),
            new HouseField(Translate.t("board.field.iskiosken.description"), 1, Color.cyan).setSubText("M1"),
            new PrisonField(true),
            new HouseField(Translate.t("board.field.museet.description"), 2, Color.pink).setSubText("M2"),
            new HouseField(Translate.t("board.field.biblioteket.description"), 2, Color.pink).setSubText("M2"),
            new ChanceField() .setTitle("Chance"),
            new HouseField(Translate.t("board.field.skaterparken.description"), 2, Color.orange).setSubText("M2"),
            new HouseField(Translate.t("board.field.swimmingpoolen.description"), 2, Color.orange).setSubText("M2"),
            new ParkingField() .setTitle("Parkering"),
            new HouseField(Translate.t("board.field.spillehallen.description"), 3, Color.red).setSubText("M2"),
            new HouseField(Translate.t("board.field.biografen.description"), 3, Color.red).setSubText("M2"),
            new ChanceField() .setTitle("Chance"),
            new HouseField(Translate.t("board.field.legetøjsbutikken.description"), 3, Color.yellow).setSubText("M3"),
            new HouseField(Translate.t("board.field.dyrehandlen.description"), 3, Color.yellow).setSubText("M3"),
            new PrisonField(false),
            new HouseField(Translate.t("board.field.bowlinghallen.description"), 4, Color.green).setSubText("M4"),
            new HouseField(Translate.t("board.field.zoo.description"), 4, Color.green).setSubText("M4"),
            new ChanceField() .setTitle("Chance"),
            new HouseField(Translate.t("board.field.vandlandet.description"), 5, Color.blue).setSubText("M5"),
            new HouseField(Translate.t("board.field.strandpromenaden.description"), 5, Color.blue).setSubText("M5"),
        };
    }

}
