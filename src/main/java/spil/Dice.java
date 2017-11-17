package spil;


public class Dice {
    private int faceValue;
    private int numberOfSides;

    public Dice()
    {
        this.numberOfSides = 6;
    }

    //This constructor makes it able to change the number of eyes on the die.
    public Dice(int numberOfEyes)
    {
        this.numberOfSides = numberOfEyes;
    }

    public int getNumberOfSides()
    {
        return this.numberOfSides;
    }

    public int getFaceValue()
    {
        return this.faceValue;
    }

    //Rolls the die, using the numberOfSides as factor, so that it will work for different dies.
    public void roll()
    {
        this.faceValue = (int) (Math.random() * this.numberOfSides) + 1;
    }
}