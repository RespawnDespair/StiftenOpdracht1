import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Een deck met Cards
 * 
 * @author Jelle
 *
 */
public class Deck {
	Card[] cardArray;

	/**
	 * Constructor
	 */
	Deck(){
		cardArray = new Card[0];
	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fillDeck() {
            cardArray = new Card[52];
            int index = 0;
            
            for (Suit suit : Suit.values()) {
                // Doorloop de waarden per suit
                for (CardValue val: CardValue.values())
                {
                    cardArray[index] = new Card(suit, val);
                    index++;
                }
            }
	}

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {
            Card[] biggerArray = new Card[cardArray.length + 1];
            
            System.arraycopy(cardArray, 0, biggerArray, 0, index);
            biggerArray[index] = card;
            System.arraycopy(cardArray, index, biggerArray, index + 1, cardArray.length - index);
            
            cardArray = biggerArray;
            biggerArray = null;
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
            Card[] smallerArray = new Card[cardArray.length - 1];
            
            System.arraycopy(cardArray, 0, smallerArray, 0, index);
            
            for (int i = index + 1; i < cardArray.length; i++)
            {
                smallerArray[i - 1] = cardArray[i];
            }
            
            cardArray = smallerArray;
            smallerArray = null;
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {
            Random rnd = new Random();
            
            // Wissel alle kaarten in het dek 1x
            for (int i =0; i < cardArray.length; i++)
            {
                int newindex = rnd.nextInt(cardArray.length);
                Card oldCard = cardArray[newindex];
                cardArray[newindex] = cardArray[i];
                cardArray[i] = oldCard;
            }
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {
            for (int i =0; i < cardArray.length; i++)
            {
                if (cardArray[i].suit == card.suit && cardArray[i].value == card.value)
                {
                    return i;
                }
            }

            throw new IndexOutOfBoundsException("Kaart niet gevonden");
	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {
            // Per suit en vervolgens per value sorteren
            java.util.Arrays.sort(cardArray);
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbart p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
            // Vereiste is dat we gesorteerd zijn
            int first, last, middle;
            
            first  = 0;
            last   = cardArray.length - 1;
            middle = (first + last)/2;

            while( first <= last )
            {
              if ( cardArray[middle].CompareTo(card) < 0 )
                first = middle + 1;    
              else if ( cardArray[middle].CompareTo(card) == 0 ) 
              {
                return (middle + 1);
              }
              else
                 last = middle - 1;

              middle = (first + last)/2;
           }
            
           return -1;
	}
	
	/**
	 *  Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";
		
		for(int i=0; i<cardArray.length;i++){
			str += cardArray[i];
		}
		return str;
		
	}
}
