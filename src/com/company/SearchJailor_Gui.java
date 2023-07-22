package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;

public class SearchJailor_Gui extends JFrame {
    JButton b1,b2;
    JLabel l;
    JTextField t;
    public SearchJailor_Gui(){
        setSize(400,400);
        setLayout(new FlowLayout());
        l=new JLabel("Search by id");
        b1=new JButton("Search");
        b2=new JButton("Back");
        t=new JTextField(30);
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        add(l);
        add(t);
        add(b1);
        add(b2);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Back")){
                setVisible(false);
                frame4 a=new frame4();
                a.setVisible(true);
            }
            else if(e.getActionCommand().equals("Search")){
                String id=t.getText();
                ArrayList<Jailor> JailorList = new ArrayList<>();
                JailorList = ReadData();
                for(Jailor j:JailorList){
                    if (id.equals(j.getId())){
                        JOptionPane.showMessageDialog(new JFrame(), j.getFirstName()+" "+j.getLastName());
                    }
                }
            }
        }
    }
    ArrayList<Jailor>ReadData(){
        Jailor j=null;
        ArrayList<Jailor> a=new ArrayList<Jailor>();
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("com.company.Jailor.ser"));
            while(true){
                j=(Jailor)in.readObject();
                a.add(j);
            }
        }
        catch(EOFException e){
            System.out.println("End of file");
        }
        catch(IOException e){
            System.out.println("Error");
        }
        catch(ClassNotFoundException c){
            System.out.println("Error");
        }
        return a;
    }
}
