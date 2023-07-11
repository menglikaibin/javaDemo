package com.visit.demo.part;

import com.visit.demo.visitor.ComputerPartVisitor;

/**
 * @author wuyi
 * @date 2023/7/11
 */
public interface ComputerPart {

    void accept(ComputerPartVisitor computerPartVisitor);

}
