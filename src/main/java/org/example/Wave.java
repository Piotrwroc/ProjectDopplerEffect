package org.example;

public class Wave {
double frequency;
double velocity;
    Wave()
    {
        this.frequency = 1;
        this.velocity=343;
    }
    Wave(double frequency)
    {
        this.frequency = frequency;
        this.velocity=343;
    }
    Wave(double frequency, double velocity)
    {
        this.frequency = frequency;
        this.velocity=velocity;
    }
}
