import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a SUBSET of the unit tests with which we will grade your code.
 *
 * Make absolute sure that your code can compile together with this tester!
 * If it does not, you may get a very low grade for your assignment.
 */
public class FacebukPartialTester {
	private Person _barack, _michelle, _kevin, _ina, _joe, _malia;
	private Pet _bo, _sunny;
	private Moment _meAndBarack;
	private ArrayList _michelleAndBarack, _michelleJoeBoAndMalia;

	@Before
	public void setUp () {
		initPeople();
		initPets();
		initGroups();
		initPossessions();
		initMoments();
	}

	private void initPeople () {
		_michelle = new Person("Michelle", new Image("Michelle.png"));
		_barack = new Person("Barack", new Image("Barack.png"));
		_kevin = new Person("Kevin", new Image("Kevin.png"));
		_ina = new Person("Ina", new Image("Ina.png"));
		_joe = new Person("Joe", new Image("Joe.png"));
		_malia = new Person("Malia", new Image("Malia.png"));
	}

	private void initPets () {
		_bo = new Pet("Bo", new Image("Bo.png"));
		_sunny = new Pet("Sunny", new Image("Sunny.png"));

		_bo.setOwner(_michelle);
		_sunny.setOwner(_michelle);
	}

	private void initGroups () {
		// Kevin, Barack, and Ina
		final ArrayList michelleFriends = new ArrayList();
		michelleFriends.add(_kevin);
		michelleFriends.add(_barack);
		michelleFriends.add(_ina);

		// Michelle and Barack
		_michelleAndBarack = new ArrayList();
		_michelleAndBarack.add(_michelle);
		_michelleAndBarack.add(_barack);

		// Michelle, Joe, Bo, and Malia
		_michelleJoeBoAndMalia = new ArrayList();
		_michelleJoeBoAndMalia.add(_michelle);
		_michelleJoeBoAndMalia.add(_joe);
		_michelleJoeBoAndMalia.add(_bo);
		_michelleJoeBoAndMalia.add(_malia);

		// Malia and Sunny
		final ArrayList maliaAndSunny = new ArrayList();
		maliaAndSunny.add(_malia);
		maliaAndSunny.add(_sunny);

		// Michelle
		final ArrayList michelleList = new ArrayList();
		michelleList.add(_michelle);

		// Bo
		final ArrayList boList = new ArrayList();
		boList.add(_bo);

		// Set people's friend lists
		_michelle.setFriends(michelleFriends);
		_malia.setFriends(boList);
		_sunny.setFriends(boList);
		_barack.setFriends(michelleList);
		_kevin.setFriends(michelleList);
		_ina.setFriends(michelleList);
	
		// Finish configuring pets
		_bo.setFriends(maliaAndSunny);
		_sunny.setFriends(boList);
		final ArrayList boAndSunny = new ArrayList();
		boAndSunny.add(_bo);
		boAndSunny.add(_sunny);
		_michelle.setPets(boAndSunny);
	}

	private void initPossessions () {
		final Possession boxingBag = new Possession("BoxingBag", new Image("BoxingBag.png"), 20.0f);
		boxingBag.setOwner(_michelle);
		final ArrayList michellePossessions = new ArrayList();
		michellePossessions.add(boxingBag);
		_michelle.setPossessions(michellePossessions);
	}

