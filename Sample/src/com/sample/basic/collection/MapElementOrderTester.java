package com.sample.basic.collection;

import java.util.*;

public class MapElementOrderTester {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //HashMap
        System.out.println("------HashMap无序输出------");
        HashMap<Integer, String> hsMap=new HashMap<>();
        hsMap.put(3, "Value3");
        hsMap.put(1, "Value1");
        hsMap.put(2, "Value2");
        hsMap.put(5, "ValueB");
        hsMap.put(4, "ValueA");
        Iterator it = hsMap.entrySet().iterator();
        while (it.hasNext()) { Map.Entry e = (Map.Entry) it.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
        System.out.println();
        for(Map.Entry<Integer, String> e : hsMap.entrySet()) {
            System.out.println("Key: " + e.getKey() + " --Value: " + e.getValue());
        }

        //TreeMap
        System.out.println("------TreeMap按Key排序输出------");
        TreeMap teMap=new TreeMap();
        teMap.put("3", "Value3");
        teMap.put("1", "Value1");
        teMap.put("2", "Value2");
        teMap.put("b", "ValueB");
        teMap.put("a", "ValueA");
        Iterator tit = teMap.entrySet().iterator();
        while (tit.hasNext()) { Map.Entry e = (Map.Entry) tit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }

        //LinkedHashMap
        System.out.println("--LinkedHashMap根据输入的顺序输出--");
        LinkedHashMap lhsMap=new LinkedHashMap();
        lhsMap.put("3", "Value3");
        lhsMap.put("1", "Value1");
        lhsMap.put("2", "Value2");
        lhsMap.put("b", "ValueB");
        lhsMap.put("a", "ValueA");
        Iterator lit = lhsMap.entrySet().iterator();
        while (lit.hasNext()) { Map.Entry e = (Map.Entry) lit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
    }
}
