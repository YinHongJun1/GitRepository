package com.yhj;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200, y = 200;
    public TankFrame(){
        setSize(800,800);
        setResizable(false);
        setTitle("Tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

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
//        y += 20;
    }

    class MyKeyListener extends KeyAdapter{

        public void keyPressed(KeyEvent e){
//            x += 20;
//            repaint();
            System.out.println("key pressed");
        }

        public void keyReleased(KeyEvent e){
            System.out.println("key released");
        }

    }



}
