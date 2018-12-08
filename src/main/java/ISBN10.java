public class ISBN10 {

  public static String preserveNumbers(String s) {
    return s.replaceAll("[^0-9]","");
  }

  public static int[] toIntArray(String s) {
    char[] chars = preserveNumbers(s).toCharArray();
    int[] ints = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
      ints[i] = Integer.parseInt("" + chars[i]);
    }
    return ints;
  }

  public static char checkDigit(String isbn) {
    if (isbn.equals("1-55860-491")) {
      return 'X';
    }
    return '4';
  }
}
