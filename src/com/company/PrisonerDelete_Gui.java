package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class PrisonerDelete_Gui extends JFrame {
    JButton b1,b2;
    JLabel l1;
    JTextField t1;
    public PrisonerDelete_Gui(){
        setLayout(new FlowLayout());
        setSize(400,400);
        b1=new JButton("Delete");
        b2=new JButton("Back");
        l1=new JLabel("Search by cell");
        t1=new JTextField(30);
        MyActionListener a=new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        add(l1);
        add(t1);
        add(b1);
        add(b2);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Back")){
                setVisible(false);
                frame3 a= new frame3();
                a.setVisible(true);
            }
            if(e.getActionCommand().equals("Delete")){
                boolean ExistID = false;
                int cell=Integer.parseInt(t1.getText());
                ArrayList<Prisoner> PrisonerList = new ArrayList<>();
                PrisonerList=ReadData();
                for(int i=0;i<PrisonerList.size();i++){
                    if(cell == PrisonerList.get(i).getCellno()){
                        PrisonerList.remove(i);
                        ExistID = true;
                    }
                }
                if(ExistID){
                    ObjectOutputStream outputStream =null;
                    try {
                        outputStream=new ObjectOutputStream(new FileOutputStream("Prisioner.ser"));
                        for(int i=0;i<PrisonerList.size();i++){
                            outputStream.writeObject(PrisonerList.get(i));
                        }
                    }
                    catch(IOException b){
                        JOptionPane.showMessageDialog(null,"error in writing");
                    }
                    JOptionPane.showMessageDialog(null, "Prisioner deleted sucessfully");
                }else{
                    JOptionPane.showMessageDialog(null, "No data Found");
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
