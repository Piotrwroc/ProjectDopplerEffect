package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

/**
 * Class responsible for the background of the simulation
 */
public class _Simulation extends JPanel {
    /**
     * The Diameter of sound source
     */
    private int diameter = 50;
    /**
     * The Diameter of listeners
     */
    private int diameter_listener = 20;
    /**
     * The Wave points list
     */
    protected ArrayList<Point> wavePoints;

    /**
     * Instantiates a new Simulation
     */
    _Simulation()
    {
    }

    /**
     * Create simulation responsible for creating frame with simulation
     *
     * @param dynamicListenerList the dynamic listener list
     * @param listenerList        the listener list
     * @param wave                the wave
     * @param soundSource         the sound source
     */
    protected void create_Simulation(ArrayList<DynamicListener> dynamicListenerList, ArrayList<Listener> listenerList, Wave wave, SoundSource soundSource)
    {
        /*
         * Creating a JFrame
         */
        JFrame frame = new JFrame("ProjectDopplerEffect");

        /*
         * Creating wave points list
         */
        wavePoints = new ArrayList<>();

        /*
         * Creating a simulation_SoundSource object
         */
        _Simulation_Panel simulation_SoundSource = new _Simulation_Panel();

        /*
         * calling pretimer methode
         */
        simulation_SoundSource.pretimer( soundSource,  wave,  diameter,  diameter_listener, wavePoints, dynamicListenerList, listenerList);

        //frame options
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(simulation_SoundSource);
        frame.setPreferredSize(new Dimension(1920, 1080));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Add a window listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveResultToFile(soundSource);
                System.exit(0);
            }
        });
    }

    /**
     * Add listener
     *
     * @param ListenerList the listener list
     * @param listener     the listener
     */
    protected void addListener(ArrayList<Listener> ListenerList,Graphics listener)
    {
        for (Listener value : ListenerList)
        {
            listener.fillOval(value.coordinates.x_coordinate, value.coordinates.y_coordinate, diameter_listener, diameter_listener);
        }
    }

    /**
     * Add dynamic listener
     *
     * @param DynamicListenerList the dynamic listener list
     * @param dynamiclistener     the dynamiclistener
     */
    protected void addDynamicListener(ArrayList<DynamicListener> DynamicListenerList,Graphics dynamiclistener)
    {
        for (Listener value : DynamicListenerList)
        {
            dynamiclistener.fillOval(value.coordinates.x_coordinate, value.coordinates.y_coordinate, diameter_listener, diameter_listener);
        }
    }
    private void saveResultToFile(SoundSource soundSource) {
        double result = soundSource.velocity;
        try {
            PrintWriter output = new PrintWriter ("Sound Source velocity.txt");
            output.println(result);
            output.close();
            System.out.println("Result saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the result: " + e.getMessage());
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(1920, 1080);
    }
}
