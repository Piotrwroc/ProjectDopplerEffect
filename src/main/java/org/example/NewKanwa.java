package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class responsible for creating JFrame where is error message
 */
public class NewKanwa {

    /**
     * Instantiates a new New kanwa
     */
    NewKanwa()
    {
        /*
         * Creating a JFrame
         */
        JFrame frame = new JFrame("WARNING");
        frame.setSize(300, 200);
        frame.setResizable(false);

        /*
         * Creating a JButton
         */
        JButton button = new JButton("I am sorry");
        button.setBounds(0,100,300,50);

        /*
         * Creating a JLabel
         */
        JLabel lberror  = new JLabel("Wrong data");
        lberror.setFont(new Font(null,Font.PLAIN,25));
        lberror.setBounds(0,0,200,10);

        /*
         * Adding fields to frame
         */
        frame.add(button);
        frame.add(lberror);

        /*
         * Button action listener
         */
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
