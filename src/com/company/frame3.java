package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame3 extends JFrame {
    JButton add,view,search,delete,back;
    JPanel p1,p2;
    public frame3(){
        setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setResizable(false);
        add=new JButton("Add");
        view=new JButton("View");
        search=new JButton("Search");
        delete=new JButton("Delete");
        back=new JButton("Back");
        p1=new JPanel();
        p2=new JPanel();
        p2.setBackground(Color.black);
        p1.setBackground(Color.black);
        MyActionListener a = new MyActionListener();
        add.addActionListener(a);
        view.addActionListener(a);
        search.addActionListener(a);
        delete.addActionListener(a);
        back.addActionListener(a);
        p1.add(add);
        p1.add(view);
        p1.add(search);
        p1.add(delete);
        p2.add(back);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Add")){
                AddPrisoner_Gui a=new AddPrisoner_Gui();
                setVisible(false);
            }
            else if(e.getActionCommand().equals("Back")){
                setVisible(false);
                frame2 a=new frame2();
                a.setVisible(true);
            }
            else if(e.getActionCommand().equals("Search")){
                setVisible(false);
                SearchPrisoner_gui a=new SearchPrisoner_gui();
                a.setVisible(true);
            }
            else if(e.getActionCommand().equals("Delete")){
                setVisible(false);
                PrisonerDelete_Gui a=new PrisonerDelete_Gui();
                a.setVisible(true);
            }
            else if(e.getActionCommand().equals("View")){
                setVisible(false);
                ViewPrisioner_Gui v=new ViewPrisioner_Gui();
                v.setVisible(true);
            }
        }
    }
}
