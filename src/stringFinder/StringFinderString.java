package stringFinder;

import java.util.ArrayList;
import static stringFinder.StringFinderUtils.*;

public class StringFinderString {

  private int firstCharPosition;
  private int lastCharPosition;
  private CharSequence mainString;
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

  private void getAllWords() {
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

  public final CharSequence getLastNameWord() {
    int wordsListSize = wordsList.size();
    CharSequence lastNameWord = wordsList.get(wordsListSize - 1);
    return lastNameWord;
  }

  public final boolean compareLastWords(CharSequence patternString) {
    CharSequence finderString = this.getLastNameWord();
    boolean result = contains(finderString, patternString);
    return result;
  }

  public final ArrayList<CharSequence> getWordList() {
    return this.wordsList;
  }
}
