package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ViewJailor_Gui extends JFrame {
    private JTextArea te;
    private JScrollPane sp;
    private JButton back;
    public ViewJailor_Gui(){
        setLayout(null);
        setVisible(true);
        setSize(1000,800);
        back=new JButton("Back");
        back.setBounds(500,500,100,50);
        te=new JTextArea(800,400);
        te.setEditable(false);
        ArrayList<Jailor> JailorList = new ArrayList<>();
        JailorList = ReadData();
        for(Jailor j : JailorList){
            te.append(j.getFirstName()+" "+j.getLastName()+",  "+j.getGender()+",  "+ j.getId()+"  Address = "+j.getAd().getHouse()+" "+j.getAd().getStreet()+" "
                    + ""+j.getAd().getSector()+" "+j.getAd().getCity()+"\n");
        }
        sp=new JScrollPane(te);
        sp.setBounds(50,50,800,400);
        MyActionListener a = new MyActionListener();
        back.addActionListener(a);
        add(sp);
        add(back);
    }
    public  class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Back")){
                setVisible(false);
                frame4 r = new frame4();
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
