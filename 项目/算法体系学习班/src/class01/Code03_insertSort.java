package class01;

public class Code03_insertSort {
    /*
        排序逻辑：未排序部分中的第一个与已排序部分的最后一个进行比较，如果小则继续往前比，直到找到不比他大的停止
     */
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j ,j+1);
            }
        }
    }

    public static void swap(int[] arr,int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void playArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

