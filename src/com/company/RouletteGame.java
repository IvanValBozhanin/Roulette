package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RouletteGame extends JFrame{
    private final JLabel icon, picked, result;
    private final JSlider slider;
    private int percent;

    public RouletteGame() {
        super( "Main" );
        JFrame f = new JFrame("Roulette");
        percent = 35;

        SliderHandler sliderHandler = new SliderHandler();
        ButtonHandler buttonHandler = new ButtonHandler();

        result = new JLabel();
        result.setBounds(350, 500, 200, 30);
        result.setFont(new Font("Serif", Font.ITALIC, 20));

        slider = new JSlider(0, 36, 0);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(3);
        slider.setMinorTickSpacing(1);
        slider.addChangeListener(sliderHandler);
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.setFont(new Font("Serif", Font.ITALIC, 15));
        slider.setBounds(10, 10, 200, 400);

        picked = new JLabel();
        picked.setText("Chosen number: " + 0);
        picked.setBounds(10, 500, 300, 20);
        picked.setFont(new Font("Serif", Font.ITALIC, 20));

        setLayout(new FlowLayout());
        icon = new JLabel(new ImageIcon("static.png"));
        icon.setBounds(150, 100, 780, 360);

        JButton button = new JButton("Play");
        button.setFont(new Font("Serif", Font.ITALIC, 20));
        button.setBounds(650, 500, 100, 30);
        button.addActionListener(buttonHandler);

        {
            f.add(result);
            f.add(button);
            f.add(slider);
            f.add(picked);
            f.add(icon);
            f.setSize(800, 600);
            f.setLocationRelativeTo(null);
            f.setLayout(null);
            f.setVisible(true);
        }
    }

    private class SliderHandler implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            picked.setText("Chosen number: " + slider.getValue());
        }
    }

    private class ButtonHandler implements ActionListener{
        private final Timer timer;

        public ButtonHandler(){
            timer = new Timer(2000 + (int)(Math.random()*2000), e -> {
                icon.setIcon(new ImageIcon("static.png"));

                int n = (int)(Math.random()*36);
                int prob = (int)(Math.random()*100);
                //picked.setText(" " + percent + " " + prob);
                if(prob <= percent){
                    n = slider.getValue();
                    if(percent > 40) percent -= 20;
                    else if(percent > 20) percent -= 10;
                    else if(percent > 10) percent -= 2;
                }
                if(slider.getValue() == n){
                    result.setText("You guessed right!");
                } else {
                    result.setText("Roulette number: " + n);
                    if(percent < 10) percent += 10;
                    else if(percent < 30) percent += 7;
                    else if(percent < 50) percent += 3;
                }
                slider.setValue(0);
            });
            timer.setRepeats(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            icon.setIcon(new ImageIcon("rotating.gif"));
            timer.start();
        }
    }
}