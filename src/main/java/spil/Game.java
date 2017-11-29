package spil;

import gui_main.GUI;
import spil.Board.Board;
import spil.Board.Field;


public class Game {

    private Board board;
    private GUI gui;

    private Die die;

    private Player[] players;
    private int playerIndex = 0;


    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());
        this.die = new Die();
    }


    public void play()
    {
        int numberOfPlayers = this.gui.getUserInteger(Translate.t("welcome1.getNumberOfPlayer"), 2, 4);

        this.createPlayers(numberOfPlayers);

        Player currentPlayer;
        boolean winnerFound = false;

        do {
            currentPlayer = getNextPlayer();
            // Add Game Logic Here
            playRound(currentPlayer);
        } while (! winnerFound);
    }


    private void createPlayers(int numberOfPlayers)
    {
        this.players = new Player[numberOfPlayers];

        for (int i = 0; i < this.players.length; i++) {
            String name = this.gui.getUserString(Translate.t("welcome2.getNamePlayer"));

            this.players[i] = new Player(name, this.getStartAmount(numberOfPlayers));
            this.players[i].setType(this.gui.getUserSelection("<PLACEHOLDER> type of player", "cat", "dog", "boat", "dog"));
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


    public void playRound(Player currentPlayer)
    {
        this.gui.getUserButtonPressed(Translate.t("kast.rollDie"), "Kast");
        this.die.roll();

        int faceValue = this.die.getFaceValue();
        this.gui.setDie(faceValue);
        this.gui.showMessage("Du kastede: " + faceValue);
        
        Field oldField = this.board.getPlayerField(currentPlayer);

        this.board.movePlayer(currentPlayer, faceValue);

        if (this.hasPlayerPassedStart(currentPlayer, oldField)) {
            // Player has passed start.
            currentPlayer.addBalance(2);
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