import java.util.Scanner;

public class TicTacToe {
	
	static char[] r1 = {' ',' ',' '};
	static char[] r2 = {' ',' ',' '};
	static char[] r3 = {' ',' ',' '};
	private static char x;
	
	public static void main(String[] args){
		MainMenu();
	}
		
	public static void MainMenu(){
		System.out.println("**********************");
		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println("~-~-~-~-~-~-~-~-~-~-~-");
		
		Scanner selection = new Scanner(System.in);
		System.out.println("Main Menu:");
		System.out.println("----------");
		System.out.println("1. Play Game");
		System.out.println("2. Help");
		System.out.println("3. Exit");
		System.out.println();
		System.out.print("Enter a selection: ");
		int sel = selection.nextInt();
			switch(sel){
			case 1:
				StartTicTacToeGame();
				break;
			case 2:
				HelpScreen();
				break;
			case 3:
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Sorry wrong command.");
			}
	
	}
	
	public static void HelpScreen(){
		// Instructions go here
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers, one for the row and one for the column, that you would like to place your symbol on.");
		System.out.println("For example:");
		System.out.println("    1    2    3");
		System.out.println("1 [ X ][   ][   ]");
		System.out.println("2 [ X ][ O ][ X ]");
		System.out.println("3 [ O ][ O ][ X ]");
		System.out.println();
		System.out.println("Postion: 1 3");
		System.out.println("1 and 3 will place your symbol in the top right corner.");
		System.out.print("Return to main menu? Y/n: ");
		String choice = input.next();
		if (choice.equals("y") || choice.equals("Y")){
			MainMenu();
		} else if (choice.equals("n")) {
			System.out.print("Goodbye \n");
		};
		while(!choice.equals("y") && !choice.equals("Y") && !choice.equals("n")){
			System.out.print("Wrong command, return to main menu? Y/n: ");
			choice = input.next();
		};
			
	}
	
	
	public static void StartTicTacToeGame(){
		
		// Game goes here
		Scanner input = new Scanner(System.in);
				
		char p1 = ' '; // Player 1
		char p2 = ' '; // Player 2
		
		if (p1 == ' ' || p2 == ' '){
			System.out.println("Choose X or O");
			System.out.println("-------------");
			System.out.print("Player 1: ");
			p1 = input.next().charAt(0);
			System.out.println();
			System.out.print("Player 2: ");
			p2 = input.next().charAt(0);
			// Check to make sure Player 2 didn't choose the same as Player 1
			if (p1 == p2){
				System.out.println("Player 1 is already "+p1+". Please enter a different value.");
				System.out.print("Player 2: ");
				p2 = input.next().charAt(0);
			} else {
				System.out.println("Player 1 is X. Player 2 is O.");
			};
		};

		char player = p2;
		String player_name = "Player 1";
		boolean CONTINUE = true;
		while(CONTINUE){
			
			if (
				r1[0] == r1[1] && r1[1] == r1[2] && r1[0] != ' ' ||
				r2[0] == r2[1] && r2[1] == r2[2] && r2[0] != ' ' ||
				r3[0] == r3[1] && r3[1] == r3[2] && r3[0] != ' ' ||
				r1[0] == r2[0] && r2[0] == r3[0] && r1[0] != ' ' ||
				r1[1] == r2[1] && r2[1] == r3[1] && r1[1] != ' ' ||
				r1[2] == r2[2] && r2[2] == r3[2] && r1[2] != ' ' ||
				r1[0] == r2[1] && r2[1] == r3[2] && r1[0] != ' ' ||
				r1[2] == r2[1] && r2[1] == r3[0] && r1[2] != ' ' 
					) 
				
				{

				showBoard();
				System.out.println("");
				r1[0] = ' ';
				r1[1] = ' ';
				r1[2] = ' ';
				r2[0] = ' ';
				r2[1] = ' ';
				r2[2] = ' ';
				r3[0] = ' ';
				r3[1] = ' ';
				r3[2] = ' ';
				System.out.println(player_name+" wins!");
				System.out.print("Play again? Y/n: ");
				String choice = input.next();
				if (choice.equals("y") || choice.equals("Y")){
					MainMenu();
				} else if (choice.equals("n")) {
					System.out.print("Goodbye \n");
				};
				while(!choice.equals("y") && !choice.equals("Y") && !choice.equals("n")){
					System.out.print("Wrong command, play again? Y/n: ");
					choice = input.next();
				};
				
			} else {
				
			
			if (player == p2){
				player = p1;
				player_name = "Player 1";
			} else {
				player = p2;
				player_name = "Player 2";
			};
			
			showBoard();
			System.out.println();
			System.out.println(player_name +"'s turn.");
			System.out.print("Enter row and column, ex. 1 1: ");
			int row = input.nextInt();
			int col = input.nextInt();
			switch(row-1){
			case 0:
				if (r1[col-1] != ' '){
					System.out.println("**********************************");
					System.out.println("That box is not empty, try again. ");
					System.out.println("**********************************");
					if (player == p2){
						player = p1;
						player_name = "Player 1";
					} else {
						player = p2;
						player_name = "Player 2";
					};
				} else {
					r1[col-1] = player;
				};
				break;
				
			case 1:
				if (r2[col-1] != ' '){
					System.out.println("**********************************");
					System.out.println("That box is not empty, try again. ");
					System.out.println("**********************************");
					if (player == p2){
						player = p1;
						player_name = "Player 1";
					} else {
						player = p2;
						player_name = "Player 2";
					};
				} else {
					r2[col-1] = player;
				};
				break;
				
			case 2:
				if (r3[col-1] != ' '){
					System.out.println("**********************************");
					System.out.println("That box is not empty, try again. ");
					System.out.println("**********************************");
					System.out.println();
					if (player == p2){
						player = p1;
						player_name = "Player 1";
					} else {
						player = p2;
						player_name = "Player 2";
					};
				} else {
					r3[col-1] = player;
				};
				break;
				
				default:
					System.out.println("Invalid.");
					break;
			}
		}
			
		}
	}
	
	public static void showBoard(){
		System.out.println("    1    2    3");
		System.out.println("1 [ "+r1[0]+" ][ "+r1[1]+" ][ "+r1[2]+" ]");
		System.out.println("2 [ "+r2[0]+" ][ "+r2[1]+" ][ "+r2[2]+" ]");
		System.out.println("3 [ "+r3[0]+" ][ "+r3[1]+" ][ "+r3[2]+" ]");
		
	}
}
