package spil;


public class Stash {
    private int amount;

    /**
     * Makes the Stash possible to use for other assignments.
     */
    public Stash()
    {
    }

    /**
     * Initializes the stash with a start amount.
     * @param startAmount
     */
    public Stash(int startAmount)
    {
        this.amount = startAmount;
    }

    public int getAmount()
    {
        return this.amount;
    }

    /**
     * This method adds an amount to the players stash, and makes sure that the players balance cant be negative.
     * @param numberToAdd
     */
    public void addAmount(int numberToAdd)
    {
        this.amount += numberToAdd;

        if (this.amount < 0) {
            this.amount = 0;
        }
    }


}