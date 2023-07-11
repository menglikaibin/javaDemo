package com.visit.demo.part;

import com.visit.demo.visitor.ComputerPartVisitor;

/**
 * @author wuyi
 * @date 2023/7/11
 */
public class Monitor implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
