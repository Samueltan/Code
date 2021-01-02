package com.sample.basic.thread.operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author DuzhenTong
 * @Date 2018/3/18
 * @Time 17:34
 */
public class FailFast {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        iterator(list);
    }

    public static void iterator(List list) {
        Iterator it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            if (index == 6) {
                list.remove(index);
            }
            index++;
            System.out.println(it.next());
        }
    }
}