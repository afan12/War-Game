
public class Card {
	//Attributes
	private String value;
	private String suit;
	private int weight;
	
	//Constructors
	public Card(int rnd) {
		if (rnd == 52 || rnd == 39 || rnd == 26 || rnd == 13) {
			value = "King";
			weight = 13;
		}
		else if (rnd == 51 || rnd == 38 || rnd == 25 || rnd == 12) {
			value = "Queen";
			weight = 12;
		}
		else if (rnd == 50 || rnd == 37 || rnd == 24 || rnd == 11) {
			value = "Jack";
			weight = 11;
		}
		else if (rnd == 49 || rnd == 36 || rnd == 23 || rnd == 10) {
			value = "10";
			weight = 10;
		}
		else if (rnd == 48 || rnd == 35 || rnd == 22 || rnd == 9) {
			value = "9";
			weight = 9;
		}
		else if (rnd == 47 || rnd == 34 || rnd == 21 || rnd == 8) {
			value = "8";
			weight = 8;
		}
		else if (rnd == 46 || rnd == 33 || rnd == 20 || rnd == 7) {
			value = "7";
			weight = 7;
		}
		else if (rnd == 45 || rnd == 32 || rnd == 19 || rnd == 6) {
			value = "6";
			weight = 6;
		}
		else if (rnd == 44 || rnd == 31 || rnd == 18 || rnd == 5) {
			value = "5";
			weight = 5;
		}
		else if (rnd == 43 || rnd == 30 || rnd == 17 || rnd == 4) {
			value = "4";
			weight = 4;
		}
		else if (rnd == 42 || rnd == 29 || rnd == 16 || rnd == 3) {
			value = "3";
			weight = 3;
		}
		else if (rnd == 41 || rnd == 28 || rnd == 15 || rnd == 2) {
			value = "2";
			weight = 2;
		}
		else if (rnd == 40 || rnd == 27 || rnd == 14 || rnd == 1) {
			value = "Ace";
			weight = 14;
		}
		
		if (1 <= rnd && rnd <= 13) 
			suit = "Spades";
		else if (14 <= rnd && rnd <= 26)
			suit = "Hearts";
		else if (27 <= rnd && rnd <= 39)
			suit = "Clubs";
		else if (40 <= rnd && rnd <= 52)
			suit = "Diamonds";
	}
	
	//Returns full name of card for use by the GUI
	public String getDisplayName() {
		return value + " of " + suit;
	}
	
	//Returns how "powerful" a card is vs. the cards played against it
	public int getWeight() {
		return weight;
	}
	
	//Returns suit of the card (other than testing getDisplayName should be used)ilm
	public String getSuit() {
		return suit;
	}
	
	//Returns value of the card (other than testing getDisplayName should be used)
	public String getValue() {
		return value;
	}
}
