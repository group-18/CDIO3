package spil;

import gui_fields.GUI_Player;

/**
 *
 */
public class Player {

    private GUI_Player guiPlayer;
    private String name;
    private Stash stash;
    private Type type = Type.CAT;


    /**
     * Enum to determine the player type of a Player
     */
    public enum Type {
        CAT,
        DOG,
        CAR,
        BOAT;

        /**
         * Converts a String to it's corresponding Type
         *
         * @param name The string to transform
         * @return The Player type
         */
        public static Type toEnum(String name)
        {
            try {
                return Type.valueOf(name.toUpperCase());
            } catch (Exception exception) {
                return Type.CAT;
            }
        }

        /**
         * Retrieve all Types as strings
         *
         * @return The Types as strings
         */
        public static String[] valuesToString()
        {
            Type[] types = Type.values();
            String[] typesString = new String[types.length];

            for (int i = 0; i < types.length; i++) {
                typesString[i] = types[i].toString();
            }

            return typesString;
        }
    }

    /**
     * Constructs a Player with a name and a start balance of '0'
     * @param name The name for this Player
     */
    public Player(String name)
    {
        this(name, 0);
    }

    /**
     * Constructs a Player with a name and start balance
     * @param name The name for this Player
     * @param startBalance The start balance for this Player
     */
    public Player(String name, int startBalance)
    {
        this.name = name;

        this.stash = new Stash(startBalance);
        this.guiPlayer = new GUI_Player(this.name, this.stash.getAmount());
    }

    /**
     * Retrieve the name of this Player
     * @return The name of this player
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Retrieve this Player balance
     * @return The balance of this Player
     */
    public int getBalance()
    {
        return this.stash.getAmount();
    }

    /**
     * Add to this Player balance
     * @param balance The balance to add
     */
    public void addBalance(int balance)
    {
        this.stash.addAmount(balance);
        this.guiPlayer.setBalance(this.stash.getAmount());
    }

    /**
     * Get this Player reference to the GUI
     * @return Player reference to the GUI
     */
    public GUI_Player getGuiPlayer()
    {
        return this.guiPlayer;
    }

    /**
     *  Changes the default type of player
     * @param type The type of player to be
     */
    public void setType(Type type)
    {
        this.type = type;
    }

    /**
     * Retrieve this players type
     * @return the type of player
     */
    public Type getType()
    {
        return this.type;
    }

}
