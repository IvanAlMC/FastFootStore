package models;

import java.util.Comparator;

public class ComparatorBill implements Comparator<Bill>{

	@Override
	public int compare(Bill o1, Bill o2) {
		return o1.getId()-o2.getId();
	}

}
