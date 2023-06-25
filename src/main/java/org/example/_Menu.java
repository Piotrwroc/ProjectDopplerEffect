package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class responsible for input data
 */
public class _Menu extends JFrame implements ActionListener {
    /**
     * The Listener list
     */
    private ArrayList<Listener> listenerList;
    /**
     * The Dynamic listener list
     */
    private ArrayList<DynamicListener> dynamicListenerList;
    /**
     * The Combo box for selecting static or dynamic listener
     */
    private JComboBox comboBox;
    /**
     * The X coordinate
     */
    private int x_coordinate;
    /**
     * The Y coordinate
     */
    private int y_coordinate;
    /**
     * The Frequency
     */
    private double frequency;
    /**
     * The Velocity
     */
    private double velocity;
    /**
     * The Acceleration
     */
    private double acceleration;
    /**
     * Array size
     */
    final int X = 6;
    /**
     * Instantiates a new Menu
     */
    protected _Menu()
    {
        /*
         * Creating a JFrame
         */
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JFrame frame = new JFrame("ProjectDopplerEffect_menu");
        frame.setSize(800, 600);

        /*
         * Creating a JButton
         */
        JButton button = new JButton("START");
        button.setBounds(340,0,100,50);
        frame.add(button);

        /*
         * Creating a JButton
         */
        JButton pregeneratedButton = new JButton("pregenerated START");
        pregeneratedButton.setBounds(450,0,200,50);
        frame.add(pregeneratedButton);

        /*
         * Creating a JLabels and JTextFields related to wave
         */
        JLabel lbwave  = new JLabel("Wave:");
        JLabel lbwave_frequency = new JLabel("frequency:");
        JTextField tfwave_frequency = new JTextField(20);
        lbwave_frequency.setLabelFor(tfwave_frequency);
        JLabel lbwave_velocity = new JLabel("velocity:");
        JTextField tfwave_velocity = new JTextField(20);
        lbwave_velocity.setLabelFor(tfwave_velocity);

        /*
         * Setting fields coordinates related to wave
         */
        lbwave.setBounds(370,60,100,20);
        lbwave_frequency.setBounds(22,90,100,20);
        tfwave_frequency.setBounds(90,90,200,20);
        lbwave_velocity.setBounds(323,90,100,20);
        tfwave_velocity.setBounds(375,90,200,20);

        /*
         * Adding field related to wave to frame
         */
        frame.add(lbwave);
        frame.add(lbwave_frequency);
        frame.add(tfwave_frequency);
        frame.add(lbwave_velocity);
        frame.add(tfwave_velocity);

        /*
         * Creating a JLabels and JTextFields related to sound source
         */
        JLabel lbSS  = new JLabel("Soudnd Source:");
        JLabel lbSS_velocity = new JLabel("velocity:");
        JTextField tfSS_velocity = new JTextField(20);
        lbSS_velocity.setLabelFor(tfSS_velocity);
        JLabel lbSS_acceleration  = new JLabel("acceleration:");
        JTextField tfSS_acceleration  = new JTextField(20);
        lbSS_acceleration .setLabelFor(tfSS_acceleration );
        JLabel lbSS_xcoordinate = new JLabel("x coordinate:");
        JTextField tfSS_xcoordinate  = new JTextField(20);
        lbSS_xcoordinate.setLabelFor(tfSS_xcoordinate );
        JLabel lbSS_ycoordinate = new JLabel("y coordinate:");
        JTextField tfSS_ycoordinate  = new JTextField(20);
        lbSS_ycoordinate.setLabelFor(tfSS_ycoordinate );

        /*
         * Setting fields coordinates related to sound source
         */
        lbSS.setBounds(345,120,100,20);
        lbSS_velocity.setBounds(37,150,100,20);
        tfSS_velocity.setBounds(90,150,200,20);
        lbSS_acceleration.setBounds(295,150,100,20);
        tfSS_acceleration.setBounds(375,150,200,20);
        lbSS_xcoordinate.setBounds(10,180,100,20);
        tfSS_xcoordinate.setBounds(90,180,200,20);
        lbSS_ycoordinate.setBounds(295,180,100,20);
        tfSS_ycoordinate.setBounds(375,180,200,20);

        /*
         * Adding field related to sound source to frame
         */
        frame.add(lbSS);
        frame.add(lbSS_velocity);
        frame.add(tfSS_velocity);
        frame.add(lbSS_acceleration);
        frame.add(tfSS_acceleration);
        frame.add(lbSS_xcoordinate);
        frame.add(tfSS_xcoordinate);
        frame.add(lbSS_ycoordinate);
        frame.add(tfSS_ycoordinate);

        /*
         * creating array list for static and dynamic listeners
         */
        listenerList = new ArrayList<>();
        dynamicListenerList = new ArrayList<>();

        /*
         * creating a JComboBox
         */
        JLabel lblistener  = new JLabel("Choose type of listener:");
        String listeners[]= {"static", "dynamic"};
        comboBox = new JComboBox(listeners);
        comboBox.addActionListener(this);

        /*
         * Setting fields coordinates related to listeners
         */
        comboBox.setBounds(345,240,100,20);
        lblistener.setBounds(330,210,200,20);

        /*
         * Adding field related to listeners to frame
         */
        frame.add(lblistener);
        frame.add(comboBox);

        /*
         * Button action listener
         */
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                try {
                    /*
                     * Creating wave and soundSource object, and values from text fields to objects
                     */
                    Wave wave = new Wave(frequency, velocity);
                    SoundSource soundSource = new SoundSource(velocity,acceleration,new Coordinates(x_coordinate,y_coordinate));
                    wave.frequency = Double.parseDouble(tfwave_frequency.getText());
                    wave.velocity = Double.parseDouble(tfwave_velocity.getText());
                    soundSource.velocity = Double.parseDouble(tfSS_velocity.getText());
                    soundSource.acceleration = Double.parseDouble(tfSS_acceleration.getText());
                    soundSource.coordinates.x_coordinate = Integer.parseInt(tfSS_xcoordinate.getText());
                    soundSource.coordinates.y_coordinate = Integer.parseInt(tfSS_ycoordinate.getText());
                    frame.dispose();

                    /*
                     * Creating symulacja object
                     */

                    _Simulation symulacja = new _Simulation();
                    symulacja.create_Simulation(dynamicListenerList, listenerList, wave, soundSource);
                } catch (NumberFormatException ignore)
                {
                    /*
                     * Creating newKanwa object
                     */
                    NewKanwa newKanwa = new NewKanwa();
                }
            }
        });

        /*
         * test start with pre generated data
         */
        pregeneratedButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent d)
            {
                try {
                    /*
                     * Creating wave and soundSource object, and values from text fields to objects
                     */
                    int[] data = new int[X];
                    int x = 0;
                    try {
                        File file = new File("pregenerated.txt");
                        Scanner input = new Scanner(file);
                        while (input.hasNextLine()){
                            data[x] = input.nextInt();
                            x++;
                        }
                        input.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Wave wave = new Wave(frequency, velocity);
                    SoundSource soundSource = new SoundSource(velocity,acceleration,new Coordinates(x_coordinate,y_coordinate));
                    wave.frequency = data[0];
                    wave.velocity = data[1];
                    soundSource.velocity = data[2];
                    soundSource.acceleration = data[3];
                    soundSource.coordinates.x_coordinate = data[4];
                    soundSource.coordinates.y_coordinate = data[5];
                    frame.dispose();

                    /*
                     * Creating simulation object
                     */

                    _Simulation simulation = new _Simulation();
                    simulation.create_Simulation(dynamicListenerList, listenerList, wave, soundSource);
                } catch (NumberFormatException ignore)
                {
                    /*
                     * Creating newKanwa object
                     */
                    NewKanwa newKanwa = new NewKanwa();
                }
            }
        });

        /*
         * Button for displaying number of static listeners
         */
        JButton DebugList = new JButton("Number of static listeners");
        DebugList.setBounds(300,300,200,50);
        frame.add(DebugList);
        DebugList.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                System.out.println("Number of static listeners: " + listenerList.size());
            }
        });

        /*
         * Button for displaying number of dynamic listeners
         */
        JButton DebugMovingList = new JButton("Number of dynamic listeners");
        DebugMovingList.setBounds(300,360,200,50);
        frame.add(DebugMovingList);
        DebugMovingList.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                System.out.println("Number of moving listeners: " + dynamicListenerList.size());
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /*
     * ComboBox action listener
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==comboBox)
        {
            if (comboBox.getSelectedItem()=="static")
            {
                /*
                 * Creating newListener object
                 */
                NewStaticListener newListener = new NewStaticListener();
                newListener.createListener(listenerList);
            }
            if (comboBox.getSelectedItem()=="dynamic")
            {
                /*
                 * Creating newDynamicListener object
                 */
                NewDynamicListener newDynamicListener = new NewDynamicListener();
                newDynamicListener.createListener(dynamicListenerList);
            }
        }
    }
}
