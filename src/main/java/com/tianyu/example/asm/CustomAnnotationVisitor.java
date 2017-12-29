package com.tianyu.example.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;

/**
 * CustomAnnotationVisitor
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/1 11:25
 */
public class CustomAnnotationVisitor extends AnnotationVisitor implements Opcodes {
    private CustomMethodVisitor cmv;
    public CustomAnnotationVisitor(AnnotationVisitor av,CustomMethodVisitor cmv) {
        super(ASM5, av);
        this.cmv = cmv;
    }

    @Override
    public void visitEnum(String name, String desc, String value) {
        super.visitEnum(name, desc, value);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        return super.visitAnnotation(name, desc);
    }

    @Override
    public AnnotationVisitor visitArray(String name) {
        return super.visitArray(name);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }

    @Override
    public void visit(String name, Object value) {
        if ("name".equals(name)) {
            cmv.setTargetName((String)value);
        }
        super.visit(name, value);
    }
}
