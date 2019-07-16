package P3;

import java.util.Scanner;

public class DivideAndConquer {
	
	public static void skyline (Building[] B) {
		   //put your code here and the print statements for the output.
	}
	
	public static void mergesort (int[] A) {
		int n = A.length;

		//size represents the size. (Merge from bottom to top) size 1 then 2 then 4 then 8 etc.
        for(int size = 1; size < n; size = 2 * size) {
        	for(int lhs = 0; lhs < n; lhs += 2 * size) {
        		
        		int mid = Math.min(lhs + size - 1, n-1); 
                int rhs = Math.min(lhs + 2 * size - 1, n-1); 
                
        	    merge(A, lhs, rhs, mid);
        	}
        }
	}
	
	private static void merge(int[] A, int lhs, int rhs, int mid) {
		
		int n1Len = mid - lhs + 1;
		int n2Len = rhs - mid;
		
		int[] leftArray = new int[n1Len + 1];
		int[] rightArray = new int[n2Len + 1];
		
		for(int i = 0; i < n1Len; i++) {
			leftArray[i] = A[lhs + i];
		}
		
		for(int j = 0; j < n2Len; j++) {
			rightArray[j] = A[mid + j + 1];
		}
		
		leftArray[n1Len] = Integer.MAX_VALUE;
		rightArray[n2Len] = Integer.MAX_VALUE;
		
		int i = 0; //left array index
		int j = 0; //right array index
		
		for(int x = lhs; x <= rhs; x++) {
			
			if(leftArray[i] <= rightArray[j]) {
				A[x] = leftArray[i];
				i++;
			}
			
			else {
				A[x] = rightArray[j]; 
				j++;
			}
		}
	}
	
	public static void closestPair (Pt[] P) {
		   //put your code here and the print statements for the output.
	}
	
	
	//Do we separate this to a different class for our testing or keep this here as is
	public class Building {
		  public int left;  //the left X-coordinate
		  public int right; //the right X-coordinate
		  public int height; //the height
	}
	
	public class Pt {
		  public int x;  //X-coordinate
		  public int y; // Y-coordinate
	}
}
