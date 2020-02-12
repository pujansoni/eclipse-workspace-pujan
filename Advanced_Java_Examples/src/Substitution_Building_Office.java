import java.util.*;
public class Substitution_Building_Office {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Building building = new Building();
		Office office = new Office();
//		Here the substitution principle works because the office is the subclass of the building 
//		and when we use the build method it will be able to detect the toString method of office 
//		even if the build method's signature contains the building object.
		build(building);
		build(office);
		
		List<Building> buildings = new ArrayList();
		buildings.add(new Building());
		buildings.add(new Office());
		printBuildings(buildings);
		
//		The same procedure is not applicable on the list. Here when we uncomment the code below 
//		we will get an error because the printBuildings() method signature which takes the List 
//		of type Building would not take Office as a substitution, this problem can be solved by wildcard.
//		List<Office> offices = new ArrayList();
//		offices.add(new Office());
//		offices.add(new Office());
//		printBuildings(offices);
	}
	
	static void build(Building building) {
		System.out.println("Constructing a new " + building.toString());
	}
	
	static void printBuildings(List<Building> buildings) {
		for(int i=0; i<buildings.size(); i++) {
			System.out.println(i + 1 + ": " + buildings.get(i).toString());
		}
	}

}
