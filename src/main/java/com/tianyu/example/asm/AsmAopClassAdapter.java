package com.tianyu.example.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * AsmAopClassAdapter
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/6 10:11
 */
public class AsmAopClassAdapter extends ClassVisitor implements Opcodes{
    private String enhancedSuperName,enhancedName;

    private String method;

    private String startInfo,endInfo;

    public AsmAopClassAdapter(ClassVisitor cv, String methodName, String start, String end) {
        //Responsechain 的下一个 ClassVisitor，这里我们将传入 ClassWriter，
        // 负责改写后代码的输出
        super(ASM5,cv);
        method = methodName;
        startInfo = start;
        endInfo = end;
    }

    // 重写 visitMethod，访问到 "method" 方法时，
    // 给出自定义 MethodVisitor，实际改写方法内容
    public MethodVisitor visitMethod(final int access, final String name,
                                     final String desc, final String signature, final String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;
        if (mv != null) {
            if (name.equals(method)) {
                wrappedMv = new AsmAopMethodAdapter(mv,startInfo,endInfo);
            } else if (name.equals("<init>")) {
                wrappedMv = new ChangeToChildConstructorMethodAdapter(mv,
                        enhancedSuperName);
            }
        }
        return wrappedMv;
    }

    public void visit(final int version, final int access, final String name,
                      final String signature, final String superName,
                      final String[] interfaces) {
        enhancedName = name.replace("/", "$")+"$EnhancedByASM";  // 改变类命名
        enhancedSuperName = name; // 改变父类
        super.visit(version, access, enhancedName, signature,
                enhancedSuperName, interfaces);
    }

    public String getEnhancedName() {
        return enhancedName;
    }
}
