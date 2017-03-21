package test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by FangShuai on 2017/1/3.
 */
public class LinkedAndArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = Lists.newArrayList();
        LinkedList<Integer> linkedList = Lists.newLinkedList();

        for (int i = 0; i < 10000000; i++) {
            arrayList.add(ThreadLocalRandom.current().nextInt());
            linkedList.add(ThreadLocalRandom.current().nextInt());
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            for (Integer integer : arrayList) {

            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            for (Integer integer : linkedList) {

            }
        }

        System.out.println(System.currentTimeMillis() - startTime);

    }
}
