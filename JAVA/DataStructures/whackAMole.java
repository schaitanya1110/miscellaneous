 
import java.util.Scanner;

public class whackAMole {
    int score = 0;
    int molesLeft; //"Undiscovered Moles"
    int attemptsLeft;
    int maxAttempts;
    char moleGrid[][];// new char[x][y];

    public whackAMole(int numAttempts, int griddimension) {
	maxAttempts = numAttempts; // Total Number of whacks allowed
	attemptsLeft = numAttempts;
	int gd = griddimension;
    moleGrid = new char[gd][gd];
	for (int i = 0; i < gd; i++) {
	    for (int j = 0; j < gd; j++) {
		moleGrid[i][j] = '*';
	    } 
	}
    }

    boolean place(int x, int y) {
	if (moleGrid[x][y] == '*') {
     moleGrid[x][y] = 'M';
	molesLeft += 1;
	return true;
	}else{
	    return false;
	}
	}
    

    void whack(int x, int y) { // "whack and put W"
	if (moleGrid[x][y] == 'M') {
	    score = score + 1;
	    moleGrid[x][y] = 'W';
	    molesLeft = molesLeft - 1;
	} else {
	    moleGrid[x][y] = 'W';
	    
	}
	attemptsLeft = attemptsLeft - 1;
    }

    void printGridToUser() {
	for (int i = 0; i < moleGrid.length; i++) {
	    for (int j = 0; j < moleGrid[i].length; j++) {
		if (moleGrid[i][j] == 'M') {
		    System.out.print("*" + " ");
		} else {
		    System.out.print(moleGrid[i][j] + " ");
		}
	    }
	    System.out.println();
	}
    }

    void printGrid() {// Print the Grid completely
	for (int i = 0; i < moleGrid.length; i++) {
	    for (int j = 0; j < moleGrid[i].length; j++) {
		System.out.print(moleGrid[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[] args) {
	int r = 0;
	int c = 0;
	whackAMole Whack = new whackAMole(10,10);
	for(int i = 1; i <= Whack.moleGrid.length ;i++) {
	    Whack.place(r, c);
	    r = r + 1;
	    c = c + 1;   
	}
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("You have a maximum of 50 attempts to get all moles");
	while (Whack.attemptsLeft > 0) {
	    System.out.println("Enter X and Y coordinate separated by space");
	    int x = scanner.nextInt();
	    int y = scanner.nextInt();
	    if (x == -1 && y == -1) {
		System.out.println("User surrendered");
		Whack.printGridToUser();
		break;
	    }
	    Whack.whack(x, y);
	    if (Whack.score == Whack.moleGrid.length) {
		System.out.println("Good Job");
		System.out.println("Score" + " " + Whack.score);
		Whack.printGrid();
	    }
	}

	System.out.println("GameOver");
	System.out.println("Score" + " " + Whack.score);
	Whack.printGrid();
    }
}

