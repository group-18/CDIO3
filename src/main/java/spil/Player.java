package spil;


import gui_fields.GUI_Player;

public class Player extends GUI_Player {
    private String name;
    private Stash stash;
    private int numberofplayers;

    //Creates a player, with the name that the user types in. It also creates a Stash with the startamount proporti
    public Player(String name, int numberofplayers)
    {
        super(name);
        this.name = name;
        this.stash = new Stash(startAmount(numberofplayers));
    }

    public String getName()
    {
        return this.name;
    }

    public int getAmount()
    {
        return this.stash.getAmount();
    }

    //This method adds an amount to the players stash.
    public void addAmount(int numberToAdd)
    {
        this.stash.addAmount(numberToAdd);
    }

    /**
     * Returns the stash amount, which is based on numberofplayers
     * @param numberofplayers
     * @return int
     */

public int startAmount(int numberofplayers){
    if (numberofplayers==2){
        return 20;
    }
    if (numberofplayers==3){
        return 18;
    }
    if (numberofplayers == 4){
        return 16;
    }
    return 20;
}
}