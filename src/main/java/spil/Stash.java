package spil;

/**
 *
 */
public class Stash {

    private int amount = 0;

    /**
     * Default constructor
     * Creates a new Stash
     */
    public Stash()
    {

    }

    /**
     * Creates a new Stash with a start amount.
     * @param startAmount The amount to be stored in the Stash
     */
    public Stash(int startAmount)
    {
        this.amount = startAmount;
    }

    /**
     * Add amount to this Stash
     * @param amount The amount to add
     */
    public void addAmount(int amount)
    {
        this.amount += amount;
    }

    /**
     * Get this Stash current amount
     * @return The amount of this Stash
     */
    public int getAmount()
    {
        return this.amount;
    }

}
