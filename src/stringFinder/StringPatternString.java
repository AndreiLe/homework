package stringFinder;

import java.util.ArrayList;
import static stringFinder.StringFinderUtils.*;

class StringPatternString {

  private int firstCharPosition = 0;
  private int lastCharPosition = 0;
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

    boolean isAllLowerCase = isAllLowerCase(this.mainString, this.firstCharPosition, this.lastCharPosition);
    if (isAllLowerCase) {
      this.mainString = toUpperCase(this.mainString);
    }

    getAllPatternWords();

    return this;
  }

  public final CharSequence getLastNameWord() {
    int wordsListSize = wordsList.size();
    return wordsList.get(wordsListSize - 1);
  }

  public final boolean isLastCharacterWhitespace() {
    int mainStringLength = this.mainString.length();
    int whitespacePosition = lastCharPosition + 1;
    if (whitespacePosition > mainStringLength) {
      whitespacePosition = mainStringLength;
    }
    char lastMainStringChar = this.mainString.charAt(whitespacePosition - 1);
    if (Character.isWhitespace(lastMainStringChar)) {
      return true;
    }
    return false;
  }

  private void getAllPatternWords() {
    wordsList = new ArrayList<CharSequence>();
    char nameChar;
    StringBuilder word = null;

    int wordsCount = 0;
    for (int i = this.firstCharPosition; i < this.lastCharPosition; i++) {
      nameChar = this.mainString.charAt(i);

      if (wordsCount == 0) {
        word = new StringBuilder(1).append(nameChar);
        wordsCount++;
        continue;
      }

      if (Character.isUpperCase(nameChar)) {
        CharSequence listWord = word.toString();
        wordsList.add(listWord);

        word = new StringBuilder(1).append(nameChar);
        wordsCount++;
        continue;
      }

      word.append(nameChar);
      wordsCount++;
    }

    if (word != null) {
      CharSequence listWord = word.toString();
      wordsList.add(listWord);
    }
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
