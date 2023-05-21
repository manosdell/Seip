package math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MyMathParameterizedTest {
    static MyMath testClass = new MyMath();

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int result;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{0, 1}, {1, 1}, {2, 2}, {12, 479001600}};
        return Arrays.asList(data);
    }

    @Test
    public void testFactorial() {
        assertEquals(result, testClass.factorial(input));
    }

}
