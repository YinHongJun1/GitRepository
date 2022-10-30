package com.yhj;

import java.awt.*;

public class Bullet {

    private static int x , y ;
    private Dir dir = null;
    private static final int SPEED = 15;
    private static final int WIDTH = 15, HEIGHT = 15;

    public boolean live = true;
    private TankFrame tf = null;
    public Bullet(int x, int y, Dir dir, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if (!live){
             tf.bullets.remove(this);
        }

//        Color color = g.getColor();
//        g.setColor(Color.WHITE);
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        g.setColor(color);
        switch (dir){
            case LEFT:
                g.drawImage(ResourceImage.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceImage.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceImage.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceImage.bulletD, x, y, null);
                break;
        }

        move();
    }

    private void move(){
        switch(dir) {
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;
    }
}
