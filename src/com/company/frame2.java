package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

public class frame2 extends JFrame {
    JButton b1, b2, b3;
    JPanel a2, a3;
    public frame2() {
        setLayout(new BorderLayout(3, 1));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        a2 = new JPanel();
        a3 = new JPanel();
        setSize(400, 400);
        b1 = new JButton("Prisoners");
        b2 = new JButton("Jailors");
        b3 = new JButton("Back");
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        a2.add(b1);
        a2.add(b2);
        a3.add(b3);
        a2.setBackground(Color.darkGray);
        a3.setBackground(Color.darkGray);
        add(a2, BorderLayout.NORTH);
        add(a3, BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Back")) {
                setVisible(false);
                guimenu g = new guimenu();
                g.setVisible(true);
            }
            if (e.getActionCommand().equals("Prisoners")) {
                frame3 a = new frame3();
                setVisible(false);
            }
            if (e.getActionCommand().equals("Jailors")) {
                frame4 b = new frame4();
                setVisible(false);
            }
        }
    }
}
