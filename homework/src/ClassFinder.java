import java.io.IOException;
import static java.lang.System.out;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import java.util.ArrayList;

class ClassFinder {
  public static void main(String[] args) throws IOException {
    //String[] args = {"F:\\Desktop\\работа\\codeborne\\work 1\\javaHome\\src\\classes.txt", "'B*z '"};
         
	StringFinder stringFinder = new StringFinder();
	
    readAllLines(get(args[0]))
            .stream()
            .sorted(
                    (String l, String l2) -> 
                            StringFinderUtils.getNameString(l).toString().compareTo(StringFinderUtils.getNameString(l2).toString())
            )
            .filter(
                    l -> stringFinder
                            .addFinderText(l)
                            .contains(args[1])
            )
            .forEach(
                    l -> out.println(l)
            );

  }
}



class StringFinder {

  private StringFinderString finderText = new StringFinderString();
  private StringPatternString patternText = new StringPatternString();

  public StringFinder() {
  }

  public StringFinder(String finderText) {
    addFinderText(finderText);
  }

  public final StringFinder addFinderText(String finderText) {
    this.finderText.addMainString(finderText);
    return this;
  }

  public final boolean contains(CharSequence s) {
    
    if (s == null || s == "" || s == "''"){
      return true;
    }
    
    boolean result = false;

    this.patternText.addMainString(s);

    if (this.finderText == null || this.finderText.getWordsListSize() == 0 || this.patternText.getWordsListSize() == 0) {
      return false;
    }

    //first check Whitespace in the end
    boolean isLastCharacterWhitespace = this.patternText.isLastCharacterWhitespace();
    if (isLastCharacterWhitespace) {
      result = this.finderText.compareLastWords(this.patternText.getLastNameWord());
      //end compare if result false
      if (result == false) {
        return false;
      }
    }

    //second check words arrays size
    ArrayList<CharSequence> patternWordList = this.patternText.getWordList();
    ArrayList<CharSequence> finderWordList = this.finderText.getWordList();
    int patternWordListSize = patternWordList.size();
    int finderWordListSize = finderWordList.size();
    if (finderWordListSize < patternWordListSize) {
      return false;
    }

    //third compare all words
    CharSequence finderWord = null;
    CharSequence patternWord = null;
    int i = 0;
    int j = 0;
    result = false;
    lab1:
    for (; i < patternWordListSize; i++) {
      patternWord = patternWordList.get(i);
      for (; j < finderWordListSize; j++) {
        finderWord = finderWordList.get(j);
        result = this.finderText.compareWords(finderWord, patternWord);
        if (result) {
          j++;
          continue lab1;
        }
      }
      return false;
    }

    return true;
  }
}

class StringFinderString {

  private int firstCharPosition = 0;
  private int lastCharPosition = 0;
  private CharSequence mainString = null;
  private ArrayList<CharSequence> wordsList;

  public StringFinderString() {
  }

  public StringFinderString(CharSequence mainString) {
    this.addMainString(mainString);
  }

  public final StringFinderString addMainString(CharSequence mainString) {
    this.mainString = mainString;
    this.lastCharPosition = StringFinderUtils.getLastChar(this.mainString);
    this.firstCharPosition = StringFinderUtils.getFirstChar(this.mainString, lastCharPosition);

    getAllWords();

    return this;
  }

  private final ArrayList<CharSequence> getAllWords() {
    wordsList = new ArrayList<CharSequence>();
    char nameChar = (char) 0;
    StringBuilder word = null;

    int wordsCount = 0;
    for (int i = this.firstCharPosition; i < this.lastCharPosition; i++) {
      nameChar = this.mainString.charAt(i);

      //create first word alwais
      if (wordsCount == 0) {
        word = new StringBuilder(1).append(nameChar);
        wordsCount++;
        continue;
      }
      //create new word
      if (Character.isUpperCase(nameChar)) {
        CharSequence listWord = word.toString();
        wordsList.add(listWord);

        word = new StringBuilder(1).append(nameChar);
        wordsCount++;
        continue;
      }
      //add letter to old word
      if (Character.isLowerCase(nameChar)) {
        word.append(nameChar);
        wordsCount++;
        continue;
      }
    }
    //add last word alwais
    if (word != null) {
      CharSequence listWord = word.toString();
      wordsList.add(listWord);
    }

    return wordsList;
  }

  public final int getWordsListSize() {
    if (this.wordsList == null) {
      return 0;
    }
    return this.wordsList.size();
  }

