package com.demo.huawei;

import java.util.*;

public class CheckPWD {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(check(s));
        }
    }

    public static String check(String item) {
        if (item.length() <= 8) {
            return "NG";
        }

        if (getType(item) < 3) {
            return "NG";
        }

        if (checkSub(item, 0, 3)) {
            return "NG";
        }

        return "OK";
    }

    public static Boolean checkSub(String item, int l, int r) {
        if (item.length() <= r) {
            return false;
        }
        if (item.substring(r).contains(item.substring(l, r))) {
            return true;
        } else {
            return checkSub(item, l+1, r+1);
        }
    }

    public static int getType(String item) {

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < item.length(); i++) {
            if ((int)item.charAt(i) <= 47) {
                set.add(1);
            }
            else if ((int)item.charAt(i) <= 57) {
                set.add(2);
            }
            else if ((int)item.charAt(i) <= 64) {
                set.add(1);
            }
            else if ((int)item.charAt(i) <= 90) {
                set.add(3);
            }
            else if ((int)item.charAt(i) <= 96) {
                set.add(1);
            }
            else if ((int)item.charAt(i) <= 122) {
                set.add(4);
            }
            else if ((int)item.charAt(i) <= 126) {
                set.add(4);
            }
        }

        return set.size();
    }

}
