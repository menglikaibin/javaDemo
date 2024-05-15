package com.demo.list;

import com.github.javafaker.Faker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

/**
 * @author wukaibin
 */
public class Demo {

    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("zh-CN"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("franchisees.csv"));
            writer.write("加盟商编号,加盟商姓名,联系方式,加盟商状态\n");
            for (int i = 1; i <= 200; i++) {
                String franchiseeNumber = String.format("%03d", i);
                String name = faker.name().fullName();
                String phoneNumber = faker.phoneNumber().cellPhone();
                String status = i % 2 == 0 ? "活跃" : "休眠";
                writer.write(franchiseeNumber + "," + name + "," + phoneNumber + "," + status + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
