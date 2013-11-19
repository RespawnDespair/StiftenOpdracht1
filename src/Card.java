/**
 * 
 * @author Youri Tjang
 *
 */
public class Card implements Comparable {
	/**
	 * Klaver, Schoppen, Harten of Ruiten 
	 * Hoeft niet perse van type Object te zijn,
	 * vul zelf in
	 */
	Suit suit;
	
	/**
	 * 2,3,4,5,6,7,8,9,10,b,v,k,a
	 * Hoeft niet perse van type Object te zijn,
	 * vul zelf in
	 */
	CardValue value;
        
        public Card(Suit suitVal, CardValue cardVal)
        {
            suit = suitVal;
            value = cardVal;
        }
	
	/**
	 * Pretty-print deze Card als string
	 */
	public String toString(){
		return suit.toString() + " " + value.toString();
	}
        
        /**
         * @param otherCard
         * @return 0 als gelijk, -1 als deze kaart lager dan de andere kaart, 1 als deze hoger dan de andere kaart
         */
        public int CompareTo(Card otherCard)
        {
            if (suit.compareTo(otherCard.suit) == 0)
            {
                return value.compareTo(otherCard.value);
            }
            else
            {
                return suit.compareTo(otherCard.suit);
            }
        }

    @Override
    public int compareTo(Object o) {
        return CompareTo((Card)o);
    }
}
