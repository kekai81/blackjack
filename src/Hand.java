import java.util.*;
import jss2.exceptions.*;

public class Hand{
	
	protected ArraySet<Card> inHand;
	protected int handvalue, count;
	
	public Hand(){
		
		inHand = new ArraySet<Card>(12);
		handvalue = 0;
		count = 0;
	}
	
	private void reduceHand(Card newCard){
		
		if((handvalue) > 21){
			if(aceInHand())
				handvalue -= 10;
		}
	}
	
	private boolean aceInHand(){
		
		boolean result = false;
		Card cardchk = null;
		Iterator<Card> scan = inHand.iterator();
		
		while (scan.hasNext() && !result){
			cardchk = scan.next();
			if(cardchk.getValue() == 11){
				cardchk.setValue(1);
				result = true;
			}
		}
		return result;
	}
	
	public Card newCard(Deck currentdeck){
		
		Card result;
		result = currentdeck.getCard();
		inHand.add(result);
		handvalue+=result.getValue();
		reduceHand(result);
		count++;
		
		return result;
	}
	
	public int getHandValue(){
		
		return handvalue;
	}
	
	public Iterator<Card2> iterator(){
		
		return inHand.iterator();
	}
	
	public Card remove(Card crd) throws ElementNotFoundException {
		
		return(inHand.remove(crd));
	}
	
	public String toString(){
		
		String result = "";
		
		Card cardstr = null;
		int i = 0;
		Iterator<Card2> scan = inHand.iterator();
		while (scan.hasNext()){
			cardstr = scan.next();
			result += "card" + i + ": " + cardstr.getValue() + "\n";
			i++;
		}
		return result;
	}
}
