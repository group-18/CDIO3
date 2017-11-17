package spil;


public class Player {
    private String name;
    private Stash stash;

    //Creates a player, with the name that the user types in. It also creates a Stash with the startamount = 0
    public Player(String name)
    {
        this.name = name;
        this.stash = new Stash(0);
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
}