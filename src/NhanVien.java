
public class NhanVien extends ConNguoi {
	private double luongCB;
	

	public NhanVien() {
	}

	public NhanVien(String id, String hoVaTen, String gioiTinh, String diaChi, Date ngaySinh, double luongCB,
		 String e, String sdt) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, e, sdt);
		this.luongCB = luongCB;
	}



	public void setId(int stt) {
		super.id = "NV" + ++stt;
	}

	public String getId() {
		return this.id;
	}



	public double getluongCB() {
		return luongCB;
	}

	public void setluongCB(double luongCB) {
		for (;;) {
			if (luongCB >= 0)
				break;
			System.out.println("Moi nhap lai:");
			luongCB = sc.nextDouble();
		}
		this.luongCB = luongCB;
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

		System.out.printf("%-15s", getluongCB());
		// System.out.print("\t" + chucVu + "\t\t" + luong + "\n");
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
		System.out.println("Moi nhap luong co ban:");
		setluongCB(Integer.parseInt(sc.nextLine()));
	}
	
	public double tinhLuong () {
		return luongCB + 1;
	}
}
