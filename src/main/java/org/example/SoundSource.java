package org.example;

/**
 * Class responsible for sound source parameters
 */
public class SoundSource {
    /**
     * Sound source velocity
     */
    protected double velocity;
    /**
     * Sound source acceleration
     */
    protected double acceleration;
    /**
     * Sound source coordinates
     */
    protected Coordinates coordinates;
    /**
     * Instantiates a new Sound source
     *
     * @param velocity     the velocity
     * @param acceleration the acceleration
     * @param coordinates  the coordinates
     */
    SoundSource(double velocity,  double acceleration, Coordinates coordinates)
    {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.coordinates = coordinates;
    }
}
