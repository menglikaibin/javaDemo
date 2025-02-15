package com.demo.huawei;

import java.util.Scanner;

public class Jinzhi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String data = str.split("x")[1];
        int length = data.length();

        int index = 0;
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            int num = getNum(data.charAt(index));
            result += getData(i, num);
            index++;
        }

        System.out.println(result);
    }

    private static int getNum(Character character) {
        if (!Character.isDigit(character)) {
            if ('A' == character) {
                return 10;
            }
            if ('B' == character) {
                return 11;
            }
            if ('C' == character) {
                return 12;
            }
            if ('D' == character) {
                return 13;
            }
            if ('E' == character) {
                return 14;
            }
            if ('F' == character) {
                return 15;
            }

            return 10;
        } else {
            return Integer.parseInt(character.toString());
        }
    }

    private static int getData(int count, int num) {
        while (count > 0) {
            num *= 16;
            count--;
        }

        return num;
    }

}
