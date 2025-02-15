package com.demo.huawei;

import java.util.Scanner;

public class Zhishu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int data = in.nextInt();

        String result = "";

        for(int i = 2; i <= data; i ++) {
            if (data % i == 0) {
                data = data / i;
                result += (i + " ");
                i = 1;
            }
        }

        System.out.println(result);
    }

}
