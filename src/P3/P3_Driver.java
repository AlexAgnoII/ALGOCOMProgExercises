package P3;

import java.util.Random;

public class P3_Driver {

	public static void main(String[] args) {
	
		
		skylineTest();
		//iterativeMergeSortTest();
		//closestPairTest();
	}
	
	private static void skylineTest() {
		DivideAndConquer.Building[] B = new DivideAndConquer.Building[1];
		
		B[0] = new DivideAndConquer.Building();
		B[0].left = 1;
		B[0].height = 11;
		B[0].right = 5;
		
//		B[1] = new DivideAndConquer.Building();
//		B[1].left = 3;
//		B[1].height = 15;
//		B[1].right = 6;
//		
//		B[2] = new DivideAndConquer.Building();
//		B[2].left = 5;
//		B[2].height = 12;
//		B[2].right = 12;
//		
//		B[3] = new DivideAndConquer.Building();
//		B[3].left = 13;
//		B[3].height = 10;
//		B[3].right = 16;
//		
//		B[4] = new DivideAndConquer.Building();
//		B[4].left = 13;
//		B[4].height = 10;
//		B[4].right = 16;
//		
//		B[5] = new DivideAndConquer.Building();
//		B[5].left = 15;
//		B[5].height = 5;
//		B[5].right = 17;
//		
//		B[6] = new DivideAndConquer.Building();
//		B[6].left = 23;
//		B[6].height = 13;
//		B[6].right = 29;
//		
//		B[7] = new DivideAndConquer.Building();
//		B[7].left = 24;
//		B[7].height = 4;
//		B[7].right = 28;		
		
		long before = System.nanoTime();
		DivideAndConquer.skyline(B);
		long after = System.nanoTime();
		
		//System.out.println((after - before) / 1_000_000_000.0);
	}
	
	
	private static void iterativeMergeSortTest() {

		int A[] = {317, 60, 266, 242, 381, 420, 405, 431, 445, 407, 33, 9, 176, 325, 321, 94, 278, 292, 89, 40, 93, 184, 448, 192, 129, 246, 56, 98, 424, 287, 340, 168, 92, 132, 277, 197, 235, 322, 338, 418, 300, 362, 178, 382, 238, 170, 397, 215, 301, 211, 141, 179, 140, 457, 399, 489, 227, 465, 38, 194, 243, 135, 351, 23, 248, 286, 434, 121, 180, 96, 444, 396, 232, 225, 398, 75, 495, 122, 360, 152, 1, 367, 253, 454, 125, 207, 490, 487, 61, 315, 320, 441, 206, 83, 43, 329, 114, 391, 499, 32, 181, 213, 371, 148, 143, 229, 95, 204, 233, 368, 256, 113, 349, 421, 228, 230, 147, 105, 261, 271, 485, 384, 313, 303, 247, 428, 174, 390, 223, 6, 324, 80, 22, 392, 358, 155, 198, 112, 41, 473, 39, 17, 341, 134, 164, 118, 185, 411, 158, 74, 282, 408, 146, 81, 312, 373, 295, 2, 336, 451, 478, 316, 318, 220, 86, 97, 11, 302, 361, 45, 202, 387, 188, 64, 46, 10, 352, 288, 195, 452, 131, 245, 104, 447, 189, 389, 339, 159, 482, 298, 150, 24, 470, 334, 264, 30, 55, 432, 305, 252, 166, 417, 240, 101, 130, 209, 359, 58, 442, 284, 88, 52, 393, 182, 333, 31, 76, 123, 241, 177, 289, 47, 477, 410, 217, 492, 144, 191, 413, 7, 69, 335, 308, 63, 138, 139, 167, 466, 273, 270, 249, 497, 115, 37, 133, 435, 201, 183, 203, 199, 35, 44, 172, 296, 77, 54, 100, 16, 319, 234, 119, 214, 304, 108, 383, 142, 380, 433, 372, 463, 154, 196, 453, 363, 111, 364, 347, 205, 449, 5, 259, 429, 330, 254, 208, 293, 137, 357, 153, 255, 472, 160, 124, 18, 425, 294, 412, 476, 427, 13, 221, 415, 65, 4, 67, 439, 59, 78, 307, 126, 326, 71, 99, 480, 496, 27, 306, 103, 73, 36, 28, 269, 468, 275, 26, 328, 354, 224, 419, 467, 109, 20, 331, 157, 219, 486, 72, 14, 236, 355, 128, 475, 280, 395, 459, 311, 117, 461, 84, 416, 494, 404, 348, 281, 378, 471, 51, 49, 403, 90, 244, 483, 498, 491, 460, 385, 34, 263, 222, 479, 370, 226, 186, 12, 402, 171, 250, 70, 3, 116, 25, 406, 162, 265, 91, 462, 258, 430, 62, 422, 458, 299, 469, 337, 57, 156, 50, 297, 437, 169, 500, 239, 388, 79, 332, 42, 314, 110, 365, 450, 285, 212, 200, 102, 456, 53, 145, 82, 276, 161, 175, 346, 343, 369, 323, 187, 151, 87, 260, 386, 426, 455, 262, 216, 283, 345, 481, 423, 309, 193, 464, 350, 15, 356, 366, 484, 401, 173, 19, 377, 353, 163, 210, 344, 279, 29, 493, 375, 438, 409, 327, 274, 68, 400, 290, 440, 474, 446, 342, 106, 488, 414, 257, 66, 443, 272, 107, 149, 21, 127, 165, 374, 394, 379, 136, 268, 436, 310, 120, 48, 218, 237, 231, 190, 376, 85, 267, 8, 251, 291};
		long before = System.nanoTime();
		DivideAndConquer.mergesort(A);
		long after = System.nanoTime();
		
		System.out.println((after - before) / 1_000_000_000.0);
	}
	
	private static void closestPairTest() {

		DivideAndConquer.Pt[] points = new DivideAndConquer.Pt[500];
		Random r = new Random();
		
		for(int i = 0; i < points.length; i++) {
			points[i] = new DivideAndConquer.Pt();
			points[i].x = r.nextInt(500);
			points[i].y = r.nextInt(500);
			
			//System.out.println("(" + points[i].x + ", " + points[i].y);
		}

		long before = System.nanoTime();
		DivideAndConquer.closestPair(points);
		long after = System.nanoTime();
		
		//System.out.println((after - before) / 1_000_000_000.0);
	}
	
	

}
