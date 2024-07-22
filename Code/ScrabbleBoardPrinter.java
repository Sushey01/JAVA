package Week5;

public class ScrabbleBoardPrinter {
	public static void printBoard(char[][] board) {
        int size = board.length;
        // Print the top border
        System.out.print("+");
        for (int i = 0; i < size; i++) {
            System.out.print(" -");
        }
        System.out.println(" +");

        // Print each row of the board
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + (board[i][j] == '-' ? '.' : board[i][j]));
            }
            System.out.println(" |");
        }

        // Print the bottom border
        System.out.print("+");
        for (int i = 0; i < size; i++) {
            System.out.print(" -");
        }
        System.out.println(" +");
    }
	  public static void main(String[] args) {
	        char[][] board = {
	            { '-', '.', 'W', '.', '.' },
	            { '.', '.', 'O', '.', '.' },
	            { '.', '.', 'R', '.', '.' },
	            { 'H', 'E', 'L', 'L', 'O' },
	            { '.', '.', 'D', '.', '.' }
	        };
	        printBoard(board);
	    }
}
 