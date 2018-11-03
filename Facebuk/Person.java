import java.util.ArrayList;

public class Person extends Entity {
	private ArrayList _pets;
	private ArrayList _possessions;
	
	public Person(String nameOfPerson, Image img) {
		name = nameOfPerson;
		image = img;
		_pets = new ArrayList();
		_possessions = new ArrayList();
		moments = new ArrayList();
		friends = new ArrayList();
	}
	
	public void setPossessions(ArrayList poss) {
		_possessions = poss;
	}
	
	public void setPets(ArrayList petsList) {
		_pets = petsList;
	}
}
