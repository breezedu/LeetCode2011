package leetCode2012;

import java.util.Scanner;

/******************
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * @author Frog
 *
 */
public class LongestPalindromicSubstring {
	
	public static void main(String[] args){
		
		System.out.println("This is Longest Palindromic Substring program.");
		
		//1st, ask user to input a string
		System.out.println("Please input the string:");
		Scanner input = new Scanner(System.in);
		System.out.print(" string: ");
		String str = input.next();
		input.close();
		
		
		//2nd, check out the longest Palindromic Substring in the str;
		String longestPalind = longestPalindrome(str);
		System.out.println("The LPS is: " + longestPalind);
		
	}//end main()

	/****************
	 * use Dynamic Programming algo;
	 * build a matrix to check if the subString between index i and j is Palindromic;
	 * start:
	 * matrix[i][i] = 1, any single letter is Palindromic;
	 * if s.charAt(i)==s.charAt(i+1), the matrix[i][i+1]=1; two equal neighbor also means palindromic;
	 * 
	 * also: if s.charAt(i) = s.charAt(j) && matrix[i+1][j-1]=1, then matrix[i][j]=1;
	 * check the length between i and j, if j-i > maxLen, then update current (i,j) as the potential
	 * longest Palindromic subString;
	 * 
	 * @param oriStr
	 * @return
	 */
	private static String longestPalindrome(String oriStr) {
		// TODO get the longest palindromic substring 
		if(oriStr == "" || oriStr.length()==1) return oriStr;
		
		int Len = oriStr.length();
		int[][] matrixPalin = new int[Len][Len];
		int start = 0; 	//potential start point of longest Palindrome;
		int end = 0;	//potential end point of longest Palindrome;
		
		//create a matrix, assign every matrix[i][i]=1;
		//check neighbors, if s.charAt(i)==s.charAt(i+1), then matrix[i][i+1]=1;
		matrixPalin[0][0] = 1;
		for(int i=1; i<Len; i++){
			
			matrixPalin[i][i] = 1;
			if(oriStr.charAt(i) == oriStr.charAt(i-1)) {
				matrixPalin[i-1][i] = 1;
				start = i-1;
				end = i;
			}
		}
		printMatrix(matrixPalin);
		
		//check all other steps; 
		//if s.charAt(j)==s.charAt(j) && matrix[j+1][i-1]=1, then matrix[j][i]=1;
		for(int i=2; i<Len; i++){
			
			for(int j=0; j<i; j++){
				
				if(oriStr.charAt(i) == oriStr.charAt(j) && matrixPalin[j+1][i-1]==1){
					
						matrixPalin[j][i] = 1;
						//got an new 'updated' palindromic, if the length is longer, update start-end
						if(i-j > end-start){
							start = j;
							end = i;
						}
					
				}//end if oriStr.charAt(i) == oriStr.charAt(j) condition;
				
			}//end inner for j<Len loop;
			
		}//end outer for i<Len loop;
		printMatrix(matrixPalin);
		
		return oriStr.substring(start, end+1);
	}//end longestPalindrome() method;

	private static void printMatrix(int[][] matrix) {
		// TODO Printout a matrix
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i=0; i<row; i++){
			
			for(int j=0; j<col; j++){
				
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
	}//end printMatrix() method;

}//end of everything in LongestPalindromicSubstring class
