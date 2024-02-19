package com.ruediger.java.arraysAndHashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ValidSodoku {

	public static void main(String[] args) {

		/*
		 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
		 * validated according to the following rules:
		 * 
		 * Each row must contain the digits 1-9 without repetition. Each column must
		 * contain the digits 1-9 without repetition. Each of the nine 3 x 3 sub-boxes
		 * of the grid must contain the digits 1-9 without repetition. Note:
		 * 
		 * A Sudoku board (partially filled) could be valid but is not necessarily
		 * solvable. Only the filled cells need to be validated according to the
		 * mentioned rules.
		 * 
		 * 
		 * Example 1:
		 * 
		 * 
		 * Input: board = [["5","3",".",".","7",".",".",".","."]
		 * ,["6",".",".","1","9","5",".",".","."] ,[".","9","8",".",".",".",".","6","."]
		 * ,["8",".",".",".","6",".",".",".","3"] ,["4",".",".","8",".","3",".",".","1"]
		 * ,["7",".",".",".","2",".",".",".","6"] ,[".","6",".",".",".",".","2","8","."]
		 * ,[".",".",".","4","1","9",".",".","5"]
		 * ,[".",".",".",".","8",".",".","7","9"]] Output: true Example 2:
		 * 
		 * Input: board = [["8","3",".",".","7",".",".",".","."]
		 * ,["6",".",".","1","9","5",".",".","."] ,[".","9","8",".",".",".",".","6","."]
		 * ,["8",".",".",".","6",".",".",".","3"] ,["4",".",".","8",".","3",".",".","1"]
		 * ,["7",".",".",".","2",".",".",".","6"] ,[".","6",".",".",".",".","2","8","."]
		 * ,[".",".",".","4","1","9",".",".","5"]
		 * ,[".",".",".",".","8",".",".","7","9"]] Output: false Explanation: Same as
		 * Example 1, except with the 5 in the top left corner being modified to 8.
		 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
		 */

		char[][] sudokuBoard = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		char[][] invalidSudokuBoard = { 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '8' } // Invalid digit '8' in the last cell
			}; 
		char[][] invalidRowSudoku = {
			    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			    {'3', '9', '8', '.', '.', '.', '.', '6', '.'}, // Invalid duplicate '3' in the first row
			    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
			};

		char[][] invalidColumnSudoku = {
			    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			    {'6', '.', '.', '.', '8', '.', '.', '7', '9'} // Invalid duplicate '6' in the first column
			};


		print2DArray(sudokuBoard);
		boolean isValid = isValidSudoku(sudokuBoard, false);
		if (isValid) {
			System.out.println("The Sudoku puzzle is valid.");
		} else {
			System.out.println("The Sudoku puzzle is not valid.");
		}
		
		print2DArray(invalidSudokuBoard);
		isValid = isValidSudoku(invalidSudokuBoard, false);
		if (isValid) {
			System.out.println("The Sudoku puzzle is valid.");
		} else {
			System.out.println("The Sudoku puzzle is not valid.");
		}
		
		print2DArray(invalidRowSudoku);
		isValid = isValidSudoku(invalidRowSudoku, false);
		if (isValid) {
			System.out.println("The Sudoku puzzle is valid.");
		} else {
			System.out.println("The Sudoku puzzle is not valid.");
		}
		
		print2DArray(invalidColumnSudoku);
		isValid = isValidSudoku(invalidColumnSudoku, false);
		if (isValid) {
			System.out.println("The Sudoku puzzle is valid.");
		} else {
			System.out.println("The Sudoku puzzle is not valid.");
		}

	}

	public static void print2DArray(char[][] toPrint) {
		System.out.println();
		for (int i = 0; i < toPrint.length; i++) {
			for (int j = 0; j < toPrint.length; j++) {
				System.out.print(toPrint[i][j] + "   ");
			}
			System.out.println();
		}

	}

	public static boolean isValidSudoku(char[][] board, boolean debug) {
		boolean isValid = true;

		String rowRuleLog = "";
		String colRuleLog = "";
		String subGridRuleLog = "";
		for (int i = 0; i < 9; i++) {

			HashSet<Character> rowSet = new HashSet<>();
			HashSet<Character> colSet = new HashSet<>();
			HashSet<Character> subgridSet = new HashSet<>();

			for (int j = 0; j < 9; j++) {
				char rowChar = board[i][j];
				char colChar = board[j][i];
				char subgridChar = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];

				
				if (debug) {
					rowRuleLog += ("Checking row " + i + "\n");
					colRuleLog += ("Checking column " + j + "\n");
					subGridRuleLog += ("Checking grid i " + (i / 3 * 3 + j / 3) + ", j " + (i % 3 * 3 + j % 3) + " VALUE: " + subgridChar + "\n");
				}
	

				if (rowChar != '.' && !rowSet.add(rowChar)) {
					isValid = false;
					rowRuleLog += ("ERROR: Duplicate " + rowChar + " in row " + i + "\n");
				}
				if (colChar != '.' && !colSet.add(colChar)) {
					isValid = false;
					colRuleLog += ("ERROR: Duplicate " + colChar + " in col " + j + "\n");
				}
				if (subgridChar != '.' && !subgridSet.add(subgridChar)) {
					isValid = false;
					subGridRuleLog += ("ERROR: Duplicate grid char " + subgridChar + " in i " + (i / 3 * 3 + j / 3)
							+ ", j " + (i % 3 * 3 + j % 3));
				}
			}
		}

		if (debug) {
			System.out.println("ROW AUDIT LOG");
			System.out.println(rowRuleLog);
			System.out.println("COL AUDIT LOG");
			System.out.println(colRuleLog);
			System.out.println("SUBGRID AUDIT LOG");
			System.out.println(subGridRuleLog);
		}
		else {
			System.out.println(rowRuleLog);
			System.out.println(colRuleLog);
			System.out.println(subGridRuleLog);
		}

		return isValid;
	}

}
