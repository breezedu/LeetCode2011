package leetCode2011;

import java.util.Scanner;

/******************
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Frog
 *
 */
public class ThreeSumClosest {
	
	public static void main(String[] args){
		
		System.out.println("This is 3-Sum closest program.");
		
		//1st, create an array of integers
		System.out.println("Please input the num of elements in the array:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		
		int[] array = createArray(num);
		printArray(array);
		
		
		//2nd, ask user to input a target
		System.out.print("target: ");
		int target = input.nextInt();
		input.close();
		
		//3rd, checkout the closest sum to target
		int triSum = threeSumClosest(array, target);
		System.out.println("The clostest sum we can get from the array is: " + triSum);
		
	}//end main()

	private static int threeSumClosest(int[] array, int target) {
		// TODO calculate the three-sum from the array, return the closest result to target
		if(array.length ==0 || array==null) return 0;
		if(array.length <4){
			int sum = 0;
			for(int i=0; i<array.length; i++){
				sum += array[i];
			}
			return sum;
		}
		
		int count = 0; 	//the num of elements added (0, 1, 2 or 3)
		int start = 0; 	//the index of start point;
		int sum = 0;	//sum of elements
		int diff = 10000; 	//potential diff to target, we want the smallest abs value of diff;
		diff = calculateThreeSum(array, start, count, diff, target, sum);
		
		return diff + target;
	}

	private static int calculateThreeSum(int[] array, int start, int count, int diff, int target, int sum) {
		// TODO Auto-generated method stub		
		if(count == 3){
			
			int tempDiff = sum - target;
			if(Math.abs(tempDiff) < Math.abs(diff) ){
				diff = tempDiff;
				System.out.print(" " +diff);
			}
			return diff;
			
		} else if(count <3){
			
			for(int i= start; i<array.length; i++){
				int newSum = sum + array[i];
				int newCount = count+1;
				diff = calculateThreeSum(array, i+1, newCount, diff, target, newSum);
				
			}
			
		}//end if-else conditions;
		
		return diff;		
	}

	private static int[] createArray(int num) {
		// TODO create an array of num elements
		if(num == 0){
			return null;
		}
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random() * 25);
		}
		return array;
	}//end createArray() method;

	private static void printArray(int[] array) {
		// TODO Printout an array
		if(array == null || array.length==0){
			System.out.println("Nothing in the array");
		}
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}//end printArray() method

}//end everything in ThreeSumClosest class
