/*
program to play blackjack, one player, one round

main()
	draw 2 initial cards each for player and dealer
	print the intial cards

	while player_sum < 21
		- ask player to hit or stay
			- if hit, turn() for player
			- if stay, end()

	while dealer_sum < 16
		- turn() for dealer

	end()

	if player_sum > 21 & dealer_sum > 21, print draw
	if player_sum > 21, print you lost
	if delear_sum > 21, print you won
	if 21 - player_sum < 21 - dealer_sum, print you won
	else, pring you lost


draw()
	return int card


turn()
	take parameter 'initial_sum'
	get the next_card with draw()
	return new_sum + next_card

end()
	print both sums
	if player_sum > 21 & dealer_sum > 21, print draw
	if player_sum > 21, print you lost
	if delear_sum > 21, print you won
	if 21 - player_sum < 21 - dealer_sum, print you won
	else, pring you lost
*/



import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class blackjack
{

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int player1, player2, player_draw, dealer1, dealer2, dealer_draw, player_sum, dealer_sum;
//		String choice;		

		// maybe better: make array 'initial_draw', do draw() on all members
		player1 = draw(); 
		player2 = draw(); 
		dealer1 = draw(); 
		dealer2 = draw(); 
		player_sum = player1 + player2;
		dealer_sum = dealer1 + dealer2;
		String choice = "hit";
// why does this return error 'string choice is already defined in method main'?

		System.out.println("Welcome to blackjack\nYou got a "+player1+" and a "+player2+"\nYour total is "+player_sum);
		System.out.println("\nThe dealer has a "+dealer1+" showing, and a hidden card\nHis total is hidden too");
	
		while ((player_sum < 21) && choice.equals("hit")) {
//		while (player_sum < 21) {
			System.out.println("\nYour sum is "+player_sum);
			System.out.print("Would you like to 'hit' or 'stay'? ");
			choice = keyboard.next();

			if (choice.equals("hit")) {
				player_sum = turn(player_sum);
			}

			else {
				System.out.println("It is the dealer's turn");

				while (dealer_sum < 16) {
					System.out.println("\nDealer's sum is "+dealer_sum);
					dealer_sum = turn(dealer_sum);
					}
			}
		}	
		
		end(player_sum, dealer_sum);
		
	}

	// TODO - add support for ace and face cards	
	public static int draw() {
		int card;
		card = ThreadLocalRandom.current().nextInt(2, 11);
		return card;
	}

	public static int turn(int initial_sum) {
		int new_sum, next_card;

		next_card = draw();
		new_sum = initial_sum + next_card;
		
		return new_sum;
	}

// this results in printing multiple outcomes, must nest the statements correctly
	public static void end(int player, int dealer) {
		System.out.println("\nGame over, you have "+player+" and the dealer has "+dealer);

		if ((player > 21) && (dealer > 21)) {
			System.out.println("Game is a Draw");
		}
		
		else if ((player > 21) && (dealer <= 21)) {
			System.out.println("Dealer won");
		}

		else if ((player <= 21) && (dealer > 21)) {
			System.out.println("You won");
		}

		else {
			// both player and dealer are <= 21
			if (player > dealer) {
				System.out.println("You won");
			}
			else if (player < dealer) {
				System.out.println("Dealer won");
			}
			else {
				System.out.println("Game is a draw");
			}

		}

	}

}
