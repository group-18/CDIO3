package spil;
import gui_main.GUI;


public class Main {

    public static void main(String[] args) {
        //The game-object is created

      Game game = new Game();

      //The askForPlayer() can be changed if more players are needed to play the game

/**
        int amountOfPlayers = gui.getUserInteger("Indtast antal spillere: ");

        if (amountOfPlayers >= 2 && amountOfPlayers <= 4) {
            game.askForPlayers(amountOfPlayers);
        } else {
            amountOfPlayers = gui.getUserInteger("Ikke tilladt! Indtast antal spillere: ");
        }
*/
        int amountOfPlayers = 2;
        game.askForPlayers(amountOfPlayers);
        //the Game-class contains the game, and the the method play() plays it
        game.play();

      //Board.boardgame(null);

    }
}