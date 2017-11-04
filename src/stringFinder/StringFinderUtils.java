package stringFinder;

public class StringFinderUtils {

  public static final int getFirstChar(CharSequence string, int lastChar) {
    int L = lastChar;
    char stringChar = (char) 0;

    while (L-- > 0) {
      stringChar = string.charAt(L);
//      System.out.println(stringChar);
      if (!Character.isLetterOrDigit(stringChar) && (stringChar != '*')) {
        return ++L;
      }
      if (stringChar == '.') {
        return ++L;
      }
    }

    return 0;
  }

  public static final int getLastChar(CharSequence string) {
    int L = string.length();
    char stringChar = (char) 0;

    while (L-- > 0) {
      stringChar = string.charAt(L);
//      System.out.println(stringChar);
      if (Character.isLetterOrDigit(stringChar) || (stringChar == '*')) {
        return ++L;
      }
    }

    return 0;
  }

  public static final CharSequence getNameString(CharSequence mainString) {
    int lastCharPosition = getLastChar(mainString);
    int firstCharPosition = getFirstChar(mainString, lastCharPosition);
    return getNameString(mainString, firstCharPosition, lastCharPosition);
  }

  public static final CharSequence getNameString(CharSequence mainString, int firstCharPosition, int lastCharPosition) {
    CharSequence nameString = mainString.subSequence(firstCharPosition, lastCharPosition);
    //System.out.println(nameString);
    return nameString;
  }

  public static final boolean isAllLowerCase(CharSequence mainString) {
    int lastCharPosition = getLastChar(mainString);
    int firstCharPosition = getFirstChar(mainString, lastCharPosition);
    return isAllLowerCase(mainString, firstCharPosition, lastCharPosition);
  }

  public static final boolean isAllLowerCase(CharSequence mainString, int firstCharPosition, int lastCharPosition) {

    int L = mainString.length();
    char stringChar = (char) 0;

    while (L-- > 0) {
      stringChar = mainString.charAt(L);
      if (Character.isUpperCase(stringChar)) {
        return false;
      }
    }

    return true;
  }

  public static final CharSequence toUpperCase(CharSequence mainString) {
    String lowerCaseString = mainString.toString();
    CharSequence upperCaseString = lowerCaseString.toUpperCase();
    return upperCaseString;
  }
}
