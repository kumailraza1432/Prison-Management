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
import java.util.ArrayList;

public class AddJailor_Gui extends JFrame {
    JLabel l[] = new JLabel[5];
    JTextField t[]=new JTextField[5];
    JButton b1,b2;
    JPanel p1,p2,p3;
    JTextField t1[]=new JTextField[3];
    public AddJailor_Gui(){
        setLayout(new BorderLayout());
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p3.setLayout(new FlowLayout());
        l[0]=new JLabel("ID");
        l[1]=new JLabel("First Name");
        l[2]=new JLabel("Last Name");
        l[3]=new JLabel("Address (house,street,sector,city)");
        l[4]=new JLabel("Gender");
        t[0]=new JTextField(30);
        t[1]=new JTextField(30);
        t[2]=new JTextField(30);
        t[3]=new JTextField(5);
        t[4]=new JTextField(30);
        for(int i=0;i<=2;i++){
            t1[i]=new JTextField(5);
        }
        p3.add(t[3]);
        p3.add(new JLabel(","));
        p3.add(t1[0]);
        p3.add(new JLabel(","));
        p3.add(t1[1]);
        p3.add(new JLabel(","));
        p3.add(t1[2]);
        b1=new JButton("Submit");
        b2=new JButton("Back");
        setVisible(true);
        setSize(600,700);
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        p1.setLayout(new GridLayout(6,2));
        for(int i=0;i<5;i++){
            p1.add(l[i]);
            if (i==3)
                p1.add(p3);
            else
                p1.add(t[i]);
        }
        p2.add(b1);
        p2.add(b2);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.SOUTH);
        Jailor aa=null;
        ArrayList<Jailor> j=new ArrayList();
        try{
            ObjectInputStream o=new ObjectInputStream(new FileInputStream("com.company.Jailor.ser"));
            while(true){
                aa=(Jailor)o.readObject();
                j.add(aa);
            }
        }
        catch(EOFException e){
            System.out.println("End of file");
        }
        catch(IOException e){
            System.out.println("Error");
        }
        catch(ClassNotFoundException e){
            System.out.println("Error");
        }
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ReadData();
            if(e.getActionCommand().equals("Submit")){
                String FirstName=t[1].getText();
                String LastName=t[2].getText();
                String gender=t[4].getText();
                String id=t[0].getText();
                Address a=new Address(t1[2].getText(),t[3].getText(),t1[0].getText(),t1[1].getText());
                Jailor j = new Jailor(id,FirstName,LastName,a,gender);
                ObjectOutputStream outputStream = null;
                ArrayList<Jailor> q=new ArrayList<Jailor>();
                q=ReadData();
                q.add(j);
                try{
                    outputStream=new ObjectOutputStream(new FileOutputStream("com.company.Jailor.ser"));
                    for(int i=0;i<q.size();i++){
                        outputStream.writeObject(q.get(i));
                    }
                }
                catch(IOException b){
                    JOptionPane.showMessageDialog(null,"error in writing");
                }
                JOptionPane.showMessageDialog(null, "com.company.Jailor added sucessfully");
            }
            else if(e.getActionCommand().equals("Back")){
                frame4 s=new frame4();
                s.setVisible(true);
                setVisible(false);
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
}
