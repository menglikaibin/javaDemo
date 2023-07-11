package com.visit.demo.part;

import com.visit.demo.visitor.ComputerPartVisitor;

/**
 * @author wuyi
 * @date 2023/7/11
 */
public class Computer implements ComputerPart {

    ComputerPart[] computerParts;

    public Computer() {
        computerParts = new ComputerPart[]{new Keyboard(), new Monitor(), new Mouse()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart computerPart : computerParts) {
            computerPart.accept(computerPartVisitor);
        }

        computerPartVisitor.visit(this);
    }
}
