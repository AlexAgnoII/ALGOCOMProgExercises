package P3;

import java.util.ArrayList;
import java.util.List;

public class DivideAndConquer {
	
	public static void skyline (Building[] B) {
		List<SkylinePoint> skylinePoints;
		
		skylinePoints = getSkylines(B, 0, B.length - 1);

		for(SkylinePoint sp : skylinePoints) {
			System.out.print(sp.x + " " + sp.y + " ");
		}
		System.out.println();
	}
	
	private static List<SkylinePoint> getSkylines(Building[] B, int lhs, int rhs) {
		
		List<SkylinePoint> skyLinePointList = new ArrayList<SkylinePoint>();
		if(lhs < rhs) {
			int mid = (lhs + rhs) / 2;
			List<SkylinePoint> leftSkylinePointList = getSkylines(B, lhs, mid);
			List<SkylinePoint> rightSkylinePointList = getSkylines(B, mid + 1, rhs);
			return mergeSkylines(leftSkylinePointList, rightSkylinePointList);
		}
		
		//divide single building into 2 skyline point (1 building has 2 skyline point)
		else if (lhs == rhs) {
			SkylinePoint s1 = new SkylinePoint(B[lhs].left, B[lhs].height);
			SkylinePoint s2 = new SkylinePoint(B[lhs].right, 0);
			skyLinePointList.add(s1);
			skyLinePointList.add(s2);
		}
		
		return skyLinePointList;
	}
	
	private static List<SkylinePoint> mergeSkylines(List<SkylinePoint> leftSkylinePointList, 
			                                        List<SkylinePoint> rightSkylinePointList) {
		
		List<SkylinePoint> mergedSkylinePoints = new ArrayList<SkylinePoint>();
		int leftHeight = 0; //
		int rightHeight = 0;
		int n = leftSkylinePointList.size();
		int m = rightSkylinePointList.size();
		
		int i = 0; //index of left skyline points
		int j = 0; //index of right skyline points 
		
		//left and right hand side of the list of skyline points are not empty.
		while(i < n && j < m) {
			SkylinePoint newSkylinePoint = new SkylinePoint();
			
			//compare the left x coordinate strip of a building between the leftskylinePoint and rightSkylinePoint
			if(leftSkylinePointList.get(i).x < rightSkylinePointList.get(j).x) {
				
				newSkylinePoint.x = leftSkylinePointList.get(i).x;
				leftHeight = leftSkylinePointList.get(i).y;		
				newSkylinePoint.y = Math.max(leftHeight, rightHeight);
				i++;
			}
			
			else {
				newSkylinePoint.x = rightSkylinePointList.get(j).x;
				rightHeight = rightSkylinePointList.get(j).y;
				newSkylinePoint.y = Math.max(leftHeight, rightHeight);
				j++;
			}
			
			addNewSkylinePoint(mergedSkylinePoints, newSkylinePoint);
		}
		
		//add remaining strips that were not used.
		while( i < n) {
			mergedSkylinePoints.add(leftSkylinePointList.get(i));
			i++;
		}
		
		while(j < m ) {
			mergedSkylinePoints.add(rightSkylinePointList.get(j));
			j++;
		}
		
		return mergedSkylinePoints;
	}
	
	//check previous element and dont add unecessary skyline points (when new x or height is same as the recently added skyline point's x or height.)
	private static void addNewSkylinePoint(List<SkylinePoint> mergedSkylinePoints, 
			                        SkylinePoint newSkylinePoint) {
		int n = mergedSkylinePoints.size();

		
		if(n > 0) {
			if(mergedSkylinePoints.get(n - 1).y == newSkylinePoint.y)
				return;
			
			else if(mergedSkylinePoints.get(n - 1).x == newSkylinePoint.x) {
				mergedSkylinePoints.get(n - 1).y = Math.max(mergedSkylinePoints.get(n - 1).y, newSkylinePoint.y);
				return;
			}
		}
		//safetly add new skyline point.
		mergedSkylinePoints.add(newSkylinePoint);
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
        
        for (int i = 0; i < n; i++) {
        	System.out.print(A[i] + " ");
        }
        System.out.println();
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
	
	private static class SkylinePoint {
		
		public SkylinePoint(int left, int height) {
			this.x = left;
			this.y = height;
		}
		
		public SkylinePoint() {
			// TODO Auto-generated constructor stub
		}

		public int x;
		public int y;
		
	}
	
	public static class Building {
		  public int left;  //the left X-coordinate
		  public int right; //the right X-coordinate
		  public int height; //the height
	}
	
	public static class Pt {
		  public int x;  //X-coordinate
		  public int y; // Y-coordinate
	}
}
