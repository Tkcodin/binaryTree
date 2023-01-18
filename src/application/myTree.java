package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class myTree<T> {
	
	myNode<T> idMatch = null;
	
	Boolean balanced;
	public myNode<T> getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(myNode<T> idMatch) {
		this.idMatch = idMatch;
	}

	myNode<T> root;
	Comparator<Person> comp;
	private ArrayList<Person> mySearch;
	
	public myTree(myNode<T> r, Comparator<Person> c) {
		this.root = r;
		this.comp = c;
		mySearch=new ArrayList<Person>();
	}
	
	public myTree(Comparator<Person> c) {
		this.root = null;
		this.comp = c;
	}
	
	public void findIDMatch(myNode<T> n, int x) {
		if(n!=null) {
			findIDMatch(n.getlNode(), x);
			if(n.getPerson().getId()==x) {
				idMatch = n;
				return;
			}
			findIDMatch(n.getrNode(), x);
		}
	}
	
	public void addNode(myNode<T> placing, myNode<T> last) {
		if (last==null) {
			this.root = placing;
			//placing.update();
			fixBalance(placing);
			//placing.update();
			
		}
		else if(this.comp.compare(placing.getPerson(), last.getPerson())<=0){
			//put to the left
			
			if(last.getlNode()!=null) {
				addNode(placing, last.getlNode());
				
			}
			else {
				last.setlNode(placing);
				placing.setParent(last);
				//REMOVE IF BREAK
				//placing.update();
				fixBalance(placing);
				//placing.update();
			}
		}
		else if(this.comp.compare(placing.getPerson(), last.getPerson())>0) {
			//put to the right
			
			if(last.getrNode()!=null) {
				addNode(placing, last.getrNode());
				
			}
			else {
				last.setrNode(placing);
				placing.setParent(last);
				//REMOVE IF BREAK
				//placing.update();
				fixBalance(placing);
				//placing.update();
			}
		}
		
	}
	
	public void fixBalance(myNode<T> n) {
		n.update();
		n.doBalance(this);
		if(n.getParent()!=null) {
			fixBalance(n.getParent());
		}
	}
	
	public myNode<T> getRoot() {
		return root;
	}

	public void setRoot(myNode<T> root) {
		this.root = root;
	}

	
	//depth first pre order
	
	public void printAll(myNode<T> n, String label) {
		if(n!=null) {
		//String s = "";
//		if(n.getBalance()==false) {
//			s+= "UNBALANCED";
//		}
		
		//n.update();
		Main.resultsList1.add(label + n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " Age: " + n.getPerson().getAge()  + " ID: " + n.getPerson().getId());
		printAll(n.getlNode(), "   "+label);
		printAll(n.getrNode(), "   "+label);
		}
	}
	
	
	//post order would be print at end
	public void printAll4(myNode<T> n, String label) {
		if(n!=null) {
		
		
		printAll4(n.getlNode(), "   "+label);
		printAll4(n.getrNode(), "   "+label);
		Main.resultsList1.add(label + n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " Age: " + n.getPerson().getAge() + " ID: " + n.getPerson().getId());
		}
	}
	
	//depth first in order
	public void printAll2(myNode<T> n) {
		if(n!=null) {
		printAll2(n.getlNode());
		Main.resultsList1.add(n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " Age: " + n.getPerson().getAge() + " ID: " + n.getPerson().getId());
		printAll2(n.getrNode());
		}
	}
	
	public void printBigFirst(myNode<T> n) {
		if(n!=null) {
		printBigFirst(n.getlNode());
		int f = n.getPerson().getFirstName().length();
		int l = n.getPerson().getLastName().length();
		if(f>l) {
			Main.resultsList1.add(n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " Age: " + n.getPerson().getAge()+ " ID: " + n.getPerson().getId());
		}
		printBigFirst(n.getrNode());
		}
	}
	
	public void printBigLast(myNode<T> n) {
		if(n!=null) {
		printBigLast(n.getlNode());
		int f = n.getPerson().getFirstName().length();
		int l = n.getPerson().getLastName().length();
		if(l>f) {
			Main.resultsList1.add(n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " Age: " + n.getPerson().getAge()+ " ID: " + n.getPerson().getId());
		}
		printBigLast(n.getrNode());
		}
	}
	
	//breadth first
	@SuppressWarnings("rawtypes")
	public void printAll3(myNode<T> n) {
		updateTree();
		//ArrayList<Person> thisLine = new ArrayList<Person>();
		int currentD = n.getDepth();
		if(n!=null) {
			Queue<myNode> q = new LinkedList<myNode>();
			q.add(n);
			while(q.size()>0) {
				myNode n2 = q.poll();
				//String s =(n2.getPerson().getFirstName() + " " + n2.getPerson().getLastName() + " " + n2.getPerson().getAge());
				
				if(n2.getDepth()==currentD) {
					n2.update();
					Main.resultsList1.add(n2.getPerson().getFirstName() + " " + n2.getPerson().getLastName() +  " age: " + n2.getPerson().getAge() + ",  ");
				}
				else {
					n2.update();
					currentD = n2.getDepth();
					Main.resultsList1.add("");
					Main.resultsList1.add(n2.getPerson().getFirstName() + " " + n2.getPerson().getLastName() +  " age: " + n2.getPerson().getAge() +  ",  ");
//					System.out.print("Height -"+currentH+"--> ");
//					for(Person p : thisLine) {
//						System.out.print(p.getFirstName() + " " + p.getLastName() +  ",  ");
//					}
//					System.out.println();
//					thisLine = new ArrayList<Person>();
//					currentH = n2.getHeight();
//					thisLine.add(n2.getPerson());
				}
				
				if(n2.getlNode()!=null) {
					q.add(n2.getlNode());
				}
				if(n2.getrNode()!=null) {
					q.add(n2.getrNode());
				}
			
			}
		}
	}
	
	public void searchFN(myNode<T> n, String fn) {
		
		
		if(n!=null && fn!=null) {
			//System.out.println("im in fn search");
			Person p = new Person(fn, fn);
			myFirstNameComparator comp = new myFirstNameComparator();
			if(comp.compare(n.getPerson(), p)==0) {
				mySearch.add(n.getPerson());
				if(n.getlNode()!=null) {
					searchFN(n.getlNode(), fn);
				}
			}
			
			if(comp.compare(n.getPerson(), p)>0 && n.getlNode()!=null) {
				searchFN(n.getlNode(), fn);
			}
			if(comp.compare(n.getPerson(), p)<0 && n.getrNode()!=null) {
				searchFN(n.getrNode(), fn);
			}
		}
	}
	
	//have user select which by using name
//	public void changeName(myNode<T> n, String ln) {
//		
//	}
	
	public void searchLN(myNode<T> n, String ln) {
		if(n!=null&& ln!=null) {
			Person p = new Person(ln, ln);
			myLastName comp = new myLastName();
			if(comp.compare(n.getPerson(), p)==0 ) {
				mySearch.add(n.getPerson());
				if(n.getlNode()!=null) {
					searchLN(n.getlNode(), ln);
				}
			}
			if(comp.compare(n.getPerson(), p)>0&& n.getlNode()!=null) {
				searchLN(n.getlNode(), ln);
			}
			if(comp.compare(n.getPerson(), p)<0&& n.getrNode()!=null) {
				searchLN(n.getrNode(), ln);
			}
		}
	}
	
	public void searchA(myNode<T> n, int age) {
		if(n!=null) {
			Person p = new Person(age);
			myAgeComparator comp = new myAgeComparator();
			if(comp.compare(n.getPerson(), p)==0 ) {
				mySearch.add(n.getPerson());
				if(n.getlNode()!=null) {
					searchA(n.getlNode(), age);
				}
			}
			if(comp.compare(n.getPerson(), p)>0&& n.getlNode()!=null) {
				searchA(n.getlNode(), age);
			}
			if(comp.compare(n.getPerson(), p)<0&& n.getrNode()!=null) {
				searchA(n.getrNode(), age);
			}
		}
		
		
		
//		if(n!=null) {
//			if(n.getPerson().getAge()>age && n.getlNode()!=null) {
//				searchA(n.getlNode(), age);
//			}
//		//System.out.println(n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " " + n.getPerson().getAge());
//			else if(n.getPerson().getAge()==age) {
//				mySearch.add(n.getPerson());
//				searchA(n.getlNode(), age);
//			}
//			else if (n.getPerson().getAge()<age && n.getrNode()!=null){
//				searchA(n.getrNode(), age);
//			}
//		}
	}
	
	public void updateNodeHeights(myNode<T> n) {
		if(n!=null) {
		n.findHeight();
		}
	}
	
	public void updateNodeDepths(myNode <T> n) {
		//System.out.println("updating depths");
		if(n!=null) {
			if(n.getlNode()!=null) {
				//System.out.println("updating left depths");
				updateNodeDepths(n.getlNode());
			}
			n.findDepth();
			if(n.getrNode()!=null) {
				//System.out.println("updating right depths");
				updateNodeDepths(n.getrNode());
			}
		}
	}
	
	public void updateTree() {
		updateNodeHeights(root);
		updateNodeDepths(root);
	}

	public ArrayList<Person> getMySearch() {
		return mySearch;
	}

	public void setMySearch(ArrayList<Person> mySearch) {
		this.mySearch = mySearch;
	}
	
	public void refreshSearch() {
		this.mySearch = new ArrayList<Person>();
	}
	
//	public void append(T t) {
//		Wagon<T> w = new Wagon<T>(t);
//		if(this.head==null) {
//			this.head = w;
//		}
//		else {
//			Wagon<T> current = head;
//			while(current.getNext()!=null) {
//				current = current.getNext();
//			}
//			current.setNext(w);
//		}
//	}
	
	public void printFNRange(myNode<T> n, int h, int l) {
		if(n!=null) {
		printFNRange(n.getlNode(), h,l);
		if(h>=n.getPerson().getFirstName().length() && n.getPerson().getFirstName().length()>=l) {
			Main.resultsList1.add(n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " ID: " + n.getPerson().getId());
		}
		printFNRange(n.getrNode(), h,l);
		}
	}
	
	public void printLNRange(myNode<T> n, int h, int l) {
		if(n!=null) {
		printLNRange(n.getlNode(), h,l);
		if(h>=n.getPerson().getLastName().length() && n.getPerson().getLastName().length()>=l) {
			Main.resultsList1.add(n.getPerson().getFirstName() + " " + n.getPerson().getLastName() + " ID: " + n.getPerson().getId());
		}
		printLNRange(n.getrNode(), h,l);
		}
	}
	
}
