package spil;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    //Alle test på nær getNumberOfSides er fra vores forige rapport CDIO1. Vi har dog lavet en ny unit test på getNumberOfSides,
    // da det var et krav at man skal nemt kunne skifte terning.

    private Dice dice;

    //Makes a dice for testing
    @Before
    public void setUp() throws Exception {
        this.dice = new Dice(6);
    }

    //Testing the roll will give a value that is >=1 and <=6
    @Test
    public void roll() throws Exception {
        this.dice.roll();

        assertTrue("Dice faceValue to low", this.dice.getFaceValue() >= 1);
        assertTrue("Dice faceValue to high", this.dice.getFaceValue() <= 6);
    }

    @Test
    public void getNumberOfEyes() throws Exception {
        assertEquals(6, this.dice.getNumberOfSides());
    }

    //Testing the statistical probability of the dice (even distribution between 1 and 6).
    @Test
    public void rollMany() {
        Dice dice = new Dice();

        int numberOfRolls = 60000;
        int numberOfEyes = dice.getNumberOfSides();

        int[] rolls = new int[numberOfEyes];

        for (int i = 0; i < numberOfRolls; i++) {
            dice.roll();

            rolls[dice.getFaceValue() - 1]++;
        }

        int failureRate = 400;
        int minFailureRate = (numberOfRolls / numberOfEyes) - failureRate;
        int maxFailureRate = (numberOfRolls / numberOfEyes) + failureRate;

        for (int i = 0; i < rolls.length; i++) {
            assertTrue("Der er for få " + i + "'er " + rolls[i], rolls[i] > minFailureRate);
            assertTrue("Der er for mange " + i + "'er " + rolls[i], rolls[i] < maxFailureRate);
        }
    }

    //Testing the statistical probability of the sum of the dices.
    @Test
    public void rollCountMultiple() {
        int numberOfDies = 2;
        int numberOfRolls = 60000;

        Dice d1 = new Dice();
        Dice d2 = new Dice();

        int[] rolls = new int[numberOfDies * 6 + 1];

        for (int i = 0; i < numberOfRolls; i++) {
            d1.roll();
            d2.roll();

            int sum = d1.getFaceValue() + d2.getFaceValue();

            rolls[sum]++;
        }

        double oneRollPercent = (double) 100 / numberOfRolls;

        double totalPercentage = 0;
        double failureRate = 0.75;
        for (int i = numberOfDies; i < rolls.length; i++) {
            double percentage = (double) rolls[i] * oneRollPercent;
            double expectedPercentage = this.numPossibilities(numberOfDies, i) * (100.0 / 36.0);

            assertTrue("Sum " + i + " med sandsynlighed " + percentage + "% er for lav, min. " + (expectedPercentage - failureRate) + "%", percentage >= expectedPercentage - failureRate);
            assertTrue("Sum " + i + " med sandsynlighed " + percentage + "% er for høj, max. " + (expectedPercentage + failureRate) + "%", percentage <= expectedPercentage + failureRate);

            totalPercentage += percentage;
        }

        assertTrue("Summen giver ikke 100% +- 1% : " + totalPercentage, totalPercentage >= 99 && totalPercentage <= 101);
    }

    private int numPossibilities(int numDice, int sum) {
        if (numDice == sum) {
            return 1;
        } else if (numDice == 0 || sum < numDice) {
            return 0;
        } else {
            return this.numPossibilities(numDice, sum - 1) +
                    this.numPossibilities(numDice - 1, sum - 1) -
                    this.numPossibilities(numDice - 1, sum - 7);
        }
    }
}