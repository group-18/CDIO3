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
    private int prisonCards;


    /**
     * This is the action to run for this Players next turn
     */
    private TurnAction turnAction;


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
        this.prisonCards = 0;
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
     * Retrieve amount of Prisoncards
     * @return The balance of int prisonCards
     */
    public int getPrisonCard () {return this.prisonCards; }

    /**
     * Add to amount of Prisoncards
     * @return The balance of int prisonCards
     */
    public int addPrisonCard (int numbersOfPrisonCards)
    {
        this.prisonCards += numbersOfPrisonCards;

        return this.prisonCards;
    }

    /**
     * Remove to amount of Prisoncards
     * @return The balance of int prisonCards
     */
    public int removePrisonCard (int numbersOfPrisonCards)
    {
        this.prisonCards -= numbersOfPrisonCards;

        return this.prisonCards;
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


    /**
     * Interface for Player runnable action instead of it's normal turn
     */
    public interface TurnAction {
        /**
         * This is the action to run for this Players next turn
         */
        void run();
    }


    /**
     * Sets an action for the next turn
     *
     * @param turnAction The action to perform
     */
    public void setTurnAction(TurnAction turnAction)
    {
        this.turnAction = turnAction;
    }


    /**
     * Runs the action. The action will be removed after use.
     */
    public void runTurnAction()
    {
        if (this.hasTurnAction()) {
            this.turnAction.run();
            this.turnAction = null;
        }
    }

    /**
     * Determine if this Player has a TurnAction set
     *
     * @return Whether there is a TurnAction or not
     */
    public boolean hasTurnAction()
    {
        return this.turnAction != null;
    }


    /**
     * Filter method to check if a Player is bankrupt.
     *
     * @param player The Player to check
     * @return Whether the Player is bankrupt or not
     */
    public static boolean isBankrupt(Player player)
    {
        return player.getBalance() < 0;
    }

}
