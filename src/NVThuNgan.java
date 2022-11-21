
public class NVThuNgan extends NhanVien {
	private static int stt = 0;
	private float soNgayLam;

	public NVThuNgan() {
	}

	public NVThuNgan(String id, String hoVaTen, String gioiTinh, String diaChi, Date ngaySinh, double luong,
		 String e, String sdt, float soNgayLam) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, luong, e, sdt);
		this.soNgayLam = soNgayLam;
	}

	
	public float getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(float soNgayLam) {
		this.soNgayLam = soNgayLam;
	}
	@Override
	public void setId(int stt) {
		super.id = "NVTN" + ++stt;
	}
	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Nhap so ngay lam viec:");
		setSoNgayLam(Integer.parseInt(sc.nextLine()));
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.printf("%-15s|%n", getSoNgayLam());
		// System.out.print("\t" + chucVu + "\t\t" + luong + "\n");
	}
	
	@Override
	public double tinhLuong () {
		return super.getluongCB() /  26 * getSoNgayLam();
	}
}
