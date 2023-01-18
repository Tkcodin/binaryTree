package application;

public class Person {
	
	
	
	
//	private boolean balanced;
//	private int lHeight;
//	private int rHeight;
	
	
//	private Person rChild;
//	private Person lChild;
	
	static int idCount = 1;
	private int id;
	
	private int age;
	private String firstName;
	private String lastName;
	
	public Person(String fn, String ln, int a) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = a;
		this.id = idCount;
		idCount++;
	}
	
	public Person(String fn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = 0;
//		this.id = idCount;
//		idCount++;
	}
	
	public Person(int x) {
		this.firstName=null;
		this.lastName=null;
		this.age=x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//get that set that
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//	public boolean isBalanced() {
//		return balanced;
//	}
//
//
//
//
//	public void setBalanced(boolean balanced) {
//		this.balanced = balanced;
//	}
//
//
//
//
//	public int getlHeight() {
//		return lHeight;
//	}
//
//
//
//
//	public void setlHeight(int lHeight) {
//		this.lHeight = lHeight;
//	}
//
//
//
//
//	public int getrHeight() {
//		return rHeight;
//	}
//
//
//
//
//	public void setrHeight(int rHeight) {
//		this.rHeight = rHeight;
//	}
//
//
//

//	public Person getrChild() {
//		return rChild;
//	}
//
//
//
//
//	public void setrChild(Person rChild) {
//		this.rChild = rChild;
//	}
//
//
//
//
//	public Person getlChild() {
//		return lChild;
//	}
//
//
//
//
//	public void setlChild(Person lChild) {
//		this.lChild = lChild;
//	}
}
