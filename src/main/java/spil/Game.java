package spil;

import gui_main.GUI;
import gui_fields.*;
import gui_codebehind.Observable;
import gui_resources.Attrs;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Type;
import java.util.HashMap;

import static gui_fields.GUI_Car.*;
import static gui_fields.GUI_Car.Pattern.FILL;
import static gui_fields.GUI_Car.Type.CAR;
import static java.awt.Color.*;

public class Game {

    private GUI gui;

    private Board board;

    private HashMap<Integer, JLabel> cars = new HashMap<>();
    private Dice[] dies;

    private Player[] players;
    private int playerIndex = 0;

    private Translate translate;

    private GUI_Car car;

    private String[][] fields = new String[][] {
        {"burgerbaren", "Burgerbaren"},
        {"pizzeriaet", "Pizzeriaet"},
        {"chance", "Chance"},
        {"slikbutikken", "Slikbutikken"},
        {"iskiosken", "Iskiosken"},
        {"chance", "Chance"},
        {"museet", "Museet"},
        {"biblioteket", "Biblioteket"},
        {"chance", "Chance"},
        {"skaterparken", "Skaterparken"},
        {"swimmingpoolen", "Swimmingpoolen"},
        {"gratisparkering", "Gratis parkering"},
        {"spillehallen", "Spillehallen"},
        {"biografen", "Biografen"},
        {"chance", "Chance"},
        {"legetøjsbutikken", "Legetøjsbutikken"},
        {"dyrehandlen", "Dyrehandlen"},
        {"chance", "Chance"},
        {"bowlinghallen", "Bowlinghallen"},
        {"zoo", "Zoo"},
        {"chance", "Chance"},
        {"vandlandet", "Vandlandet"},
        {"strandpromenaden", "Strandpromenaden"},
    };


    private int[] fieldValues = new int[]{
            1,
            1,
            0,
            1,
            1,
            0,
            2,
            2,
            0,
            2,
            2,
            0,
            3,
            3,
            0,
            3,
            3,
            0,
            4,
            4,
            0,
            5,
            5,
    };

    public Game(GUI gui, Board board)
    {
        this.gui = gui;
        this.board = board;

        this.translate = new Translate("da_DK");
        this.dies = new Dice[]{new Dice()};

    }

    public void askForPlayers(int numberOfPlayers)
    {
        this.players = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = gui.getUserString(
                    this.translate.t("writeName", new String[] {"" + (i + 1)})
            );

            this.players[i] = new Player(playerName, numberOfPlayers);

            gui.addPlayer(new GUI_Player(this.players[i].getName(), this.players[i].getAmount()));
            this.car = new GUI_Car(Color.YELLOW,Color.BLUE,CAR,Pattern.FILL);

        }
    }

    public void play() {
        this.printWelcomeMessage();

        Player currentPlayer;
        boolean winnerFound;

        do {
            currentPlayer = getNextPlayer();

            this.print(this.translate.t("turn.currentPlayer", new String[] {currentPlayer.getName()}));

            //Adds a button that executes the following do-while-statement, remove this for easy unittesting
            gui.getUserButtonPressed("", "Kast");

            do {
                this.rollDies();

                gui.setDie(this.dies[0].getFaceValue());

                int fieldNumber = this.sum();
                GUI_Street field = this.board.getField(fieldNumber);
                field.setCar(currentPlayer, true);
                // Do stuff with field here :-)

                this.print(new String[] {
                        this.translate.t("turn.rollResult", new String[] {"" + sum()}),
                        this.translate.t("turn.position", new String[] {this.fields[fieldNumber][1]}),
                        this.translate.t("field." + this.fields[fieldNumber][0] + ".description"),
                });

                int score = this.fieldValues[fieldNumber];
                currentPlayer.addAmount(score);
                currentPlayer.setBalance(currentPlayer.getAmount());

                this.print(new String[] {
                    this.translate.t("turn.score", new String[] {"" + (score > 0 ? "+" : "") + score}),
                    this.translate.t("turn.scoreCurrent", new String[] {"" + currentPlayer.getAmount()}),
                });
                //GUI_Player.setBalance(currentPlayer.getName(),currentPlayer.getAmount());
                //GUI_Player.setBalance(currentPlayer.getAmount());
                currentPlayer.getBalance();
            } while (this.sum() == 10);

            winnerFound = currentPlayer.getAmount() >= 3000;
        } while (! winnerFound);

        this.printScoreBoard(currentPlayer);
    }

    private Player getNextPlayer()
    {
        if (this.playerIndex >= this.players.length) {
            this.playerIndex = 0;
        }

        return this.players[this.playerIndex++];
    }

    private void printWelcomeMessage(){
        this.print(this.translate.t("welcome1"));
        this.print(this.translate.t("welcome2"));
        this.print(this.translate.t("welcome3"));
    }

    private void printScoreBoard(Player winningPlayer)
    {
        String[] scoreboardText = new String[this.players.length + 2];

        scoreboardText[0] = this.translate.t("scoreboard.title");

        for (int i = 1; i <= this.players.length; i++) {
            Player player = this.players[i - 1];

            scoreboardText[i] = " - " + player.getName() + ": " + player.getAmount();

            if (player == winningPlayer) {
                scoreboardText[i] = scoreboardText[i] + " " + this.translate.t("scoreboard.winnerText");
            }
        }

        scoreboardText[this.players.length + 1] = this.translate.t("scoreboard.winner", new String[] {winningPlayer.getName()});

        this.print(String.join("\n", scoreboardText));
    }


    private int sum()
    {
        int sum = 0;

        for (Dice dice : this.dies) {
            sum += dice.getFaceValue();
        }

        return sum;
    }


    private void rollDies()
    {
        for (Dice dice : this.dies) {
            dice.roll();
        }
    }


    private void print(String msg)
    {
        gui.showMessage(msg);
    }


    private void print(String[] messages)
    {
        this.print(String.join("\n", messages));
    }

}