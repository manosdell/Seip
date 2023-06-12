package math;

/**
 * The MyMath class provides simple math operations
 * that serve as hands-on practice on Unit Testing.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 2023-05-21
 */
public class MyMath {

    /**
     * Returns the factorial of a number.
     *
     * @param n the number
     * @return the factorial of n
     * @throws IllegalArgumentException when n < 0 or n > 12
     */
    public int factorial(int n) {
        // if n < 0 or n > 12 throw IllegalArgumentException
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);

    }

    /**
     * Checks if the  given number is prime and
     * returns true if it is.
     *
     * @param n the number
     * @return true if n is prime, false otherwise
     * @throws IllegalArgumentException when n < 2
     */
    public boolean isPrime(int n) {
        // if n < 2 throw IllegalArgumentException
        if (n < 2) {
            throw new IllegalArgumentException();
        }

        // check if n is prime
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }
}
