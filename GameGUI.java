import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class GameGUI implements ActionListener {

	// West Labels
	JLabel name1, currentCardBox1, winLoseTie1, tieCards1, tieBox1_1, tieBox1_2, tieBox1_3, cardsWonBox1;

	// East Labels
	JLabel name2, currentCardBox2, winLoseTie2, tieCards2, tieBox2_1, tieBox2_2, tieBox2_3, cardsWon2, cardsWonBox2;

	// Center Buttons
	JButton butDeal, butTie, butClear, butReset;

	// Frame
	JFrame frame;

	// Label Border Initializers
	Border blackline = BorderFactory.createLineBorder(Color.black);
	Border loweredBevel = BorderFactory.createLoweredBevelBorder();

	// Score Counters for cardsWon labels
	int score1 = 0;
	int score2 = 0;

	// Tie Resolution parity
	boolean tie = false;

	// Create Deck object that Shuffles and Deals the card objects for interaction
	Deck deck = new Deck();

	// Create the GUI
	public void run() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create a BorderLayout of which we will use West, Center and East
		JPanel panelBorder = new JPanel();
		panelBorder.setLayout(new BorderLayout());

		// Create Vertical BoxLayout that will fill the West BorderLayout panel
		JPanel panelVertWest = new JPanel();
		panelVertWest.setLayout(new BoxLayout(panelVertWest, BoxLayout.Y_AXIS));
		panelBorder.add(panelVertWest, BorderLayout.WEST);

		// Create Vertical BoxLayout that will fill the Center BorderLayout panel
		JPanel panelVertCenter = new JPanel();
		panelVertCenter.setLayout(new BoxLayout(panelVertCenter, BoxLayout.Y_AXIS));
		panelBorder.add(panelVertCenter, BorderLayout.CENTER);

		// Create Vertical BoxLayout that will fill the East BorderLayout panel
		JPanel panelVertEast = new JPanel();
		panelVertEast.setLayout(new BoxLayout(panelVertEast, BoxLayout.Y_AXIS));
		panelBorder.add(panelVertEast, BorderLayout.EAST);

		// WEST Layout
		// ---------------------------------------------------------------------------
		// Name
		name1 = newVertLabel("  Player  ");
		name1.setFont(name1.getFont().deriveFont(32.0f)); // Set 32 Font
		panelVertWest.add(name1);
		panelVertWest.add(Box.createVerticalGlue()); // Glue Spacing

		// Current Card
		currentCardBox1 = newVertLabel("                 ");
		panelVertWest.add(currentCardBox1);
		TitledBorder currCard = BorderFactory.createTitledBorder(blackline, "Current Card");
		currCard.setTitleJustification(TitledBorder.CENTER);
		currentCardBox1.setBorder(currCard);
		panelVertWest.add(Box.createVerticalGlue()); // Glue Spacing

		// Win/Lose/Tie
		winLoseTie1 = newVertLabel("");
		winLoseTie1.setFont(winLoseTie1.getFont().deriveFont(24.0f)); // Set 24 Font
		panelVertWest.add(winLoseTie1);
		panelVertWest.add(Box.createVerticalGlue()); // Glue Spacing

		// Tie Cards
		tieCards1 = newVertLabel("Tie Cards");

		tieBox1_1 = newVertLabel("                 ");
		tieBox1_1.setBorder(loweredBevel);

		tieBox1_2 = newVertLabel("                 ");
		tieBox1_2.setBorder(loweredBevel);

		tieBox1_3 = newVertLabel("                 ");
		tieBox1_3.setBorder(loweredBevel);

		panelVertWest.add(tieCards1);
		panelVertWest.add(tieBox1_1);
		panelVertWest.add(Box.createVerticalStrut(10)); // Strut Spacing
		panelVertWest.add(tieBox1_2);
		panelVertWest.add(Box.createVerticalStrut(10)); // Strut Spacing
		panelVertWest.add(tieBox1_3);
		panelVertWest.add(Box.createVerticalGlue()); // Glue Spacing

		// Score Keeping
		cardsWonBox1 = newVertLabel("         " + score1 + "         ");
		TitledBorder cardsWon = BorderFactory.createTitledBorder(blackline, "Cards Won");
		cardsWon.setTitleJustification(TitledBorder.CENTER);
		cardsWonBox1.setBorder(cardsWon);
		panelVertWest.add(cardsWonBox1);
		// ---------------------------------------------------------------------------

		// CENTER Layout
		// ---------------------------------------------------------------------------
		panelVertCenter.add(Box.createVerticalGlue()); // Add Glue to the top surface for spacing

		// Deal Button
		butDeal = newVertButton("DEAL", 120, 40);
		butDeal.addActionListener(this);
		panelVertCenter.add(butDeal);
		panelVertCenter.add(Box.createVerticalStrut(10)); // Strut Spacing

		// Resolve Tie Button
		butTie = newVertButton("Resolve Tie", 100, 40);
		butTie.addActionListener(this);
		panelVertCenter.add(butTie);
		panelVertCenter.add(Box.createVerticalStrut(10)); // Strut Spacing
		butTie.setEnabled(false); // Disable Tie button until a tie is reached

		// Clear Button
		// butClear = newVertButton("Clear Table", 120, 40);
		// panelVertCenter.add(butClear);
		// panelVertCenter.add(Box.createVerticalStrut(10)); //Strut Spacing

		// Reset Button
		butReset = newVertButton("Reset Game", 120, 40);
		butReset.addActionListener(this);
		panelVertCenter.add(butReset);
		panelVertCenter.add(Box.createVerticalGlue()); // Add Glue to bottom for spacing
		// ---------------------------------------------------------------------------

		// EAST Layout
		// ---------------------------------------------------------------------------
		// Name
		name2 = newVertLabel("Computer");
		name2.setFont(name2.getFont().deriveFont(32.0f)); // Set 32 Font
		panelVertEast.add(name2);
		panelVertEast.add(Box.createVerticalGlue()); // Glue Spacing

		// Current Card
		currentCardBox2 = newVertLabel("                 ");
		panelVertEast.add(currentCardBox2);
		currentCardBox2.setBorder(currCard);
		panelVertEast.add(Box.createVerticalGlue()); // Glue Spacing

		// Win/Lose/Tie
		winLoseTie2 = newVertLabel("");
		winLoseTie2.setFont(winLoseTie2.getFont().deriveFont(24.0f)); // Set 24 Font
		panelVertEast.add(winLoseTie2);
		panelVertEast.add(Box.createVerticalGlue()); // Glue Spacing

		// Tie Cards
		tieCards2 = newVertLabel("Tie Cards");

		tieBox2_1 = newVertLabel("                 ");
		tieBox2_1.setBorder(loweredBevel);

		tieBox2_2 = newVertLabel("                 ");
		tieBox2_2.setBorder(loweredBevel);

		tieBox2_3 = newVertLabel("                 ");
		tieBox2_3.setBorder(loweredBevel);

		panelVertEast.add(tieCards2);
		panelVertEast.add(tieBox2_1);
		panelVertEast.add(Box.createVerticalStrut(10)); // Strut Spacing
		panelVertEast.add(tieBox2_2);
		panelVertEast.add(Box.createVerticalStrut(10)); // Strut Spacing
		panelVertEast.add(tieBox2_3);
		panelVertEast.add(Box.createVerticalGlue()); // Glue Spacing

		// Score Keeping
		cardsWonBox2 = newVertLabel("         " + score2 + "         ");
		cardsWonBox2.setBorder(cardsWon);
		panelVertEast.add(cardsWonBox2);

		// ---------------------------------------------------------------------------

		// Create the Frame
		frame = new JFrame("War Game");
		frame.setSize(600, 400);
		frame.add(panelBorder);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Create a new button that takes input dimensions and centers the button
	private JButton newVertButton(String text, int width, int height) {
		JButton button = new JButton(text);
		button.setMaximumSize(new Dimension(width, height));
		button.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		return button;
	}

	// Create a new Center Aligned label of font 16
	private JLabel newVertLabel(String text) {
		JLabel label = new JLabel("     " + text + "     "); // Spaces for the space in the border boxes
		label.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		label.setFont(label.getFont().deriveFont(16.0f)); // Set 16 Font
		return label;
	}

	// Update the Scores at the botton of the GUI after each deal
	private void updateScore() {
		cardsWonBox1.setText("         " + score1 + "         ");
		cardsWonBox2.setText("         " + score2 + "         ");
	}

	// Updates the colors of WINNER LOSER and TIE to Green, Red and Blue
	// Respectively
	private void updateColor(JLabel label) {
		if (label.getText().equals("WINNER!"))
			label.setForeground(Color.GREEN);
		else if (label.getText().equals("LOSER!"))
			label.setForeground(Color.RED);
		else
			label.setForeground(Color.BLUE);
	}

	// Play cards from top of each player's pile to the Current Card and get
	// win/lose/tie
	private int dealCards() {
		// Reset tie card boxes if previous round ended in a tie
		if (tie) {
			tieBox1_1.setText("                           ");
			tieBox1_2.setText("                           ");
			tieBox1_3.setText("                           ");
			tieBox2_1.setText("                           ");
			tieBox2_2.setText("                           ");
			tieBox2_3.setText("                           ");

			tie = false;
		}

		// Get the card off of player's stack
		currentCardBox1.setText("     " + deck.playerDeck1.get(deck.playerDeck1.size() - 1).getDisplayName() + "     ");
		Card tempPlayer = deck.playerDeck1.remove(deck.playerDeck1.size() - 1);

		// Get card off of computer's stack
		currentCardBox2.setText("     " + deck.playerDeck2.get(deck.playerDeck2.size() - 1).getDisplayName() + "     ");
		Card tempComputer = deck.playerDeck2.remove(deck.playerDeck2.size() - 1);

		// compare the weight of the two cards played
		int compare = deck.compareWeight(tempPlayer, tempComputer);

		if (compare == 1) { // Player wins
			winLoseTie1.setText("WINNER!");
			winLoseTie2.setText("LOSER!");
			score1 += 2;
			updateScore();
			updateColor(winLoseTie1);
			updateColor(winLoseTie2);
		} else if (compare == -1) { // Computer wins
			winLoseTie1.setText("LOSER!");
			winLoseTie2.setText("WINNER!");
			score2 += 2;
			updateScore();
			updateColor(winLoseTie1);
			updateColor(winLoseTie2);
		} else { // Tie
			winLoseTie1.setText("TIE!");
			winLoseTie2.setText("TIE!");
			updateColor(winLoseTie1);
			updateColor(winLoseTie2);
			butDeal.setEnabled(false); // Disable Deal Button
			butTie.setEnabled(true); // Enable Tie Button
		}

		return compare;
	}

	// When a tie is found up to 3 cards go into the tie card boxes and another card
	// is
	// played to see who takes all of the cards on the field.
	private void resolveTie(int score) {

		int tempScore = score; // iterator to add tie matches to the winner's score

		// Checks how many cards are left on each pile. If there is more than 1 on each
		// it will place cards into the tie boxes. If there is only one card remaining
		// on each player's deck while the resolveTie method is going it will compare
		// the
		// final card and increment the score based upon the cards played.
		if (deck.playerDeck1.size() > 1) {
			// Get the card off of player's stack
			tieBox1_1.setText("     " + deck.playerDeck1.get(deck.playerDeck1.size() - 1).getDisplayName() + "     ");
			deck.playerDeck1.remove(deck.playerDeck1.size() - 1);

			// Get card off of computer's stack
			tieBox2_1.setText("     " + deck.playerDeck2.get(deck.playerDeck2.size() - 1).getDisplayName() + "     ");
			deck.playerDeck2.remove(deck.playerDeck2.size() - 1);

			tempScore += 2;

			if (deck.playerDeck1.size() > 1) {
				// Get the card off of player's stack
				tieBox1_2.setText(
						"     " + deck.playerDeck1.get(deck.playerDeck1.size() - 1).getDisplayName() + "     ");
				deck.playerDeck1.remove(deck.playerDeck1.size() - 1);

				// Get card off of computer's stack
				tieBox2_2.setText(
						"     " + deck.playerDeck2.get(deck.playerDeck2.size() - 1).getDisplayName() + "     ");
				deck.playerDeck2.remove(deck.playerDeck2.size() - 1);

				tempScore += 2;
			}

			if (deck.playerDeck1.size() > 1) {
				// Get the card off of player's stack
				tieBox1_3.setText(
						"     " + deck.playerDeck1.get(deck.playerDeck1.size() - 1).getDisplayName() + "     ");
				deck.playerDeck1.remove(deck.playerDeck1.size() - 1);

				// Get card off of computer's stack
				tieBox2_3.setText(
						"     " + deck.playerDeck2.get(deck.playerDeck2.size() - 1).getDisplayName() + "     ");
				deck.playerDeck2.remove(deck.playerDeck2.size() - 1);

				tempScore += 2;
			}
		}

		int tieCompare = dealCards();

		if (tieCompare == 1) { // Player wins
			score1 += tempScore;
			updateScore();
			butDeal.setEnabled(true);
			butTie.setEnabled(false);
		} else if (tieCompare == -1) { // Computer wins
			score2 += tempScore;
			updateScore();
			butDeal.setEnabled(true);
			butTie.setEnabled(false);
		} else { // Tie
			resolveTie(tempScore);
		}

		tie = true; // parity to reset the tie box fields when tie is resolved
	}

	// Runs the GUI for testing. The main class will call run() in final product
	// public static void main(String[] args) {
	// new GameGUI().run();
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// Check if there are cards left on the stack
		if (deck.playerDeck1.size() >= 1) { // playerDeck1 and 2 always same size

			// Deal button clicked
			if (e.getSource() == butDeal) {
				dealCards();
			}

			// Resolve Tie button clicked
			else if (e.getSource() == butTie) {
				resolveTie(2);
			}

			else if (e.getSource() == butReset) {
				frame.setVisible(false);
				new GameGUI().run();
			}
		}
		// Once last card is played popup a win/lose/tie window and prompt for playing
		// again.
		else {

			String yesNoText;

			if (score1 > score2)
				yesNoText = "Congratulations You Won!\nWould you like to play again?";
			else if (score1 < score2)
				yesNoText = "Bummer... You Lost!\nWould you like to play again?";
			else
				yesNoText = "You tied!\nWould you like to play again and see if\nyou can beat the computer this time?";

			int yesNo = JOptionPane.showConfirmDialog(null, yesNoText, "Play Again?", JOptionPane.YES_NO_OPTION);

			if (yesNo == 0) {
				frame.setVisible(false);
				new GameGUI().run();
			} else
				System.exit(0);
		}
	}
}
