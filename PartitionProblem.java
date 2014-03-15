package leetCode2011;
/******************
 * Write a method which takes an array of integers.  The method should return 
 * true if there is a way to split the array in two so that the sum of the
 * numbers on one side of the split equals the sum of the numbers on the other side.
 */

import java.util.HashSet;
import java.util.Scanner;

public class PartitionProblem {

	public static void main(String[] args){
		
		//int[] array = creatArray();
		int[] array = {1,2,2,3,5,7};
		boolean PN = partitionPro(array);
		
		if(PN) System.out.println("yes!");
		else System.out.println("Nope.");
		
	}//end main()

	private static boolean partitionPro(int[] array) {
		// TODO Auto-generated method stub
		int totalSum = 0;
		
		HashSet<Integer> sumSet = new HashSet<Integer>();
		//add each single element to the hashSet, and count the totalSum
		for(int i=0; i<array.length; i++){
			totalSum += array[i];
			sumSet.add(array[i]);
		}
		if(totalSum%2==1) return false;
		
		
		//for a combination of n-elements: n<array.length;
		//actually, we can reduce the combination from array.length-1 to array.length/2 (trick);
		for(int combination = 2; combination<array.length; combination++){
			int currSum = 0;  	//the sum value of this circle;
			int elements = 0; 	//elements already counted;
			int start =0; 		//the index that has not been visited;
			sumCombinationofNElements(currSum, elements, combination, array, start, sumSet);
			
		}//end for combination<array.length loop;
		
		return sumSet.contains(totalSum/2);

	}//end of partitionPro() method;

	/*************
	 * check the elements already counted: if elements = combination, it means we have summed up
	 * as many as combination elements in this circle; so add the currSum to hashSet;
	 * 
	 * if elements has not reached the combination required, add one more array[] element;
	 * the new array[] element could be picked from array index [start];
	 * 
	 * @param currSum
	 * @param elements
	 * @param combination
	 * @param array
	 * @param start
	 * @param sumSet
	 */
	private static void sumCombinationofNElements(int currSum, int elements, int combination, 
			int[] array, int start, HashSet<Integer> sumSet) {
		// TODO Auto-generated method stub
		if(elements == combination){
			int tempSum = currSum;
			sumSet.add(tempSum);
			
		} else {
			
			for(int i=start; i<array.length; i++){
				currSum += array[i];
				sumCombinationofNElements(currSum, elements+1, combination, array, i+1, sumSet);
				
				//recover currSum
				currSum = currSum-array[i];
				
			}//end for i<array.length loop;
			
		}//end if-else elements==combination condition;
		
	}//end of sumCombinationofNElements() method;

	/********
	 * create a random array;
	 * @return
	 */
	private static int[] creatArray() {
		// TODO Auto-generated method stub
		System.out.println("Please input the num of elements in the array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*5);
			System.out.print(" " + array[i]);
		}
		System.out.println();
		
		return array;
	}//end creatArray() method;
}//end of everything in PartitionProblem class;
