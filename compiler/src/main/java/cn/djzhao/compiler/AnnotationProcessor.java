package cn.djzhao.compiler;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("cn.djzhao.annotation.MyAnno")
public class AnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        // 注解处理程序中一般使用Messager进行信息输出
        Messager messager = processingEnv.getMessager();
        // 需要指定输出等级
        messager.printMessage(Diagnostic.Kind.NOTE, "DJZHAO-AnnotationProcessor");
        return true;
    }
}
