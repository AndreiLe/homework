package stringFinder;

import java.util.ArrayList;

public class StringFinder {

  private final StringFinderString finderText = new StringFinderString();
  private final StringPatternString patternText = new StringPatternString();

  public StringFinder() {
  }

  public StringFinder(String finderText) {
    addFinderText(finderText);
  }

  public final StringFinder addFinderText(String finderText) {
    this.finderText.addMainString(finderText);
    return this;
  }

  public final boolean contains(CharSequence patternString) {
    
    if (patternString == null || patternString == "" || patternString == "''"){
      return true;
    }
    
    this.patternText.addMainString(patternString);

    if (this.finderText == null || this.finderText.getWordsListSize() == 0 || this.patternText.getWordsListSize() == 0) {
      return false;
    }

    boolean isLastCharacterWhitespace = this.patternText.isLastCharacterWhitespace();
    if (isLastCharacterWhitespace) {
      boolean result = this.finderText.compareLastWords(this.patternText.getLastNameWord());
      if (!result) {
        return false;
      }
    }

    int patternWordListSize = this.patternText.getWordsListSize();
    int finderWordListSize = this.finderText.getWordsListSize();
    if (finderWordListSize < patternWordListSize) {
      return false;
    }

    ArrayList<CharSequence> patternWordList = this.patternText.getWordList();
    ArrayList<CharSequence> finderWordList = this.finderText.getWordList();
    CharSequence finderWord;
    CharSequence patternWord;
    int i = 0;
    int j = 0;
    boolean result;
    lab1:
    for (; i < patternWordListSize; i++) {
      patternWord = patternWordList.get(i);
      for (; j < finderWordListSize; j++) {
        finderWord = finderWordList.get(j);
        result = StringFinderUtils.contains(finderWord, patternWord);
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
