package spil;

import java.util.Random;


public class ChanceDeck {

    private ChanceCard[] cards;

    private int numberOfDrawnCards;


    /**
     * Construct a ChanceDeck with ChanceCards
     *
     * @see ChanceCard
     */
    public ChanceDeck()
    {
        this.cards = ChanceDeck.defaultChanceCards.clone();
        this.shuffle();
    }


    /**
     * Draw the ChanceCard in the top of the dec
     *
     * @see ChanceCard
     * @return The top ChanceCard
     */
    public ChanceCard draw()
    {
        if (this.isEmpty()) {
            this.shuffle();
        }

        return this.cards[this.numberOfDrawnCards++];
    }


    /**
     * Shuffle the cards in this ChanceDeck
     */
    public void shuffle()
    {
        Random rand = new Random();

        int max = this.cards.length;
        for (int i = 0; i < max; i++) {
            // Pick random index between 0 and card length
            int slot = rand.nextInt(max);

            // Swap cards in the deck
            ChanceCard temp = this.cards[slot];
            this.cards[slot] = this.cards[i];
            this.cards[i] = temp;
        }

        this.numberOfDrawnCards = 0;
    }


    /**
     * Check if this ChanceDeck is empty
     *
     * @return If this ChanceDeck is empty
     */
    public boolean isEmpty()
    {
        return this.numberOfDrawnCards >= this.cards.length;
    }


    /**
     * Default {@link ChanceCard}s in a ChanceDeck.
     */
    static private ChanceCard[] defaultChanceCards = new ChanceCard[] {};

}
