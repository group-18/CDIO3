package spil;

import gui_fields.GUI_Player;
import gui_main.GUI;
import spil.Board.Board;

import java.util.ArrayList;


public class Game {

    private Board board;
    private GUI gui;
    private Player players[];
    public int startamount=30;

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
            players[i] = new Player(name, startamount);
            this.gui.addPlayer(players[i].getGuiPlayer());
        }




    }


    public static void main(String[] args)
    {
        new Game().play();
    }

}