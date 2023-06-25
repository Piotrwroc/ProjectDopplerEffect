package org.example;

/**
 * Class responsible for static listener
 */
public class Listener {
    /**
     * listener coordinates
     */
    protected Coordinates coordinates;

    /**
     * Instantiates a new Listener
     *
     * @param coordinates the coordinates
     */
    Listener(Coordinates coordinates)
    {
        this.coordinates=coordinates;
    }

    /**
     * Instantiates a new Listener
     */
    Listener()
    {
        this.coordinates=new Coordinates(0,0);
    }
}
