import java.util.Random;
/**
 * A class that generates random math problems.
 * @author Keith Tramm
 * @version 3/20/2024
 */
public class MathGenerator {

    /**
     * Returns three random integers for addition.
     *
     * @param theUpperBound the upper bound (inclusive) of the random integers
     * @param theLowerBound the lower bound (inclusive) of the random integers
     * @param theRand       a random number generator
     * @return an array of three integers, where the first and second integers are the factors, and the third integer is their sum
     */
    public static int[] randomAddition(int theUpperBound, int theLowerBound, Random theRand) {
        int fTerm;
        int sTerm;
        int sum;
        theRand = new Random();

        fTerm = theRand.nextInt(theUpperBound) + theLowerBound;
        sTerm = theRand.nextInt(theUpperBound) + theLowerBound;
        sum = fTerm + sTerm;
        return new int[] {fTerm, sTerm, sum, 1};
    }

    /**
     * Returns three random integers for subtraction.
     *
     * @param theUpperBound the upper bound (inclusive) of the random integers
     * @param theLowerBound the lower bound (inclusive) of the random integers
     * @param theRand       a random number generator
     * @return an array of three integers, where the first and second integers are the factors, and the third integer is their difference
     */
    public static int[] randomDifference(int theUpperBound, int theLowerBound, Random theRand) {
        int fTerm;
        int sTerm;
        int difference;
        theRand = new Random();
        fTerm = theRand.nextInt(theUpperBound) + theLowerBound;
        sTerm = theRand.nextInt(theUpperBound) + theLowerBound;
        difference = fTerm - sTerm;
        return new int[] {fTerm, sTerm, difference, 2};
    }

    /**
     * Returns three random integers for multiplication.
     *
     * @param theUpperBound the upper bound (inclusive) of the random integers
     * @param theLowerBound the lower bound (inclusive) of the random integers
     * @param theRand       a random number generator
     * @return an array of three integers, where the first and second integers are the factors, and the third integer is their product
     */
    public static int[] randomMultiplication(int theUpperBound, int theLowerBound, Random theRand) {
        int fTerm;
        int sTerm;
        int product;
        theRand = new Random();
        fTerm = theRand.nextInt(theUpperBound) + theLowerBound;
        sTerm = theRand.nextInt(theUpperBound) + theLowerBound;
        product = fTerm * sTerm;
        return new int[] {fTerm, sTerm, product, 3};
    }

    /**
     * Returns three random integers for division.
     *
     * @param theUpperBound the upper bound (inclusive) of the random integers
     * @param theLowerBound the lower bound (inclusive) of the random integers
     * @param theRand       a random number generator
     * @return an array of four integers, where the first two integers are the dividend and divisor, and the second two integers are their quotient and remainder
     */
    public static int[] randomDivision(int theUpperBound, int theLowerBound, Random theRand) {
        int fTerm = -1;
        int sTerm = 1;
        int quotient;
        theRand = new Random();
        while (fTerm < sTerm || fTerm % sTerm != 0) {
            fTerm = theRand.nextInt(theUpperBound) + theLowerBound;
            sTerm = theRand.nextInt(theUpperBound) + theLowerBound;
        }
        quotient = fTerm / sTerm;
        return new int[] {fTerm, sTerm, quotient, 4};
    }
}
