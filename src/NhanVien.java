
public class NhanVien extends ConNguoi {
	private String chucVu;
	private double luong;
	private static int stt = 0;

	public NhanVien() {
	}

	public NhanVien(String id, String hoVaTen, String gioiTinh, String diaChi, Date ngaySinh, double luong,
			String chucVu, String e, String sdt) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, e, sdt);
		this.chucVu = chucVu;
		this.luong = luong;
	}

	public void setId() {
		super.id = "NV" + ++stt;
	}

	public void setId(int stt) {
		super.id = "NV" + ++stt;
	}

	public String getId() {
		return this.id;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		for (;;) {
			if (chucVu.equalsIgnoreCase("ban hang")
					|| chucVu.equalsIgnoreCase("thu ngan")
					|| chucVu.equalsIgnoreCase("quan ly"))
				break;
			System.out.println("Moi nhap lai (ban hang/ thu ngan/quan ly):");
			chucVu = sc.nextLine();
		}
		this.chucVu = chucVu;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		for (;;) {
			if (luong >= 0)
				break;
			System.out.println("Moi nhap lai:");
			luong = sc.nextDouble();
		}
		this.luong = luong;
	}

	@Override
	public String toString() {
		return super.toString();
	}
 
	@Override
	public void xuat() {
		super.xuat();
		System.out.printf("%-15s", getChucVu());
		System.out.printf("%-15s|%n", getLuong());
		// System.out.print("\t" + chucVu + "\t\t" + luong + "\n");
	}
	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Moi nhap chuc vu:");
		setChucVu(sc.nextLine());
		System.out.println("Moi nhap luong:");
		setLuong(Integer.parseInt(sc.nextLine()));
	}
	
	public static void main(String[] args) {
		ConNguoi cn = new KhachHang();
		cn.setEmail(sc.nextLine());
		cn.setSdt(sc.nextLine());
		System.out.println(cn.getEmail());
		System.out.println(cn.getSdt());
		
	}
}
