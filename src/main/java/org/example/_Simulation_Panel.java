package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for the painting drawings
 */
public class _Simulation_Panel extends JPanel {
    /**
     * Class attribute local_SS_X, temporary Sound Source x coordinate
     */
    private int local_SS_X = 0;
    /**
     * Class attribute local_SS_Y, temporary Sound Source y coordinate
     */
    private int local_SS_Y = 0;
    /**
     * Class attribute local_L_X, temporary Listener x coordinate
     */
    private int local_L_X = 0;
    /**
     * Class attribute local_L_Y, temporary Listener y coordinate
     */
    private int local_L_Y = 0;
    /**
     * Class attribute local_DL_X, temporary Dynamic Listener x coordinate
     */
    private int local_DL_X=0;
    /**
     * Class attribute local_DL_Y, temporary Dynamic Listener y coordinate
     */
    private int local_DL_Y=0;
    /**
     * Class attribute local_diameter, temporary diameter of Sound Source
     */
    private int local_diameter = 0;
    /**
     * Class attribute local_diameter_listener, temporary diameter of listener
     */
    private int local_diameter_listener = 0;
    /**
     * Class attribute local_wave_velocity, temporary velocity of wave
     */
    private double local_wave_velocity = 0;
    /**
     * Class attribute waveRadius
     */
    private int waveRadius=0;
    /**
     * Class attribute sizeDynamic
     */
    private int sizeDynamic=0;
    /**
     * Class attribute sizeStatic
     */
    private int sizeStatic=0;
    /**
     * List of wave points.
     */
    private ArrayList<Point> localPoint = new ArrayList<>();
    /**
     * List of dynamic listeners.
     */
    private ArrayList<DynamicListener> localDynamicListener = new ArrayList<>();
    /**
     * List of static listeners.
     */
    private ArrayList<Listener> localListener = new ArrayList<>();
    /**
     * List of dynamic listeners.
     */
    private ArrayList<Coordinates> local_DL = new ArrayList<>();
    /**
     * List of static listeners.
     */
    private ArrayList<Coordinates> local_L = new ArrayList<>();
    /**
     * List of wave points.
     */
    private ArrayList<Point> points = new ArrayList<>();

    /**
     * Instantiates a new Simulation panel.
     */
    _Simulation_Panel() {
    }

    /**
     * Pretimer methode responsible for assign temporary values, make timer action and start timer
     *
     * @param soundSource       the sound source
     * @param wave              the wave
     * @param diameter          the diameter
     * @param diameter_listener the diameter listener
     * @param wavePoints        the wave points
     * @param dynamicListener   the dynamic listener
     * @param listener          the listener
     */
    protected void pretimer(SoundSource soundSource, Wave wave, int diameter, int diameter_listener, ArrayList<Point> wavePoints, ArrayList<DynamicListener> dynamicListener, ArrayList<Listener> listener)
    {
        double time = (10/ wave.frequency);

        //Creating a timer
        Timer timer = new Timer((int) time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Assigning temporary values
                local_SS_X = soundSource.coordinates.x_coordinate;
                local_SS_Y = soundSource.coordinates.y_coordinate;
                local_wave_velocity = wave.velocity;
                local_diameter = diameter;
                local_diameter_listener = diameter_listener;
                ArrayList<Point> localPoint = new ArrayList<>(wavePoints);
                ArrayList<Listener> localListener = new ArrayList<>(listener);
                localPoint.add(new Point(soundSource.coordinates.x_coordinate + diameter / 2, soundSource.coordinates.y_coordinate + diameter / 2));
                ArrayList<DynamicListener> localDynamicListener = new ArrayList<>(dynamicListener);
                sizeStatic=localListener.size();
                sizeDynamic= localDynamicListener.size();
                for (Listener value : dynamicListener)
                {
                    Coordinates cordy = new Coordinates(0,0);
                    cordy.x_coordinate=value.coordinates.x_coordinate;
                    cordy.y_coordinate=value.coordinates.y_coordinate;
                    local_DL.add(cordy);
                }
                for (Listener value : listener)
                {
                    Coordinates cordy2 = new Coordinates(0,0);
                    cordy2.x_coordinate=value.coordinates.x_coordinate;
                    cordy2.y_coordinate=value.coordinates.y_coordinate;
                    local_L.add(cordy2);
                }
                for (Point value : localPoint)
                {
                    Point point = new Point(0,0);
                    point.x=value.x;
                    point.y=value.y;
                    points.add(point);
                }

                //updating sound source velocity and coordinates
                soundSource.velocity += soundSource.velocity * soundSource.acceleration;
                soundSource.coordinates.x_coordinate += soundSource.velocity;

                //updating dynamic listener velocity
                for (int i=0; i<dynamicListener.size(); i++)
                {
                    dynamicListener.get(i).coordinates.x_coordinate += dynamicListener.get(i).velocity;
                }
                repaint();
                //condition for reset coordinates
                if (soundSource.coordinates.x_coordinate + diameter > getWidth())
                {
                    soundSource.coordinates.x_coordinate = 0;
                    wavePoints.clear();
                }

            }
        });
        timer.start();
    }

    //method responsible for painting sound source, wave, listeners and dynamic listeners
    @Override
    protected void paintComponent(Graphics circles)
    {
        super.paintComponent(circles);
        Graphics2D circles2d = (Graphics2D) circles;
        //ANTIALIASING
        circles2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        circles2d.setColor(Color.BLACK);
        circles2d.fillOval(local_SS_X, local_SS_Y, local_diameter, local_diameter);
        circles.setColor(Color.BLUE);
        for (Point point : points)
        {
            waveRadius = (int) (local_wave_velocity * Math.sqrt((local_SS_X + local_diameter / 2 - point.x) * (local_SS_X + local_diameter / 2 - point.x) + (local_SS_Y + local_diameter / 2 - point.y) * (local_SS_Y + local_diameter / 2 - point.y)));
            circles.drawOval(point.x - waveRadius, point.y - waveRadius, 2 * waveRadius, 2 * waveRadius);
        }
        circles.setColor(Color.GREEN);
        for (Coordinates value : local_DL)
        {
            local_DL_X = value.x_coordinate;
            local_DL_Y = value.y_coordinate;

            circles2d.fillOval(local_DL_X, local_DL_Y, local_diameter_listener, local_diameter_listener);

            //if (local_DL_X <= local_SS_X + waveRadius)
            //{
            //    circles.setColor(Color.RED);
            //}
        }
        for (Coordinates value : local_L)
        {
            local_L_X = value.x_coordinate;
            local_L_Y = value.y_coordinate;

            circles.fillOval(local_L_X, local_L_Y, local_diameter_listener, local_diameter_listener);

            //if (local_L_X <= local_SS_X + waveRadius)
            //{
            //    circles.setColor(Color.RED);
            //}
        }
    }
}

