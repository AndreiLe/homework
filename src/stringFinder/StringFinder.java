package stringFinder;

import java.util.ArrayList;

public class StringFinder {

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
      if (result == false) {
        return false;
      }
    }

    //second check words arrays size
    int patternWordListSize = this.patternText.getWordsListSize();
    int finderWordListSize = this.finderText.getWordsListSize();
    if (finderWordListSize < patternWordListSize) {
      return false;
    }

    //third compare all words
    ArrayList<CharSequence> patternWordList = this.patternText.getWordList();
    ArrayList<CharSequence> finderWordList = this.finderText.getWordList();
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
