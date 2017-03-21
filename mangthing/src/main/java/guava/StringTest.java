package guava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fangshuai on 2016/6/24.
 */
public class StringTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int cur = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1]
                        + arr[i + 2][j + 2];
                max = max > cur ? max : cur;
            }
        }
        System.out.println(max);
    }

    class Solution {
        // Write your code here.
        LinkedList<Character> stack;
        LinkedList<Character> queue;

        Solution() {
            stack = new LinkedList<Character>();
            queue = new LinkedList<Character>();
        }

        void pushCharacter(char c) {
            stack.addFirst(c);
        }

        void enqueueCharacter(char c) {
            queue.addLast(c);
        }

        String popCharacter() {
            StringBuilder stringBuilder = new StringBuilder();
            while (stack.getFirst() != null) {
                stringBuilder.append(stack.getFirst());
                stack.removeFirst();
            }
            return stringBuilder.toString();
        }

        String dequeueCharacter() {
            StringBuilder stringBuilder = new StringBuilder();
            while (queue.getLast() != null) {
                stringBuilder.append(queue.getLast());
                queue.removeLast();
            }
            return stringBuilder.toString();
        }
    }

    interface a {
        int divisorSum(int n);
    }

    class Calculator implements a {
        Calculator() {
        }

        public int divisorSum(int n) {
            List<Integer> list = new ArrayList();
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                }
            }
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            return sum;
        }
    }

}
