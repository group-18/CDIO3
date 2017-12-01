package spil;

import java.util.ArrayList;


/**
 * Collection of players.
 *
 * Extended from an ArrayList to bring
 * more helpers on a collection og players.
 */
public class PlayerCollection extends ArrayList<Player> {

    /**
     * The index used for determining which {@link Player}
     * is the current one
     */
    private int playerIndex;


    /**
     * Default constructor
     */
    public PlayerCollection()
    {
        this.playerIndex = 0;
    }


    /**
     * Add a Player to this PlayerCollection
     *
     * @param player The Player to add
     */
    public void addPlayer(Player player)
    {
        this.add(player);
    }


    /**
     * Retrieve the current player for this PlayerCollection
     *
     * @return The current player
     */
    public Player getCurrentPlayer()
    {
        return this.get(this.playerIndex);
    }


    /**
     * Set the player index for changing player
     *
     * @param playerIndex The new index to use
     */
    public void setPlayerIndex(int playerIndex)
    {
        this.playerIndex = playerIndex;
    }


    /**
     * Increment the player index to go to next Player
     */
    public void incrementPlayerIndex()
    {
        this.playerIndex = (this.playerIndex < (this.size() - 1)) ? this.playerIndex + 1 : 0;
    }


    /**
     * Check if any Player in this collection is bankrupt
     *
     * @return Whether a Player is bankrupt or not
     */
    public boolean isAnyBankrupt()
    {
        return this.stream().anyMatch(Player::isBankrupt);
    }


    /**
     * Get a Player in this collection by it's {@code Player.Type}.
     *
     * @param type The type to look for
     * @return The first Player with the exact type
     */
    public Player getByType(Player.Type type)
    {
        return this.stream()
                .filter(player -> player.getType() == type)
                .findFirst()
                .orElse(null);
    }


    /**
     * Get a Player which is bankrupt
     *
     * @return The first Player which is bankrupt
     */
    public Player getBankruptPlayer()
    {
        return this.stream()
                .filter(Player::isBankrupt)
                .findFirst()
                .orElse(null);
    }


    /**
     * Get the Player with most money in the stash.
     * If it's a tie, returns null.
     *
     * @return The winner of the game
     */
    public Player[] getWinner()
    {
        Player tmpWinner = null;

        ArrayList<Player> winners = new ArrayList<>();

        for (Player player : this) {
            if (tmpWinner == null) {
                tmpWinner = player;
                winners.add(player);
            } else if (player.getBalance() > tmpWinner.getBalance()) {
                tmpWinner = player;
                winners.clear();
                winners.add(player);
            }
            else if (player.getBalance()>=tmpWinner.getBalance()){
                tmpWinner = player;
                winners.add(player);
            }


        }

        return winners.toArray(new Player[] {});
    }

}
