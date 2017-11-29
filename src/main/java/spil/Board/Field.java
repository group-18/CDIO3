package spil.Board;

import gui_fields.GUI_Field;
import spil.Player;

import java.awt.Color;


public abstract class Field {

    /**
     * The name of this Field
     */
    private String name;

    /**
     * The description for this Field
     */
    private String description;

    /**
     * The sub description for this Field
     */
    private String subDescription;


    /**
     * The GUI_Field of this Field
     */
    protected GUI_Field guiField;


    /**
     * Constructs a Field with a name
     *
     * @param name The name of this Field
     */
    public Field(String name)
    {
        this.guiField = this.createGUIFIeld();

        this.setName(name);
    }


    /**
     * Constructs a Field with all needed information; Name, description,
     * sub description, background color and foreground color
     *
     * @param name The name of this Field
     * @param description The description of this Field (shown in the card in the middle of the board)
     * @param subDescription The sub description of this Field (shown in the actual field on the board)
     * @param backgroundColor The color of this Field background
     * @param foregroundColor The color of this Field foreground
     */
    public Field(String name, String description, String subDescription, Color backgroundColor, Color foregroundColor)
    {
        this(name);

        this.setDescription(description).setSubDescription(subDescription);
        this.setBackgroundColor(backgroundColor).setForegroundColor(foregroundColor);
    }


    /**
     * Get the name of this Field
     *
     * @return The name of this Field
     */
    public String getName()
    {
        return this.name;
    }


    /**
     * Set the name of this Field. Also sets the name on
     * the corresponding GUI field. Returns this Field
     * for easy chaining.
     *
     * @param name The new name of this Field
     * @return This Field
     */
    public Field setName(String name)
    {
        this.name = name;
        this.guiField.setTitle(this.name);

        return this;
    }


    /**
     * Get the description of this Field
     *
     * @return The description of this Field
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Set the description of this Field. Also sets the description on
     * the corresponding GUI field. Returns this Field
     * for easy chaining.
     *
     * @param description The new description of this Field
     * @return This Field
     */
    public Field setDescription(String description)
    {
        this.description = description;
        this.guiField.setDescription(this.description);

        return this;
    }


    /**
     * Get the sub description of this Field
     *
     * @return The sub description of this Field
     */
    public String getSubDescription()
    {
        return this.subDescription;
    }


    /**
     * Set the sub description of this Field. Also sets the sub description on
     * the corresponding GUI field. Returns this Field
     * for easy chaining.
     *
     * @param subDescription The new sub description of this Field
     * @return This Field
     */
    public Field setSubDescription(String subDescription)
    {
        this.subDescription = subDescription;
        this.guiField.setSubText(this.subDescription);

        return this;
    }


    /**
     * Set the background color of this Field. Also sets the background color on
     * the corresponding GUI field. Returns this Field
     * for easy chaining.
     *
     * @param backgroundColor The new background color of this Field
     * @return This Field
     */
    public Field setBackgroundColor(Color backgroundColor)
    {
        this.guiField.setBackGroundColor(backgroundColor);

        return this;
    }


    /**
     * Set the foreground color of this Field. Also sets the foreground color on
     * the corresponding GUI field. Returns this Field
     * for easy chaining.
     *
     * @param foregroundColor The new foreground color of this Field
     * @return This Field
     */
    public Field setForegroundColor(Color foregroundColor)
    {
        this.guiField.setForeGroundColor(foregroundColor);

        return this;
    }


    public void setCar(Player player)
    {
        this.guiField.setCar(player.getGuiPlayer(), true);
    }


    public void removeCar(Player player)
    {
        this.guiField.setCar(player.getGuiPlayer(), false);
    }


    /**
     * Creates the right GUI field. This method is called in the
     * constructor and must return the right GUI field for its purpose.
     *
     * @return A GUI field
     */
    abstract protected GUI_Field createGUIFIeld();


    /**
     * Must return the GUI field with the right type.
     *
     * @return A GUI field
     */
    abstract public GUI_Field getGuiField();

    public abstract void runAction(Player player, Field field);
}
