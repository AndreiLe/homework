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

  public static final CharSequence getName(CharSequence mainString) {
    int lastCharPosition = getLastChar(mainString);
    int firstCharPosition = getFirstChar(mainString, lastCharPosition);
    return getName(mainString, firstCharPosition, lastCharPosition);
  }

  public static final CharSequence getName(CharSequence mainString, int firstCharPosition, int lastCharPosition) {
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
  

  public static final boolean contains(CharSequence finderString, CharSequence patternString) {
    if (finderString == null || patternString == null) {
      return false;
    }
    String tempFinderString = finderString.toString();
    String tempPatternString = patternString.toString();

    //find substring with *
    int resultNum = tempPatternString.indexOf("*");
    if (resultNum > 0) {
      String[] patternStringArr = tempPatternString.split("\\*");
      int patternStringArrL = patternStringArr.length;
      String wordPart = null;
      int wordPartPosition = 0;
      int wordPartL = 0;
      for (int i = 0; i < patternStringArrL; i++) {
        wordPart = patternStringArr[i];
        wordPartL = wordPart.length();
        if (wordPartL == 0) {
          continue;
        }
        resultNum = tempFinderString.indexOf(wordPart, wordPartPosition);
        if (resultNum == -1) {
          return false;
        }
        if (i == 0 && resultNum != wordPartPosition) {
          return false;
        }
        wordPartPosition += resultNum + wordPartL + 1;
      }
      return true;
    }

    //default find substring
    resultNum = tempFinderString.indexOf(tempPatternString);
    if (resultNum == 0) {
      return true;
    }
    return false;
  }
}
