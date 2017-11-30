package spil.Board;

import gui_fields.GUI_Street;
import spil.Game;
import spil.Player;

import java.awt.Color;

public class HouseField extends Field {

    /**
     * The rent for this HouseField
     */
    private String rent;

    /**
     * The Player which own this HouseField.
     * Is {@code null} when not owned.
     */
    private Player owner;
    private HouseField houseField;



    /**
     * Constructs a HouseField with a given name and rent. Sets a default description, sub description,
     * background color and foreground color
     *
     * @param name The title of this HouseField
     * @param rent The rent of this HouseField
     */
    public HouseField(String name, String rent) {
        this(name, "", "", rent, Color.BLUE, Color.BLACK);
    }


    /**
     * Constructs a HouseField with all needed information; Name, description,
     * sub description, rent, background color and foreground color
     *
     * @param name            The name of this HouseField
     * @param description     The description of this HouseField (shown in the card in the middle of the board)
     * @param subDescription  The sub description of this HouseField (shown in the actual field on the board)
     * @param rent            The rent of this HouseField
     * @param backgroundColor The color of this HouseField background
     * @param foregroundColor The color of this HouseField foreground
     */
    public HouseField(String name, String description, String subDescription, String rent, Color backgroundColor, Color foregroundColor) {
        super(name, description, subDescription, backgroundColor, foregroundColor);

        this.rent = rent;

        this.getGuiField().setRent(this.rent);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected GUI_Street createGUIFIeld() {
        return new GUI_Street();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public GUI_Street getGuiField() {
        return (GUI_Street) this.guiField;
    }


    /**
     * Get this HouseFields rent
     *
     * @return The rent for this HouseField
     */
    public String getRent() {
        return this.rent;
    }

    private int rentToInt(String rent) {
        return Integer.parseInt(rent);
    }

    /**
     * Method to determine if this HouseField is owned
     *
     * @return Is this HouseField owned?
     */
    public boolean isOwned() {
        return this.owner != null;
    }


    /**
     * Check if this HouseField is owned by a specific {@link Player}.
     *
     * @param player The Player to check with
     * @return If this HouseField is owned by Player
     */
    public boolean isOwnedByPlayer(Player player) {
        return this.owner == player;
    }


    /**
     * Set the owner on this HouseField
     *
     * @param player The Player to own this HouseField
     */
    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return this.owner;
    }


    @Override
    public void runAction(Game game) {
        Player player = game.getPlayers().getCurrentPlayer();

        if (this.isOwned()){
                if (!isOwnedByPlayer(player)){
                    player.addBalance(-this.rentToInt(getRent()));
                    this.getOwner().addBalance(this.rentToInt(getRent()));
                    game.getGui().showMessage("Dette felt tilhører " + this.getOwner().getName() + ", som derfor tjener " + getRent() + "M fra " + player.getName());
                }
            }
            else {
                player.addBalance(-this.rentToInt(getRent()));
                this.setOwner(player);
                this.getGuiField().setOwnerName(player.getName());

                this.getGuiField().setBorder(player.getGuiPlayer().getPrimaryColor());
            }
        }
    }

