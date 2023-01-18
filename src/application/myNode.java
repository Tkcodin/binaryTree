package application;

import java.util.ArrayList;
import java.util.Comparator;

public class myNode <T>{
	
	int balance;
	Person person;
	T data;
	myNode<T> lNode;
	myNode<T> rNode;
	myNode<T> parent;
	
	int depth;
	int Height;
	
	static ArrayList<Integer> rightIDs = new ArrayList<Integer>();;
	
	static boolean foundRight = false;
	
	public void deleteNode() {
		
			if(lNode==null && rNode==null) {
				myNode<T> n = this.getParent();
				if(n.getlNode()==this) {
					n.setlNode(null);
					this.setParent(null);
					this.setlNode(null);
					this.setrNode(null);
				}
				if(n.getrNode()==this) {
					n.setrNode(null);
					this.setParent(null);
					this.setlNode(null);
					this.setrNode(null);
				}
			}
			else if(lNode==null) {
				myNode<T> n = this.getParent();
				myNode<T> r = this.getrNode();
				if(n.getlNode()==this) {
					n.setlNode(r);
					r.setParent(n);
					this.setParent(null);
					this.setlNode(null);
					this.setrNode(null);
				}
				if(n.getrNode()==this) {
					n.setrNode(r);
					r.setParent(n);
					this.setParent(null);
					this.setlNode(null);
					this.setrNode(null);
				}
			}
			else if(rNode==null) {
				myNode<T> n = this.getParent();
				myNode<T> l = this.getlNode();
				if(n.getlNode()==this) {
					n.setlNode(l);
					l.setParent(n);
					this.setParent(null);
					this.setlNode(null);
					this.setrNode(null);
				}
				if(n.getrNode()==this) {
					n.setrNode(l);
					l.setParent(n);
					this.setParent(null);
					this.setlNode(null);
					this.setrNode(null);
				}
			}
			else {
				myNode<T> n = this.getParent();
				myNode<T> nextHighest = findNext1(this);
				if(nextHighest.getrNode()==null) {
					if(n.getlNode()==this) {
						
						n.setlNode(nextHighest);
						System.out.println("Setting " + n.getPerson().getFirstName() + " left node to " + nextHighest.getPerson().getFirstName());
						
						
						myNode<T> circularProblems = nextHighest.getParent().getlNode();
						
						nextHighest.getParent().setlNode(null);
						nextHighest.setParent(n);
						System.out.println("Setting " + nextHighest.getPerson().getFirstName() + " parent node to " + n.getPerson().getFirstName());
						this.rightIDs = new ArrayList<Integer>();
						nextHighest.CheckRightIDs();
						System.out.println(this.getrNode().getPerson().getId());
						System.out.println(this.rightIDs);
						if(nextHighest.getPerson().getId()!=this.getrNode().getPerson().getId()&& !this.rightIDs.contains(this.getrNode().getPerson().getId())) {
							nextHighest.setrNode(this.getrNode());
							System.out.println("Setting " + nextHighest.getPerson().getFirstName() + "  11 right node to " + this.getrNode().getPerson().getFirstName());
						}
						else {
							nextHighest.setrNode(null);
						}
						
						if(this.lNode!=null) {
							System.out.println("setting " + nextHighest.getPerson().getFirstName() + " left node to "+ this.getlNode().getPerson().getFirstName());
							nextHighest.setlNode(this.getlNode());
						}
						else {
							System.out.println("setting " + nextHighest.getPerson().getFirstName() + " left node to "+ circularProblems.getPerson().getFirstName());
							nextHighest.setlNode(circularProblems);
						}
						this.setParent(null);
						this.setlNode(null);
						this.setrNode(null);
					}
					if(n.getrNode()==this) {
						n.setrNode(nextHighest);
						System.out.println("Setting " + n.getPerson().getFirstName() + " right node to " + nextHighest.getPerson().getFirstName());
						myNode<T> circularProblems = nextHighest.getParent().getlNode();
						
						nextHighest.getParent().setlNode(null);
						nextHighest.setParent(n);
						System.out.println("Setting " + nextHighest.getPerson().getFirstName() + " parent node to " + n.getPerson().getFirstName());
						this.rightIDs = new ArrayList<Integer>();
						nextHighest.CheckRightIDs();
						System.out.println(this.getrNode().getPerson().getId());
						System.out.println(this.rightIDs);
						if(nextHighest.getPerson().getId()!=this.getrNode().getPerson().getId()&& !this.rightIDs.contains(this.getrNode().getPerson().getId())) {
							nextHighest.setrNode(this.getrNode());
							System.out.println("Setting " + nextHighest.getPerson().getFirstName() + "  12 right node to " + this.getrNode().getPerson().getFirstName());
						}
						else {
								nextHighest.setrNode(null);
						}
						if(this.lNode!=null) {
							System.out.println("setting " + nextHighest.getPerson().getFirstName() + " left node to "+ this.getlNode().getPerson().getFirstName());
							nextHighest.setlNode(this.getlNode());
						}
						else {
							System.out.println("setting " + nextHighest.getPerson().getFirstName() + " left node to "+ circularProblems.getPerson().getFirstName());
							nextHighest.setlNode(circularProblems);
						}
						this.setParent(null);
						this.setlNode(null);
						this.setrNode(null);
					}
				}
				else {
					myNode<T> bottomR = getBottomR(nextHighest);
					if(n.getlNode()==this) {
						n.setlNode(nextHighest);
						System.out.println("Setting " + n.getPerson().getFirstName() + " leftt node to " + nextHighest.getPerson().getFirstName());
						nextHighest.setParent(n);
						System.out.println("Setting " + nextHighest.getPerson().getFirstName() + " parent node to " + n.getPerson().getFirstName());
						this.rightIDs = new ArrayList<Integer>();
						nextHighest.CheckRightIDs();
						System.out.println(this.getrNode().getPerson().getId());
						System.out.println(this.rightIDs);
						if(bottomR.getPerson().getId()!=this.getrNode().getPerson().getId() && !this.rightIDs.contains(this.getrNode().getPerson().getId())) {
							bottomR.setrNode(this.getrNode());
							System.out.println("Setting " + bottomR.getPerson().getFirstName() + " 13 right node to " + this.getrNode().getPerson().getFirstName());
						}
						else {
							bottomR.setrNode(null);
						}
						System.out.println("setting " + nextHighest.getPerson().getFirstName() + " left node to "+ this.getlNode().getPerson().getFirstName());
						nextHighest.setlNode(this.getlNode());
						this.setParent(null);
						this.setlNode(null);
						this.setrNode(null);
					}
					if(n.getrNode()==this) {
						n.setrNode(nextHighest);
						System.out.println("Setting " + n.getPerson().getFirstName() + " leftt node to " + nextHighest.getPerson().getFirstName());
						nextHighest.setParent(n);
						System.out.println("Setting " + nextHighest.getPerson().getFirstName() + " parent node to " + n.getPerson().getFirstName());
						this.rightIDs = new ArrayList<Integer>();
						nextHighest.CheckRightIDs();
						
						if(bottomR.getPerson().getId()!=this.getrNode().getPerson().getId() && !this.rightIDs.contains(this.getrNode().getPerson().getId())) {
							bottomR.setrNode(this.getrNode());
							System.out.println("Setting " + bottomR.getPerson().getFirstName() + " 14 right node to " + this.getrNode().getPerson().getFirstName());
						}
						else {
							bottomR.setrNode(null);
						}
						System.out.println("setting " + nextHighest.getPerson().getFirstName() + " left node to "+ this.getlNode().getPerson().getFirstName());
						nextHighest.setlNode(this.getlNode());
						this.setParent(null);
						this.setlNode(null);
						this.setrNode(null);
					}
					
				}
				
			
			
			
			
			
		}
	}
	
