package ua.hillel;



import ua.hillel.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {

    public static void start(String className) throws Exception {


        List<Method> before = new ArrayList<>();
        List<Method> after = new ArrayList<>();
        Queue<Method> tests = new PriorityQueue<>( mComparator);
        Class<?> clazz = Class.forName(className);
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {

            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                switch (annotation.annotationType().getSimpleName()) {
                    case "Test":
                        tests.add(method);
                        break;
                    case "BeforeSuite":
                        before.add(method);
                        break;
                    case "AfterSuite":
                        after.add(method);
                        break;
                    default:
                        break;
                }
            }
        }
        if (before.size() > 1 || after.size() > 1) {
            throw new ua.hillel.exeptions.TestRunnerException();
        }
        for (Method m : before) {
            m.invoke(obj);

        }
        tests.forEach((method -> {
            try {
                method.invoke(obj);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }));

        for (Method m : after) {
            m.invoke(obj);

        }

    }

    public static Comparator<Method> mComparator = new Comparator<Method>() {
        public int compare(Method m1, Method m2) {
            return (m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority());
        }
    };

}
