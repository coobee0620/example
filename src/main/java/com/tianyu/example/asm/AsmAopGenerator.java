package com.tianyu.example.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

/**
 * AsmAopGenerator
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/6 10:18
 */
public class AsmAopGenerator {
    private AOPGeneratorClassLoader classLoader ;

    public AsmAopGenerator(){
        classLoader = new AOPGeneratorClassLoader();
    }


    public Object proxy(Class c,String methodName,String startInfo,String endInfo) {
        try {
            if (c != null) {
                String classPath = c.toString().replace("/", ".");
                ClassReader cr = new ClassReader(classPath.substring(6, classPath.length()));
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                AsmAopClassAdapter classAdapter = new AsmAopClassAdapter(cw, methodName, startInfo, endInfo);
                cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
                byte[] data = cw.toByteArray();
                Class obj = classLoader.defineClassFromClassFile(classAdapter.getEnhancedName(), data);
                //TODO:隐藏BUG
                return obj.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    class AOPGeneratorClassLoader extends ClassLoader {
        public Class defineClassFromClassFile(String className,
                                              byte[] classFile) throws ClassFormatError {
            return defineClass(className, classFile, 0,
                    classFile.length);
        }
    }
}
