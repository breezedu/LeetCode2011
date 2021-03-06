package leetCode2011;

import java.util.Scanner;

/******************
 * The string "PAYPALISHIRING" is written in a zigzag pattern 
 * on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility
 * num = 3
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * Str: PAYPALISHIRINGIGH
 * num = 4
 * original length is: 17
 * P   I   N
 * A L S I G
 * Y A H R I H
 * P   I   G  
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author Frog
 *
 */
public class ZigZagConversion {

	public static void main(String[] args){
		
		System.out.println("This is ZigZag Conversion program");
		
		//1st, ask user to input the original string and num of lines
		System.out.println("Please input the original string:");
		Scanner input = new Scanner(System.in);
		System.out.print("Str: ");
		String oriStr = input.next();
		
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		
		//2nd, convert the original string into ZigZag string
		System.out.println("original length is: " + oriStr.length());
		String zigZag = convert(oriStr, num);
		
		//printout the zigzag string;
		System.out.println("ZigZag: " + zigZag +", Length: " + zigZag.length());
		
	}//end of main()

	private static String convert(String oriStr, int num) {
		// TODO convert a string into a zigzag string
		if(num==1 || oriStr.length()<3) return oriStr;
		
		//create a matrix of row*col, row=num; col = oriStr.length/(num-1);
		int row = num;
		int col = oriStr.length()/(num-1) +1;
		char[][] board = new char[row][col];
		
		for(int i=0; i<col; i++){
			
			if(i%2==0){ //even column 0, 2, 4...
				for(int j=0; j<row; j++){
					if(i*(num-1) + j < oriStr.length())
						board[j][i] = oriStr.charAt(i*(num-1) + j);
					else board[j][i] = ' ';
				}
			
			} else { //odd column, 1, 3, 5...
				board[0][i] = ' ';
				board[num-1][i] = ' '; 	//the first and the last one is blank ' ';
				
				//originally, b[j][i] = oriStr.charAt(i*(num-1)+j);
				//but the zigzag has to swap up and down; so b[j][i] swap to b[num-j-1][i];
				for(int j=1; j<row-1; j++){
					if(i*(num-1) + j < oriStr.length())
						board[row-j-1][i] = oriStr.charAt(i*(num-1) + j);
					else board[row-1-j][i] = ' ';
				}
				
			}//end if-else conditions;
		}//end for i<col loop;
		
		printMatrix(board);
		
		String retStr = "";
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(board[i][j]!=' ') retStr += board[i][j];
			}
		}
		return retStr;
	}

	private static void printMatrix(char[][] board) {
		// TODO Printout a matrix of characters
		int row = board.length;
		int col = board[0].length;
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				System.out.print(" " + board[i][j]+"");
			}
			System.out.println();
		}
		
		System.out.println();
	}//end printMatrix() method;
	
}//end of everything in ZigZagConversion class
