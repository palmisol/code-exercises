package AdvancedTopics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationsClass {
    public static void main(String[] args) throws NoSuchMethodException {

        MyClass myClass = new MyClass();
        Method sayHelloMethod = myClass.getClass().getMethod("sayHello");
        MyCustomAnnotation myCustomAnnotation = sayHelloMethod.getAnnotation(MyCustomAnnotation.class);
        myCustomAnnotation.value();
    }

}

class MyClass {

    @MyCustomAnnotation(value = 10)
    public void sayHello(){
        System.out.println("HELLO");
    }
}

@Retention(RetentionPolicy.RUNTIME) //Process at runtime
@Target(ElementType.METHOD) // Target audience for instance type, method, etc..
@interface MyCustomAnnotation {
    int value();
}
