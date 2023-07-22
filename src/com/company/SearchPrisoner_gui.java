package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SearchPrisoner_gui extends JFrame {
    JButton b1,b2;
    JLabel l;
    JTextField t;
    public SearchPrisoner_gui(){
        setSize(400,400);
        setLayout(new FlowLayout());
        l=new JLabel("Search by Cell no");
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
                frame3 a=new frame3();
                a.setVisible(true);
            }
            if(e.getActionCommand().equals("Search")){
                int cell=Integer.parseInt(t.getText());
                ArrayList<Prisoner> PrisonerList =new ArrayList<>();
                PrisonerList =ReadData();
                for(Prisoner p:PrisonerList){
                    if(cell==(p.getCellno())){
                        JOptionPane.showMessageDialog(new JFrame(), p.getFirstName()+" "+ p.getLastName());
                    }
                }
            }
        }
    }
    ArrayList<Prisoner> ReadData(){
        Prisoner p=null;
        ArrayList<Prisoner> a=new ArrayList<Prisoner>();
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("Prisioner.ser"));
            while(true){
                p=(Prisoner)in.readObject();
                a.add(p);
            }}
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
