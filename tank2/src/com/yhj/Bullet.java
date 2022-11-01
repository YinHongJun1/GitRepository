package com.yhj;

import java.awt.*;

public class Bullet {

    private int x , y ;
    private Dir dir = null;
    private static final int SPEED = 20;
    public static final int WIDTH = ResourceManage.bulletU.getWidth();
    public static final int HEIGHT = ResourceManage.bulletU.getHeight();

    private boolean living = true;
    private TankFrame tf = null;

    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
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
                g.drawImage(ResourceManage.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceManage.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManage.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManage.bulletD, x, y, null);
                break;
        }

        move();
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
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWithTank(Tank tank) {
        if (this.group == tank.getGroup()) return ;
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
