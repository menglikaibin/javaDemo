package com.demo.huawei;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Suiji {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        Set<Integer> set = new HashSet<>();
        int count = in.nextInt();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            set.add(in.nextInt());
        }

        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(ints);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}