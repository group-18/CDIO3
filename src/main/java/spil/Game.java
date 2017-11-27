package spil;

import gui_main.GUI;
import spil.Board.Board;


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

    }


    public static void main(String[] args)
    {
        new Game().play();
    }

}