package com.yhj;

import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank tank = new  Tank(200,200,Dir.DOWN);
    Bullet bullet = new Bullet(50,50,Dir.DOWN);
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }
    Image offerScreenImage = null;
    @Override
    public void update(Graphics g){
        if (offerScreenImage == null){
            offerScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics getOfferScreen = offerScreenImage.getGraphics();
        Color c = getOfferScreen.getColor();
        System.out.println(c);
        getOfferScreen.setColor(Color.BLUE);
        getOfferScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        getOfferScreen.setColor(c);
        paint(getOfferScreen);
        g.drawImage(offerScreenImage,0,0,null);

    }

    @Override
    public void paint(Graphics g) {
        // 将画笔交给坦克类
       tank.paint(g);
       bullet.paint(g);
    }


    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bU && !bD && !bR) tank.setMoving(false);
            else {
                tank.setMoving(true);
                if (bL) tank.setDir(Dir.LEFT);
                if (bU) tank.setDir(Dir.UP);
                if (bR) tank.setDir(Dir.RIGHT);
                if (bD) tank.setDir(Dir.DOWN);
            }
        }

    }
}
