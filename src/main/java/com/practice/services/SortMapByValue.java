package com;

import java.util.*;

/**
 * Created by janardhan.nellibanda on 9/21/2016.
 */
public class SortMapByValue {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);

        /*//Sort using VALUE
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }*/

        //

        for(Map.Entry<String, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
    }

}
