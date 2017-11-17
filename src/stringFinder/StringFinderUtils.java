package stringFinder;

public class StringFinderUtils {

  public static final int getFirstChar(CharSequence string, int lastChar) {
    int lastCharPosition = lastChar;
    char stringChar;

    while (lastCharPosition-- > 0) {
      stringChar = string.charAt(lastCharPosition);
      if (!Character.isLetterOrDigit(stringChar) && (stringChar != '*')) {
        return ++lastCharPosition;
      }
      if (stringChar == '.') {
        return ++lastCharPosition;
      }
    }

    return 0;
  }

  public static final int getLastChar(CharSequence string) {
    int stringLength = string.length();
    char stringChar;

    while (stringLength-- > 0) {
      stringChar = string.charAt(stringLength);
      if (Character.isLetterOrDigit(stringChar) || (stringChar == '*')) {
        return ++stringLength;
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
    return mainString.subSequence(firstCharPosition, lastCharPosition);
  }

  public static final boolean isAllLowerCase(CharSequence mainString) {
    int lastCharPosition = getLastChar(mainString);
    int firstCharPosition = getFirstChar(mainString, lastCharPosition);
    return isAllLowerCase(mainString, firstCharPosition, lastCharPosition);
  }

  public static final boolean isAllLowerCase(CharSequence mainString, int firstCharPosition, int lastCharPosition) {
    int mainStringLength = mainString.length();
    char stringChar;

    while (mainStringLength-- > 0) {
      stringChar = mainString.charAt(mainStringLength);
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
    
    int resultNum = tempPatternString.indexOf("*");
    if (resultNum > 0) {
      return containsPatternWithAterisk(tempFinderString, tempPatternString);
    }

    return  containsSimplePattern(tempFinderString, tempPatternString);
  }
  
  private static boolean containsPatternWithAterisk(String tempFinderString, String tempPatternString) {
      String[] patternStringArr = tempPatternString.split("\\*");
      int patternStringArrLength = patternStringArr.length;
      String wordPart = null;
      int wordPartPosition = 0;
      int wordPartL = 0;
      for (int i = 0; i < patternStringArrLength; i++) {
        wordPart = patternStringArr[i];
        wordPartL = wordPart.length();
        if (wordPartL == 0) {
          continue;
        }
        int resultNum = tempFinderString.indexOf(wordPart, wordPartPosition);
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
  
  private static boolean containsSimplePattern(String tempFinderString, String tempPatternString) {
    int resultNum = tempFinderString.indexOf(tempPatternString);
    if (resultNum == 0) {
      return true;
    }
    return false;
  }
}
