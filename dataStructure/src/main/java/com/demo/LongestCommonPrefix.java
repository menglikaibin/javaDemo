package com.demo;

/**
 * @author 吴凯斌
 * 创建时间 2024/3/25 19:40
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int slength = str.length();
            int plength = prefix.length();

            int length = Math.min(slength, plength);

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if (prefix.charAt(j) == str.charAt(j)) {
                    result.append(str.charAt(j));
                } else {
                    break;
                }
            }

            prefix = result.toString();
        }

        return prefix;
    }

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flow", "flower", "flwwwwww"}));

    }

}
