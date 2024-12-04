package com.concurrent.demo;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class MetaspaceDemo extends ClassLoader {

    public static void main(String[] args) {
        MetaspaceDemo metaspaceDemo = new MetaspaceDemo();

        for (int i = 0; i < 10000; i++) {
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/object", null);

            byte[] code = classWriter.toByteArray();
            metaspaceDemo.defineClass("class" + i, code, 0, code.length);
        }
    }

}
