import java.util.ArrayList;

public abstract class Entity extends FacebukObject{
	protected ArrayList moments;
	protected ArrayList friends;
	
	public void setFriends(ArrayList friendList) {
		friends = friendList;
	}
	
	public void setMoments(ArrayList momentsList) {
		moments = momentsList;
	}
	
	public ArrayList getFriends() {
		return friends;
	}
	
	public void addFriend(Entity friend) {
		friends.add(friend);
	}
	
	public boolean isFriend(Entity friend) {
		return friends.contains(friend);
	}
	
	public Moment getOverallHappiestMoment() {
		float max = Integer.MIN_VALUE; 
		//-2.147 billion as that makes sure that if there is even a negative average happiness (thats sad) it will work.
		Moment moment = null;
		for(Object mom1 : moments) {
			final Moment mom = (Moment)(mom1); //goes through every moment in this entity
			final float avgHappy = mom.averageHappiness(); //finds average happiness of the moment
			if(avgHappy > max) {
				max = avgHappy;
				moment = mom;
				//if average happiness of this moment is higher than the current max, then set to max and set moment to this
			}
		}
		return moment; //return
	}
	
	public Entity getFriendWithWhomIAmHappiest() {
		float max = Integer.MIN_VALUE;
		Entity friend = null;
		
		for(int i = 0; i < friends.size(); i++) {
			final Entity friendAtList = (Entity)(friends.get(i)); //goes through every friend that this entity has
			float happinessWithFriend = 0; //total happiness with friend
			float numberOfMoments = 0; //total moments that friend has participated in
			
			for(int j = 0; j < moments.size(); j++) {
				final Moment mom = (Moment)(moments.get(j)); //goes through every moment in this entity's life
				final boolean hasFriend = mom.getParticipants().contains(friendAtList); //gets whether friend is in the participants
				if(hasFriend) { //if friend is in moment
					happinessWithFriend+=mom.getHappinessOfParticipant(this); 
					numberOfMoments++;
					//add happiness to the total and increase number of moments
				}
			}
			
			if(numberOfMoments != 0) { //if there are moments that this friend has participated in
				happinessWithFriend/=numberOfMoments; //find the average happiness
				if (happinessWithFriend > max) {
					max = happinessWithFriend; 
					friend = friendAtList;
					//if max, set both max and friend to their new values
				}
			}
		}
		return friend; //return the friend.
	}
	
	//takes an ArrayList of entities.
	public static boolean isClique(ArrayList set) {
		for(int i = 0; i < set.size()-1; i++) {
			Entity friendi = (Entity)(set.get(i)); //goes through every entities in the set
			for(int j = i+1; j < set.size(); j++) { //looks at all the entities in the set after friendi
				Entity friendj = (Entity)(set.get(j));
				if(!friendi.isFriend(friendj)) {
					return false; //if friendi is not friend with this entity, return false as it is not a clique
				}
			}
		}
		return true; //if this for loop never fails, everyone is friends with each other so return true.
	}
	
	public ArrayList findMaximumCliqueOfFriends() {
		return makeClique(new ArrayList(), getFriends()); //use a helper function as it is done recursively.
	}	
	
	//takes two ArrayLists of entities.
	private ArrayList makeClique(ArrayList current, ArrayList toAdd) {
		if(toAdd.size() == 0) return current;
		//if there is nothing to add, current is your maximum clique 
		final ArrayList possibleClique = addToList(current, toAdd.get(0)); 
		//this is the possible clique of the current clique and toAdd's first item
		final ArrayList toAddRest = removeFirstIndex(toAdd); //this is the rest of toAdd, removing what just entered possibleClique
		
		if(((Entity)toAdd.get(0)).equals(this) || current.contains(toAdd.get(0))) {
			return makeClique(current, toAddRest);
			//if the entity is who we're trying to find the clique for, continue on the recursive search
			//or if current already has the entity in it, then continue as well.
		}
		else { //if current doesn't already contain the first of toAdd
			if(isClique(possibleClique)) { //if the possibleClique clique is actually a clique
				final Entity ent = (Entity)(toAdd.get(0)); //cast as entity
				return max(makeClique(possibleClique, addToList(toAddRest, ent.getFriends())), makeClique(current,toAddRest));
				//return the max size ArrayList between two recursive calls
				
				//first makes a recursive call between possibleClique and the rest of toAdd but also with the new clique member's friends.
				
				//second is a recursive call to see, what if we skipped the first guy and used the second guy as a clique member? 
				//could create a bigger clique?
			}
			else return makeClique(current, toAddRest);
		}
	}
	
	//takes two ArrayLists, any type
	private ArrayList max(ArrayList one, ArrayList two) {
		if(one.size() >= two.size()) return one;
		return two;
		//returns the max size ArrayList between two ArrayLists.
	}
	
	//takes an ArrayList, any type
	private ArrayList removeFirstIndex(ArrayList list) {
		ArrayList ret = new ArrayList();
		for(int i = 1; i < list.size(); i++) {
			ret.add(list.get(i));
		}
		return ret;
		//removes first index in an ArrayList, as .remove returns a boolean and I wanted to shorten code in makeClique
	}
	
	//takes an ArrayList and object, any type
	private ArrayList addToList(ArrayList list, Object add) {
		ArrayList ret = new ArrayList();
		for(int i = 0; i < list.size(); i++) ret.add(list.get(i));
		ret.add(add);
		return ret;
		//adds object to list, as .add returns a boolean and I wanted to shorten code in makeClique
	}
	
	//takes two ArrayLists, any type
	private ArrayList addToList(ArrayList list1, ArrayList list2) {
		ArrayList ret = new ArrayList();
		for(int i = 0; i < list1.size(); i++) ret.add(list1.get(i));
		ret.addAll(list2);
		return ret;
		//adds together two lists, as .addAll returns a boolean and I wanted to shorten code in makeClique
	}

}
