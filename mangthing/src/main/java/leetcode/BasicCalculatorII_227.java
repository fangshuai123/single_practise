package leetcode;

/**
 * Created by Fangshuai on 2016/3/3.
 */
public class BasicCalculatorII_227 {

    public static int calculator(String s) {
        int result = 0;
        char[] ctr = s.toCharArray();
        int[] num = new int[ctr.length];
        int n = 0;
        int m = 0;
        char[] ops = new char[ctr.length];
        for (int i = 0; i < ctr.length; ) {
            if (ctr[i] == ' ') {
                i++;
                continue;
            } else if (ctr[i] <= '9' && ctr[i] >= '0') {
                int temp = 0;
                while (i < ctr.length && ctr[i] <= '9' && ctr[i] >= '0') {
                    temp = temp * 10 + Integer.parseInt(String.valueOf(ctr[i]));
                    i++;
                }
                num[n] = temp;
                n++;
            } else if (ctr[i] == '+' || ctr[i] == '-') {
                ops[m] = ctr[i];
                i++;
                m++;
            } else if (ctr[i] == '*') {
                i++;
                int temp = 0;
                while (ctr[i] == ' ') {
                    i++;
                }
                while (i < ctr.length && ctr[i] <= '9' && ctr[i] >= '0') {
                    temp = temp * 10 + Integer.parseInt(String.valueOf(ctr[i]));
                    i++;
                }
                num[n - 1] = num[n - 1] * temp;
            } else if (ctr[i] == '/') {
                i++;
                int temp = 0;
                while (ctr[i] == ' ') {
                    i++;
                }
                while (i < ctr.length && ctr[i] <= '9' && ctr[i] >= '0') {
                    temp = temp * 10 + Integer.parseInt(String.valueOf(ctr[i]));
                    i++;
                }
                num[n - 1] = num[n - 1] / temp;
            }
        }
        result= num[0];
        for (int i = 1, j = 0; i < n && j < n; j++) {

            switch (ops[j]) {
                case '+': {
                    result = result + num[i];
                    i++;
                    continue;
                }
                case '-': {
                    result = result - num[i];
                    i++;
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculator(" 1+1+1 "));
    }
}
