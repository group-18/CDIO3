package spil;

/**
 *
 */
public class Die {

    /**
     * The number of sides a Die has
     */
    private int numberOfSides;
    /**
     * The current value of the Die
     */
    private int faceValue;

    /**
     * Constructs a Die with 6 sides
     */
    public Die()
    {
        this(6);
    }

    /**
     * Constructs a die with any number of sides
     * @param numberOfSides The number of sides for the Die
     */
    public Die(int numberOfSides)
    {
        this.numberOfSides = numberOfSides;
    }

    /**
     * Roll this die.
     * This changes the faceValue
     */
    public void roll()
    {
        this.faceValue = (int) (Math.random() * this.numberOfSides) + 1;
    }

    /**
     * Get the current face value of this Die
     * @return The current face value for this Die
     */
    public int getFaceValue()
    {
        return this.faceValue;
    }

    /**
     * Get the number of sides for this Die
     * @return The number of sides for this Die
     */
    public int getNumberOfSides()
    {
        return this.numberOfSides;
    }

}
