package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewStaticListener {
    Listener listener;
    int x_coordinate;
    int y_coordinate;
    NewStaticListener()
    {
    }
    public void createListener(ArrayList ListenerList)
    {
        JFrame frame = new JFrame("Static Listener");
        frame.setSize(400, 300);
        //frame.setLayout(null);
        frame.setVisible(true);

        JButton button = new JButton("OK");
        button.setBounds(150,0,100,50);
        frame.add(button);

        JLabel lbStaticL = new JLabel("Static Listener:");
        JLabel lbStaticL_xcoordinate = new JLabel("x coordinate :");
        JTextField tfStaticL_xcoordinate  = new JTextField(20);
        lbStaticL_xcoordinate.setLabelFor(tfStaticL_xcoordinate);
        JLabel lbStaticL_ycoordinate = new JLabel("y coordinate :");
        JTextField tfStaticL_ycoordinate  = new JTextField(20);
        lbStaticL_ycoordinate.setLabelFor(tfStaticL_ycoordinate);
        JTextField tfno1 = new JTextField(20);

        lbStaticL.setBounds(10,50,120,50);
        lbStaticL_xcoordinate.setBounds(10,100,120,20);
        tfStaticL_xcoordinate.setBounds(100,100,120,20);
        lbStaticL_ycoordinate.setBounds(10,150,120,20);
        tfStaticL_ycoordinate.setBounds(100,150,120,20);
        tfno1.setBounds(100,200,120,20);
        tfno1.setEditable(false);

        frame.add(lbStaticL);
        frame.add(lbStaticL_xcoordinate);
        frame.add(tfStaticL_xcoordinate);
        frame.add(lbStaticL_ycoordinate);
        frame.add(tfStaticL_ycoordinate);
        frame.add(tfno1);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                listener = new Listener(new Coordinates(x_coordinate, y_coordinate));
                try {
                    listener.coordinates.x_coordinate = Integer.parseInt(tfStaticL_xcoordinate.getText());
                    listener.coordinates.y_coordinate = Integer.parseInt(tfStaticL_ycoordinate.getText());
                    frame.dispose();
                } catch (NumberFormatException ignore)
                {
                    NewKanwa newKanwa = new NewKanwa();
                }
                ListenerList.add(listener);
            }
        });
        frame.setVisible(true);
    }
}
