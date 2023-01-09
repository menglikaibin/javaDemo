package com.template.demo;

import com.template.demo.model.Cricket;
import com.template.demo.model.Football;
import com.template.demo.model.Game;

/**
 * @author 吴凯斌
 * 创建时间 2023/1/8 23:36
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();

        Game football = new Football();
        football.play();
    }

}
