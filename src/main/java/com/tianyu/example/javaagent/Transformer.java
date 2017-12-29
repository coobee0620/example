package com.tianyu.example.javaagent;

import com.tianyu.example.asm.CustomVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Transformer
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/2 17:27
 */
public class Transformer implements ClassFileTransformer{
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            ClassReader cr = new ClassReader(className);
            ClassWriter cw=new ClassWriter(ClassWriter.COMPUTE_MAXS);
            CustomVisitor myv=new CustomVisitor(Opcodes.ASM5,cw);
            cr.accept(myv, 0);
            return cw.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
