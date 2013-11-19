/**
 * 
 * @author Jelle
 *
 */
public class App {

	/**
	 * App die onze datastructuur test.
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.fillDeck();
		deck.shuffle();
		
		Card card = new Card(Suit.Spades, CardValue.Ace); // The aces of spades, the ace of spades!
		int testIndex = 30;
		deck.insertAt(card, testIndex);
		System.out.print("Sequential search ...");
		int foundIndex = deck.sequentialSearch(card);
		System.out.println((foundIndex == testIndex)?"Win":"Fail"); // Is niet waar als de fillDeck deze kaart ook al had en deze door de shuffle VOOR de index geplaatst word.
		
		System.out.print("Binary search...");
		deck.sort();
		foundIndex = deck.binarySearch(card);
		System.out.println(foundIndex);
	}
}
