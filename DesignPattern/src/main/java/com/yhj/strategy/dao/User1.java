package com.yhj.strategy.dao;

import com.yhj.strategy.Strategys;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 22:20
 * @Description: com.yhj.strategy.dao
 * @version: 1.0
 */
public class User1 implements Strategys {

    @Override
    public void excute() {
        System.out.println("我来搞运营。。。");
    }
}
