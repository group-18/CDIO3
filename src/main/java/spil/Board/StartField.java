package spil.Board;

import gui_fields.GUI_Start;
import spil.Game;
import spil.Player;
import spil.Translate;
import java.awt.Color;


public class StartField extends Field {

    /**
     * Constructs a StartField with title, description, sub description,
     * background color and foreground color
     */
    public StartField()
    {
        super(
                Translate.t("board.field.start.title"),
                Translate.t("board.field.start.description"),
                Translate.t("board.field.start.subDescription"),
                Color.GREEN,
                Color.BLACK
        );
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected GUI_Start createGUIFIeld()
    {
        return new GUI_Start();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public GUI_Start getGuiField()
    {
        return (GUI_Start) this.guiField;
    }

    @Override
    public void runAction(Game game) {

    }
}
