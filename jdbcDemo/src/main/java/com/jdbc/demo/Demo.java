package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 1.加载并注册jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.建立数据库连接
            connection = DriverManager.getConnection("");

            // 3.创建statement对象
            statement = connection.createStatement();

            // 4.执行sql语句
            ResultSet resultSet = statement.executeQuery("select * from user order by id desc limit 100");

            // 5.处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + "\t" + resultSet.getString("age"));
            }

        } catch (Exception e) {

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
