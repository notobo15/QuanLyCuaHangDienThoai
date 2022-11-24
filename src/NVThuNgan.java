
public class NVThuNgan extends NhanVien {
	private float soNgayLam;

	public NVThuNgan(String id, String ten, String diachi, String gioiTinh, Date ngaySinh, String e, String sdt, String tenCV, double luong, float soNgayLam) {
		super(id, ten, diachi, gioiTinh, ngaySinh, e, sdt, tenCV, luong);
		this.soNgayLam = soNgayLam;
	}

//	public NVThuNgan(String id, String hoVaTen, String gioiTinh, String diaChi, Date ngaySinh, double luong,
//			String tenChucVu, String e, String sdt, float soNgayLam) {
//		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, luong,tenChucVu,  e, sdt);
//		this.soNgayLam = soNgayLam;
//	}




	public NVThuNgan() {
	}

	@Override
	public void nhap() {
		super.nhap();
		super.setTenChucVu("Thu Ngan");
		System.out.println("Nhap so ngay lam viec:");
		setSoNgayLam(Integer.parseInt(sc.nextLine()));
	}

	public float getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(float soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.printf("%-45s|%n", getSoNgayLam());
		// System.out.print("\t" + chucVu + "\t\t" + luong + "\n");
	}

	@Override
	public double tinhLuong() {
		return super.getluongCB() / 26 * getSoNgayLam();
	}
}
