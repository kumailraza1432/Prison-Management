package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ViewPrisioner_Gui extends JFrame {
    private JTextArea te;
    private JScrollPane sp;
    private JButton back;
    public ViewPrisioner_Gui(){
        setLayout(null);
        setVisible(true);
        setSize(1000,800);
        te=new JTextArea(800,400);
        te.setEditable(false);
        back=new JButton("Back");
        back.setBounds(500,500,100,50);
        ArrayList<Prisoner> PrisonersList=new ArrayList<>();
        PrisonersList=ReadData();
        for(Prisoner p: PrisonersList){
            te.append(p.getFirstName()+","+p.getLastName()+","+p.getFelony()+","+p.getId()+","+p.getCellno()+","+p.getAd().getHouse()+","+
                    p.getAd().getStreet()+","+p.getAd().getSector()+","+p.getAd().getCity()+"\n");
        }
        sp=new JScrollPane(te);
        sp.setBounds(50,50,800,400);
        MyActionListener a=new MyActionListener();
        back.addActionListener(a);
        add(sp);
        add(back);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Back")){
                setVisible(false);
                frame3 a=new frame3();
                a.setVisible(true);
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
