package org.example;

import javax.swing.*;
import java.awt.*;

public class NewDynamicListener extends Menu {
    NewDynamicListener()
    {
        JFrame frame = new JFrame("Dynamic Listener");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        JButton button = new JButton("OK");
        button.setBounds(150,0,100,50);
        //button.addActionListener((ActionListener) this);
        frame.add(button);


    }
}
