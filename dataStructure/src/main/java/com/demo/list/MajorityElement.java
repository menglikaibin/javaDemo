package com.demo.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
                    max = map.get(num);
                    val = num;
                    if (max > nums.length / 2) {
                        return num;
                    }
                }
            } else {
                map.put(num, 1);
            }
        }

        return val;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        Random random = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            // 随机选择一个下标作为候选
            int candidate = nums[randRange(random, 0, nums.length)];
            // 计算是否大于1/2
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int randRange(Random random, int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
