package com.yhj;

import java.awt.*;
import java.util.Random;

public class Tank {

    private static final int SPEED = 2;
    public static int WIDTH = ResourceManage.goodTankU.getWidth();
    public static int HEIGHT = ResourceManage.goodTankU.getHeight();
    private Random random = new Random();
    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean moving = true;
    private TankFrame tf = null;
    private boolean living = true;
    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
//            if (this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public Dir getDir() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getY() {
        return y;
    }

    public boolean isMoving() {
        return moving;
    }

    private void move() {

        if (!moving) return;

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

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 97) {
            randomDir();
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void paint(Graphics g) {
        if (!living) tf.tanks.remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceManage.goodTankL : ResourceManage.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceManage.goodTankU : ResourceManage.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceManage.goodTankR : ResourceManage.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceManage.goodTankD : ResourceManage.badTankD, x, y, null);
                break;
        }
        move();
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        this.living = false;
    }

}
