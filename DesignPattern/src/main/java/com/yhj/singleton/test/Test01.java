package com.yhj.singleton.test;

import com.yhj.singleton.dao.Singleton1;
import com.yhj.singleton.dao.Singleton2;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 22:55
 * @Description: com.yhj.singleton.test
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        // 拿到的实例是同一个
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);
    }
}
