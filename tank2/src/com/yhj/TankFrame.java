package com.yhj;

import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TankFrame extends Frame {

    Tank tank = new  Tank(200,200,Dir.DOWN,this);
//    Bullet bullet = new Bullet(50,50,Dir.DOWN);
    ArrayList<Bullet> bullets = new ArrayList<>();
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
        getOfferScreen.setColor(Color.BLUE);
        getOfferScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        getOfferScreen.setColor(c);
        paint(getOfferScreen);
        g.drawImage(offerScreenImage,0,0,null);

    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.drawString("子弹的数量："+ bullets.size(), 10, 60);
        g.setColor(c);
        // 将画笔交给坦克类
       tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).paint(g);
        }
//       bullet.paint(g);
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
                    setMainTankDir();
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    setMainTankDir();
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
                    setMainTankDir();
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    setMainTankDir();
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
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
