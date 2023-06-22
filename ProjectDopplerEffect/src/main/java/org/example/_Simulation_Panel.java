package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class _Simulation_Panel extends JPanel {
    int local_SS_X = 0;
    int local_SS_Y = 0;
    int local_L_X = 0;
    int local_L_Y = 0;
    int local_DL_X=0;
    int local_DL_Y=0;
    int local_diameter = 0;
    int local_diameter_listener = 0;
    double local_wave_velocity = 0;
    double local_listener_velocity=0;
    int waveRadius=0;
    int sizeDynamic=0;
    int sizeStatic=0;
    ArrayList<Point> localPoint = new ArrayList<>();
    ArrayList<DynamicListener> localDynamicListener = new ArrayList<>();
    ArrayList<Listener> localListener = new ArrayList<>();
    ArrayList<Coordinates> local_DL = new ArrayList<>();
    ArrayList<Coordinates> local_L = new ArrayList<>();
    ArrayList<Point> points = new ArrayList<>();
    _Simulation_Panel() {
    }

    public void pretimer(SoundSource soundSource, Wave wave, int diameter, int diameter_listener, ArrayList<Point> wavePoints, ArrayList<DynamicListener> dynamicListener, ArrayList<Listener> listener)
    {
        double time = (1 / wave.frequency) * 1000;

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                //prePaint(soundSource, wave, diameter, diameter_listener,  wavePoints,  dynamicListener,  listener);
                soundSource.velocity += soundSource.velocity * soundSource.acceleration;
                soundSource.coordinates.x_coordinate += soundSource.velocity;

                for (int i=0; i<dynamicListener.size(); i++)
                {
                    dynamicListener.get(i).coordinates.x_coordinate += dynamicListener.get(i).velocity;
                }
                repaint();
                //if (soundSource.coordinates.x_coordinate + diameter > getWidth()) //repeat function
                //{
                //    soundSource.coordinates.x_coordinate = 0;
                //    wavePoints.clear();
                //}

            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics circles)
    {

        super.paintComponent(circles);
        Graphics2D circles2d = (Graphics2D) circles;
        //circles2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // too high requirements
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

