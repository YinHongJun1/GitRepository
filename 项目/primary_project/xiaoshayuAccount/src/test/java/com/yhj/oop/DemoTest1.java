package com.yhj.oop;

import java.util.Scanner;

public class DemoTest1 {
    public static void main(String[] args) {
        String details = "";
        int balance = 0;
        while(true){
            System.out.println("----欢迎使用小鲨鱼记账系统----");
            System.out.println("1.收支明细");
            System.out.println("2.登记收入");
            System.out.println("3.登记支出");
            System.out.println("4.退出");
            System.out.println("请输入你要选择的功能");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4){
                System.out.println("你录入的功能不存在，请重新输入你的选择！！！");
                int newChoice = sc.nextInt();
                choice = newChoice;
            }
            switch (choice){
                case 1:
                    System.out.println("记账系统》》收支明细");
                    if (details != ""){
                        System.out.println(details.substring(0,details.length()-1));
                    }else {
                        System.out.print(details);
                    }
                    break;
                case 2:
                    System.out.println("记账系统》》登记收入");
                    System.out.println("请录入收入金额：");
                    int money = sc.nextInt();
                    System.out.println("请录入收入说明:");
                    String moneyComment = sc.next();
                    balance += money;
                    details = details+"收入："+money+",收入说明："+moneyComment+",账户余额为："+balance+"\n";
                    break;
                case 3:
                    System.out.println("记账系统》》登记支出");
                    System.out.println("请录入支出金额：");
                    int expend = sc.nextInt();
                    System.out.println("请录入支出说明:");
                    String expendComment = sc.next();
                    balance -= expend;
                    details = details+"支出："+expend+",支出说明："+expendComment+",账户余额为："+balance+"\n";
                    break;
                case 4:
                    System.out.println("记账系统》》退出");
                    System.out.println("确定要退出系统吗？Y/N：");
                    String isExit = sc.next();
                    switch (isExit){
                        case "Y":
                            System.out.println("系统退出！！欢迎下次继续使用");
                            return;
                    }
                    return;
            }
        }

    }
}
