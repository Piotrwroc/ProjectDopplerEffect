package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewDynamicListener {
    double velocity;
    //Listener listener;
    DynamicListener dynamicListener;
    NewDynamicListener()
    {

    }
    public void createListener(ArrayList ListenerList)
    {
        JFrame frame = new JFrame("Dynamic Listener");
        frame.setSize(400, 300);
        //frame.setLayout(null);
        frame.setVisible(true);


        JButton button = new JButton("OK");
        button.setBounds(150,0,100,50);
        frame.add(button);

        JLabel lbDynamicL = new JLabel("Dynamic Listener:");
        JLabel lbDynamicL_xcoordinate = new JLabel("x coordinate :");
        JTextField tfDynamicL_xcoordinate  = new JTextField(20);
        lbDynamicL_xcoordinate.setLabelFor(tfDynamicL_xcoordinate);
        JLabel lbDynamicL_ycoordinate = new JLabel("y coordinate :");
        JTextField tfDynamicL_ycoordinate  = new JTextField(20);
        lbDynamicL_ycoordinate.setLabelFor(tfDynamicL_ycoordinate);
        JLabel lbDynamicL_velocity = new JLabel("velocity :");
        JTextField tfDynamicL_velocity  = new JTextField(20);
        lbDynamicL_velocity.setLabelFor(tfDynamicL_velocity);
        JTextField tfno2 = new JTextField(20);

        lbDynamicL.setBounds(10,50,120,50);
        lbDynamicL_xcoordinate.setBounds(10,100,120,20);
        tfDynamicL_xcoordinate.setBounds(100,100,120,20);
        lbDynamicL_ycoordinate.setBounds(10,150,120,20);
        tfDynamicL_ycoordinate.setBounds(100,150,120,20);
        tfno2.setBounds(100,250,120,20);
        tfno2.setEditable(false);
        lbDynamicL_velocity.setBounds(10,200,120,20);
        tfDynamicL_velocity.setBounds(100,200,120,20);

        frame.add(lbDynamicL);
        frame.add(lbDynamicL_xcoordinate);
        frame.add(tfDynamicL_xcoordinate);
        frame.add(lbDynamicL_ycoordinate);
        frame.add(tfDynamicL_ycoordinate);
        frame.add(lbDynamicL_velocity);
        frame.add(tfDynamicL_velocity);
        frame.add(tfno2);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                dynamicListener = new DynamicListener(velocity);
                try {
                    dynamicListener.coordinates.x_coordinate = Integer.parseInt(tfDynamicL_xcoordinate.getText());
                    dynamicListener.coordinates.y_coordinate = Integer.parseInt(tfDynamicL_ycoordinate.getText());
                    dynamicListener.velocity = Double.parseDouble(tfDynamicL_velocity.getText());
                    frame.dispose();
                } catch (NumberFormatException ignore)
                {
                    NewKanwa newKanwa = new NewKanwa();
                }
                ListenerList.add(dynamicListener);
            }
        });
        frame.setVisible(true);
    }
}
