public class Possession extends FacebukObject{
	private float _price;
	private Person _owner;
	
	public Possession(String nameOfPoss, Image img, float cost) {
		_price = cost;
		name = nameOfPoss;
		image = img;
		_owner = null;
	}
	
	public void setOwner(Person own) {
		_owner = own;
	}
	
	public float getPrice() {
		return _price;
	}
}
