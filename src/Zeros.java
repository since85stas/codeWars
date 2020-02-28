public class Zeros {

    /*Write a program that will calculate the number of trailing zeros in a factorial of a given number.

    N! = 1 * 2 * 3 * ... * N

    Be careful 1000! has 2568 digits...

    For more info, see: http://mathworld.wolfram.com/Factorial.html

    Examples
    zeros(6) = 1
            # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero

    zeros(12) = 2
            # 12! = 479001600 --> 2 trailing zeros*/

    public static int zeros(int n) {
        // Initialize result
        int count = 0;

        // Keep dividing n by powers
        // of 5 and update count
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;

        return count;
    }

}
