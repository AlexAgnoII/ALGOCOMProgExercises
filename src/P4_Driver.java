
public class P4_Driver {
	
	public static void main(String[] args) {
		
//		String[] s = {"4 5", "5 4 3 3", "3 3 3 4 5"};
//		GreedyAlgorithms.assignTable(s);
		
//		int[] time = {1, 2, 3};
//		int[] fine = {1, 2, 3};
//		GreedyAlgorithms.shoemaker(time, fine);

		//int[] floors = {5, 7, -2, 6, 9, -3};
		int[] floors = {8, 11, -9, 2, 5, 18, 17, -15, 4};
		//int[] floors = {33, 41, 64, 79, -61, 10, 84, 99, -26, 56, 78, -46, -45, 3, 43, 16, -57, -59, 67, 35};
		//int[] floors = {-42, 57, -60, -96, 20, -52, 83, 33, -15, -14, -71, 41, 2, 43, 89, -61, 66, 29, -24, 4};
		GreedyAlgorithms.design(floors);

		
	}

}
