package spil;

import gui_fields.GUI_Player;

/**
 *
 */
public class Player {

    private GUI_Player guiPlayer;

    private String name;
    private Stash stash;
    private boolean bankrupt;

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
        this.bankrupt=false;
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

    public boolean bankrupt(){
        if (this.getBalance()<=0){
            return true;
        }
        else{
            return false;
        }
    }
}
