package tests;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectClasses({TestOrder.class, TestDisabled.class})
public class TestSuites {
}
