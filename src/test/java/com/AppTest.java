package com;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testAddition() {
        App app = new App();
        assertEquals(3, app.calculate("add(1,2)", null));
    }

    public void testSubtraction() {
        App app = new App();
        assertEquals(7, app.calculate("sub(10,3)", null));
    }

    public void testMultiplication() {
        App app = new App();
        assertEquals(20, app.calculate("mult(5,4)", null));
    }

    public void testDivision() {
        App app = new App();
        assertEquals(4, app.calculate("div(20,5)", null));
    }

    public void testNestedExpression() {
        App app = new App();
        assertEquals(14,
                app.calculate("add(2,mult(3,4))", null));
    }

    public void testLetExpression() {
        App app = new App();
        assertEquals(8,
                app.calculate("let(a,5,add(a,3))", null));
    }

    public void testNegativeResult() {
        App app = new App();
        assertEquals(-5,
                app.calculate("sub(5,10)", null));
    }

    public void testDivideByZero() {
        App app = new App();

        try {
            app.calculate("div(10,0)", null);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }
}