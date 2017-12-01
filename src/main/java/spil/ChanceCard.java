package spil;

import gui_main.GUI;
import spil.Board.Field;
import spil.Board.HouseField;

import java.awt.*;
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


                    ArrayList<Field> fieldsToUse = new ArrayList<>();

                    // Check if there is any free fields
                    for (Field field : fields) {
                        if (((HouseField) field).isOwned()) {
                            fieldsToUse.add(field);
                        }
                    }

                    // If no free fields...
                    if (fieldsToUse.size() == 0) {
                        fieldsToUse = fields;
                    }

                    String[] fieldNames = new String[fieldsToUse.size()];
                    for (int i = 0; i < fieldsToUse.size(); i++) {
                        fieldNames[i] = fieldsToUse.get(i).getTitle();
                    }

                    String fieldName = game.getGui().getUserSelection(Translate.t("chance.description.type.action"), fieldNames);

                    game.movePlayer(player, fieldName);
                });
            }

            game.getChanceDeck().draw().play(game);
        };
    }


    public static Action fieldTypeAction(Color ...types)
    {
        return (Game game) -> {
            Player player = game.getPlayers().getCurrentPlayer();
            HouseField[] fields = game.getBoard().getFieldsByTypes(types);

            String[] fieldNames = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                fieldNames[i] = fields[i].getTitle();
            }

            String fieldName = game.getGui().getUserSelection(Translate.t("chance.description.move_to.action"), fieldNames);

            game.movePlayer(player, fieldName);

            HouseField field = (HouseField) game.getBoard().getFieldByTitle(fieldName);

            if (field.isOwned()) {
                field.payRent(game.getBoard(), player);
            } else {
                field.setOwner(player);
            }
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
