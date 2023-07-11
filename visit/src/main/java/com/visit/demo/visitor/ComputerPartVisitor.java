package com.visit.demo.visitor;

import com.visit.demo.part.Computer;
import com.visit.demo.part.Keyboard;
import com.visit.demo.part.Monitor;
import com.visit.demo.part.Mouse;

/**
 * @author wuyi
 * @date 2023/7/11
 */
public interface ComputerPartVisitor {

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);

    void visit(Mouse mouse);

    void visit(Computer computer);
}
