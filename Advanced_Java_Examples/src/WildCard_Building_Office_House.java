import java.util.*;

public class WildCard_Building_Office_House {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List of buildings
		List<Building> buildings = new ArrayList();
		buildings.add(new Building());
		buildings.add(new Building());
		printBuildings(buildings);
		
		//List of offices
		List<Office> offices = new ArrayList();
		offices.add(new Office());
		offices.add(new Office());
		printBuildings(offices);
		
		//List of houses
		List<House> houses = new ArrayList();
		houses.add(new House());
		houses.add(new House());
		printBuildings(houses);
		
		addHouseToList(houses);
		addHouseToList(buildings);
	}

//	Here we have used the wildcard which states that we can use any objects that extends Building class
//	So in this case we can pass House/Office to this method. This kind of variable is in variable
	static void printBuildings(List<? extends Building> buildings) {
		for(int i=0; i<buildings.size(); i++) {
			System.out.println(buildings.get(i).toString() + " " + (i + 1));
		}
		System.out.println();
	}

//	Here we have used the wildcard which states that we can use any objects that is parent of House class
//	So in this case we can pass Building to this method. This kind of variable is out variable
	static void addHouseToList(List<? super House> buildings) {
		buildings.add(new House());
		System.out.println();
	}
}
