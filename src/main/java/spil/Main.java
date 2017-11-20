package spil;

import gui_main.GUI;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        GUI gui = new GUI(board.getFields());

        Game game = new Game(gui, board);


        //The game-object is created

      /*  Game game = new Game();

        GUI gui = new GUI();

        //The askForPlayer() can be changed if more players are needed to play the game
        //game.askForPlayers(2);

        int amountOfPlayers = gui.getUserInteger("Indtast antal spillere: ");

        if (amountOfPlayers >= 2 && amountOfPlayers <= 4) {
            game.askForPlayers(amountOfPlayers);
        } else {
            amountOfPlayers = gui.getUserInteger("Ikke tilladt! Indtast antal spillere: ");
        }

        game.askForPlayers(amountOfPlayers);
        //the Game-class contains the game, and the the method play() plays it
        game.play();
*/

    }
}