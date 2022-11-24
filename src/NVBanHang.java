
public class NVBanHang extends NhanVien {
	private float soGioLam;
	private double phuCap;

	public NVBanHang() {
	}

	public NVBanHang(String id, String hoVaTen, String gioiTinh, String diaChi, Date ngaySinh, String e,
			 String sdt,String tenChucVu, double luong, float soGioLam, double phuCap) {
		super(id, hoVaTen, diaChi, gioiTinh, ngaySinh, e, sdt, tenChucVu, luong);
		this.soGioLam = soGioLam;
		this.phuCap = phuCap;
	}

	public float getSoGioLam() {
		return soGioLam;
	}

	public void setSoGioLam(float soGioLam) {
		for (;;) {
			if (soGioLam > 0)
				break;
			System.out.println("Moi nhap lai so gio lam viec :");
			gioiTinh = sc.nextLine();
		}
		this.soGioLam = soGioLam;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap() {
		this.phuCap = 9000;
	}
	
	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	@Override
	public void nhap() {
		super.nhap();
		super.setTenChucVu("Ban Hang");
		System.out.println("Nhap so gio lam viec:");
		setSoGioLam(Integer.parseInt(sc.nextLine()));
		setPhuCap();

	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.printf("%-15s", "");
		System.out.printf("%-15s", getSoGioLam());
		System.out.printf("%-,15.0f|%n", getPhuCap());
		// System.out.print("\t" + chucVu + "\t\t" + luong + "\n");
	}

	@Override
	public double tinhLuong() {
		return super.getluongCB() / 208 * getSoGioLam() + getPhuCap();
	}
}
