package leetCode2011;

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
		for(int combination = 2; combination<array.length/2; combination++){
			int currSum = 0;
			int elements = 0;
			int start =0;
			sumCombinationofNElements(currSum, elements, combination, array, start, sumSet);
			
		}		
		
		return sumSet.contains(totalSum/2);

	}//end of partitionPro() method;

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
				
			}
			
		}//end if-else elements==combination condition;
		
	}//end of sumCombinationofNElements() method;

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
