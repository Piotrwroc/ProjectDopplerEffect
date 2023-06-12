package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewKanwa {

    NewKanwa()
    {
        JFrame frame = new JFrame("WARNING");
        frame.setSize(300, 200);
        //frame.setLayout(null);
        frame.setResizable(false);
        JButton button = new JButton("Przepraszam najmocniej");
        button.setBounds(0,100,300,50);

        JLabel lberror  = new JLabel("Wrong data");
        lberror.setFont(new Font(null,Font.PLAIN,25));
        lberror.setBounds(0,0,200,10);

        frame.add(button);
        frame.add(lberror);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent d)
            {
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
}
