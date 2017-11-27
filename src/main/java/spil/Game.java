package spil;

import gui_fields.GUI_Player;
import gui_main.GUI;
import spil.Board.Board;

import java.util.ArrayList;


public class Game {

    private Board board;
    private GUI gui;
    private Player players[];
    private int startamount;
    private boolean numberofplayersmet = false;
    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());
    }


    public void play() {

        criteriaMet();

        do {
            // Add Game Logic Here
            
        }
        while (players[1].bankrupt());
    }

    private void criteriaMet() {
        do {
            int numberOfPlayers = this.gui.getUserInteger(Translate.t("welcome1.getNumberOfPlayer"));

            if (numberOfPlayers >= 2 && numberOfPlayers <= 4) {
                Player[] players = new Player[numberOfPlayers];
                for (int i = 0; i < players.length; i++) {
                    String name = this.gui.getUserString(Translate.t("welcome2.getNamePlayer"));
                    players[i] = new Player(name, smartStash(numberOfPlayers));
                    this.gui.addPlayer(players[i].getGuiPlayer());
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


    public static void main(String[] args)
    {
        new Game().play();
    }

}