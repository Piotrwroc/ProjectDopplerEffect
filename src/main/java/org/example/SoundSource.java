package org.example;

public class SoundSource {
    double velocity;
    double acceleration;
    Coordinates coordinates;
    Wave wave;
     SoundSource(double velocity,  double acceleration, Coordinates coordinates)
     {
         this.velocity = velocity;
         this.acceleration = acceleration;
         this.coordinates = coordinates;
     }
}
