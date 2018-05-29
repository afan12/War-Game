import java.util.ArrayList;
import java.util.Random;

public class Deck {
	Random rand = new Random();
	//Variables
	protected ArrayList<Card> fullDeck = new ArrayList<Card>();
	protected ArrayList<Card> playerDeck1 = new ArrayList<Card>();
	protected ArrayList<Card> playerDeck2 = new ArrayList<Card>();
	private String pName1;
	private String pName2;
	
	
	//Constructors
	public Deck() {
		int[] array = shuffle(); //Get random card assortment
		
		//Populate the full deck with card objects based on random assortment
		for (int n : array) {
			Card card = new Card(n);
			fullDeck.add(card);
		}
		
		//Populate each player deck 
		deal();
	}
	
	//Getters and Setters
	public void setName1(String pName1) {
		this.pName1 = pName1;
	}
	
	public String getName1() {
		return pName1;
	}
	
	public void setName2(String pName2) {
		this.pName2 = pName2;
	}
	
	public String getName2() {
		return pName2;
	}
	
	//Behaviors
	//Create an array populated by random unique numbers between 1 - 52
	private int[] shuffle() {
		int[] randDeck = new int[52];
		
		for (int i = 0; i < randDeck.length; i++) {
			
			int n = rand.nextInt(52) + 1;
			
			//If the random number is in the array already, deiterate and loop again
			if (contains(randDeck, n)) {
				i--;
			}
			//If it isn't in the array then add it to the array and iterate to next element
			else {
				randDeck[i] = n;
			}			
		}
		
		return randDeck;
	}
	
	//Check if a number already exists in an array
	private boolean contains(int[] array, int num) {
	    for (int n : array) {
	       if (num == n) {
	          return true;
	       }
	    }
	    return false;
	}
	
	//move card objects from the end of the main deck to each player deck. Each playerDeck
	//ends up with 26 cards that the other deck does not contain.
	public void deal() {
		do {
			playerDeck1.add(fullDeck.remove(fullDeck.size()-1));
			playerDeck2.add(fullDeck.remove(fullDeck.size()-1));
		} while (!fullDeck.isEmpty());
	}
	
	//Returns true if the first integer input weight is greater than the second
	public int compareWeight(Card card1, Card card2) {
		int comp;
		if (card1.getWeight() > card2.getWeight())
			comp = 1;
		else if (card1.getWeight() == card2.getWeight())
			comp = 0;
		else
			comp = -1;
		
		return comp;
	}
	
	//Print the deck object for testing
	public void printDeck(ArrayList<Card> list) {
		int i = 1;
		for (Card c : list) {
			System.out.print(i + ": ");
			System.out.println(c.getDisplayName());
			System.out.println(c.getWeight());
			i++;
		}
	}
}

