package org.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class _Menu extends JFrame implements ActionListener {
    //JFrame mainframe;
    JComboBox comboBox;
    public _Menu()
    {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JFrame frame = new JFrame("ProjectDopplerEffect");
        frame.setSize(800, 600);

        JButton button = new JButton("START");
        button.setBounds(300,0,200,100);
        //button.addActionListener((ActionListener) this);
        panel.add(button);

        //wave
        JLabel lbwave  = new JLabel("Wave:");
        JLabel lbwave_frequency = new JLabel("frequency:");
        JTextField tfwave_frequency = new JTextField(20);
        lbwave_frequency.setLabelFor(tfwave_frequency);
        JLabel lbwave_velocity = new JLabel("velocity:");
        JTextField tfwave_velocity = new JTextField(20);
        lbwave_velocity.setLabelFor(tfwave_velocity);

        panel.add(Box.createRigidArea(new Dimension(800, 0)));
        panel.add(lbwave);
        panel.add(Box.createRigidArea(new Dimension(800, 0)));
        panel.add(lbwave_frequency);
        panel.add(tfwave_frequency);
        panel.add(lbwave_velocity);
        panel.add(tfwave_velocity);

        //Soudnd Source
        JLabel lbSS  = new JLabel("Soudnd Source:");
        JLabel lbSS_velocity = new JLabel("velocity:");
        JTextField tfSS_velocity = new JTextField(20);
        lbSS_velocity.setLabelFor(tfSS_velocity);
        JLabel lbSS_acceleration  = new JLabel("acceleration :");
        JTextField tfSS_acceleration  = new JTextField(20);
        lbSS_acceleration .setLabelFor(tfSS_acceleration );
        JLabel lbSS_xcoordinate = new JLabel("x coordinate :");
        JTextField tfSS_xcoordinate  = new JTextField(20);
        lbSS_xcoordinate.setLabelFor(tfSS_xcoordinate );
        JLabel lbSS_ycoordinate = new JLabel("y coordinate :");
        JTextField tfSS_ycoordinate  = new JTextField(20);
        lbSS_ycoordinate.setLabelFor(tfSS_ycoordinate );

        panel.add(Box.createRigidArea(new Dimension(12000,0 )));
        panel.add(lbSS);
        panel.add(Box.createRigidArea(new Dimension(800, 0)));
        panel.add(lbSS_velocity);
        panel.add(tfSS_velocity);
        panel.add(lbSS_acceleration);
        panel.add(tfSS_acceleration);
        panel.add(Box.createRigidArea(new Dimension(110, 0)));
        panel.add(lbSS_xcoordinate);
        panel.add(tfSS_xcoordinate);
        panel.add(lbSS_ycoordinate);
        panel.add(tfSS_ycoordinate);

        //Listener
        panel.add(Box.createRigidArea(new Dimension(300, 0)));
        JLabel lblistener  = new JLabel("Choose type of listener:");
        String listeners[]= {"static", "dynamic"};
        comboBox = new JComboBox(listeners);
        comboBox.addActionListener(this);
        panel.add(lblistener);
        panel.add(comboBox);

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

            //TODO spawn nowe okno z danym sluchaczem
        }
    }
}