	private void initMoments () {
		// Smiles
		final ArrayList michelleAndBarackSmiles = new ArrayList();
		michelleAndBarackSmiles.add(0.25f);
		michelleAndBarackSmiles.add(0.75f);

		final ArrayList michelleJoeBoAndMaliaSmiles = new ArrayList();
		michelleJoeBoAndMaliaSmiles.add(0.2f);
		michelleJoeBoAndMaliaSmiles.add(0.3f);
		michelleJoeBoAndMaliaSmiles.add(0.4f);
		michelleJoeBoAndMaliaSmiles.add(0.5f);

		// Moments
		_meAndBarack = new Moment("Me & Barack", new Image("MeAndBarack.png"), _michelleAndBarack, michelleAndBarackSmiles);
		final Moment meJoeAndCo = new Moment("Me, Joe & co.", new Image("MeJoeAndCo.png"), _michelleJoeBoAndMalia, michelleJoeBoAndMaliaSmiles);

		final ArrayList michelleMoments = new ArrayList();
		michelleMoments.add(_meAndBarack);
		michelleMoments.add(meJoeAndCo);
		_michelle.setMoments(michelleMoments);

		final ArrayList barackMoments = new ArrayList();
		barackMoments.add(_meAndBarack);
		_barack.setMoments(barackMoments);

		final ArrayList joeMoments = new ArrayList();
		joeMoments.add(meJoeAndCo);
		_joe.setMoments(joeMoments);

		final ArrayList maliaMoments = new ArrayList();
		maliaMoments.add(meJoeAndCo);
		_malia.setMoments(maliaMoments);

		final ArrayList boMoments = new ArrayList();
		boMoments.add(meJoeAndCo);
		_bo.setMoments(boMoments);
	}
	
	@Test
	public void testAddFr() {
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Pet pet1 = new Pet("pet1", new Image("pet1.png"));
		Pet pet2 = new Pet("pet2", new Image("pet2.png"));
		person1.addFriend(person2);
		pet1.addFriend(person2);
		pet2.addFriend(pet1);
		person1.addFriend(pet2);
	}
	@Test
	public void testEquals () {
		assertEquals(_michelle, new Person("Michelle", new Image("Michelle.png")));
		assertEquals(_michelle, new Person("Michelle", new Image("Michelle2.png")));  // should still work
		assertNotEquals(_michelle, _barack);
		assertEquals(_bo, new Pet("Bo", new Image("Pet.png")));
		assertNotEquals(_bo, new Pet("Boo", new Image("Pet.png")));
	}

