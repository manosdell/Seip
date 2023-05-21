package math;

/**
 * The MathOperations provides simple arithmetic operations
 * that serve as hands-on practice on Unit Testing.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 2023-05-21
 */
public class ArithmeticOperations {

    /**
     * Performs the basic arithmetic operation of division.
     *
     * @param numerator   the numerator of the operation
     * @param denominator the denominator of the operation
     * @return the result of the division between numerator and denominator
     * @throws ArithmeticException when denominator is zero
     */
    public double divide(double numerator, double denominator) {
        if (denominator == 0) throw new ArithmeticException("Cannot divide with zero");

        return numerator / denominator;
    }


    /**
     * Performs the basic arithmetic operation of multiplication
     * between two positive Integers
     *
     * @param x the first input
     * @param y the second input
     * @return the product of the multiplication
     * @throws IllegalArgumentException when <b>x</b> or <b>y</b> are negative numbers
     * @throws IllegalArgumentException when the product does not fit in an Integer variable
     */
    public int multiply(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x & y should be >= 0");
        } else if (x <= Integer.MAX_VALUE / y) {
            return x * y;
        } else {
            throw new IllegalArgumentException("The product does not fit in an Integer variable");
        }
    }

}
