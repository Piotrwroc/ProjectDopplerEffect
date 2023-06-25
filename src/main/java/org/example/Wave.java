package org.example;

/**
 * Class responsible for wave parameters
 */
public class Wave {
    /**
     * Wave frequency
     */
    protected double frequency;
    /**
     * Wave velocity
     */
    protected double velocity;
    /**
     * Instantiates a new Wave
     */
    Wave()
    {
        this.frequency = 1;
        this.velocity=343;
    }
    /**
     * Instantiates a new Wave
     *
     * @param frequency the frequency
     */
    Wave(double frequency)
    {
        this.frequency = frequency;
        this.velocity=343;
    }
    /**
     * Instantiates a new Wave.
     *
     * @param frequency the frequency
     * @param velocity  the velocity
     */
    Wave(double frequency, double velocity)
    {
        this.frequency = frequency;
        this.velocity=velocity;
    }
}
