package com.sample.interview.hackerrank;

import java.util.HashMap;

public class RepeatString {
    public static void main(String[] args) {
        String str = "abcdefghcd";
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() - 3; i++)//处理的字符串向后移动
        {
            int k = i;
            String str1 = str.substring(i, i + 2);
            String str2 = str.substring(i + 2);
            while (str2.contains(str1))//后面的字串包含前面的
            {
                int cnt = 1;
                String strtemp = str2;
                while (strtemp.contains(str1)) {
                    cnt++;
                    strtemp = strtemp.substring(strtemp.indexOf(str1) + str1.length());
                    //被查找的字符串更新
                }
                if (!map.containsKey(str1))
                    map.put(str1, cnt);//放入HashMap

                str1 = str.substring(i, ++k + 2);//”可能的重复串“扩展
                str2 = str.substring(k + 2);
            }
        }

        int j = 0;//以下程序为了格式化输出
        for (Object key : map.keySet()) {
            j++;
            System.out.print(key + ":" + map.get(key) + "\t");
            if (j % 5 == 0)
                System.out.println();
        }
    }

}