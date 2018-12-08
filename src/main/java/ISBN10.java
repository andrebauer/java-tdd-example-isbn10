import java.util.Arrays;
import java.util.stream.IntStream;

public class ISBN10 {

  public static String preserveNumbers(String s) {
    return s.replaceAll("[^0-9]","");
  }

  public static int[] toIntArray(String s) {
    return preserveNumbers(s)
      .chars()
      .mapToObj(c -> "" + (char) c)
      .mapToInt(Integer::parseInt)
      .toArray();
  }

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
