package org.example;
import static org.example.Space.*;
public class Main {
    static int x_coordinate;
    static int y_coordinate;
    static double frequency;
    static double velocity;
    static double acceleration;
    Coordinates coordinates;
    Wave wave;
    Listener listener;
    MovingListener movingListener;
    SoundSource soundSource;
    public static void main(String[] args)
    {
        Wave wave = new Wave(frequency, velocity);
        SoundSource soundsource = new SoundSource(velocity,acceleration,new Coordinates(x_coordinate,y_coordinate));
        _Menu _menu = new _Menu();
        Introduction();
        Create_Space();
        Space przestrzen = new Space();
        przestrzen.Creation();
        System.out.println();
    }
}