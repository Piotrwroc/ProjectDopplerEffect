package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class _Simulation extends JPanel {
    int diameter = 50;
    int diameter_listener = 20;  // Diameter of the listener
    protected ArrayList<Point> wavePoints;  // List to store wave points
    _Simulation()
    {

    }
    public void create_Simulation(ArrayList<DynamicListener> dynamicListenerList, ArrayList<Listener> listenerList, Wave wave, SoundSource soundSource)
    {

        JFrame frame = new JFrame("ProjectDopplerEffect");
        wavePoints = new ArrayList<>();
        _Simulation_Panel simulation_SoundSource = new _Simulation_Panel();
        simulation_SoundSource.pretimer( soundSource,  wave,  diameter,  diameter_listener, wavePoints, dynamicListenerList, listenerList);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(simulation_SoundSource);


        frame.setPreferredSize(new Dimension(1920, 1080));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        wavePoints = new ArrayList<>();


        setPreferredSize(new Dimension(1920, 1080));
        setFocusable(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new _Simulation());

        frame.add(simulation_SoundSource);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    protected void addListener(ArrayList<Listener> ListenerList,Graphics listener)
    {
        for (Listener value : ListenerList)
        {
            listener.fillOval(value.coordinates.x_coordinate, value.coordinates.y_coordinate, diameter_listener, diameter_listener);
        }
    }
    protected void addDynamicListener(ArrayList<DynamicListener> DynamicListenerList,Graphics dynamiclistener)
    {
        for (Listener value : DynamicListenerList)
        {
            dynamiclistener.fillOval(value.coordinates.x_coordinate, value.coordinates.y_coordinate, diameter_listener, diameter_listener);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(1920, 1080);
    }
}
