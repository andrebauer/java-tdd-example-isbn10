import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Functions that compute the ISBN10 check digit based on the
 * first nine figures, given in a string.
 *
 * @author André Bauer
 * @version 1.0
 */
public class ISBN10 {
    
  /**
   * Filters out all characters of a given string, except figures.
   * 
   * @param s the input string.
   * @return A string, that only contains the figures from the input string.
   */
  public static String preserveNumbers(String s) {
    return s.replaceAll("[^0-9]","");
  }

  /**
   * Transforms a string to an array of figures. It ignores characters that 
   * are not figures. Each single character that is a figure will be
   * convertet to an int and gets
   * his own entry in the resulting array.
   *
   * @param s the input string.
   * @return An int array, that contains the figures of the input string.
   */
  public static int[] toIntArray(String s) {
    return preserveNumbers(s)
      .chars()
      .mapToObj(c -> "" + (char) c)
      .mapToInt(Integer::parseInt)
      .toArray();
  }

  /**
   * Computes the ISBN10 check digit. The input is an arbitrary string.
   * Only if the sring contains exact nine figures, a valid ISBN10 check
   * will be computed. In all other cases the output is unspecified.
   *
   * @param isbn a string, that should contain exact nine figures.
   * @return The ISBN10 check digit-
   */
  public static char checkDigit(String isbn) {
    int[] ints = toIntArray(isbn);
    int sum = IntStream.range(0, ints.length)
      .map(i -> (i + 1) * ints[i])
      .reduce(0, Integer::sum);
    int digit = sum % 11;
    if (digit == 10) {
      return 'X';
    }
    return Integer.toString(digit).charAt(0);
  }
}
