public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] stringArr) {
		int row = stringArr.length - 1;
		int col = 0;
		int moves = 0;

		return mazeHelper(stringArr, row, col, moves);
	}

	public static int mazeHelper(String[][] stringArr, int row, int col, int moves) {
		if (row == -1) {
			return -1;
		}

		if (col == stringArr[row].length) {
			return -1;
		}

		if (stringArr[row][col].equals("*")) {
			return -1;
		}

		if (stringArr[row][col].equals("F")) {
			return moves;
		}

		moves++;

		int temp = mazeHelper(stringArr, row, col + 1, moves);
		int temp2 = mazeHelper(stringArr, row - 1, col, moves);

		if (temp == -1 && temp2 != -1) {
			return temp2;
		} else if (temp2 == -1 && temp != -1) {
			return temp;
		} else if (temp == temp2 && temp == -1) {
			return -1;
		} else {
			if (temp > temp2) {
				return temp2;
			} else {
				return temp;
			}
		}

	}

	public static int noOfPaths(String[][] stringArr) {
		int row = stringArr.length - 1;
		int col = 0;
		int reached = 0;

		return noMazeHelper(stringArr, row, col, reached);
	}

	public static int noMazeHelper(String[][] stringArr, int row, int col, int reached) {
		if (row == -1) {
			return -1;
		}

		if (col == stringArr[row].length) {
			return -1;
		}

		if (stringArr[row][col].equals("*")) {
			return -1;
		}

		if (stringArr[row][col].equals("F")) {
			reached = reached + 1;
			return reached;
		}

		int temp1 = noMazeHelper(stringArr, row, col + 1, reached);
		int temp2 = noMazeHelper(stringArr, row - 1, col, reached);

		if (temp1 != -1) {
			reached = reached + temp1;
		}
		if (temp2 != -1) {
			reached = reached + temp2;
		}
		return reached;

	}
}
