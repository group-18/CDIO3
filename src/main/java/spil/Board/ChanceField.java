package spil.Board;

import gui_fields.GUI_Chance;
import spil.Game;
import spil.Player;
import spil.Translate;

import java.awt.Color;

public class ChanceField extends Field {

    /**
     * Constructs a ChangeField with title, description, sub description,
     * background color and foreground color
     */
    public ChanceField()
    {
        super(
                Translate.t("board.field.chance.title"),
                Translate.t("board.field.chance.description"),
                Translate.t("board.field.chance.subDescription"),
                Color.BLACK,
                Color.WHITE
        );
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected GUI_Chance createGUIFIeld()
    {
        return new GUI_Chance();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public GUI_Chance getGuiField()
    {
        return (GUI_Chance) this.guiField;
    }

    @Override
    public void runAction(Game game) {

    }
}
