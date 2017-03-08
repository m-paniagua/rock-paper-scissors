import java.util.Random;
import javax.swing.JOptionPane;

public class RockPaperScissors {

	public static void main(String[] args) {
		int ranNum;
		int userNum;
		int winner;
		int compWins = 0;
		int userWins = 0;
		int tieGame = 0;
		String userChoice;
		String contin;
		
		do {
			ranNum = randomNumber();
			
			userChoice = userInput();
			if (userChoice.equalsIgnoreCase("rock")) {
				userNum = 1;
			}
			else if (userChoice.equalsIgnoreCase("paper")) {
				userNum = 2;
			}
			else {
				userNum = 3;
			}
			
			winner = checkWinner(ranNum, userNum);
			
			if (winner == 0) {
				tieGame = updateStats(tieGame);
				displayStats(winner, compWins, userWins, tieGame);
			}
			else if (winner == 1) {
				compWins = updateStats(compWins);
				displayStats(winner, compWins, userWins, tieGame);
			}
			else {
				userWins = updateStats(userWins);
				displayStats(winner, compWins, userWins, tieGame);
			}
			
			contin = JOptionPane.showInputDialog("Enter yes to play again, anything else to quit");
			if(contin == null )	 																										//exits if user clicks cancel
			{
				System.exit(0);
			}
			
		} while (contin.equalsIgnoreCase("yes"));
		
		System.exit(0);

	}
	
	public static int randomNumber() {
		int rNumber;
		Random randomNumber = new Random();
		rNumber = randomNumber.nextInt(3) + 1;
		
		return rNumber;
	}
	
	public static String userInput() {
		String userChoice;
		userChoice = JOptionPane.showInputDialog("Enter rock, paper, or scissors: ");
		
		if(userChoice == null )	 																										//exits if user clicks cancel
		{
			System.exit(0);
		}
		
		while(!(userChoice.equalsIgnoreCase("rock")) && !(userChoice.equalsIgnoreCase("paper")) && !(userChoice.equalsIgnoreCase("scissors"))) 											//if invalid input, stuck in loop
		{
			userChoice = JOptionPane.showInputDialog("Invalid input!\nOnly valid options are rock, paper, or scissors.  \nTry again: ");					//prompts user for valid input
			if(userChoice == null )	
			{
				System.exit(0);
			}
		}
		
		return userChoice;
	}
	
	public static int checkWinner(int comp, int user) {
		if (comp == 1 && user == 3) {
			return 1;
		}
		else if (comp == 3 && user == 2) {
			return 1;
		}
		else if (comp == 2 && user == 1) {
			return 1;
		}
		else if (user == 1 && comp == 3) {
			return 2;
		}
		else if (user == 3 && comp ==1) {
			return 2;
		}
		else if (user == 2 && comp == 1) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	public static void displayStats(int winner, int comp, int user, int tie) {
		if (winner == 0) {
			JOptionPane.showMessageDialog(null, "Tie Game!" + "\nYou lost: " + comp + "\nYou won: " + user + "\nYou tied: " + tie);
		}
		else if (winner == 1) {
			JOptionPane.showMessageDialog(null, "Computer wins!" + "\nYou lost: " + comp + "\nYou won: " + user + "\nYou tied: " + tie);
		}
		else {
			JOptionPane.showMessageDialog(null, "You win!" + "\nYou lost: " + comp + "\nYou won: " + user + "\nYou tied: " + tie);
		}
	}
	
	public static int updateStats(int stats) {
		int wins;
		
		wins = stats + 1;
		return wins;
	}
}

