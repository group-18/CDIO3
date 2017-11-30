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

    private Player[] players;
    private Player currentPlayer;
    private int playerIndex = 0;
    private boolean winnerFound = false;


    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());
        this.die = new Die();
        this.chanceDeck = new ChanceDeck();
    }


    public void play()
    {
        int numberOfPlayers = choosePlayerAmountStringToInt();

        this.createPlayers(numberOfPlayers);

        youngestPlayerStarts(numberOfPlayers);

        do {
            this.currentPlayer = getNextPlayer();
            // Add Game Logic Here
            playRound();
        } while (! this.winnerFound);
    }


    public GUI getGui()
    {
        return this.gui;
    }


    public ChanceDeck getChanceDeck()
    {
        return this.chanceDeck;
    }


    public Player getCurrentPlayer()
    {
        return this.currentPlayer;
    }


    public Player[] getPlayers()
    {
        return this.players;
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
        this.players = new Player[numberOfPlayers];

        ArrayList<String> types = new ArrayList<>(Arrays.asList(Player.Type.valuesToString()));

        for (int i = 0; i < this.players.length; i++) {
            String name = this.gui.getUserString(Translate.t("welcome2.getNamePlayer"));
            String type = this.gui.getUserSelection(Translate.t("type.whatplayer"), types.toArray(new String[] {}));

            types.remove(type);

            Player player = new Player(name, this.getStartAmount(numberOfPlayers));
            player.setType(Player.Type.toEnum(type));

            this.gui.addPlayer(player.getGuiPlayer());
            this.board.addPlayer(player);

            this.players[i] = player;
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


    private Player getNextPlayer()
    {
        if (this.playerIndex >= this.players.length) {
            this.playerIndex = 0;
        }

        return this.players[this.playerIndex++];
    }


    /**
     * Brings a gui-dropdown menu to ask player who is youngest of the players.
     * The youngest player starts.
     * Takes in the int numberOfPlayers, and outputs an int.
     */

    private void youngestPlayerStarts(int countplayers){

        String playerNumberString = "";

        switch (countplayers) {

            case 2:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players[0].getName(), "2. " + this.players[1].getName());
                break;

            case 3:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players[0].getName(), "2. " + this.players[1].getName(), "3. " + this.players[2].getName());
                break;

            case 4:  playerNumberString = this.gui.getUserSelection(Translate.t("welcome3.getYoungestPlayer"), "1. " + this.players[0].getName(), "2. " + this.players[1].getName(), "3. " + this.players[2].getName(), "4. " + this.players[3].getName());
                break;
        }

        playerNumberString = playerNumberString.split("\\.", 2)[0];

        int a = Integer.parseInt(playerNumberString);

        this.playerIndex = a - 1;
    }


    public void playRound()
    {
        this.gui.getUserButtonPressed(Translate.t("kast.rollDie") + " "+ currentPlayer.getName() + Translate.t("kast.rollDie1"), "Kast");
        this.die.roll();

        int faceValue = this.die.getFaceValue();
        this.gui.setDie(faceValue);
        this.gui.showMessage(this.currentPlayer.getName() + Translate.t("kast.rollDie2") + " "+faceValue);

        this.movePlayer(this.currentPlayer, faceValue);

        Field field = this.board.getPlayerField(currentPlayer);
        field.runAction(this);
        isCurrentPlayerBankupt();
    }

    /**
     * Checks if player is bankrupt, and if true:
     * changes winnerfound & outputs message
     */

    public void isCurrentPlayerBankupt()
    {
        if(currentPlayer.getBalance() <= 0)
            {
                this.gui.showMessage(this.currentPlayer.getName() + Translate.t("end.game.bankrupt"));
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