package math;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMathTest {
    static MyMath testClass;

    @BeforeClass
    public static void setUpClass() {
        // code executed once before all tests
        testClass = new MyMath();
    }

    @Test
    public void testFactorialZeroInput() {

        Assert.assertEquals(1, testClass.factorial(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegativeInput() {
        testClass.factorial(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialInputTooLarge() {
        testClass.factorial(13);
    }

    @Test
    public void testIsPrimeTrue() {
        Assert.assertEquals(true, testClass.isPrime(2));
    }

    @Test
    public void testIsPrimeFalse() {
        Assert.assertEquals(false, testClass.isPrime(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsPrimeSmallerThanTwoException() {
        testClass.isPrime(1);
    }


}
