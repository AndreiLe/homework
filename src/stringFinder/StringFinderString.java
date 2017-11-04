package stringFinder;

import java.util.ArrayList;
import static stringFinder.StringFinderUtils.*;

public class StringFinderString {

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
    this.lastCharPosition = getLastChar(this.mainString);
    this.firstCharPosition = getFirstChar(this.mainString, lastCharPosition);

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
