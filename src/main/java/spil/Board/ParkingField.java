package spil.Board;

import gui_fields.GUI_Street;
import spil.Player;
import spil.Translate;

import java.awt.Color;

public class ParkingField extends Field {

    /**
     * Constructs a ParkingField with title, description, sub description,
     * background color and foreground color
     */
    public ParkingField()
    {
        super(
                Translate.t("board.field.parking.title"),
                Translate.t("board.field.parking.description"),
                Translate.t("board.field.parking.subDescription"),
                Color.BLACK,
                Color.WHITE
        );
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected GUI_Street createGUIFIeld()
    {
        return new GUI_Street();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public GUI_Street getGuiField()
    {
        return (GUI_Street) this.guiField;
    }

    @Override
    public void runAction(Player player) {

    }
}
