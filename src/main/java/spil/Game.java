package spil;

import gui_fields.GUI_Player;
import gui_main.GUI;
import spil.Board.Board;

import java.util.ArrayList;


public class Game {

    private Board board;
    private GUI gui;


    private Game()
    {
        this.board = new Board();
        this.gui = new GUI(this.board.getGuiFields());
    }


    public void play()
    {
        int numberOfPlayers = this.gui.getUserInteger("<PLACEHOLDER> min. 2, max 4",2,4);
        ArrayList<Player> player = new ArrayList<>();
        



    }


    public static void main(String[] args)
    {
        new Game().play();
    }

}