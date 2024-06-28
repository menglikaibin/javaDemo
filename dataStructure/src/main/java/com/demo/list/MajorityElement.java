package com.demo.list;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);

        int max = 0;
        int val = 0;
        for (int num : nums) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) + 1 >= max) {
                    max = map.get(num) + 1;
                    val = num;
                }
            } else {
                map.put(num, 1);
            }
        }

        return val;
    }

}
