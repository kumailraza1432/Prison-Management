package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AddPrisoner_Gui extends JFrame implements Serializable {
    JLabel [] l=new JLabel[7];
    JTextField [] t=new JTextField[6];
    JButton b1,b2;
    JPanel p3;
    JTextField[]t1=new JTextField[4];
    public AddPrisoner_Gui(){
        setLayout(new GridLayout(8,2));
        p3=new JPanel();
        l[0]=new JLabel("ID");
        l[1]=new JLabel("Felony");
        l[2]=new JLabel("First Name");
        l[3]=new JLabel("Last Name");
        l[4]=new JLabel("Address(House,Street,Sector,City)");
        l[5]=new JLabel("Gender");
        l[6]=new JLabel("Cellno");
        t[0]=new JTextField(30);
        t[1]=new JTextField(30);
        t[2]=new JTextField(30);
        t[3]=new JTextField(30);
        t[4]=new JTextField(30);
        t[5]=new JTextField(30);
        for(int i=0;i<4;i++){
            t1[i]=new JTextField(5);
        }
        p3.add(t1[0]);
        p3.add(new JLabel(","));
        p3.add(t1[1]);
        p3.add(new JLabel(","));
        p3.add(t1[2]);
        p3.add(new JLabel(","));
        p3.add(t1[3]);
        b1=new JButton("Submit");
        b2=new JButton("Back");
        p3.setLayout(new FlowLayout());
        setSize(600,400);
        setVisible(true);
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        add(l[0]);
        add(t[0]);
        add(l[1]);
        add(t[1]);
        add(l[2]);
        add(t[2]);
        add(l[3]);
        add(t[3]);
        add(l[4]);
        add(p3);
        add(l[5]);
        add(t[4]);
        add(l[6]);
        add(t[5]);
        add(b1);
        add(b2);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Submit")){
                String id; String felony; String FirstName; String LastName; String home;String street;String sector;String city; String gender;int cellno;
                try{
                    cellno=Integer.parseInt(t[5].getText());
                    id = t[0].getText();
                    felony = t[1].getText();
                    FirstName = t[2].getText();
                    LastName = t[3].getText();
                    home = t1[0].getText();
                    street = t1[1].getText();
                    sector = t1[2].getText();
                    city = t1[3].getText();
                    gender = t[4].getText();
                    Address a=new Address(city, home, street, sector);
                    Prisoner s = new Prisoner(id,felony, FirstName,LastName,a,gender,cellno);
                    ObjectOutputStream outputStream = null;
                    ArrayList<Prisoner> q=new ArrayList<Prisoner>();
                    q=ReadData();
                    q.add(s);
                    System.out.println(q.get(0).getFelony());
                    try {
                        outputStream=new ObjectOutputStream(new FileOutputStream("Prisioner.ser"));
                        for(int i=0;i<q.size();i++){
                            outputStream.writeObject(q.get(i));
                        }
                    }
                    catch(IOException b){
                        JOptionPane.showMessageDialog(null,"error in writing");
                    }
                    JOptionPane.showMessageDialog(null, "Prisioner added sucessfully");
                }catch(NumberFormatException ae){

                    JOptionPane.showMessageDialog(null, "Enter Only digits in Cell phone Field");
                }
            }
            if(e.getActionCommand().equals("Back")){
                setVisible(false);
                frame3 a=new frame3();
                a.setVisible(true);
            }
        }
    }
    ArrayList<Prisoner>ReadData(){
        Prisoner p=null;
        ArrayList<Prisoner> a=new ArrayList<Prisoner>();
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("Prisioner.ser"));
            while(true){
                p=(Prisoner)in.readObject();
                a.add(p);
            }
        }
        catch(EOFException e){
            System.out.println("End of file");
        }
        catch(IOException e){
            System.out.println("IOException");
        }
        catch(ClassNotFoundException c){
            System.out.println("Class not found");
        }
        return a;
    }

}
