package com.composite.demo;

import com.composite.demo.model.Employee;

/**
 * @author wuyi
 * @date 2023/4/19
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO", 30000);
        Employee headSales = new Employee("Robert","Head Sales", 20000);
        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(CEO);
        for (Employee subordinate : CEO.getSubordinates()) {
            System.out.println(subordinate);
            for (Employee employee : subordinate.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
