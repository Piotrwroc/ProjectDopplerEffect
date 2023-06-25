package org.example;

/**
 * Class responsible for moving listener
 */
public class DynamicListener extends Listener{
    /**
     * moving listener velocity
     */
    protected double velocity;

    /**
     * Instantiates a new Dynamic listener
     *
     * @param velocity the velocity
     */
    DynamicListener(double velocity)
    {
        this.velocity=velocity;
    }
}
