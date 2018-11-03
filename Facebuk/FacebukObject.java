public abstract class FacebukObject {
	protected String name;
	protected Image image;
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false; //if object is null it can't be equal to object
		final String superClassName = o.getClass().getSuperclass().getSimpleName(); //find name of superclass
		if(!superClassName.equals("Entity") && !superClassName.equals("FacebukObject")) return false; 
		
		//if it's not Entity and not FacebukObject then it's not going to be equal
		//contains Entity clause as Person extends Entity and Entity extends FacebukObject
		//for a person, superclass is Entity not FacebukObject but Entity is a FacebukObject.
		//basically a precaution in-case someone puts in a non-FaceBuk object (i.e string) into the function
		
		FacebukObject o2 = (FacebukObject)(o); //cast
		return name.equals(o2.name); //return if the name of this object is equal to name of argument.
	}
}
