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
    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());
    }


    public void play()
    {
        int numberOfPlayers = this.gui.getUserInteger("<PLACEHOLDER> min. 2, max 4",2,4);
        Player[] players = new Player[numberOfPlayers];
        for (int i=0; i<players.length;i++){
            String name = this.gui.getUserString("<PLACEHOLDER> name");
            players[i] = new Player(name, smartStash(numberOfPlayers));
            this.gui.addPlayer(players[i].getGuiPlayer());
        }

        smartStash(numberOfPlayers);


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