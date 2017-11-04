package stringFinder;

import java.util.ArrayList;
import static stringFinder.StringFinderUtils.*;

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
    this.lastCharPosition = getLastChar(this.mainString);
    this.firstCharPosition = getFirstChar(this.mainString, lastCharPosition);

    this.isAllLowerCase = isAllLowerCase(this.mainString, this.firstCharPosition, this.lastCharPosition);
    if (isAllLowerCase) {
      this.mainString = toUpperCase(this.mainString);
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
