
public class NhanVien extends ConNguoi {
	private double luongCB;
	private String tenChucVu;

	public NhanVien() {
	}

	public NhanVien(String id, String hoVaTen, String gioiTinh, String diaChi, Date ngaySinh, 
			String e,String sdt,  String tenChucVu, double luongCB) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, e, sdt);
		this.luongCB = luongCB;
		this.tenChucVu =tenChucVu;
	}



	public void setId(int stt) {
		super.id = "NV" + ++stt;
	}

	public String getId() {
		return this.id;
	}

	

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
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
		System.out.printf("%-15s", getTenChucVu());
		System.out.printf("%-,15.0f", getluongCB());
		// System.out.print("\t" + chucVu + "\t\t" + luong + "\n");
	}
	

	@Override
	public String toString() {
		return "NhanVien [luongCB=" + luongCB + ", tenChucVu=" + tenChucVu + "]";
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
		for(;;) {
			
			if(2022 - ngaySinh.getYear() >= 18 && ngaySinh.getMonth()  < 12)
				break;
			System.out.println("Chua do 18 tuoi ! Moi ban nhap lai : ");
			ngaySinh.setTime();
		}
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
