package spil;

import gui_main.GUI;
import spil.Board.Field;
import spil.Board.HouseField;

import java.util.ArrayList;
import java.util.Arrays;


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
     * Method for used in ChanceCards regarding {@link Player.Type}.
     *
     * @param type The Player Type to give this card to
     * @return The Action function to be run
     */
    public static Action typeAction(Player.Type type)
    {
        return (Game game) -> {
            Player player = game.getPlayers().getByType(type);

            if (player != null) {
                player.setTurnAction(() -> {
                    ArrayList<Field> fields = new ArrayList<>(Arrays.asList(game.getFields()));

                    // Only use HouseFields
                    fields.removeIf(field -> ! (field instanceof HouseField));


                    // Check if there is any free fields
                    Field[] fieldsToUse = (Field[]) fields.stream().filter(field -> ((HouseField) field).isOwned()).toArray();
                    if (fieldsToUse.length == 0) {
                        fieldsToUse = fields.toArray(new Field[] {});
                    }

                    String[] fieldNames = new String[fieldsToUse.length];
                    for (int i = 0; i < fieldsToUse.length; i++) {
                        fieldNames[i] = fieldsToUse[i].getName();
                    }

                    String fieldName = game.getGui().getUserSelection(Translate.t("chance.description.type.action"), fieldNames);

                    game.movePlayer(player, fieldName);
                });
            }

            game.getChanceDeck().draw().play(game);
        };
    }


    /**
     * Interface for ChanceCard runnable action
     */
    @FunctionalInterface
    public interface Action {
        /**
         * The action this ChanceCard should do. Implement actions
         * to apply on {@link Player}s (using {@link Game#getPlayers()}
         * and/or interact with the {@link GUI} (using {@link Game#getGui()}.
         *
         * @param game The Game to act with
         */
        void run(Game game);
    }

}
