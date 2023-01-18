package application;

import java.util.Comparator;

public class myFirstNameComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
	}
//		int fn = o1.getFirstName().compareTo(o2.getFirstName());
////		if(fn==0) {
////			int ln = o1.getLastName().compareTo(o2.getLastName());
////			if(ln==0) {
////				int age = o1.getAge()-o2.getAge();
////				if(age==0) {
////					return o1.getId()-o2.getId();
////				}
////				else {
////					return age;
////				}
////			}
////			else {
////				return ln;
////			}
////		}
////		else {
////			return fn;
////		}
////		
////		
////	}



}
