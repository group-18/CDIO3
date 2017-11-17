package spil;
import desktop_resources.GUI;


public class Main {
    public static void main(String[] args) {
        //The game-object is created
        Game game = new Game();
        //The askForPlayer() can be changed if more players are needed to play the game
        //game.askForPlayers(2);

        int amountOfPlayers = GUI.getUserInteger("Indtast antal spillere: ");

        if (amountOfPlayers >= 2 && amountOfPlayers <= 4) {
            game.askForPlayers(amountOfPlayers);
        } else {
            amountOfPlayers = GUI.getUserInteger("Ikke tilladt! Indtast antal spillere: ");
        }

        game.askForPlayers(amountOfPlayers);
        //the Game-class contains the game, and the the method play() plays it
        game.play();
    }
}