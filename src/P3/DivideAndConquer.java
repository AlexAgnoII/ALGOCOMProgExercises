package P3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Name: Alexander H. Agno II
//Secion: ALGOCOM S18
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
		   
		List<Point> pointX = new ArrayList<Point>(); //Points sorted in x.
		List<Point> pointY = new ArrayList<Point>(); //Points sorted in y.
		
		for(int i = 0; i < P.length; i++) {
			Point p = new Point();
			p.setX(P[i].x);
			p.setY(P[i].y);
			p.setInputIndex(i);
			pointX.add(p);
			pointY.add(p);
		}
		
		Collections.sort(pointX, Point.xComparator);
		Collections.sort(pointY, Point.yComparator);
		
//		for(Point p : pointX) {
//			System.out.print("(" + p.x + ", " +  p.y + ")");
//		}
		
		Pair p = findClosestPair(pointX, pointY,  P.length);

		int index_lower;
		int index_higher;
		
		if(p.getP1().getInputIndex() < p.getP2().getInputIndex()) {
			index_lower = p.getP1().getInputIndex();
			index_higher = p.getP2().getInputIndex();
		}
		else {
			index_lower = p.getP2().getInputIndex();
			index_higher = p.getP1().getInputIndex();
		}
		
		System.out.printf("%d %d %f \n", index_lower, 
				                         index_higher, 
				                         p.getDistance());
	}
	
	private static Pair findClosestPair(List<Point> pointX, List<Point> pointY, int size) {
	
		if(size <= 3) {
			return doBruteForce(pointX, size);
		}
		
		int mid = size / 2;
		Point midPoint = pointX.get(mid);
		
//		System.out.println("size: " + size);
//		System.out.println("pointX size:  " + pointX.size());
//		System.out.println("pointY size: " + pointY.size());
//		System.out.println("Mid: " + mid);
		
		
		List<Point> PYL = new ArrayList<Point>();
		List<Point> PYR = new ArrayList<Point>();
		
		//separate the points to PL and PR (sorted in Y)
		for(int i = 0; i < size; i++) {
			
			if(i < mid) 
				PYL.add(pointY.get(i));
			else if(i > mid)
				PYR.add(pointY.get(i));	
		}
		
		//shift point x so that it will access the other half of the points
		List<Point> shiftedPointX = new ArrayList<Point>();
		for(int i = 0; i < size - mid - 1; i++) {
			shiftedPointX.add(pointX.get(i + mid + 1));
		}
		
//		System.out.println("PYL: " + PYL.size());
//		System.out.println("PYR: " + PYR.size());
//		System.out.println();
		
		//find closest pair of points on the left and right of the midpoint.
		Pair smallPairLeft = findClosestPair(pointX, PYL, mid);
		Pair smallPairRight = findClosestPair(shiftedPointX, PYR, (size - mid - 1));
		
		//Find the smallest distance between the left and right.
		Pair smallestPair = smallPairLeft.getDistance() < smallPairRight.getDistance() ? smallPairLeft : smallPairRight;
		
		//Optimized combined step
		List<Point> rectangle = new ArrayList<Point>();
		for(int i = 0; i < size; i++) {
			
			//If true, there's a special case of Delta(SL,SR)
			if(Math.abs(pointY.get(i).getX() - midPoint.x) < smallestPair.getDistance()) 
				rectangle.add(pointY.get(i));
			
		}
		
		//Find the minimum between the smallest distance and the possible smallest distance on the special case.
		Pair possiblePair = rectangleClosest(rectangle, smallestPair.getDistance());
		return smallestPair.getDistance() < possiblePair.getDistance() ? smallestPair : possiblePair;
	}
	
	private static Pair rectangleClosest(List<Point> rectangle, double distance) {
		
		int size = rectangle.size();
		double min = distance;
		Pair p = new Pair(null, null, Double.MAX_VALUE);
		
		for(int i = 0 ; i < size; i++) {
			for(int j = i + 1; j < size; j++) {
				double smallestDistance = calculateDistance(rectangle.get(i), rectangle.get(j));
				
				if(smallestDistance < min) {
					min = smallestDistance;
					p.setDistance(min);
					p.setP1(rectangle.get(i));
					p.setP2(rectangle.get(j));
				}
				
				if(rectangle.get(j).getY() - rectangle.get(i).getY() < min)
					break;
			}
		}
		
		return p;
	}
	
	private static Pair doBruteForce(List<Point> pointX, int size) {
		
		double min = Double.MAX_VALUE;
		Pair p = new Pair(null, null, Double.MAX_VALUE);
		for(int i = 0; i < size; i++) {
			for(int j = i+1; j < size; j++) {
				double smallestDistance = calculateDistance(pointX.get(i), pointX.get(j));
				if(smallestDistance < min) {
					min = smallestDistance;
					p.setDistance(min);
					p.setP1(pointX.get(i));
					p.setP2(pointX.get(j));
				}
			}
		}
		
 		return p;
	}
	
	//Euclidean Distance formula
	private static double calculateDistance(Point p1, Point p2) {
		return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) +
				         (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
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
	
	private static class Pair {
		private Point p1;
		private Point p2;
		private double distance;
		
		public Pair(Point p1, Point p2, double distance) {
			this.p1 = p1;
			this.p2 = p2;
			this.distance = distance;	
		}

		public Pair() {
			// TODO Auto-generated constructor stub
		}

		public Point getP1() {
			return p1;
		}

		public void setP1(Point p1) {
			this.p1 = p1;
		}

		public Point getP2() {
			return p2;
		}

		public void setP2(Point p2) {
			this.p2 = p2;
		}

		public double getDistance() {
			return distance;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}
	}
	
	private static class Point {
		
		private int x;
		private int y;
		private int inputIndex;

		public static Comparator<Point> xComparator = new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				// TODO Auto-generated method stub
				return (p1.getX() < p2.getX() ? -1 : (p1.getX() == p2.getX() ? 0 : 1));
			}
		};
		
		public static Comparator<Point> yComparator = new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return (p1.getY() < p2.getY() ? -1 : (p1.getY() == p2.getY() ? 0 : 1));
			}
		};
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public void setInputIndex(int inputIndex) {
			this.inputIndex = inputIndex;
		}
		
		public int getInputIndex() {
			return this.inputIndex;
		}
	}

}
