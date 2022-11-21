
public class NVBanHang extends NhanVien {
	private float soGioLam;
	private double phuCap;

	public NVBanHang() {
	}

	public NVBanHang(String id, String hoVaTen, String gioiTinh, String diaChi, Date ngaySinh, double luong,
		 String e, String sdt, float soGioLam, double phuCap) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, luong, e, sdt);
		this.soGioLam = soGioLam;
		this.phuCap = phuCap;
	}
	


	public float getSoGioLam() {
		return soGioLam;
	}

	public void setSoGioLam(float soGioLam) {
		this.soGioLam = soGioLam;
	}
	

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap() {
		this.phuCap = 9000;
	}

	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Nhap so gio lam viec:");
		setSoGioLam(Integer.parseInt(sc.nextLine()));
		setPhuCap();
		
	}
	@Override
	public void setId(int stt) {
		super.id = "NVBH" + ++stt;
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.printf("%-15s", getSoGioLam());
		System.out.printf("%-10s|%n", getPhuCap());
		// System.out.print("\t" + chucVu + "\t\t" + luong + "\n");
	}
	
	@Override
	public double tinhLuong () {
		return super.getluongCB() /  208 * getSoGioLam() + getPhuCap();
	}
}
