package ua.hillel.exeptions;

public class TestRunnerException extends Exception{
public TestRunnerException(){
    super("Only one BeforeSuite and AfterSuite annotation can be here");
}
}
