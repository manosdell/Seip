package math;

import org.junit.*;
import org.junit.Assert;
import org.junit.rules.ExpectedException;


// test class for ArithmeticOperations
public class ArithmeticOperationsTest {
    static ArithmeticOperations testClass;

    @Before
    public void setUp() {
        // code executed before each test
        testClass = new ArithmeticOperations();
    }

    @Test
    public void testDivide() {
        // delta might be unnecessary
        Assert.assertEquals(3, testClass.divide(15, 5), 0.0001);
    }

    @Test
    public void testDivideByNegative() {
        // delta might be unnecessary
        Assert.assertEquals(-3, testClass.divide(15, -5), 0.0001);
    }

    @Test
    public void testDivideNegative() {
        // delta might be unnecessary
        Assert.assertEquals(-3, testClass.divide(-15, 5), 0.0001);
    }

    @Test
    public void testDivideNegativeByNegative() {
        // delta might be unnecessary
        Assert.assertEquals(3, testClass.divide(-15, -5), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // delta might be unnecessary
        testClass.divide(15, 0);
    }

    @Test
    public void testMultiply() {
        // delta might be needed
        Assert.assertEquals(15, testClass.multiply(3, 5));
    }

    @Test
    public void testMultiplyFirstByZero() {
        // delta might be needed
        Assert.assertEquals(0, testClass.multiply(3, 0));
    }

    @Test
    public void testMultiplySecondByZero() {
        // delta might be needed
        Assert.assertEquals(0, testClass.multiply(0, 5));
    }

    @Test
    public void testMultiplyBothByZero() {
        // delta might be needed
        Assert.assertEquals(0, testClass.multiply(0, 0));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMultiplyFirstInputNegative() {
        // delta might be needed
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(-3, 5);
    }

    @Test
    public void testMultiplySecondInputNegative() {
        // delta might be needed
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(3, -5);
    }

    @Test
    public void testMultiplyBothInputsNegative() {
        // delta might be needed
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(-3, -5);
    }

    @Test
    public void testMultiplyFirstInputOverflow() {
        // delta might be needed
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        testClass.multiply(Integer.MAX_VALUE, 2);
    }

    @Test
    public void testMultiplySecondInputOverflow() {
        // delta might be needed
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        testClass.multiply(2, Integer.MAX_VALUE);
    }


}
