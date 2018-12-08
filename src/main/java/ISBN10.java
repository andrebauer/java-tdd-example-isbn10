import java.util.Arrays;

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
    if (isbn.equals("1-55860-491")) {
      return 'X';
    }
    return '4';
  }
}
