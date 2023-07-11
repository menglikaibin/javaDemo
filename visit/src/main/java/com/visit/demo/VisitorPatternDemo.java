package com.visit.demo;

import com.visit.demo.part.Computer;
import com.visit.demo.visitor.ComputerPartDisplayVisitor;

/**
 * @author wuyi
 * @date 2023/7/11
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

}
