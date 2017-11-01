package stringFinder;

public class StringFinder{
	
	private String finderText =  null;
	
	public StringFinder(){
	}
	
	public StringFinder(String finderText){
		addFinderText(finderText);
	}
	
	public StringFinder addFinderText(String finderText){
		this.finderText = finderText;
		return this;
	}
	
	public boolean contains(CharSequence s){
		boolean result = finderText.contains(s);
		return result;
	}
}