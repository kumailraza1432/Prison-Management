package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guimenu extends JFrame{
    JLabel l1,l2,l3;
    JButton b1;
    JTextField t1,t2;
    JPanel p1,p2;
    public guimenu(){
        setTitle("Welcome to Prison Management System");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400,400);
        //LABELS
        l1= new JLabel("USERNAME");
        l2=new JLabel("PASSWORD");
        //TEXT_FIELDS
        t1=new JTextField(30);
        t2=new JTextField(30);
        //BUTTON
        b1=new JButton("LOGIN");
        p1=new JPanel();
        p2=new JPanel();
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p2.add(b1);
        add(p1);
        add(p2,BorderLayout.SOUTH);
        setVisible(true);
        p2.setBackground(Color.darkGray);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("LOGIN")){
                try
                {
                    LoginID();
                    frame2 a=new frame2();
                    setVisible(false);
                    a.setVisible(true);
                }catch(InvalidIDException ae){
                    ae.printStackTrace();
                    JOptionPane.showMessageDialog(
                            null, "wrong username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    public void LoginID() throws InvalidIDException{
        if(!(t1.getText().equals("a")&&(t2.getText().equals("a")))){
            throw new InvalidIDException();
        }
    }
}
