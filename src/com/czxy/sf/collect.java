package com.czxy.sf;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class collect {


    public static void main(String[] args) {


        TreeMap<String,String> map=new TreeMap<>(new Comparator<String>() {
            @Override
            //默认从小到大
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        map.put("a","zhangsan");
        map.put("b","lisi");
        map.put("c","wangwu");
        map.put("d","hehhehe");
        map.put("d","zhaoliu");

        System.out.println(map);

        Set<String> strings = map.keySet();

        for (String ke : strings) {

            System.out.println("key ="+ke +" value="+map.get(ke));
        }


    }
}
