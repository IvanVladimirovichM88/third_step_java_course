package Lesson7;

import Lesson7.Anatations.MarkingAfterSuite;
import Lesson7.Anatations.MarkingBeforeSuite;
import Lesson7.Anatations.MarkingTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestingClass {

    static void star(Class testClass){
        Method[] allMethods = testClass.getDeclaredMethods();

        ArrayList<Method> testMethods= new ArrayList<>();

        int count = 0;

        for (Method m :
                allMethods) {
            if (m.getAnnotation(MarkingBeforeSuite.class) != null){
                try {
                    count++;
                    if (count ==1) {
                        m.invoke(testClass.newInstance());
                    }else{
                        throw new RuntimeException(" в классе больше одного метода с анатацией MarkingBeforeSuite");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }


        for (Method m :
                allMethods) {
            if (m.getAnnotation(MarkingTest.class) != null){
                testMethods.add(m);
            }
        }

        Collections.sort(testMethods, new SortByAnon());


        for (Method m :
                testMethods) {
            try {
                 m.invoke(testClass.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        count = 0;
        for (Method m :
                allMethods) {
            if (m.getAnnotation(MarkingAfterSuite.class) != null){
                try {
                    count ++;
                    if (count == 1 ){
                        m.invoke(testClass.newInstance());
                    }else{
                        throw new RuntimeException(" в классе больше одного метода с анатацией MarkingAfterSuite");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class SortByAnon implements Comparator<Method> {

    @Override
    public int compare(Method o1, Method o2) {
        return  o1.getAnnotation(MarkingTest.class).value() - o2.getAnnotation(MarkingTest.class).value();
    }
}