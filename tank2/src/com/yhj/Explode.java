package com.yhj;

import java.awt.*;

public class Explode {

    private int x , y ;
    public static final int WIDTH = ResourceManage.explodes[0].getWidth();
    public static final int HEIGHT = ResourceManage.explodes[0].getHeight();

    private boolean living = true;
    private TankFrame tf = null;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }


    public void paint(Graphics g){
        g.drawImage(ResourceManage.explodes[step++], x, y, null);
        if (step >= ResourceManage.explodes.length){
            step = 0;
        }
    }

}
