import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithms {
	
	//0 = num of team(1st) and num of tables(2nd)
	//1 = size of each team
	//2 = capacity of each table.
	public static void assignTable(String[] input) {
		List<Team> teamList;
		List<Table> tableList;
		
		int[] sizes, 
		      teamSizes, 
		      tableCapacities;
		
		int possible = 1;
		
		sizes = stringSplitToInt(input[0]);
		teamSizes = stringSplitToInt(input[1]);
		tableCapacities = stringSplitToInt(input[2]);
		
		teamList = new ArrayList<Team>();
		for(int i = 0; i < teamSizes.length; i++) 
			teamList.add(new Team(i+1, teamSizes[i]));
		
		tableList = new ArrayList<Table>();
		for(int i = 0; i < tableCapacities.length; i++) {
			tableList.add(new Table(i+1, tableCapacities[i]));
		}
		
//		printElements(teamList);
//		printElements(tableList);
		
		//Descending order of tables.
		Collections.sort(tableList, Table.capacityComparator);
		
		for (Team team : teamList) {
//			System.out.println(team.getName());
			
			if(team.getSize() <= tableList.size()) {
				
				int index = 0;
				while(team.getSize() > 0 && 
					  index < tableList.size() &&
					  possible == 1) {
					
					Table table = tableList.get(index);
					
					if(table.getCapacity() > 0) {
						team.addTableAssigned(table.getName());
						team.setSize(team.getSize() - 1);
						table.setCapacity(table.getCapacity() - 1);
					}
					else {
						possible = 0;
					}
					
					index++;
				}
				
				//not possible anymore since not all students were able to sit.
				if(possible == 0)
					break;
			}
			
			//not possible anymore since the number of tables is less the number of student in a team.
			else {
				possible = 0;
				break;
			}
		}
		
		//check if all teams are capacity 0
		for (Team team : teamList) {
			if(team.getSize() != 0) {
				possible = 0;
				break;
			}
		}
		
		System.out.println(possible);
		if(possible == 1) {			
			for(Team team : teamList) {
				team.printTableAssigned();
			}
		}		
	}
	
	private static int[] stringSplitToInt(String string) {
		
		String[] stringSplitted = string.split(" ");
		int size = stringSplitted.length;
		int[] intSplitted = new int[size];
		
		for(int i = 0 ; i < size; i++) 
			intSplitted[i] = Integer.parseInt(stringSplitted[i]);
		
		return intSplitted;
	}
	
	//Testing	
	private static void printElements(List<Integer> list) {
		for (int element : list) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void shoemaker(int[] jobTime, int[] fine) {
		  //your print statements here 
	}


	public static void design(int[] floors) {
		  //your print statements here 
	}
	
	
	private static class Table {
		private int name;
		private int capacity;
		
		public Table(int name, int capacity) {
			this.name = name;
			this.capacity = capacity;
		}

		public int getName() {
			return name;
		}

		public void setName(int name) {
			this.name = name;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		
		public static void printElements(List<Table> tables) {
			for (Table t : tables) {
				System.out.print("Table " + t.getName() + ": " + t.getCapacity() + " | ");
			}
			System.out.println();
		}
		
		public static Comparator<Table> capacityComparator = new Comparator<Table>() {
			@Override
			public int compare(Table t1, Table t2) {
				// TODO Auto-generated method stub
				return (t2.getCapacity() < t1.getCapacity() ? -1 : (t2.getCapacity() == t1.getCapacity() ? 0 : 1));
			}
		};
	}
	
	private static class Team {
		private int name;
		private int size;
		private List<Integer> tableAssigned;
		
		public Team(int name, int size) {
			this.name = name;
			this.size = size;
			this.tableAssigned = new ArrayList<Integer>();
		}
		
		public void addTableAssigned(int tableName) {
			this.tableAssigned.add(tableName);
		}

		public int getName() {
			return name;
		}

		public void setName(int name) {
			this.name = name;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
		
		public static void printElements(List<Team> teams) {
			for (Team t : teams) {
				System.out.print("Team " + t.getName() + ": " + t.getSize() + " ");
			}
			System.out.println();
		}
		
		public void printTableAssigned() {
			for (int i : tableAssigned) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
