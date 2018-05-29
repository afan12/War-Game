import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String rules = "Welcome to the Card Game War!\n\n"
				+ "Rules:\n\nIn this game you are playing against the computer."
				+ "\n\nYou are each dealt 26 cards from a shuffled deck. When you click the “Deal” button the top"
				+ "\ncard from your pile will be played against the computer’s top card. If the value of your card is"
				+ "\nhigher than the Computer’s you win that battle. If it is less than the Computer’s you lose that"
				+ "\nbattle. If you have the same value cards the battle results in a tie."
				+ "\n\nWinning a Battle: Both cards are placed into your “Cards Won” Pile."
				+ "\n\nLosing a Battle: Both cards are placed into the Computer’s “Cards won” pile."
				+ "\n\nTie Battle: Both Player and Computer deal the top three cards from their pile onto the field"
				+ "\nface up. The fourth card is then played against the Computer’s and the winner of that battle"
				+ "\ntakes all cards in play."
				+ "\n\nEnd game: Once all battles have been fought and each player has no more cards"
				+ "\nto play, the player with the most cards won is declared the winner.";
		int gotIt = JOptionPane.showConfirmDialog(null, rules, "War Rules", JOptionPane.OK_CANCEL_OPTION);
		if (gotIt == 0)
			new GameGUI().run();
		else
			System.exit(0);
	}

}