  public final CharSequence getLastNameWord() {
    int wordsListSize = wordsList.size();
    CharSequence lastNameWord = wordsList.get(wordsListSize - 1);
    return lastNameWord;
  }

  public final boolean compareLastWords(CharSequence patternString) {
    CharSequence finderString = this.getLastNameWord();
    boolean result = compareWords(finderString, patternString);
    return result;
  }

  public final boolean compareWords(CharSequence finderString, CharSequence patternString) {
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
        resultNum = tempFinderString.indexOf(wordPart, wordPartPosition);
        if (resultNum == -1) {
          return false;
        }
        if (i == 0 && resultNum != wordPartPosition) {
          return false;
        }
        wordPartPosition += wordPartL + 1;
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

  public final ArrayList<CharSequence> getWordList() {
    return this.wordsList;
  }
}

class StringPatternString {

  private int firstCharPosition = 0;
  private int lastCharPosition = 0;
  private boolean isAllLowerCase = false;
  private CharSequence mainString = null;
  private ArrayList<CharSequence> wordsList = null;

  public StringPatternString() {
  }

  public StringPatternString(CharSequence mainString) {
    this.addMainString(mainString);
  }

  public final StringPatternString addMainString(CharSequence mainString) {
    this.mainString = mainString;
    this.lastCharPosition = StringFinderUtils.getLastChar(this.mainString);
    this.firstCharPosition = StringFinderUtils.getFirstChar(this.mainString, lastCharPosition);

    this.isAllLowerCase = StringFinderUtils.isAllLowerCase(this.mainString, this.firstCharPosition, this.lastCharPosition);
    if (isAllLowerCase) {
      this.mainString = StringFinderUtils.toUpperCase(this.mainString);
    }

    getAllPatternWords();

    //getNameString(this.mainString);
    return this;
  }

  public final CharSequence getLastNameWord() {
    int wordsListSize = wordsList.size();
    CharSequence lastNameWord = wordsList.get(wordsListSize - 1);
    return lastNameWord;
  }

  public final boolean isLastCharacterWhitespace() {
    int mainStringL = this.mainString.length();
    int L = lastCharPosition + 1;
    if (L > mainStringL) {
      L = mainStringL;
    }
    char lastMainStringChar = this.mainString.charAt(L - 1);
    if (Character.isWhitespace(lastMainStringChar)) {
      return true;
    }
    return false;
  }

  private final ArrayList<CharSequence> getAllPatternWords() {
    wordsList = new ArrayList<CharSequence>();
    char nameChar = (char) 0;
    StringBuilder word = null;

    int wordsCount = 0;
    for (int i = this.firstCharPosition; i < this.lastCharPosition; i++) {
      nameChar = this.mainString.charAt(i);

      //create first word alwais
      if (wordsCount == 0) {
        word = new StringBuilder(1).append(nameChar);
        wordsCount++;
        continue;
      }
      //create new word
      if (Character.isUpperCase(nameChar)) {
        CharSequence listWord = word.toString();
        wordsList.add(listWord);

        word = new StringBuilder(1).append(nameChar);
        wordsCount++;
        continue;
      }
      //add letter to old word
      if (Character.isLowerCase(nameChar) || (nameChar == '*')) {
        word.append(nameChar);
        wordsCount++;
        continue;
      }
    }
    //add last word alwais
    if (word != null) {
      CharSequence listWord = word.toString();
      wordsList.add(listWord);
    }

    return wordsList;
  }

  public final int getWordsListSize() {
    if (this.wordsList == null) {
      return 0;
    }
    return this.wordsList.size();
  }

  public final ArrayList<CharSequence> getWordList() {
    return this.wordsList;
  }
}


class StringFinderUtils {

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
    int lastCharPosition = StringFinderUtils.getLastChar(mainString);
    int firstCharPosition = StringFinderUtils.getFirstChar(mainString, lastCharPosition);
    return getNameString(mainString, firstCharPosition, lastCharPosition);
  }

  public static final CharSequence getNameString(CharSequence mainString, int firstCharPosition, int lastCharPosition) {
    CharSequence nameString = mainString.subSequence(firstCharPosition, lastCharPosition);
    //System.out.println(nameString);
    return nameString;
  }

  public static final boolean isAllLowerCase(CharSequence mainString) {
    int lastCharPosition = StringFinderUtils.getLastChar(mainString);
    int firstCharPosition = StringFinderUtils.getFirstChar(mainString, lastCharPosition);
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
