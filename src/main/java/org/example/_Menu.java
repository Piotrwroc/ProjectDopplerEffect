package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class _Menu extends JFrame implements ActionListener {
    //JFrame mainframe;
    JComboBox comboBox;
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
    public _Menu()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JFrame frame = new JFrame("ProjectDopplerEffect_menu");
        frame.setSize(800, 600);

        //button
        JButton button = new JButton("START");
        button.setBounds(340,0,100,50);
        frame.add(button);

        //wave
        JLabel lbwave  = new JLabel("Wave:");
        JLabel lbwave_frequency = new JLabel("frequency:");
        JTextField tfwave_frequency = new JTextField(20);
        lbwave_frequency.setLabelFor(tfwave_frequency);
        JLabel lbwave_velocity = new JLabel("velocity:");
        JTextField tfwave_velocity = new JTextField(20);
        lbwave_velocity.setLabelFor(tfwave_velocity);

        lbwave.setBounds(370,60,100,20);
        lbwave_frequency.setBounds(22,90,100,20);
        tfwave_frequency.setBounds(90,90,200,20);
        lbwave_velocity.setBounds(323,90,100,20);
        tfwave_velocity.setBounds(375,90,200,20);


        frame.add(lbwave);
        frame.add(lbwave_frequency);
        frame.add(tfwave_frequency);
        frame.add(lbwave_velocity);
        frame.add(tfwave_velocity);

        //Soudnd Source
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

        lbSS.setBounds(345,120,100,20);
        lbSS_velocity.setBounds(37,150,100,20);
        tfSS_velocity.setBounds(90,150,200,20);
        lbSS_acceleration.setBounds(295,150,100,20);
        tfSS_acceleration.setBounds(375,150,200,20);
        lbSS_xcoordinate.setBounds(10,180,100,20);
        tfSS_xcoordinate.setBounds(90,180,200,20);
        lbSS_ycoordinate.setBounds(295,180,100,20);
        tfSS_ycoordinate.setBounds(375,180,200,20);

        frame.add(lbSS);
        frame.add(lbSS_velocity);
        frame.add(tfSS_velocity);
        frame.add(lbSS_acceleration);
        frame.add(tfSS_acceleration);
        frame.add(lbSS_xcoordinate);
        frame.add(tfSS_xcoordinate);
        frame.add(lbSS_ycoordinate);
        frame.add(tfSS_ycoordinate);

        //Listener
        panel.add(Box.createRigidArea(new Dimension(300, 0)));
        JLabel lblistener  = new JLabel("Choose type of listener:");
        String listeners[]= {"static", "dynamic"};
        comboBox = new JComboBox(listeners);
        comboBox.addActionListener(this);

        comboBox.setBounds(345,240,100,20);
        lblistener.setBounds(330,210,200,20);

        frame.add(lblistener);
        frame.add(comboBox);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {

                try {
                    wave.frequency = Integer.parseInt(tfwave_frequency.getText());
                    wave.velocity = Integer.parseInt(tfwave_velocity.getText());

                    soundSource.velocity = Double.parseDouble(tfSS_velocity.getText());
                    soundSource.acceleration = Double.parseDouble(tfSS_acceleration.getText());
                    soundSource.coordinates.x_coordinate = Integer.parseInt(tfSS_xcoordinate.getText());
                    soundSource.coordinates.y_coordinate = Integer.parseInt(tfSS_ycoordinate.getText());
                    frame.dispose();
                    Simulation projektDopplerEffect = new Simulation();

                } catch (NumberFormatException ignore)
                {
                    NewKanwa newKanwa = new NewKanwa();
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==comboBox)
        {
            if (comboBox.getSelectedItem()=="static")
            {
                NewStaticListener newListener = new NewStaticListener();
            }
            if (comboBox.getSelectedItem()=="dynamic")
            {
                NewDynamicListener newListener = new NewDynamicListener();
            }
        }
    }
}
