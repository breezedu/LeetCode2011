package leetCode2011;
/***************
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * @author Frog
 */
import java.util.Scanner;

public class MedianOfTwoSortedArray { 
		
	public static void main(String[] args){
		
		System.out.println("This is a Median of Two Sorted Array program.");
		
		//1st, build 2 arrays
		System.out.println("Please input the length of each array:");
		Scanner input = new Scanner(System.in);
		System.out.print("num1 = " );
		int num1 = input.nextInt();
		System.out.print("num2 = " );
		int num2 = input.nextInt();
		input.close();
		
		int arrayOne[] = createArray(num1);
		int arrayTwo[] = createArray(num2);
		//printout two arrays
		printArray(arrayOne);
		printArray(arrayTwo);
				
		double Median = findMedianSortedArrays(arrayOne, arrayTwo);
		System.out.println("The median of 1st two arrays is: " + Median);
		
		
		//3rd, checkout the median element of the two arrays;
		System.out.println("L36: Inputed arrays that TLE in LeetCode OJ:");
		int[] arrayA = {23, 32, 47, 50};
		int[] arrayB = {1, 10, 10, 30, 39, 41};
		double med2 = findMedianSortedArrays(arrayA, arrayB);
		System.out.println("the median of 2nd two arrays is: " + med2);
		
	}//end main();
	
	
	//very much like the merge-sort; 
	//but with O(logM + logN), it's quite difficult;
	//Even headache, ==!
	public static double findMedianSortedArrays(int A[], int B[]){
		 int LenA = A.length, LenB = B.length;
	        if(LenA == 0) return simpleMedian(B);
	        if(LenB == 0) return simpleMedian(A);
	        
	        return medianSearch(A, B, Math.max(0, (LenA + LenB)/2 - LenB), Math.min(LenA - 1, (LenA + LenB)/2));
	} //end findMedianSortedArrays() method;
	    
	private static double medianSearch(int A[], int B[], int left, int right){
		int LenA = A.length, LenB = B.length;
	    if(left > right) return medianSearch(B, A, Math.max(0, (LenA + LenB)/2 - LenA), Math.min(LenB - 1, (LenA + LenB)/2));
	    int i = (left + right) / 2;
	    int j = (LenA + LenB) / 2 - i - 1;
	    boolean lvalid = (j < 0) || (A[i] >= B[j]);
	    boolean rvalid = (j >= LenB - 1) || (A[i] <= B[j + 1]);
	        
	    if(lvalid && !rvalid){ 
	        return medianSearch(A, B, left, i - 1);
	    }else if(!lvalid && rvalid){
	        return medianSearch(A, B, i + 1, right);
	    }
	        
	    // median is found
	    if((LenA + LenB) % 2 == 1) return A[i];
	    if(i > 0) {
	        int pre = (j < 0) ? A[i - 1] : Math.max(A[i - 1], B[j]);
	        return (A[i] + pre) / 2.0;
	    }
	    return (A[i] + B[j]) / 2.0;
	}//end medianSearch() method;
	    
	private static double simpleMedian(int array[]){
	    int Len = array.length;
	    return (Len % 2 == 1) ? array[Len/2] : (array[Len/2 - 1] + array[Len/2]) / 2.0;
	   
	}//end simpleMedian() method;


	private static void printArray(int[] array) {
		// TODO Printout an array
		if(array==null){
			System.out.println("Nothing in the array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
		
	}//end of printArray() method

	private static int[] createArray(int num) {
		// TODO create an sorted array
		
		if(num==0) return null;
		int[] array = new int[num];
		
		array[0] = (int)(Math.random() * 25);
		for(int i=1; i<num; i++){
			array[i] = array[i-1] + (int)(Math.random() * 25);
		}
		
		return array;
		
	}//end createArray() method;
	
}//end everything in MedianOfTwoSortedArray class
