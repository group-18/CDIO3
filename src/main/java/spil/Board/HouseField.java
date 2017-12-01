package spil.Board;

import gui_fields.GUI_Street;
import spil.Game;
import spil.Player;

import java.awt.Color;

public class HouseField extends Field {

    /**
     * The rent for this HouseField
     */
    private int rent;

    /**
     * The Player which own this HouseField.
     * Is {@code null} when not owned.
     */
    private Player owner;

    /**
     * The type of this HouseField.
     * Also determines the background color of the GUI_Field.
     */
    private Color type;



    /**
     * Constructs a HouseField with a given name and rent. Sets a default description, sub description,
     * type and foreground color
     *
     * @param title The title of this HouseField
     * @param rent The rent of this HouseField
     * @param type The type of this HouseField
     */
    public HouseField(String title, int rent, Color type)
    {
        super(title);

        this.setDescription("");
        this.setSubText("");

        this.setBackgroundColor(type);
        this.setForegroundColor(Color.BLACK);

        this.rent = rent;
        this.type = type;

        this.getGuiField().setRent("M" + this.rent);
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


    /**
     * Retrieve the type of this HouseField
     *
     * @return The type
     */
    public Color getType()
    {
        return this.type;
    }

    /**
     * Get this HouseFields rent
     *
     * @return The rent for this HouseField
     */
    public int getRent()
    {
        return this.rent;
    }


    /**
     * Buy this HouseField for a Player
     *
     * @param player The Player to buy this HouseField
     */
    public void buyProperty(Player player)
    {
        this.setOwner(player);

        player.addBalance(-this.getRent());
    }


    /**
     * Pay this HouseFields rent for Player
     *
     * @param player The Player to pay the rent for
     */
    public void payRent(Player player)
    {
        player.addBalance(-this.getRent());
        this.owner.addBalance(this.getRent());
    }


    /**
     * Method to determine if this HouseField is owned
     *
     * @return Is this HouseField owned?
     */
    public boolean isOwned()
    {
        return this.owner != null;
    }


    /**
     * Check if this HouseField is owned by a specific {@link Player}.
     *
     * @param player The Player to check with
     * @return If this HouseField is owned by Player
     */
    public boolean isOwnedByPlayer(Player player)
    {
        return this.owner == player;
    }


    /**
     * Set the owner on this HouseField
     *
     * @param player The Player to own this HouseField
     */
    public void setOwner(Player player)
    {
        this.owner = player;

        this.getGuiField().setOwnerName(player.getName());
        this.getGuiField().setBorder(player.getGuiPlayer().getPrimaryColor());
    }


    @Override
    public void runAction(Game game)
    {
        Player player = game.getPlayers().getCurrentPlayer();

        if (! this.isOwned()) {
            this.buyProperty(player);
        } else if (! this.isOwnedByPlayer(player)) {
            this.payRent(player);
            game.getGui().showMessage("Dette felt tilhører " + this.owner.getName() + ", som derfor tjener " + this.getRent() + "M fra " + player.getName());
        }
    }

}

