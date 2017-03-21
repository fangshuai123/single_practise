package test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javafx.util.Pair;

/**
 * Created by Fangshuai on 2016/4/13.
 */
public class jianR {

    public static void main(String[] args) {

        //        TreeMap<Integer, Long> a = Maps.newTreeMap(Ordering.natural().reverse());
        //        a.put(1, 1L);
        //        a.put(1, 2L);
        //        a.put(2, 3L);
        //        a.put(3, 4L);
        //        a.put(4, 5L);
        //        a.put(5, 6L);
        //        TreeMap<Integer, Long> b = new TreeMap<Integer, Long>();
        //        for (Entry<Integer, Long> entry : a.entrySet()) {
        //            if (entry.getValue() == 4) {
        //                b.put(entry.getKey(), entry.getValue());
        //            }
        //        }
        //
        //        for (Entry<Integer, Long> entry : b.entrySet()) {
        //            if (entry.getValue() == 4) {
        //                a.remove(entry.getKey());
        //            }
        //        }
        //        while (a.lastKey() < 3) {
        //            a.remove(a.lastKey());
        //        }
        //        System.out.println(a);

        List<Pair<Long, Integer>> list = Lists.newLinkedList();
        list.add(new Pair<Long, Integer>(1L, 2));
        list.add(new Pair<Long, Integer>(2L, 2));
        list.add(new Pair<Long, Integer>(3L, 2));
        list.add(new Pair<Long, Integer>(4L, 2));
        list.add(new Pair<Long, Integer>(5L, 2));
        list.add(new Pair<Long, Integer>(6L, 2));
        list.add(new Pair<Long, Integer>(7L, 2));

        while (list.size() > 0 && list.get(0).getKey() < 7) {
            list.remove(0);
        }
        System.out.println(list);

        //        for (int i = list.size() - 1; i >= 0; i--) {
        //            if (list.get(i).getKey() < 3) {
        //                list.remove(i);
        //            }
        //        }

    }

    static class A {
        int a;

        A(int a) {
            this.a = a;
        }
    }
}