	@Test
	public void testR2 () {
		//Combined R2 test cases to reuse this code
		assertEquals(_michelle.getOverallHappiestMoment(), _meAndBarack);
		Person person1 = new Person("person1", new Image("person1.png"));
		Pet pet = new Pet("pet", new Image("pet.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Person person3 = new Person("person3", new Image("person3.png"));
		Person person4 = new Person("person4", new Image("person4.png"));
		
		ArrayList p1 = new ArrayList();
		p1.add(person1);
		
		ArrayList p2 = new ArrayList();
		p2.add(pet);
		
		ArrayList smiles1 = new ArrayList();
		smiles1.add(0.5f);
		smiles1.add(0.3f);
		smiles1.add(0.1f);
		ArrayList list1 = new ArrayList();
		list1.add(person1);
		list1.add(pet);
		list1.add(person4); //not friend
		
		ArrayList smiles2 = new ArrayList();
		smiles2.add(0.3f);
		
		ArrayList smiles3 = new ArrayList();
		smiles3.add(0.6f);
		
		ArrayList persons = new ArrayList();
		persons.add(person1);
		persons.add(person2);
		
		ArrayList personsSmile = new ArrayList();
		personsSmile.add(0.6f);
		personsSmile.add(1f);
		
		Moment first = new Moment ("Moment1", new Image("dog.png"), list1, smiles1);
		Moment second = new Moment("Moment2", new Image("dog2.png"), p1, smiles2);
		Moment third = new Moment("Moment3", new Image("dog3.png"), p2, smiles3);
		Moment fourth = new Moment("Moment3", new Image("dog4.png"), persons, personsSmile);
		
		ArrayList momentP1 = new ArrayList();
		momentP1.add(first);
		momentP1.add(second);
		momentP1.add(fourth);
		
		ArrayList momentPet = new ArrayList();
		momentPet.add(first);
		momentPet.add(third);
		
		person1.setMoments(momentP1);
		pet.setMoments(momentPet);
		
		assertEquals(person1.getOverallHappiestMoment(), fourth);
		assertEquals(pet.getOverallHappiestMoment(), third);
		
		Pet pet2 = new Pet("pet", new Image("pet.png"));
		assertEquals(pet2.getOverallHappiestMoment(), null);
		
		//GetFriendWithWhomIAmHappiest
		assertEquals(_michelle.getFriendWithWhomIAmHappiest(), _barack);
		assertEquals(person1.getFriendWithWhomIAmHappiest(), null); //not friends with p2
		
		person1.addFriend(pet);
		person1.addFriend(person3); //never appears in any moments
		
		assertEquals(person1.getFriendWithWhomIAmHappiest(), pet);
		assertEquals(pet.getFriendWithWhomIAmHappiest(), null);
		
	}

	@Test
	public void testFriendRequest1 () {
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Pet pet1 = new Pet("pet1", new Image("pet1.png"));
		Pet pet2 = new Pet("Pet2", new Image("Pet2.png"));
		
		FriendRequest friendRequest1 = new FriendRequest(person1, person2);
		// Make sure the code also compiles for making friend requests for people and pets
		FriendRequest friendRequest2 = new FriendRequest(person1, pet1);
		FriendRequest friendRequest3 = new FriendRequest(pet1, pet2);
		
		friendRequest1.approve(person1);
		friendRequest2.approve(pet1);
		friendRequest3.approve(pet2);
		//compiling both friendRequest and approving them.
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFriendRequest2 () {
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Person person3 = new Person("person3", new Image("person3.png"));
		FriendRequest friendRequest = new FriendRequest(person1, person2);
		// This should raise an IllegalArgumentException:
		friendRequest.approve(person3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFriendApproval() {
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Pet pet1 = new Pet("pet1", new Image("pet1.png"));
		Pet pet2 = new Pet("Pet2", new Image("Pet2.png"));

		FriendRequest friendRequest1 = new FriendRequest(person1, person2);
		FriendRequest friendRequest2 = new FriendRequest(person1, pet1);
		FriendRequest friendRequest3 = new FriendRequest(pet1, pet2);
		
		friendRequest3.approve(person1);
		//testing IllegalArgumentException with pet 
	}
	@Test
	public void testClique() {
		ArrayList set = new ArrayList();
		set.add(_kevin);
		set.add(_barack);
		set.add(_ina);
		assertEquals(false, Entity.isClique(set));
		//all friends with Michelle but not with each other
		
		assertEquals(true, Entity.isClique(new ArrayList()));
		//blank ArrayList is a clique
		
		ArrayList set1 = new ArrayList();
		set1.add(_bo);
		set1.add(_malia);
		assertEquals(true, Entity.isClique(set1));
		
		ArrayList set2 = new ArrayList();
		set2.add(_bo);
		set2.add(_malia);
		set2.add(_sunny);
		assertEquals(false, Entity.isClique(set2));
	}

	@Test
	public void testMaxCliques() {
		//compiles redundant code into one test function
		Person person1 = new Person("person1", new Image("person1.png"));
		Person person2 = new Person("person2", new Image("person2.png"));
		Person person3 = new Person("person3", new Image("person3.png"));
		Person person4 = new Person("person4", new Image("person4.png"));
		Person person5 = new Person("person5", new Image("person5.png"));
		Person person6 = new Person("person6", new Image("person6.png"));
		Person person7 = new Person("person7", new Image("person7.png"));
		Person person8 = new Person("person8", new Image("person8.png"));
		Person person9 = new Person("person9", new Image("person9.png"));
		person1.addFriend(person2);
		
		FriendRequest req1 = new FriendRequest(person2, person3);
		FriendRequest req2 = new FriendRequest(person4, person3);
		FriendRequest req3 = new FriendRequest(person2, person4);
		
		req1.approve(person2);
		req1.approve(person3);
		req2.approve(person3);
		req2.approve(person4);
		req3.approve(person2);
		req3.approve(person4);
		
		ArrayList set1 = new ArrayList();
		set1.add(person2);
		set1.add(person3);
		set1.add(person4);
		assertEquals(true, Entity.isClique(set1));
		//^^^^ making sure that I set up person2, 3, and 4 correctly
		
		ArrayList test1 = person1.findMaximumCliqueOfFriends();
		assertEquals(set1, test1);
		//^^^^ testing MaximumCliqueOfFriends where only one clique exists, and is adding all friends to one list
		
		FriendRequest req4 = new FriendRequest (person4, person5);
		req4.approve(person4);
		req4.approve(person5);
		ArrayList test2 = person1.findMaximumCliqueOfFriends();
		assertEquals(set1, test2);
		//^^^^ testing MaximumCliqueOfFriends where there is one clique that works, one that doesn't
		FriendRequest req5 = new FriendRequest (person7, person6);
		FriendRequest req6 = new FriendRequest (person8, person9);
		FriendRequest req7 = new FriendRequest (person7, person9);
		FriendRequest req8 = new FriendRequest (person8, person6);
		FriendRequest req9 = new FriendRequest (person7, person8);
		FriendRequest req10 = new FriendRequest (person9, person6);
		
		req5.approve(person6);
		req5.approve(person7);
		req6.approve(person8);
		req6.approve(person9);
		req7.approve(person7);
		req7.approve(person9);
		req8.approve(person8);
		req8.approve(person6);
		req9.approve(person7);
		req9.approve(person8);
		req10.approve(person6);
		req10.approve(person9);
		
		person1.addFriend(person6);
		
		ArrayList test3 = person1.findMaximumCliqueOfFriends();
		ArrayList set2 = new ArrayList();
		set2.add(person6);
		set2.add(person7);
		set2.add(person8);
		set2.add(person9);
		assertEquals(set2, test3);
		//^^^^ testing MaximumCliqueOfFriends where there are two cliques and one is bigger than the other.
	}
	
	@Test
	public void TestMaxClique2() {
		//testing with the example in Project1
		Person melania = new Person("Melania", new Image("mel.png"));
		Person marlon = new Person("Marlon", new Image("mar.png"));
		Person ivana = new Person("Ivana", new Image("iv.png"));
		Person kevin = new Person("Kevin", new Image("kev.png"));
		Person hillary = new Person("Hillary", new Image("hil.png"));
		Person charlotte = new Person("Charlotte", new Image("char.png"));
		Person humphrey = new Person("Humphrey", new Image("hum.png"));
		Person tom = new Person("Tom",new Image("tom.png"));
		Person robin = new Person("Robin", new Image("rob.png"));
		
		//initialize friends
		melania.addFriend(ivana);
		melania.addFriend(kevin);
		melania.addFriend(hillary);
		melania.addFriend(marlon);
		
		marlon.addFriend(melania);
		marlon.addFriend(charlotte);
		marlon.addFriend(humphrey);
		marlon.addFriend(kevin);
		
		ivana.addFriend(melania);
		ivana.addFriend(tom);
		ivana.addFriend(hillary);
		ivana.addFriend(kevin);
		
		kevin.addFriend(melania);
		kevin.addFriend(marlon);
		kevin.addFriend(robin);
		kevin.addFriend(humphrey);
		kevin.addFriend(hillary);
		kevin.addFriend(ivana);
		
		hillary.addFriend(melania);
		hillary.addFriend(ivana);
		hillary.addFriend(kevin);
		hillary.addFriend(robin);
		
		//making expected answer
		ArrayList expected = new ArrayList();
		expected.add(ivana);
		expected.add(kevin);
		expected.add(hillary);
		assertEquals(expected, melania.findMaximumCliqueOfFriends());
		
		ArrayList expected2 = new ArrayList();
		expected2.add(melania);
		expected2.add(hillary);
		expected2.add(ivana);
		
		assertEquals(expected2, kevin.findMaximumCliqueOfFriends());
	}

	
	// COMPLETE: write more methods to test addFriend
	// COMPLETE: write more methods to test approve
	
	// COMPLETE: write more methods to test getFriendWithWhomIAmHappiest 
	// COMPLETE: write more methods to test getOverallHappiestMoment 
	
	// COMPLETE: write methods to test isClique 
	// COMPLETE: write methods to test findMaximumCliqueOfFriends
}
