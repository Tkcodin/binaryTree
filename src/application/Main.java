package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	ArrayList<Person> search = new ArrayList<Person>();
	
	myTree<String> fnt;
	myTree<String> lnt;
	myTree<Integer> at;
	
	int upperBound;
	int lowerBound;
	
	int nodeToReplace;
	
	int rAge = -1;
	String rFirstName = "";
	String rLastName = "";
	
//	Person pete = new Person("Pete", "Taylor", 44);
//	myNode<String> peteFN = new myNode<String>(pete, pete.getFirstName());
//	myNode<String> peteLN = new myNode<String>(pete, pete.getLastName());
//	myNode<Integer> peteA = new myNode<Integer>(pete, pete.getAge());
	
	
	private int personCount;
	private int searchInt;
	private String searchName;
	
	static ObservableList<String> resultsList1;
	public void start(Stage primaryStage) {
		
		//makeData(16);
		
		try {
			
			Label suggestion = new Label("JAVAFX AS NEW & EFFECTIVE TORTURE FOR GUANTANAMO?");
			
			HBox root = new HBox();
			
			VBox interactions = new VBox();
			
			resultsList1 = FXCollections.observableArrayList();
			ListView<String> resultsView1 = new ListView<String>();
			resultsView1.setItems(resultsList1);
			
			root.getChildren().add(interactions);
			root.getChildren().add(resultsView1);
			root.setHgrow(resultsView1, Priority.ALWAYS);
			
			TextField searchTarget = new TextField();
			Label search = new Label("Search Target: ");
			HBox searchbox1 = new HBox();
			searchbox1.getChildren().addAll(search, searchTarget);
			
			HBox searchbox2 = new HBox();
			Button fnSearch = new Button("Search First Name");
			Button lnSearch = new Button("Search last Name");
			Button ageSearch = new Button("Search age");
			
			
			
			VBox searchBox3 = new VBox();
			VBox intSearchBox = new VBox();
			HBox int1 = new HBox();
			HBox int2 = new HBox();
			TextField hiInt = new TextField();
			TextField lowInt = new TextField();
			Label ints = new Label("Choose low bound and high bound: ");
			int1.getChildren().addAll(ints, lowInt, hiInt);
			
			Button fnames = new Button("find First names w/i bounds");
			Button lnames = new Button("find last names w/i bounds");
			int2.getChildren().addAll(fnames, lnames);
			
			intSearchBox.getChildren().addAll(int1, int2);
			
			HBox fnlnSearchBox = new HBox();
			Button bigFNames = new Button("find F.names > L.names");
			Button bigLNames = new Button("find L.names > F.names");
			
			fnlnSearchBox.getChildren().addAll(bigFNames, bigLNames);
			Label space3 = new Label(" ");
			
			searchBox3.getChildren().addAll(intSearchBox, space3, fnlnSearchBox);
			
			searchbox2.getChildren().addAll(fnSearch, lnSearch, ageSearch);
			
			Label searchL = new Label("SEARCHING: ");
			
			VBox searchVbox = new VBox();
			
			Label space4 = new Label(" ");
			searchVbox.getChildren().addAll(searchL, searchbox1,  searchbox2, space4, searchBox3);
			
			
			VBox databox = new VBox();
			TextField dataAmount = new TextField();
			Label dataAmL = new Label("Amount of people: ");
			HBox databox1 = new HBox();
			Button generateData = new Button("Generate New Data of selected amount");
			Button loadData = new Button("Load existant data");
			databox1.getChildren().addAll(loadData);
			HBox databox2 = new HBox();
			Label dataL = new Label("CREATING TREES: ");
			
			
			databox2.getChildren().addAll(dataAmL, dataAmount, generateData);
			databox.getChildren().addAll(dataL, databox1, databox2);
				
			VBox printBox = new VBox();
			Label printInst = new Label("Select print Type:");
			Label treeInst = new Label("Select Binary Tree to print:");
			String st[] = {"Depth_PreOrder", "Depth_PostOrder", "Depth_InOrder", "Breadth"};
			String st2[]= {"First Name", "Second Name", "Age"};
			ChoiceBox cbPrint = new ChoiceBox(FXCollections.observableArrayList(st));
			
			ChoiceBox cbTree = new ChoiceBox(FXCollections.observableArrayList(st2));
			
			Button print = new Button("Print");
			
			//Button spitHeights = new Button("Heights");
			Label printL = new Label("PRINTING: ");
			printBox.getChildren().addAll(printL, printInst, cbPrint,  treeInst, cbTree, print);
			
			Label space = new Label(" ");
			Label space2 = new Label(" ");
			
			Label space5 = new Label(" ");
			Label space6 = new Label(" ");
			
			VBox replaceMain = new VBox();
			Label replacingL = new Label("CHANGING NODES: ");
			
			HBox replaceBox1 = new HBox();
			
			Label replaceNode = new Label("Enter ID of node to replace: ");
			TextField replaceTarget = new TextField();
			
			VBox replaceBox2 = new VBox();
			
			Label newNode = new Label("Enter the new First Name and/or Last Name and/or Age to change below");
			Label newNode2 = new Label("Unedited fields will remain what they were.");
			
			HBox fuckJavafx = new HBox();
			HBox makesmewanttoKMS = new HBox();
			HBox itjusttakesforfuckingevertodoanything = new HBox();
			
			TextField newFN = new TextField();
			Label l1 = new Label("new First Name: ");
			
			fuckJavafx.getChildren().addAll(l1, newFN);
			
			TextField newLN = new TextField();
			Label l2 = new Label("new Last Name: ");
			
			makesmewanttoKMS.getChildren().addAll(l2, newLN);
			
			TextField newAge = new TextField();
			Label l3 = new Label("new Age: ");
			
			itjusttakesforfuckingevertodoanything.getChildren().addAll(l3, newAge);
			
			Button replaceIt = new Button("Replace");
			
			replaceBox2.getChildren().addAll(newNode, newNode2, fuckJavafx, makesmewanttoKMS, itjusttakesforfuckingevertodoanything, replaceIt);
			
			replaceBox1.getChildren().addAll(replaceNode, replaceTarget);
			
			
			
			replaceMain.getChildren().addAll(replacingL, replaceBox1, replaceBox2);
			
			Label space7 = new Label(" ");
			Label space8 = new Label(" ");
			
			Label space9 = new Label(" ");
			Label space10 = new Label(" ");
			
			interactions.getChildren().addAll(suggestion, space9,  databox, space, space2, searchVbox, space5, space6,  printBox, space7, space8, replaceMain);
			
			//resultsList1.add("fuckknuckle");
			interactions.setStyle("-fx-background-color: #E6E6FA");
			
			
			Scene scene = new Scene(root,800,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
//			cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//				public void changed(ObservableValue ov, Number value, Number new_value) {
//					if(new_value.equals("Print 1"){
//						print.setOnAction(new EventHandler<ActionEvent>() {
//							public void handle(ActionEvent arg0) {
//								fnt.printAll(fnt.getRoot(), "");
//							}
//						});
//					}
//				}
//			});
			
			bigFNames.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					resultsList1.add("");
					resultsList1.add("============================================");
					resultsList1.add("");
					resultsList1.add("Searching first names longer than last names -->");
					fnt.printBigFirst(fnt.getRoot());
				}
			});
			
			bigLNames.setOnAction(new EventHandler<ActionEvent>() {
				
				public void handle(ActionEvent arg0) {
					resultsList1.add("");
					resultsList1.add("============================================");
					resultsList1.add("");
					resultsList1.add("Searching last names longer than first names -->");
					lnt.printBigLast(fnt.getRoot());
				}
			});
			
			print.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					printSetUp((String) cbTree.getValue(), (String) cbPrint.getValue());
				}
			});
			
			loadData.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					loadOldData();
				}
			});
			
			dataAmount.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					personCount = Integer.parseInt(dataAmount.getText());
					//System.out.println(personCount);
				}
			});
			
			
			newAge.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					rAge = Integer.parseInt(newAge.getText());
					//System.out.println(personCount);
				}
			});
			
			newLN.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					rLastName = newLN.getText();
					//System.out.println(personCount);
				}
			});
			
			newFN.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					rFirstName = newFN.getText();
					//System.out.println(personCount);
				}
			});
			
			hiInt.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					upperBound = Integer.parseInt(hiInt.getText());
					System.out.println(upperBound);
				}
			});
			
			lowInt.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					lowerBound = Integer.parseInt(lowInt.getText());
					System.out.println(lowerBound);
				}
			});
			
			fnames.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					resultsList1.add("");
					resultsList1.add("============================================");
					Main.resultsList1.add(" ");
					Main.resultsList1.add("first names between " + lowerBound + " & " + upperBound + " characters long:");
					fnt.printFNRange(fnt.getRoot(), upperBound, lowerBound);
				}
			});
			
			lnames.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					resultsList1.add("");
					resultsList1.add("============================================");
					Main.resultsList1.add(" ");
					Main.resultsList1.add("last names between " + lowerBound + " & " + upperBound + " characters long:");
					lnt.printLNRange(lnt.getRoot(), upperBound, lowerBound);
				}
			});
			
			generateData.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					if(personCount>0) {
						makeData();
					}
				}
			});
			
			searchTarget.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					String s = searchTarget.getText();
					char c = s.charAt(0);
					if(Character.isDigit(c)){
						searchInt = Integer.parseInt(s);
//						searchName = "dnu";
						resultsList1.add("Age to search is '" + searchInt+"'");
					}
					else {
						searchName =s;
						resultsList1.add("Name to search is '" + searchName + "'");
//						searchInt = -1;
					}
				}
			});
			
			fnSearch.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					searchTreeFN(searchName, fnt);
				}
			});
			
			lnSearch.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					searchTreeLN(searchName, lnt);
				}
			});
			
			ageSearch.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					searchTreeAge(searchInt, at);
				}
			});
			
			replaceTarget.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					nodeToReplace = Integer.parseInt(replaceTarget.getText());
					//System.out.println(lowerBound);
				}
			});
			
			replaceIt.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent arg0) {
					fnt.findIDMatch(fnt.getRoot(), nodeToReplace);
					myNode fntD = fnt.getIdMatch();
					fntD.deleteNode();
					
					lnt.findIDMatch(lnt.getRoot(), nodeToReplace);
					myNode lntD = lnt.getIdMatch();
					lntD.deleteNode();
					
					at.findIDMatch(at.getRoot(), nodeToReplace);
					myNode atD = at.getIdMatch();
					atD.deleteNode();
					
					if(rAge != -1) {
						fntD.getPerson().setAge(rAge);
						atD.setData(rAge);
					}
					if(rFirstName != "") {
						fntD.getPerson().setFirstName(rFirstName);
						fntD.setData(rFirstName);
					}
					if(rLastName != "") {
						fntD.getPerson().setLastName(rLastName);
						lntD.setData(rLastName);
					}
					
				
					fnt.addNode(fntD, fnt.getRoot());
					
					lnt.addNode(lntD, lnt.getRoot());
					
					at.addNode(atD, at.getRoot());
					
					rAge = -1;
					rFirstName = "";
					rLastName = "";
				}
			});
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void printSetUp(String tree, String printType) {
		if(fnt!=null && lnt!= null && at!=null && fnt.getRoot()!=null && lnt.getRoot() !=null && at.getRoot() != null ) {
		resultsList1.add("");
		resultsList1.add("============================================");
		resultsList1.add("");
		
		if(printType.equals("Depth_PreOrder")) {
			if(tree.equals("First Name")) {
				resultsList1.add("First Name tree in Depth_PreOrder -->");
				fnt.printAll(fnt.getRoot(), "");
			}
			if(tree.equals("Second Name")) {
				resultsList1.add("last Name tree in Depth_PreOrder -->");
				lnt.printAll(lnt.getRoot(), "");
			}
			if(tree.equals("Age")) {
				resultsList1.add("age tree in Depth_PreOrder -->");
				at.printAll(at.getRoot(), "");
			}
		}
		else if(printType.equals("Depth_PostOrder")) {
			if(tree.equals("First Name")) {
				resultsList1.add("First Name tree in Depth_PostOrder -->");
				fnt.printAll4(fnt.getRoot(), "");
			}
			if(tree.equals("Second Name")) {
				resultsList1.add("Last Name tree in Depth_PostOrder -->");
				lnt.printAll4(lnt.getRoot(), "");
			}
			if(tree.equals("Age")) {
				resultsList1.add("Age tree in Depth_PostOrder -->");
				at.printAll4(at.getRoot(), "");
			}
		}
		else if(printType.equals("Depth_InOrder")) {
			if(tree.equals("First Name")) {
				resultsList1.add("First Name tree in Depth_InOrder -->");
				fnt.printAll2(fnt.getRoot());
			}
			if(tree.equals("Second Name")) {
				resultsList1.add("Last Name tree in Depth_InOrder -->");
				lnt.printAll2(lnt.getRoot());
			}
			if(tree.equals("Age")) {
				resultsList1.add("Age Name tree in Depth_InOrder -->");
				at.printAll2(at.getRoot());
			}
		}
		else if(printType.equals("Breadth")) {
			if(tree.equals("First Name")) {
				resultsList1.add("First Name tree in Breadth -->");
				fnt.printAll3(fnt.getRoot());
			}
			if(tree.equals("Second Name")) {
				resultsList1.add("Last Name tree in Breadth -->");
				lnt.printAll3(lnt.getRoot());
			}
			if(tree.equals("Age")) {
				resultsList1.add("Age tree in Breadth -->");
				at.printAll3(at.getRoot());
			}
		}
		}
	}
	
	public void loadOldData() {
		JFileChooser chooser = new JFileChooser();
		
		int returnVal = chooser.showOpenDialog(null);
		
		File data = chooser.getSelectedFile();
		
		fnt = new myTree<String>(new myFirstNameComparator());
		lnt = new myTree<String>(new myLastName());
		at = new myTree<Integer>(new myAgeComparator());
		
		Person.idCount = 1;
		
		try {
			Scanner sc = new Scanner(data);
			while(sc.hasNext()) {
//				String s = sc.nextLine();
//				Scanner sc2 = new Scanner(s);
				Person p = new Person(sc.next(), sc.next(), sc.nextInt());
				myNode<String> nFN = new myNode<String>(p, p.getFirstName());
				fnt.addNode(nFN, fnt.getRoot());
				myNode<String> nLN = new myNode<String>(p, p.getLastName());
				lnt.addNode(nLN, lnt.getRoot());
				myNode<Integer> nA = new myNode<Integer>(p, p.getAge());
				at.addNode(nA, at.getRoot());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		resultsList1.add("File" + data.getName() + " Loaded");
	}
	
	public void makeData() {
		File names = new File("Names2.txt");
		JFileChooser chooser = new JFileChooser();
		
		int returnVal = chooser.showOpenDialog(null);
		
		File destination = chooser.getSelectedFile();
		
		
		
		
		try {
			PrintStream ps = new PrintStream(destination);
		
		for(int i = 0; i<personCount; i++) {
			int age =(int) (Math.random()*100);
			
			int fnInt = (int) (Math.random()*18238);
			int lnInt = (int) (Math.random()*18238);
			
			String fn = "";
			String ln = "";
			
			Scanner sc1;
			try {
				sc1 = new Scanner(names);
				for(int x = 0; x<fnInt; x++) {
					sc1.nextLine();
				}
				fn = sc1.next();
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			Scanner sc2;
			try {
				sc2 = new Scanner(names);
				for(int x = 0; x<lnInt; x++) {
					sc2.nextLine();
				}
				ln = sc2.next();
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ps.println(fn + " " + ln + " " + age);
			
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
			//1->18239
			
//			System.out.println("NEW PASS");
//			int y = (int) (Math.random()*500);
//			System.out.println(y);
//			int count = 1;
//			for(int j = 0; j<y-1; j++) {
//				System.out.println(sc.nextLine() + count);
//				count++;
//			}
//		public void usedata() {	
//			Person p = new Person(sc.next(), sc.next(), z);
//			
//			//System.out.println(p.getFirstName()+" "+p.getLastName()+" "+p.getAge());
//			
//			myNode<String> nFN = new myNode<String>(p, p.getFirstName());
//			
//			fnt.addNode(nFN, fnt.getRoot());
//			
//			myNode<String> nLN = new myNode<String>(p, p.getLastName());
////			
//			lnt.addNode(nLN, lnt.getRoot());
////			
//			myNode<Integer> nA = new myNode<Integer>(p, p.getAge());
////			
//			at.addNode(nA, at.getRoot());
//			
//			
//			
//		}
//		String s = "";
//		fnt.printAll(fnt.getRoot(), s);
//		System.out.println("===============");
//		
//		fnt.printAll3(fnt.getRoot());
		
//		fnt.printAll2(fnt.getRoot()); 
//		System.out.println("===============");
//		lnt.printAll(lnt.getRoot(), s);
//		System.out.println("===============");
//		lnt.printAll2(lnt.getRoot());
////		at.printAll(at.getRoot());
//		System.out.println("===============");
//		
//		at.printAll(at.getRoot(), s);
//		System.out.println("===============");
//		at.printAll2(at.getRoot());
//		System.out.println("===============");
//		
//		searchTreeFN("karen", fnt);
//		System.out.println("===============");
//		
//		searchTreeLN("rongo", lnt);
//		System.out.println("===============");
//		searchTreeAge(10, at);
		
	
	private void searchTreeAge(int age, myTree<Integer> t) {
		if(fnt!=null && lnt!= null && at!=null && fnt.getRoot()!=null && lnt.getRoot() !=null && at.getRoot() != null ) {
			resultsList1.add("");
			resultsList1.add("============================================");
			resultsList1.add("");
		resultsList1.add("Searching age: '" + age+ "' -> ");
		t.refreshSearch();
		t.searchA(t.getRoot(), age);
		String s = "";
		for(Person p : t.getMySearch()) {
			s = s  + p.getFirstName() + " "+ p.getLastName() + " is "+ p.getAge() + " years old " + "(ID: " + p.getId()+ ") ";
		}
		resultsList1.add(s);
	}
	}
	
	private void searchTreeFN(String fn, myTree<String> t) {
		if(fnt!=null && lnt!= null && at!=null && fnt.getRoot()!=null && lnt.getRoot() !=null && at.getRoot() != null ) {
			resultsList1.add("");
			resultsList1.add("============================================");
			resultsList1.add("");
		resultsList1.add("Searching first name: '" + fn + "' -> ");
		t.refreshSearch();
		t.searchFN(t.getRoot(), fn);
		String string = "";
		for(Person p : t.getMySearch()) {
			string = string  + p.getFirstName() + " "+ p.getLastName() + " is "+ p.getAge() + " years old " + "(ID: " + p.getId()+ ") ";
		}
		resultsList1.add(string);
	}}
	
	
	private void searchTreeLN(String ln, myTree<String> t) {
		if(fnt!=null && lnt!= null && at!=null && fnt.getRoot()!=null && lnt.getRoot() !=null && at.getRoot() != null ) {
			resultsList1.add("");
			resultsList1.add("============================================");
			resultsList1.add("");
		resultsList1.add("Searching last name: '" + ln+ "' -> ");
		t.refreshSearch();
		t.searchLN(t.getRoot(), ln);
		String string = "";
		for(Person p : t.getMySearch()) {
			string = string  + p.getFirstName() + " "+ p.getLastName() + " is "+ p.getAge() + " years old " + "(ID: " + p.getId()+ ") ";
		}
		resultsList1.add(string);
	}
	}
}
