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
    static private ChanceCard[] defaultChanceCards = new ChanceCard[] {
        new ChanceCard(
            Translate.t("chance.description.car"),
            (game) -> {} // todo: missing player types
        ),
        new ChanceCard(
            Translate.t("chance.description.ship"),
            (game) -> {} // todo: missing player types
        ),
        new ChanceCard(
            Translate.t("chance.description.cat"),
            (game) -> {} // todo: missing player types
        ),
        new ChanceCard(
            Translate.t("chance.description.dog"),
            (game) -> {} // todo: missing player types
        ),
        new ChanceCard(
            Translate.t("chance.description.to_start"),
            (game) -> game.movePlayer(game.getCurrentPlayer(), Translate.t("board.field.start.title"))
        ),
        new ChanceCard(
            Translate.t("chance.description.move_5_fields"),
            (game) -> {
                String fieldAnswer = game.getGui().getUserSelection(Translate.t("chance.description.move_5_fields.question"), "1", "2", "3", "4", "5");
                int numberOfFields = Integer.parseInt(fieldAnswer);

                game.movePlayer(game.getCurrentPlayer(), numberOfFields);
            }
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_orange"),
            (game) -> {} // todo: missing field types
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_orange_green"),
            (game) -> {} // todo: missing field types
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_lightblue"),
            (game) -> {} // todo: missing field types
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_pink_darkblue"),
            (game) -> {} // todo: missing field types
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_red"),
            (game) -> {} // todo: missing field types
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_lightblue_red"),
            (game) -> {} // todo: missing field types
        ),
        new ChanceCard(
            Translate.t("chance.description.move_to_brown_yellow"),
            (game) -> {} // todo: missing field types
        ),
        new ChanceCard(
            Translate.t("chance.description.field_or_card"),
            (game) -> {
                String answer = game.getGui().getUserButtonPressed(
                    Translate.t("chance.description.field_or_card.question"),
                    Translate.t("chance.description.field_or_card.move"),
                    Translate.t("chance.description.field_or_card.card")
                );

                if (answer.equals(Translate.t("chance.description.field_or_card.move"))) {
                    game.movePlayer(game.getCurrentPlayer(), 1);
                } else {
                    game.getChanceDeck().draw().play(game);
                }
            }
        ),
        new ChanceCard(
            Translate.t("chance.description.slik"),
            (game) -> game.getCurrentPlayer().addBalance(-2)
        ),
        new ChanceCard(
            Translate.t("chance.description.prison"),
            (game) ->game.getCurrentPlayer().addPrisonCard(1)
        ),
        new ChanceCard(
            Translate.t("chance.description.strandpromenaden"),
            (game) -> game.movePlayer(game.getCurrentPlayer(), Translate.t("board.field.strandpromenaden.description"))
        ),
        new ChanceCard(
            Translate.t("chance.description.birthday"),
            (game) -> {
                for (Player player : game.getPlayers()) {
                    player.addBalance(-1);
                    game.getCurrentPlayer().addBalance(1);
                }
            }
        ),
        new ChanceCard(
            Translate.t("chance.description.homework"),
            (game) -> game.getCurrentPlayer().addBalance(2)
        ),
        new ChanceCard(
            Translate.t("chance.description.skaterparken"),
            (game) -> game.movePlayer(game.getCurrentPlayer(), Translate.t("board.field.skaterparken.description"))
        ),
    };

}
