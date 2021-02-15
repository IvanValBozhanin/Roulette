package com.company;

import javax.swing.*;
import java.awt.*;

public class RouletteGame extends JFrame{
    private JTextField jTextField;
    private JLabel icon;
    public RouletteGame(){
        JFrame f = new JFrame("Roulette");

        setLayout( new FlowLayout() );

        jTextField = new JTextField();
        jTextField.setBounds(10, 10, 50, 20);
        icon = new JLabel(new ImageIcon("static.png"));
        icon.setBounds(150, 100, 780 ,360);
        add(jTextField);
        add(icon);
        {
            f.add(jTextField);
            f.add(icon);
            f.setSize(800, 600);
            f.setLocationRelativeTo(null);
            f.setLayout(null);
            f.setVisible(true);
        }
        for(long i=0l;i<5000000000l; ++i){

        }
        icon.setIcon(new ImageIcon("rotating.gif"));
    }
}
