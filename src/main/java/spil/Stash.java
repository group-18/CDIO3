package spil;


import gui_fields.GUI_Player;

public class Stash extends GUI_Player{
    private int amount;

    /**
     * Makes the Stash possible to use for other assignments.
     */

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

        return getBalance();
    }

    /**
     * This method adds an amount to the players stash, and makes sure that the players balance cant be negative.
     * @param numberToAdd
     */
    public void addAmount(int numberToAdd)
    {
        this.amount += numberToAdd;
        this.setBalance(numberToAdd);

        if (this.amount < 0) {
            this.amount = 0;
        }
    }


}