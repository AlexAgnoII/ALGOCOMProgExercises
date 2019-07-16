package P2;

public class P2_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.nanoTime();
		action();
		long end = System.nanoTime();
		
		System.out.println("Time it took: " + ((double)(end - start) / 1000000000 ) + " seconds");
		


	}
	
	public static void action() {
		//Algorithm_Design_Writing.analyze("Count me 1 2 3 4 5! Wow! I love ALGOCOM!");
		
//		
		int[] arr = {10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,410,9,8,7,6,5,4,3,2,10,9,8,7,6,5,4,3,2,11,3,2,1,10,9,10,9,8,7,6,5,4,3,2,18,7,10,9,8,7,6,5,4,3,2,16,5,4,3,2,110,9,8,7,6,5,4,3,2,1,10,9,8,7,6,5,4,3,2,1, 10,9,8,7,6,5,4,3,2,1, 10,9,8,7,6,5,4,3,2,1, 10,9,8,7,6,5,4,3,2,1, 10,9,8,7,6,5,4,3,2,1};
		Algorithm_Design_Writing.countSwaps(arr.length, arr);

		
//		int[] arr2 = {100, 0, 300, 100, 100};
//		Algorithm_Design_Writing.checkHarvest(arr2.length, 500, arr2);

		//Algorithm_Design_Writing.printCombination(4, 3);
	}

}
