import java.util.ArrayList;

public class Moment extends FacebukObject{
	private ArrayList _participants;
	private ArrayList _smileValues;
	
	public Moment(String nameOfMoment, Image img, ArrayList participantList, ArrayList smileValueList) {
		name = nameOfMoment;
		image = img;
		_participants = participantList;
		_smileValues = smileValueList;
	}
	
	public float averageHappiness() {
		float totalHappy = 0; 
		final int size = _smileValues.size();
		for(int i = 0; i < size; i++) totalHappy+=(float)(_smileValues.get(i));
		if(size == 0) return totalHappy; //a moment is created with only possessions in it, so no smiles or participants.
		return totalHappy/size;
	}
	
	public float getHappinessOfParticipant(Entity entity) {
		return (float)(_smileValues.get(_participants.indexOf(entity)));
	}
	
	public ArrayList getParticipants() {
		return _participants;
	}
}
