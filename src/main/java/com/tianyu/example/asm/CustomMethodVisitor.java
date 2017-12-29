package com.tianyu.example.asm;


import lombok.Setter;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.AdviceAdapter;

/**
 * CustomMethodVisitor
 *
 * @Author yu.tian@mtime.com
 * @Date 17/10/30 17:27
 */
public class CustomMethodVisitor extends AdviceAdapter implements Opcodes{
    private final static int EXCEPTION_STACK = 2 + 1;//max_stack至少需要能够容纳2个常量地址(监控方法使用)和1个exception地址
    private boolean target = false;
    private boolean hasATHROW = false;
    Label l0 = new Label();
    Label l1 = new Label();
    Label l2 = new Label();
    @Setter
    private String targetName;

    public CustomMethodVisitor(MethodVisitor mv,int access,String name, String desc) {
        super(ASM5, mv,access,name,desc);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {

        System.out.println("visitAnnotation: desc="+desc+" visible="+visible);
        if (desc.equals("Lcom/tianyu/example/asm/TestJavaAgent;")) {
            target = true;
        }
        AnnotationVisitor av = super.visitAnnotation(desc,visible);
        return target ? new CustomAnnotationVisitor(av,this) : av;
    }

//    @Override
//    public void visitCode() {
//        mv.visitCode();
//        if (target) {
//            mv.visitTryCatchBlock(start, end, handlerStart, "java/lang/Throwable");
//            mv.visitLabel(start);
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J",false);
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V",false);
//        }
//
//    }
//
//    @Override
//    public void visitInsn(int opcode) {
//        if (opcode >= IRETURN && opcode <= RETURN && target) {
////            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
////            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J",false);
////            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V",false);
//
//            mv.visitLabel(end);
//            mv.visitJumpInsn(GOTO, handlerEnd);
//            mv.visitLabel(handlerStart);
//            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/Exception"});
//            mv.visitVarInsn(ASTORE, 1);
//            mv.visitLabel(l4);
////
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitLdcInsn("aa");
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//
//            Label l5 = new Label();
//            mv.visitLabel(l5);
//            mv.visitVarInsn(ALOAD, 1);
//            mv.visitInsn(ATHROW);
//
//            mv.visitLabel(handlerEnd);
//            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
////            mv.visitInsn(RETURN);
////            Label l5 = new Label();
////            mv.visitLabel(l5);
////            mv.visitLocalVariable("e", "Ljava/lang/Exception;", null, l4, handlerEnd, 1);
////            mv.visitLocalVariable("this", "Lcom/tianyu/example/asm/FirstByteBuddyHelloWorld;", null, start, l5, 0);
//        }
//        mv.visitInsn(opcode);
//    }
//
//    @Override
//    public void visitEnd() {
//        if (target) {
////            mv.visitLabel(end);
////            mv.visitTryCatchBlock(start,end,end,null);
//
////            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
////            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J",false);
////            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V",false);
//
////            mv.visitInsn(ATHROW);
////            mv.visitLabel(l5);
////            mv.visitLocalVariable("t", "Ljava/lang/Throwable;", null, l4, handlerEnd, 1);
////            mv.visitLocalVariable("this", "Lcom/tianyu/example/asm/FirstByteBuddyHelloWorld;", null, start, l5, 0);
//
//            Label l6 = new Label();
//            mv.visitLabel(l6);
//            mv.visitLocalVariable("e", "Ljava/lang/Exception;", null, l4, handlerEnd, 1);
//            mv.visitLocalVariable("this", "Lcom/tianyu/example/asm/FirstByteBuddyHelloWorld;", null, start, l6, 0);
//        }
//
//
//        mv.visitEnd();
//    }
//
//    @Override
//    public void visitMaxs(int maxStack, int maxLocals) {
//        if (target) {
//            mv.visitMaxs(Math.max(EXCEPTION_STACK,maxStack), maxLocals);
//        } else {
//            mv.visitMaxs(maxStack,maxLocals);
//        }
//
//    }

    @Override
    protected void onMethodEnter() {
        if (target) {
            visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
            visitLabel(l0);
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J",false);
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V",false);
        }
        super.onMethodEnter();
    }

    @Override
    public void onMethodExit(int opcode) {
        if(opcode==RETURN) {
            visitInsn(ACONST_NULL);
        } else if(opcode==ATHROW) {
//            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/Exception"});
//            mv.visitVarInsn(ASTORE, 1);

            if (!hasATHROW) {
                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitLdcInsn("thrown !");
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                hasATHROW = true;
            }

//            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ATHROW);
            dup();
        } else {
            if(opcode==LRETURN || opcode==DRETURN) {
                dup2();
            } else {
                dup();
            }
            box(Type.getReturnType(this.methodDesc));
        }
        super.onMethodExit(opcode);
    }



//    @Override
//    public void visitInsn(int opcode) {
////        if (opcode == RETURN && target) {
////            System.out.println(targetName);
////            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
////            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J",false);
////            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V",false);
////        }
//        super.visitInsn(opcode);
//    }
}
