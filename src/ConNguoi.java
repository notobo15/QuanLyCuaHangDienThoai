import java.util.Scanner;
import java.util.regex.*;

public abstract class ConNguoi {
	static Scanner sc = new Scanner(System.in);

	protected String id;
	protected String hoVaTen;

	protected String diaChi;

	protected String gioiTinh;

	protected String email;

	protected String sdt;
	protected Date ngaySinh = new Date();

	public ConNguoi() {
	}

	public ConNguoi(String id, String hoVaTen, String diaChi, String gioiTinh, Date ngaySinh, String e, String sdt) {
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.email = e;
		this.sdt = sdt;
	}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = id;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		hoVaTen = hoVaTen.trim();
		boolean foundSpace = true;
		char[] charArray = hoVaTen.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])) {
				if (foundSpace) {
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			} else {
				foundSpace = true;
			}
		}
		this.hoVaTen = String.valueOf(charArray);
		// this.hoVaTen = hoVaTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		for (;;) {
			if (gioiTinh.equalsIgnoreCase("Nam") || gioiTinh.equalsIgnoreCase("Nu"))
				break;
			System.out.println("Moi nhap lai gioi tinh (nam/ nu):");
			gioiTinh = sc.nextLine();
		}
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		// final String regexPattern = "^[A-Za-z0-9+._-]+@(.+)$";
		// Pattern pattern = Pattern.compile(regexPattern);
		// Matcher matcher = pattern.matcher(email);
		// for(;;){
		// System.out.println(matcher.matches());
		// if(matcher.matches()) {
		// break;
		// }
		// System.out.println("Moi nhap lai email:");
		// email=sc.nextLine();
		// }
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		final String regexPattern = "^\\d{10}$";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(sdt);
//		for (;;) {
//			if (matcher.matches()) {
//				break;
//			}
//			System.out.println("khong phai dinh dang cua so dien thoai");
//			System.out.println("Moi nhap lai so dien thoai:");
//			sc.nextLine();
//			sdt = sc.nextLine();
//		}
		this.sdt = sdt;
	}

	public void nhap() {
		System.out.println("Moi nhap ho ten:");
		setHoVaTen(sc.nextLine());
		System.out.println("Moi nhap gioi tinh:");
		setGioiTinh(sc.nextLine());
		System.out.println("Moi nhap dia chi:");
		setDiaChi(sc.nextLine());
		System.out.println("Moi nhap ngay sinh:");
		ngaySinh.setTime();
		System.out.println("Moi nhap email:");
		setEmail(sc.nextLine());
		System.out.println("Moi nhap sdt:");
		setSdt(sc.nextLine());
	}

	@Override
	public String toString() {
		return id + "\t" + hoVaTen + "\t\t\t" + gioiTinh + "\t\t" + diaChi + "\t\t" + ngaySinh.toString()
				+ "\t" + email + "\t" + sdt;
	}

	public void xuat() {
		System.out.printf("|  %-10s", getId());
		System.out.printf("%-25s", getHoVaTen());
		System.out.printf("%-15s", getGioiTinh());
		System.out.printf("%-15s", getDiaChi());
		System.out.printf("%-15s", getNgaySinh());
		System.out.printf("%-15s", getEmail());
		System.out.printf("%-15s", getSdt());
		// System.out.println("'%15s' %n", "baeldung");
	}

}
