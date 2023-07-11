package com.visit.demo.visitor;

import com.visit.demo.part.Computer;
import com.visit.demo.part.Keyboard;
import com.visit.demo.part.Monitor;
import com.visit.demo.part.Mouse;

/**
 * @author wuyi
 * @date 2023/7/11
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("display keyboard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("display monitor");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("display mouse");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("display computer");
    }
}
