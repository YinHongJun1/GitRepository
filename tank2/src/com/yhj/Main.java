package com.yhj;

import com.sun.xml.internal.ws.api.message.AddressingUtils;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
   public static void main(String[] args) throws InterruptedException {
//        // frame就是一个窗口   setVisible(true 设为窗口可见
//        Frame frame = new Frame();
//        frame.setVisible(true);
//        frame.setSize(800,800);
//        // 设定大小不会在改变
//        frame.setResizable(false);
//        frame.setTitle("Tranks war");
//        // 添加windows的监视器
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // super.windowClosing(e);
//                // 关闭窗口
//                System.exit(0);
//            }
//        });
//
       TankFrame frame = new TankFrame();
       for (int i = 0; i < 5; i++) {
           frame.tanks.add(new Tank(50 + i * 70,200, Dir.DOWN,Group.BAD,frame));
       }

       new Thread(()->new Audio("audio/war1.wav").loop()).start();

       while (true) {
           Thread.sleep(50);
           frame.repaint();
       }

   }
}
