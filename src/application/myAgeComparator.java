package application;

import java.util.Comparator;

public class myAgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getAge()-o2.getAge();
	}
//		if(o1.getAge()==o2.getAge()) {
//			int fn = o1.getFirstName().compareTo(o2.getFirstName());
//			if(fn==0) {
//				int ln = o1.getFirstName().compareTo(o2.getFirstName());
//				if(ln==0) {
//					return o1.getId()-o2.getId();
//				}
//				else {
//					return ln;
//				}
//			}
//			else {
//				return fn;
//			}
//		}
//		else if(o1.getAge()>o2.getAge()) {
//			return 1;
//		}
//		else {
//			return -1;
//		}
//	}

}

