package spil;

import gui_main.GUI;
import spil.Board.Board;
import spil.Board.Field;
import spil.Board.PrisonField;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private Board board;
    private GUI gui;

    private Die die;
    private ChanceDeck chanceDeck;
    private PlayerCollection players;

    private boolean winnerFound = false;


    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());

        this.die = new Die();
        this.chanceDeck = new ChanceDeck();
        this.players = new PlayerCollection();
    }


    public void play()
    {
        int numberOfPlayers = choosePlayerAmountStringToInt();

        this.createPlayers(numberOfPlayers);

        youngestPlayerStarts(numberOfPlayers);

        do {
            Player currentPlayer = this.players.getCurrentPlayer();

            if (currentPlayer.hasTurnAction()) {
                currentPlayer.runTurnAction();
            } else {
                playRound(currentPlayer);
            }

            this.players.incrementPlayerIndex();
        } while (! this.winnerFound);
    }


    public GUI getGui()
    {
        return this.gui;
    }


    public PlayerCollection getPlayers()
    {
        return this.players;
    }


    public ChanceDeck getChanceDeck()
    {
        return this.chanceDeck;
    }



    public Field[] getFields()
    {
        return this.board.getFields();
    }


    public void movePlayer(Player player, int fieldsToMove)
    {
        Field oldField = this.board.getPlayerField(player);

        this.board.movePlayer(player, fieldsToMove);

        if (this.hasPlayerPassedStart(player, oldField)) {
            player.addBalance(2);
            this.gui.showMessage(player.getName() + Translate.t("kast.rollDie3"));
        }
    }


    public void movePlayer(Player player, String fieldName)
    {
        Field oldField = this.board.getPlayerField(player);

        Field moveToField = this.board.getFieldByName(fieldName);
        this.board.movePlayer(player, moveToField);

        if (! (oldField instanceof PrisonField) && !(moveToField instanceof PrisonField)) {
            if (this.hasPlayerPassedStart(player, oldField)) {
                player.addBalance(2);
                this.gui.showMessage(player.getName() + Translate.t("kast.rollDie3"));
            }
        }
    }


    /**
     * Brings a gui-dropdown menu to ask player how many are playing the game.
     * Choose between: 2, 3 or 4 players
     */

    private int choosePlayerAmountStringToInt(){

        String playerNumberString = this.gui.getUserSelection(Translate.t("welcome1.getNumberOfPlayer"),"2", "3", "4");

        int playerNumberInt = Integer.valueOf(playerNumberString);

        return playerNumberInt;
    }


    private void createPlayers(int numberOfPlayers)
    {
        ArrayList<String> types = new ArrayList<>(Arrays.asList(Player.Type.valuesToString()));

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = this.gui.getUserString(Translate.t("welcome2.getNamePlayer"));
            String type = this.gui.getUserSelection(Translate.t("type.whatplayer"), types.toArray(new String[] {}));

            types.remove(type);

            Player player = new Player(name, this.getStartAmount(numberOfPlayers));
            player.setType(Player.Type.toEnum(type));

            this.gui.addPlayer(player.getGuiPlayer());
            this.board.addPlayer(player);
            this.players.addPlayer(player);
        }
    }


    private int getStartAmount(int numberOfPlayers)
    {
        switch (numberOfPlayers) {
            case 2: return 20;
            case 3: return 18;
            case 4: return 16;
            default: return 20;
        }
    }


    /**
     * Brings a gui-dropdown menu to ask player who is youngest of the players.
     * The youngest player starts.
     * Takes in the int numberOfPlayers, and outputs an int.
     */

    private void youngestPlayerStarts(int countplayers){

        String playerNumberString = "";

        switch (countplayers) {

            case 2:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players.get(0).getName(), "2. " + this.players.get(1).getName());
                break;

            case 3:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players.get(0).getName(), "2. " + this.players.get(1).getName(), "3. " + this.players.get(2).getName());
                break;

            case 4:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players.get(0).getName(), "2. " + this.players.get(1).getName(), "3. " + this.players.get(2).getName(), "4. " + this.players.get(3).getName());
                break;
        }

        playerNumberString = playerNumberString.split("\\.", 2)[0];

        int a = Integer.parseInt(playerNumberString);

        this.players.setPlayerIndex(a - 1);
    }


    public void playRound(Player currentPlayer)
    {
        this.gui.getUserButtonPressed(Translate.t("kast.rollDie") + " "+ currentPlayer.getName() + Translate.t("kast.rollDie1"), "Kast");
        this.die.roll();

        int faceValue = this.die.getFaceValue();
        this.gui.setDie(faceValue);
        this.gui.showMessage(currentPlayer.getName() + Translate.t("kast.rollDie2") + " "+faceValue);

        this.movePlayer(currentPlayer, faceValue);

        Field field = this.board.getPlayerField(currentPlayer);
        field.runAction(this);

        if (this.players.isAnyBankrupt()) {
            Player bankruptPlayer = this.players.getBankruptPlayer();
            this.gui.showMessage(bankruptPlayer.getName() + Translate.t("end.game.bankrupt"));
            this.winnerFound = true;
        }
    }


    private boolean hasPlayerPassedStart(Player player, Field oldField)
    {
        Field newField = this.board.getPlayerField(player);

        return this.board.isFieldBefore(newField, oldField);
    }


    public static void main(String[] args)
    {
        new Game().play();
    }

}