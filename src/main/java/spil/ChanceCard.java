package spil;

import gui_main.GUI;


public class ChanceCard {

    private String description;

    private Action action;


    /**
     * Constructs a ChangeCard with a description and a playable action
     *
     * @param description The description of this ChanceCard
     * @param action A callable action which will be run when playing the card
     */
    public ChanceCard(String description, Action action)
    {
        this.description = description;
        this.action = action;
    }


    /**
     * Method to play this ChanceCard action.
     * Show this ChanceCard text in the GUI.
     *
     * @param game The Game to act with
     */
    public void play(Game game)
    {
        game.getGui().displayChanceCard(this.description);

        this.action.run(game);
    }


    /**
     * Interface for ChanceCard runnable action
     */
    @FunctionalInterface
    public interface Action {
        /**
         * The action this ChanceCard should do. Implement actions
         * to apply on a {@link Player} (using {@link Game#getCurrentPlayer()}
         * and/or interact with the {@link GUI} (using {@link Game#getGui()}.
         *
         * @param game The Game to act with
         */
        void run(Game game);
    }

}
