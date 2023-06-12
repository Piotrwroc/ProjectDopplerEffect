package org.example;

import javax.swing.*;
import java.awt.*;

public class NewStaticListener extends Menu {
    NewStaticListener()
    {

        JFrame frame = new JFrame("Static Listener");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JButton button = new JButton("OK");
        button.setBounds(150,0,100,50);
        //button.addActionListener((ActionListener) this);
        frame.add(button);

        JLabel lbStatic = new JLabel("Static Listener:");
        JLabel lbStaticL_xcoordinate = new JLabel("x coordinate :");
        JTextField tfStaticL_xcoordinate  = new JTextField(20);
        lbStaticL_xcoordinate.setLabelFor(tfStaticL_xcoordinate);
        JLabel lbStaticL_ycoordinate = new JLabel("y coordinate :");
        JTextField tfStaticL_ycoordinate  = new JTextField(20);
        lbStaticL_ycoordinate.setLabelFor(tfStaticL_ycoordinate);

        frame.add(lbStatic);
        frame.add(lbStaticL_xcoordinate);
        frame.add(tfStaticL_xcoordinate);
        frame.add(lbStaticL_ycoordinate);
        frame.add(tfStaticL_ycoordinate);


        frame.setVisible(true);
    }
}
