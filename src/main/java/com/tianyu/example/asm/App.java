package com.tianyu.example.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * App
 *
 * @Author yu.tian@mtime.com
 * @Date 17/10/30 16:29
 */
public class App extends ClassLoader implements Opcodes{
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassReader cr=new ClassReader(HelloWorld.class.getName());
        ClassWriter cw=new ClassWriter(cr,ClassWriter.COMPUTE_FRAMES);
        CustomVisitor myv=new CustomVisitor(Opcodes.ASM5,cw);
        cr.accept(myv, ClassReader.EXPAND_FRAMES);

        byte[] code=cw.toByteArray();

        //自定义加载器
        App loader=new App();
        Class<?> appClass=loader.defineClass(null, code, 0,code.length);
        Method[] methods = appClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("sayHello")) {
                try {
                    method.invoke(appClass.newInstance(), new Object[]{});
                } catch (Exception e) {
                    System.out.println(e.getCause().getMessage());
                }
//                method.invoke(appClass.newInstance(), new Object[]{});
            }
        }

//		FileOutputStream f=new FileOutputStream(new File("d:"+File.separator+"ok2.class"));
//		f.write(code);
//		f.close();
    }
}
