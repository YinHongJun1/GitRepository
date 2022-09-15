package class01;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Code01_SelectSort {
    /*
        排序
     */
    public static void selectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return ;
        }
        // 0 ~ N-1  找到最小值，在哪，放到0位置上
        // 1 ~ n-1  找到最小值，在哪，放到1 位置上
        // 2 ~ n-1  找到最小值，在哪，放到2 位置上
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1 ; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    /*
        原生的排序
     */
    public static void compareSort(int[] arr){
        Arrays.sort(arr);
    }

    /*
        交换位置
     */
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
        打印
     */
    public static void printArray(int[] arr){
        if (arr == null){
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /*
        生成随机数组
     */
    public static int[]  generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    /*
        拷贝数组
     */
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /*
        判断两个数组是否相同
     */
    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 != null & arr2 == null) || (arr1 == null && arr2 != null)){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
                int[] arr1 = generateRandomArray(maxSize,maxValue);
                int[] arr2 = copyArray(arr1);
                selectSort(arr1);
                compareSort(arr2);
                if (!isEqual(arr1,arr2)){
                    success = false;
                   printArray(arr1);
                    System.out.println(" --- ");
                   printArray(arr2);
                   break;
                }
        }
        System.out.println(success ? "Nice!" : "Fucking fuck");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }


}
