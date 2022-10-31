package com.yhj;

import com.sun.java.swing.plaf.windows.WindowsGraphicsUtils;

import java.awt.*;

public class Bullet {

    private int x , y ;
    private Dir dir = null;
    private static final int SPEED = 20;
    public static final int WIDTH = ResourceImage.bulletD.getWidth();
    public static final int HEIGHT = ResourceImage.bulletD.getHeight();

    private boolean living = true;
    private TankFrame tf = null;
    public Bullet(int x, int y, Dir dir, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if (!living){
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
    public boolean isLiving() {
        return living;
    }
    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if(x < 0 || y < 0 || x > tf.GAME_WIDTH || y > tf.GAME_HEIGHT) living = false;
    }

    public void collideWithTank(Tank tank) {
        Rectangle rect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if (rect.intersects(rect2)){
                tank.die();
                this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
