package guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Iterator;
import java.util.Map;

import javafx.util.Pair;

/**
 * Created by Fangshuai on 2016/7/15.
 */
public class MultiMapTest{
    public static void main(String[] args){
        Multimap<Integer, Pair<Integer, Integer>> map = HashMultimap.create();
        map.put(1, new Pair<Integer, Integer>(1, 2));
        map.put(1, new Pair<Integer, Integer>(2, 2));
        map.put(1, new Pair<Integer, Integer>(3, 3));
        map.put(2, new Pair<Integer, Integer>(1, 2));

        Iterator<Map.Entry<Integer, Pair<Integer, Integer>>> iter = map
                .entries().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer, Pair<Integer, Integer>> entry = iter.next();
            System.out.println(entry.getKey() + " " + entry.getValue().getKey()
                    + " " + entry.getValue().getValue());
            if (entry.getValue().getKey() == 2){
                iter.remove();
            }
        }
        iter = map.entries().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer, Pair<Integer, Integer>> entry = iter.next();
            System.out.println(entry.getKey() + " " + entry.getValue().getKey()
                    + " " + entry.getValue().getValue());
        }
    }
}
