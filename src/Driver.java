
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.nanoTime();
		action();
		long end = System.nanoTime();
		
		System.out.println("Time it took: " + ((double)(end - start) / 1000000000 ) + " seconds");
		


	}
	
	public static void action() {
		Algorithm_Design_Writing.analyze("Alexander H. Agno II");
		
		//int[] arr = {1,2,3,4};
		//Algorithm_Design_Writing.countSwaps(arr.length, arr);

//		int[] arr = {1000, 100, 100, 100, 100};
//		Algorithm_Design_Writing.checkHarvest(arr.length, 200, arr);

		//Algorithm_Design_Writing.printCombination(20, 3);
	}

}
