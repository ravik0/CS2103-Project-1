public class FriendRequest {
	private Entity _entity1;
	private Entity _entity2;
	private boolean _approved1, _approved2;
	
	public FriendRequest(Entity ent1, Entity ent2) {
		_entity1 = ent1;
		_entity2 = ent2;
		_approved1 = _approved2 = false;
	}
	
	public void approve(Entity ent) {
		if(!ent.equals(_entity1) && !ent.equals(_entity2)) {
			throw new IllegalArgumentException("Person not part of the friend request!");
			//if entity passed in is not part of the friend request, throws an IllegalArgumentException
		}
		else if(ent.equals(_entity1) && !_approved1) {
			_approved1 = true;
			//approve for entity1
		}
		else if(ent.equals(_entity2) && !_approved2) {
			_approved2 = true;
			//approve for entity2
		}
		if(_approved1 && _approved2) {
			//if both approved, then add.
			_entity1.addFriend(_entity2);
			_entity2.addFriend(_entity1);
		}
	}
}

