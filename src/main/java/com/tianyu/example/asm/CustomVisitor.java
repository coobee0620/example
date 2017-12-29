package com.tianyu.example.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * CustomVisitor
 *
 * @Author yu.tian@mtime.com
 * @Date 17/10/30 16:46
 */
public class CustomVisitor extends ClassVisitor implements Opcodes {
    public CustomVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
//        if (name.equals("sayHello")) {
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J",false);
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V",false);
//        }
        //构造函数不修改字节码
        if ("<init>".equals(name))
        {
            return mv;
        }
        //类定义初始化方法不修改字节码
        if ("<cinit>".equals(name))
        {
            return mv;
        }
        //main函数不修改字节码
        if ("main".equals(name))
        {
            return mv;
        }
        return new CustomMethodVisitor(mv,access,name,desc);
    }
}