	public void CheckRightIDs(){
		this.rightIDs.add(this.getPerson().getId());
		if(this.getrNode()!= null) {
			this.getrNode().CheckRightIDs();
		}
//		if
//		if(this.getParent()!=null) {
//			this.getParent().CheckRightIDs();
//		}
//		
		
	}
	
	
	public myNode<T> getBottomR(myNode<T> x){
		if(x.getrNode()==null) {
			return x;
		}
		else {
			return getBottomR(x.getrNode());
		}
	}
	
	
	public myNode<T> findNext1(myNode<T> x){
		myNode<T> y = x.getrNode();
		myNode<T> z = findNext2(y);
		return z;
	}
	
	public myNode<T> findNext2(myNode<T> x){
		if(x.getlNode()==null) {
			return x;
		}
		else {
			return x.getlNode();
		}
	}
	
	
//	public int getLeftHeight() {
//		return leftHeight;
//	}
//
//	public void setLeftHeight(int leftHeight) {
//		this.leftHeight = leftHeight;
//	}

	public void update() {
		checkBalance();
		findHeight();
		findDepth();
	}
	
	public void checkBalance() {
		int lH; 
		if(lNode!=null) {
			lH = lNode.getHeight();
		}
		else {
			lH = 0;
		}
		
		int rH; 
		
		if(rNode!=null) {
		 rH = rNode.getHeight();
		}
		else {
			rH = 0;
		}
		
		balance = rH-lH;
		} 
		
	
	
	public int getBalance() {
		return balance;
	}
	
