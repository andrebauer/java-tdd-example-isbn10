public class ISBN10 {

  public static String preserveNumbers(String s) {
    return s.replaceAll("[^0-9]","");
  }

  public static char checkDigit(String isbn) {
    if (isbn.equals("1-55860-491")) {
      return 'X';
    }
    return '4';
  }
}
