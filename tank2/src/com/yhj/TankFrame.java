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

        Boolean bL = false;
        Boolean bU = false;
        Boolean bR = false;
        Boolean bD = false;
        // 系统帮我们调用
        public void keyPressed(KeyEvent e){
            // 获得按键
          int key = e.getKeyCode();
          switch (key){
              case KeyEvent.VK_LEFT:
                  bL = true;
                  x -= 10;
                  break;
              case KeyEvent.VK_UP:
                  bU = true;
                  y += 10;
                  break;
              case KeyEvent.VK_RIGHT:
                  bR = true;
                  x += 10;
                  break;
              case KeyEvent.VK_DOWN:
                  bD = true;
                  y -= 10;
                  break;
              default:
                  break;
          }
//            x += 20;
//            repaint();
            System.out.println("key pressed");
        }

        public void keyReleased(KeyEvent e){
            // 获得按键
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    x -= 10;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    y += 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    x += 10;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    y -= 10;
                    break;
                default:
                    break;
            }
            System.out.println("key released");
        }

    }



}