	public void doBalance(myTree<T> t) {
		if(balance<=-2) {
			if(lNode.getBalance()<=0) {
				this.rightRotate(t);
				//System.out.println("r");
			}
			else {
				lNode.leftRotate(t);
				this.rightRotate(t);
				//System.out.println("lr");
			}
		}
		else if(balance>=2) {
			if(rNode.getBalance()>=0) {
				this.leftRotate(t);
				//System.out.println("l");
			}
			else {
				rNode.rightRotate(t);
				this.leftRotate(t);
				//System.out.println("rl");
			}
			
			
			
		}
	}
//		System.out.println("TRYING TO BALANCE!");	
//			if(lNode==null && rNode==null) {
//				return;
//			}
//			else if(lNode==null) {
//				if(rNode.getlNode()!=null) {
//					rNode.rightRotate(t);
//					this.leftRotate(t);
//					System.out.println("rl");
//				}
//				else {
//					this.leftRotate(t);
//					System.out.println("l");
//				}
//			}
//			else if(rNode==null) {
//				if(lNode.getrNode()!=null) {
//					lNode.leftRotate(t);
//					this.rightRotate(t);
//					System.out.println("lr");
//				}
//				else {
//					this.rightRotate(t);
//					System.out.println("r");
//				}
//			}
//			else if(lNode.getHeight()>rNode.getHeight() ) {
//				if(lNode.getrNode()!=null) {
//					lNode.leftRotate(t);
//					this.rightRotate(t);
//					System.out.println("lr");
//				}
//				else {
//					this.rightRotate(t);
//					System.out.println("r");
//				}
//			}
//			else{
//				if(rNode.getlNode()!=null) {
//					rNode.rightRotate(t);
//					this.leftRotate(t);
//					System.out.println("rl");
//				}
//				else {
//					this.leftRotate(t);
//					System.out.println("l");
//				}
//			}
//		}
	//}
	
	public void rightRotate(myTree<T> t) {
		myNode<T> n = this.lNode;
		this.lNode=n.getrNode();
		if(n.getrNode()!=null) {
			n.getrNode().setParent(this);
		}
		n.setrNode(this);
		n.setParent(this.parent);
		
		if(this.parent!=null) {
			if(this.parent.getrNode()==this) {
				this.parent.setrNode(n);
			}
			else {
				this.parent.setlNode(n);
			}
		}
		else {
			t.setRoot(n);
		}
		this.parent = n;
		n.update();
		this.update();
		
	}
	
	public void leftRotate(myTree<T> t) {
		myNode<T> n = this.rNode;
		this.rNode=n.getlNode();
		if(n.getlNode()!=null) {
			n.getlNode().setParent(this);
		}
		n.setlNode(this);
		n.setParent(this.parent);
		
		if(this.parent!=null) {
			if(this.parent.getrNode()==this) {
				this.parent.setrNode(n);
			}
			else {
				this.parent.setlNode(n);
			}
		}
		else {
			t.setRoot(n);
		}
		this.parent = n;
		n.update();
		this.update();
	}
	
	
	

	public void setHeight(int Height) {
		this.Height = Height;
	}

	public myNode(Person per, T t, myNode<T> par) {
		this.person = per;
		this.data = t;
		this.parent = par;
		this.checkBalance();
		this.findHeight();
		//this.comp = c;
	}
	
	public myNode(Person per, T t) {
		this.person = per;
		this.data = t;
		this.parent = null;
		//this.comp = c;
	}
	
//	public int findLeftHeight() {
//		if(lNode == null) {
//			return 0;
//		}
//		int l = lNode.findLeftHeight();
//		int r = 0;
//		if(rNode!=null) {
//			r = rNode.findRightHeight();
//		}
//		if(r>l) {
//			return r;
//		}
//		return l;
//	}
	
	public void findHeight() {
		if(rNode == null && lNode== null) {
			Height= 0;
		}
		else if(lNode==null && rNode!=null) {
			rNode.findHeight();
			Height = 1 + rNode.getHeight();
		}
		else if(lNode!=null && rNode==null) {
			lNode.findHeight();
			Height = 1 + lNode.getHeight();
		}
		else {
			if(lNode.getHeight()>rNode.getHeight()) {
				Height = 1 + lNode.getHeight();
			}
			else {
				Height = 1 + rNode.getHeight();
			}
		}
		
	}
	public int getHeight() {
		this.findHeight();
		return Height;
	}

	public void findDepth() {
		if(parent==null) {
			this.setDepth(0);
		}
		else {
			this.setDepth(1 + parent.getDepth());
		}
	}
	
//	public void updateHeights() {
//		leftHeight = this.findLeftHeight();
//		rightHeight = this.findRightHeight();
//	}
	
	public int getDepth() {
		this.findDepth();
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public myNode<T> getlNode() {
		return lNode;
	}

	public void setlNode(myNode<T> lNode) {
		this.lNode = lNode;
	}

	public myNode<T> getrNode() {
		return rNode;
	}

	public void setrNode(myNode<T> rNode) {
		this.rNode = rNode;
	}

	public myNode<T> getParent() {
		return parent;
	}

	public void setParent(myNode<T> parent) {
		this.parent = parent;
	}

}
