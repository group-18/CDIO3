package spil;

import gui_main.GUI;
import spil.Board.Board;
import spil.Board.Field;

public class Game {

    private Board board;
    private GUI gui;

    private Die die;

    private Player[] players;
    private Player currentPlayer;
    private int playerIndex = 0;


    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());
        this.die = new Die();
    }


    public void play()
    {
        int numberOfPlayers = choosePlayerAmountStringToInt();

        this.createPlayers(numberOfPlayers);

        youngestPlayerStarts(numberOfPlayers);

        boolean winnerFound = false;

        do {
            this.currentPlayer = getNextPlayer();
            // Add Game Logic Here
            playRound();
        } while (! winnerFound);
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

        if (this.hasPlayerPassedStart(player, oldField)) {
            player.addBalance(2);
            this.gui.showMessage(player.getName() + Translate.t("kast.rollDie3"));
        }
    }



    private int choosePlayerAmountStringToInt(){

        String playerNumberString = this.gui.getUserSelection(Translate.t("welcome1.getNumberOfPlayer"),"2", "3", "4");

        int playerNumberInt = Integer.valueOf(playerNumberString);

        return playerNumberInt;
    }


    private void createPlayers(int numberOfPlayers)
    {
        this.players = new Player[numberOfPlayers];

        for (int i = 0; i < this.players.length; i++) {
            String name = this.gui.getUserString(Translate.t("welcome2.getNamePlayer"));

            this.players[i] = new Player(name, this.getStartAmount(numberOfPlayers));
            this.players[i].setType(this.gui.getUserSelection(Translate.t("type.whatplayer"), "cat", "dog", "boat", "dog"));
            this.gui.addPlayer(this.players[i].getGuiPlayer());
            this.board.addPlayer(this.players[i]);
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
        this.gui.getUserButtonPressed(Translate.t("kast.rollDie"), "Kast");
        this.die.roll();

        int faceValue = this.die.getFaceValue();
        this.gui.setDie(faceValue);
        this.gui.showMessage(this.currentPlayer.getName() + Translate.t("kast.rollDie2") + faceValue);

        this.movePlayer(this.currentPlayer, faceValue);

        Field field = this.board.getPlayerField(currentPlayer);
        field.runAction(currentPlayer);
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