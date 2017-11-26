package spil.Board;

import gui_fields.GUI_Jail;
import spil.Translate;
import java.awt.Color;


public class PrisonField extends Field {

    /**
     * Boolean to determine whether this PrisonField is
     * the "visitor" field or the "go to prison" field
     */
    private boolean isVisit;


    /**
     * Constructs a PrisonField with title, description, sub description,
     * background color and foreground color. Also sets the {@code isVisit} boolean.
     *
     * @see #isVisit
     * @param isVisit Sets {@code isVisit} for this PrisonField
     */
    public PrisonField(boolean isVisit)
    {
        super(
                Translate.t("board.field.prison.title"),
                Translate.t("board.field.prison.description"),
                Translate.t("board.field.prison.subDescription"),
                Color.BLACK,
                Color.WHITE
        );

        this.isVisit = isVisit;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected GUI_Jail createGUIFIeld()
    {
        return new GUI_Jail();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public GUI_Jail getGuiField()
    {
        return (GUI_Jail) this.guiField;
    }


    /**
     * Returns if this PrisonField is visit
     *
     * @see #isVisit
     * @return If this Field is visit
     */
    public boolean isVisit()
    {
        return this.isVisit;
    }

}
