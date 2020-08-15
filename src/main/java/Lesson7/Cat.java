package Lesson7;

import Lesson7.Anatations.MarkingAfterSuite;
import Lesson7.Anatations.MarkingBeforeSuite;
import Lesson7.Anatations.MarkingTest;

public class Cat {
    String name;
    int age;

    @MarkingBeforeSuite
    public void beforeTestCat(){
        System.out.println("Run BeforeSuite");
    }

    @MarkingTest
    public void testCat1(){
        System.out.println("Run TestCat() value - default");
    }

    @MarkingTest(value = 10)
    public void testCat2(){
        System.out.println("Run TestCat() value = 10");
    }

    @MarkingTest(value = 1)
    public void testCat3(){
        System.out.println("Run TestCat() value = 1");
    }

    @MarkingAfterSuite
    public void afterTestCat(){
        System.out.println("Run AfterSuite");
    }

    @MarkingAfterSuite
    public void afterTestCat1(){
        System.out.println("Run AfterSuite1");
    }


    public void info(){
        System.out.println("Info");
    }

}
