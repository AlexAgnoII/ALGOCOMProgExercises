package P3;

import P3.DivideAndConquer.Building;

public class P3_Driver {

	public static void main(String[] args) {
		
		Building[] B = new Building[6];
		
		B[0] = new Building();
		B[0].left = 2;
		B[0].height = 10;
		B[0].right = 9;
		
		B[1] = new Building();
		B[1].left = 3;
		B[1].height = 15;
		B[1].right = 6;
		
		B[2] = new Building();
		B[2].left = 5;
		B[2].height = 12;
		B[2].right = 12;
		
		B[3] = new Building();
		B[3].left = 13;
		B[3].height = 10;
		B[3].right = 16;
		
		B[4] = new Building();
		B[4].left = 13;
		B[4].height = 10;
		B[4].right = 16;
		
		B[5] = new Building();
		B[5].left = 15;
		B[5].height = 5;
		B[5].right = 17;
		
//		B[6] = new Building();
//		B[6].left = 23;
//		B[6].height = 13;
//		B[6].right = 29;
//		
//		B[7] = new Building();
//		B[7].left = 24;
//		B[7].height = 4;
//		B[7].right = 28;
		
		
		
		DivideAndConquer.skyline(B);

	}

}
