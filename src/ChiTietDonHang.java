import java.util.Scanner;

public class ChiTietDonHang {
	private String id;
	private String donHang_id;
	private String sanPham_id;
	private float soLuong = 1;
	private double thanhTien;
	private static int stt = 0;
	Scanner sc = new Scanner(System.in);

	public ChiTietDonHang() {
	}

	public ChiTietDonHang(String donHang_id) {
		this.donHang_id = donHang_id;
	}

	public ChiTietDonHang(String id, String donHang_id, String sanPham_id, float soLuong, double thanhTien) {
		this.id = id;
		this.donHang_id = donHang_id;
		this.sanPham_id = sanPham_id;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = "CCDH" + ++stt;
	}

	public String getDonHang_id() {
		return donHang_id;
	}

	public void setDonHang_id(String donHang_id) {
		this.donHang_id = donHang_id;
	}

	public String getSanPham_id() {
		return sanPham_id;
	}

	public void setSanPham_id(String sanPham_id) {
		this.sanPham_id = sanPham_id;
	}

	public float getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(float soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien() {
		DSSanPham dssp = new DSSanPham();
		System.out.println(dssp.xuatGia(sanPham_id));
		System.out.println(soLuong);
		this.thanhTien = soLuong * dssp.xuatGia(sanPham_id);
	}

	public void nhap(String id) {
		setId();
		setDonHang_id(id);
		System.out.println("nhap id san pham: ");
		setSanPham_id(sc.nextLine());
		System.out.println("nhap so luong: ");
		setSoLuong(Float.parseFloat(sc.nextLine()));
		setThanhTien();
		// System.out.println(getThanhTien());

	}

	@Override
	public String toString() {
		return getId() + "san pham " + getSanPham_id() + "so luong " + getSoLuong() + "thanh tien " + getThanhTien();
	}

	public void xuat() {
		System.out.printf("|\tID CTDH : %-10s", getId());
		System.out.printf("TEN SAN PHAM : %-30s", getSanPham_id());
		System.out.printf("SO LUONG : %-15s", getSoLuong());
		System.out.printf("THANH TIEN : %-,15.2f |%n", getThanhTien());

		// System.out.println(toString());
	}

}
