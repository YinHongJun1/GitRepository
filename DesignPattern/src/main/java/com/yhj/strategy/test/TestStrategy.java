package com.yhj.strategy.test;

import com.yhj.strategy.dao.User1;
import com.yhj.strategy.dao.User2;
import com.yhj.strategy.dao.User3;
import com.yhj.strategy.service.StrategysService;

/**
 * @Auther:yhj
 * @Date:2022/4/24 - 04 - 24 - 22:26
 * @Description: com.yhj.strategy.test
 * @version: 1.0
 */
public class TestStrategy {

//    public static void selectionSort(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            int flag = i;
//            for (int j = i + 1; j < arr.length; j++) {
//               flag = arr[j] < arr[flag] ? j:flag;
//            }
//            swap(arr, i, flag);
//        }
//    }
//
//    public static void swap(int[] arr, int i, int j){
//        int temp =arr[j];
//        arr[j] = arr[i];
//        arr[i] = temp;
//    }
//
//    public static void print(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//    }
//
//
//    public static void main(String[] args) {
//        int[] arr = {3, 1, 6, 18, 9, 5, 4, 10};
//        selectionSort(arr);
//        print(arr);
//
//    }

    public static void main(String[] args) {
        StrategysService s1, s2, s3;
        s1 = new StrategysService(new User1());
        s2 = new StrategysService(new User2());
        s3 = new StrategysService(new User3());
        s1.excute();
        s2.excute();
        s3.excute();
    }
}
