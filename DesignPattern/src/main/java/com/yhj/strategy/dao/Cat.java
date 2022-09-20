package com.yhj.strategy.dao;

/**
 * @Auther:yhj
 * @Date:2022/4/25 - 04 - 25 - 23:12
 * @Description: com.yhj.strategy.dao
 * @version: 1.0
 */
public class Cat {
    int weight;
    int height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int comparaTo(Cat c){
        if(this.weight > c.weight) return -1;
        else if(this.weight < c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
