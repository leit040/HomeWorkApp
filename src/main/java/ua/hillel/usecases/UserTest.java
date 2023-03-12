package ua.hillel.usecases;

import ua.hillel.annotations.AfterSuite;
import ua.hillel.annotations.BeforeSuite;
import ua.hillel.annotations.Test;

public class UserTest {

    @BeforeSuite
    public boolean testBefore() {
        System.out.println("Before test running");
        return true;
    }
//    @BeforeSuite
//    public boolean testBefore2() {
//        System.out.println("Before test running");
//        return true;
//    }

    @Test(priority = 1)
    public boolean test1() {
        System.out.println("First test running");
        return true;
    }

    @Test(priority = 3)
    public boolean test2() {
        System.out.println("Second test running");
        return true;
    }

    @Test(priority = 2)
    public boolean test3() {
        System.out.println("Third test running");
        return true;
    }

    @Test(priority = 1)
    public boolean test4() {
        System.out.println("First2 test running");
        return true;
    }

    @AfterSuite
    public boolean testAfter() {
        System.out.println("After test running");
        return true;
    }
}
