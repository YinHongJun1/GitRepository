package com.yhj;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200, y = 200;
    public TankFrame(){
        setSize(800,800);
        setResizable(false);
        setTitle("Tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g){
        System.out.println("paint");
        g.fillRect(x,y,50,50);
        x += 10;
        y += 20;
    }


}