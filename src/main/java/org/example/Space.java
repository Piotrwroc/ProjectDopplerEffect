package org.example;
import java.util.Scanner;
public class Space {
    int x_coordinate;
    int y_coordinate;
    double frequency;
    double velocity;
    double acceleration;
    Coordinates coordinates;
    Wave wave;
    Listener listener;
    MovingListener movingListener;
    SoundSource soundSource;
    Scanner scanner = new Scanner(System.in);
    int choose;
    Space(Coordinates coordinates)
    {
        this.coordinates=coordinates;
    }
    public void Wave_parameters()
    {
        System.out.println("Enter wave frequency and velocity: ");
        Wave wave = new Wave(frequency, velocity);
        wave.frequency = Double.parseDouble(scanner.nextLine());
        wave.velocity = Double.parseDouble(scanner.nextLine());
    }
    public void Create_SoundSource()
    {
        System.out.println("Enter Sound Source velocity, acceleration x and y coordinates : ");
        SoundSource soundsource = new SoundSource(velocity,acceleration,new Coordinates(x_coordinate,y_coordinate));
        soundsource.velocity = Double.parseDouble(scanner.nextLine());
        soundsource.acceleration = Double.parseDouble(scanner.nextLine());
        soundsource.coordinates.x_coordinate = Integer.parseInt(scanner.nextLine());
        soundsource.coordinates.y_coordinate = Integer.parseInt(scanner.nextLine());
    }
    public void Create_Listener()
    {
        boolean condition=true;
        while(condition)
        {
            System.out.println("Choose type of listener");
            System.out.println("(1)static listener");
            System.out.println("(2)dynamic listener");
            System.out.println("(3)end adding listeners");
            choose= Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.println("Enter listener x and y coordinates: ");
                    Listener listener1 = new Listener(new Coordinates(x_coordinate, y_coordinate));
                    listener1.coordinates.x_coordinate = Integer.parseInt(scanner.nextLine());
                    listener1.coordinates.y_coordinate = Integer.parseInt(scanner.nextLine());
                }
                case 2 -> {
                    System.out.println("Enter listener x and y coordinates and velocity: ");
                    MovingListener movinglistener1 = new MovingListener(velocity);
                    movinglistener1.coordinates.x_coordinate = Integer.parseInt(scanner.nextLine());
                    movinglistener1.coordinates.y_coordinate = Integer.parseInt(scanner.nextLine());
                    movinglistener1.velocity = Double.parseDouble(scanner.nextLine());
                }
                default -> {
                    condition=false;
                }
            }
        }
    }
    Space()
    {
        this.x_coordinate=2000; //TODO test
        this.y_coordinate=1000;
    }
    public void Creation()
    {
        Wave_parameters();
        Create_SoundSource();
        Create_Listener();
    }
    public static void Create_Space()
    {
        Space space = new Space();
    }
    public static void Introduction()
    {

    }
}
