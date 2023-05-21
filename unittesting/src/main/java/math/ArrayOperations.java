package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
 * The ArrayOperations class contains methods that perform
 * operations on arrays of numbers.
 * The methods serve as hands-on practice on Unit Testing.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 2023-05-21
 */
public class ArrayOperations {

    /**
     * Finds the prime numbers in the given file
     * (given as a filepath) and returns an array
     * containing only the prime numbers.
     *
     * @param fileIo   the FileIO object that will read the file
     * @param filepath the file that contains the numbers
     * @param myMath   the MyMath object that will check if a number is prime
     * @return an array of prime numbers
     * @throws IllegalArgumentException when the given array is empty
     */
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {

        int[] numbers = fileIo.readFile(filepath);
        List<Integer> primesList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            try {
                if (myMath.isPrime(numbers[i])) {
                    primesList.add(numbers[i]);
                }
            } catch (IllegalArgumentException e) {
            }
        }

        return primesList.stream().mapToInt(i -> i).toArray();
    }
}
