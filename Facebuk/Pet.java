import java.util.ArrayList;

public class Pet extends Entity  {
	private Person _owner;
	
	public Pet(String nameOfPet, Image img) {
		name = nameOfPet;
		image = img;
		_owner = null;
		moments = new ArrayList();
		friends = new ArrayList();
	}
	
	public void setOwner(Person own) {
		_owner = own;
	}
}
