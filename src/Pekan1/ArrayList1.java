package Pekan1;

import java.util.ArrayList;

public class ArrayList1 {

	public static void main(String[] args) {
	//size of the arraylist
		int n=5;
		//declaring the arraylist with initial size n
		ArrayList<Integer> arrli = new ArrayList<Integer>(n);
		for (int i = 1; i <=n;i++)
			arrli.add(i);
		System.out.println(arrli);
		arrli.remove(3);
		System.out.println(arrli);
		for (int i = 0; 1 < arrli.size(); i ++)
			System.out.println(arrli.get(i) + "");
	}

}
