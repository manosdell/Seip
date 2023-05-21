package math;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import io.FileIO;

import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

    static ArrayOperations testClass;

    @BeforeClass
    public static void setUpClass() {
        // code executed once before all tests
        testClass = new ArrayOperations();
    }

    @Test
    public void testFindPrimesInFile() {
        FileIO fileMock = mock(FileIO.class);
        MyMath mathMock = mock(MyMath.class);
        String filepath = "../unittesting/src/test/resources/mock_test_numbers.txt";
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        when(fileMock.readFile(filepath)).thenReturn(numbers);
        when(mathMock.isPrime(1)).thenThrow(IllegalArgumentException.class);
        when(mathMock.isPrime(2)).thenReturn(true);
        when(mathMock.isPrime(3)).thenReturn(true);
        when(mathMock.isPrime(4)).thenReturn(false);
        when(mathMock.isPrime(5)).thenReturn(true);
        when(mathMock.isPrime(6)).thenReturn(false);
        when(mathMock.isPrime(7)).thenReturn(true);
        when(mathMock.isPrime(8)).thenReturn(false);
        when(mathMock.isPrime(9)).thenReturn(false);
        int[] expected = {2, 3, 5, 7};

        int[] actual = testClass.findPrimesInFile(fileMock, filepath, mathMock);
        Assert.assertArrayEquals(expected, actual);


    }
}
