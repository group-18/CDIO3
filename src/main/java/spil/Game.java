package spil;

import gui_fields.GUI_Player;
import gui_main.GUI;
import spil.Board.Board;

import java.util.ArrayList;


public class Game {

    private Board board;
    private GUI gui;
    private Player[] players;
    private int startamount;
    private boolean numberofplayersmet = false;
    private int playerIndex = 0;
    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());
    }


    public void play() {
        Player currentPlayer;
        criteriaMet();
        boolean winnerFound = false;

        do {
            currentPlayer = getNextPlayer();
            // Add Game Logic Here
            
        }
        while (!winnerFound);
    }

    private void criteriaMet() {
        do {
            int numberOfPlayers = this.gui.getUserInteger(Translate.t("welcome1.getNumberOfPlayer"));

            if (numberOfPlayers >= 2 && numberOfPlayers <= 4) {
                this.players = new Player[numberOfPlayers];
                for (int i = 0; i < players.length; i++) {
                    String name = this.gui.getUserString(Translate.t("welcome2.getNamePlayer"));
                    this.players[i] = new Player(name, smartStash(numberOfPlayers));
                    this.gui.addPlayer(this.players[i].getGuiPlayer());
                    numberofplayersmet=true;
                }
            }

            else {
                numberofplayersmet=false;
            }
        }
        while(!numberofplayersmet);
    }

    private int smartStash(int numberOfPlayers) {
        if (numberOfPlayers==2){
            return startamount=20;
        }
        if (numberOfPlayers==3){
            return startamount=18;
        }
        if (numberOfPlayers==4) {
            return startamount=16;
        }
        return startamount=20;
    }

    private Player getNextPlayer()
    {
        if (this.playerIndex >= this.players.length) {
            this.playerIndex = 0;
        }

        return this.players[this.playerIndex++];
    }


    public static void main(String[] args)
    {
        new Game().play();
    }

}