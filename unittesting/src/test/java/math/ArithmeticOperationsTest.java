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
        Assert.assertEquals(3, testClass.divide(15, 5), 0.0001);
    }

    @Test
    public void testDivideByNegative() {
        Assert.assertEquals(-3, testClass.divide(15, -5), 0.0001);
    }

    @Test
    public void testDivideNegative() {
        Assert.assertEquals(-3, testClass.divide(-15, 5), 0.0001);
    }

    @Test
    public void testDivideNegativeByNegative() {
        Assert.assertEquals(3, testClass.divide(-15, -5), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        testClass.divide(15, 0);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(15, testClass.multiply(3, 5));
    }

    @Test
    public void testMultiplyFirstByZero() {
        Assert.assertEquals(0, testClass.multiply(3, 0));
    }

    @Test
    public void testMultiplySecondByZero() {
        Assert.assertEquals(0, testClass.multiply(0, 5));
    }

    @Test
    public void testMultiplyBothByZero() {
        Assert.assertEquals(0, testClass.multiply(0, 0));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMultiplyFirstInputNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(-3, 5);
    }

    @Test
    public void testMultiplySecondInputNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(3, -5);
    }

    @Test
    public void testMultiplyBothInputsNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(-3, -5);
    }

    @Test
    public void testMultiplyFirstInputNegativeSecondInputZero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(-3, 0);
    }

    @Test
    public void testMultiplySecondInputNegativeFirstInputZero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("x & y should be >= 0");
        testClass.multiply(0, -5);
    }

    @Test
    public void testMultiplyFirstInputOverflow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        testClass.multiply(Integer.MAX_VALUE, 2);
    }

    @Test
    public void testMultiplySecondInputOverflow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        testClass.multiply(2, Integer.MAX_VALUE);
    }

    @Test
    public void testMultiplyBothInputsOverflow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The product does not fit in an Integer variable");
        testClass.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    // 1 * max value test
    @Test
    public void testMultiplyMaxBorderSecondInputIsMax() {
        Assert.assertEquals(Integer.MAX_VALUE, testClass.multiply(1, Integer.MAX_VALUE));
    }

    @Test
    public void testMultiplyMaxBorderFirstInputIsMax() {
        Assert.assertEquals(Integer.MAX_VALUE, testClass.multiply(Integer.MAX_VALUE, 1));
    }



}
