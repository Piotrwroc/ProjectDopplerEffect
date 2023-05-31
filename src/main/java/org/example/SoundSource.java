package org.example;

public class SoundSource {
    double velocity;
    double acceleration;
    int current_x; //tymczasowe
    int current_y; //tymczasowe
    Coordinates coordinates;
    Wave wave;
     SoundSource(double velocity,  double acceleration, Coordinates coordinates)
     {
         this.velocity = velocity;
         this.acceleration = acceleration;
         this.coordinates = coordinates;
     }
}
