package com.demo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 吴凯斌
 * 创建时间 2024/4/9 10:47
 */
public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        //上来先记账
        Arrays.sort(nums);
        //账本上两行数字，第一行，这家存什么样的钱，第二行，这家存了几个钱
        List<Integer> numberlist = new ArrayList<>();
        List<Integer> countlist = new ArrayList<>();

        // 补0防止边界
        numberlist.add(0);
        countlist.add(0);

        // 加入第一家
        numberlist.add(nums[0]);
        countlist.add(1);

        //把第一家是为了方便，否则i-1越界，这个就是记账的操作了，一家家看，一样的合成“一家”
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                //如果相同的话，就增加一次计数
                countlist.set(countlist.size() - 1, countlist.get(countlist.size() - 1) + 1);
            } else {
                //如果不同就是新的出现，记作1
                numberlist.add(nums[i]);
                countlist.add(1);
            }
        }

        int[] dp = new int[countlist.size()];
        dp[0] = 0;
        dp[1] = numberlist.get(1)*countlist.get(1);

        for (int i = 2; i < numberlist.size(); i++) {
            if (numberlist.get(i) - numberlist.get(i - 1) == 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + numberlist.get(i) * countlist.get(i));
            } else {
                dp[i] = dp[i-1] + numberlist.get(i)*countlist.get(i);
            }
        }

        return dp[countlist.size() - 1];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{1, 2, 3, 3, 4, 5, 6}));
    }
}
