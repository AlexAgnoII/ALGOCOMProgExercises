

public class P3_Driver {

	public static void main(String[] args) {
		
//		Building[] B = new Building[6];
//		
//		B[0] = new Building();
//		B[0].left = 2;
//		B[0].height = 10;
//		B[0].right = 9;
//		
//		B[1] = new Building();
//		B[1].left = 3;
//		B[1].height = 15;
//		B[1].right = 6;
//		
//		B[2] = new Building();
//		B[2].left = 5;
//		B[2].height = 12;
//		B[2].right = 12;
//		
//		B[3] = new Building();
//		B[3].left = 13;
//		B[3].height = 10;
//		B[3].right = 16;
//		
//		B[4] = new Building();
//		B[4].left = 13;
//		B[4].height = 10;
//		B[4].right = 16;
//		
//		B[5] = new Building();
//		B[5].left = 15;
//		B[5].height = 5;
//		B[5].right = 17;
//		
//		B[6] = new Building();
//		B[6].left = 23;
//		B[6].height = 13;
//		B[6].right = 29;
//		
//		B[7] = new Building();
//		B[7].left = 24;
//		B[7].height = 4;
//		B[7].right = 28;		
//		
//		DivideAndConquer.skyline(B);
		
//		int[] A = {17, 12, 20, 16, 15, 7, 9, 8, 10, 13, 3, 11, 1, 19, 18, 5, 4, 6, 2, 1410, 13, 3, 11, 1, 19, 18,17, 12, 20 };
//		DivideAndConquer.mergesort(A);
		
		DivideAndConquer.Pt[] points = new DivideAndConquer.Pt[6];
		points[0] = new DivideAndConquer.Pt();
		points[0].x = 2;
		points[0].y = 3;
		
		points[1] = new DivideAndConquer.Pt();
		points[1].x = 12;
		points[1].y = 30;
		
		points[2] = new DivideAndConquer.Pt();
		points[2].x = 40;
		points[2].y = 50;
		
		points[3] = new DivideAndConquer.Pt();
		points[3].x = 5;
		points[3].y = 1;
		
		points[4] = new DivideAndConquer.Pt();
		points[4].x = 12;
		points[4].y = 10;
		
		points[5] = new DivideAndConquer.Pt();
		points[5].x = 3;
		points[5].y = 4;
		
	
		DivideAndConquer.closestPair(points);
	}

}
