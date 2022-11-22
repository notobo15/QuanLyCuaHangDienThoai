package Function;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	
	public static int checkInput(String select) {
		Scanner sc = new Scanner(System.in);
		boolean isSuccess = false;
		int luaChon = 0;
		Pattern p = Pattern.compile("^[0-9]*$");
		select = sc.nextLine();
		do {
			Matcher m = p.matcher(select);
			if (m.find() == true && select.length() != 0) {
				luaChon = Integer.parseInt(select);
				isSuccess = true;
				return luaChon;
			}
			System.out.print("Chi duoc nhap chu so !!!\nMoi ban nhap lai : ");
			select = sc.nextLine();
		} while(isSuccess != true);
		return -1;
	}
	public static int checkInput2() {
		String select = null;
		Scanner sc = new Scanner(System.in);
		boolean isSuccess = false;
		int luaChon = 0;
		Pattern p = Pattern.compile("^[0-9]*$");
		select = sc.nextLine();
		do {
			Matcher m = p.matcher(select);
			if (m.find() == true && select.length() != 0) {
				luaChon = Integer.parseInt(select);
				isSuccess = true;
				return luaChon;
			}
			System.out.print("Chi duoc nhap chu so !!!\nMoi ban nhap lai : ");
			select = sc.nextLine();
		} while(isSuccess != true);
		return -1;
	}
}
