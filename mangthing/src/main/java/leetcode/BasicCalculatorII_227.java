package leetcode;

import java.util.Stack;

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


    /**
     * 用栈的方法
     * @param s
     * @return
     */
    public static int calculate(String s){
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (!stack.empty() && (stack.peek() == 2 || stack.peek() == 3)) {
                    int sign = stack.pop();
                    int firstNumber = stack.pop();
                    if (sign == 2)
                        stack.push(firstNumber * sum);
                    else if (sign == 3)
                        stack.push(firstNumber / sum);
                } else
                    stack.push(sum);
            } else if (s.charAt(i) == '+')
                stack.push(0);
            else if (s.charAt(i) == '-')
                stack.push(1);
            else if (s.charAt(i) == '*')
                stack.push(2);
            else if (s.charAt(i) == '/')
                stack.push(3);
        }

        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.size() > 1) {
                int num = stack.pop();
                int op = stack.pop();
                if (op == 0)
                    result += num;
                else if (op == 1)
                    result -= num;
            } else
                result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculator(" 1+1+1 "));
    }
}
