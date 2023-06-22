package org.example;
public class Listener {
    Coordinates coordinates;
    boolean is_hearing;
    Listener(Coordinates coordinates)
    {
    this.coordinates=coordinates;
    }
    Listener()
    {
        this.coordinates=new Coordinates(0,0);
    }
}
