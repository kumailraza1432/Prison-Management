package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class JailorDelete_Gui extends JFrame {
    JButton b1,b2;
    JLabel l1;
    JTextField t1;
    public JailorDelete_Gui(){
        setLayout(new FlowLayout());
        setSize(400,400);
        b1=new JButton("Delete");
        b2=new JButton("Back");
        l1=new JLabel("Search by Id");
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
                frame4 a= new frame4();
                a.setVisible(true);
            }
            else if(e.getActionCommand().equals("Delete")){
                String id=t1.getText();
                boolean IDExist = false;
                ArrayList<Jailor> JailorList =new ArrayList<>();
                JailorList =ReadData();
                for(int i=0;i<JailorList.size();i++){
                    if(id.equals(JailorList.get(i).getId())){
                        JailorList.remove(i);
                        IDExist = true;
                    }
                }
                if(IDExist){
                    try{
                        ObjectOutputStream outputStream = null;
                        outputStream=new ObjectOutputStream(new FileOutputStream("com.company.Jailor.ser"));
                        for(int i=0;i<JailorList.size();i++){
                            outputStream.writeObject(JailorList.get(i));

                        }
                        outputStream.close();
                    }
                    catch(IOException b){
                        JOptionPane.showMessageDialog(null,"error in writing!!");
                    }
                    JOptionPane.showMessageDialog(null, "com.company.Jailor deleted Sucessfully!!");
                }else{
                    JOptionPane.showMessageDialog(null, "No data Found!!");
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
}
