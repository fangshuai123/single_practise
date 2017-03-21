package guava;

import java.util.Random;

/**
 * Created by Fangshuai on 2016/8/30.
 */
public class shuffleArray{
    public static void main(String[] args){
        Integer[] array = new Integer[10];
        for (int i = 0; i < 10; i++){
            array[i] = i;
        }
        shuffle2(array);
        for (int i = 0; i < 10; i++){
            System.out.println(array[i]);
        }

    }

    public static int[] shuffle1(int[] arr){
        int[] result = new int[arr.length];
        int count = arr.length;
        for (int i = 0, k = 0, pos = 0; i < count;){
            int r = count - i;
            Random rand = new Random();
            pos = rand.nextInt(r);
            result[k++] = arr[pos];
            i++;
            arr[pos] = arr[r - 1];// 将最后一位数值赋值给已经被使用的pos
        }
        return result;
    }

    public static int[] shuffle(int[] arr){
        int[] arr2 = new int[arr.length];
        int count = arr.length;
        int cbRandCount = 0;// 索引
        int cbPosition = 0;// 位置
        int k = 0;
        int runCount = 0;
        do{
            runCount++;
            Random rand = new Random();
            int r = count - cbRandCount;
            cbPosition = rand.nextInt(r);
            arr2[k++] = arr[cbPosition];
            cbRandCount++;
            arr[cbPosition] = arr[r - 1];// 将最后一位数值赋值给已经被使用的cbPosition
        } while (cbRandCount < count);
        System.out.println("m3运算次数  = " + runCount);
        return arr2;
    }

    public static <T> void shuffle2(T[] arr){
        Random rand = new Random();
        for (int index = arr.length; index > 1; index--){
            int i = index - 1;
            int j = rand.nextInt(index);

            T tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
