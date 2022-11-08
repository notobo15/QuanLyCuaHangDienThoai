import java.util.Scanner;

public class ChiTietDonHang {
	private String id;
	private String donHang_id;
	private String sanPham_id;
	private float soLuong = 1;
	private float dateBaoHanh;
	private double thanhTien;
	private static int stt = 0;
	Scanner sc = new Scanner(System.in);
	public ChiTietDonHang() {
	}
	public ChiTietDonHang(String donHang_id) {
		this.donHang_id = donHang_id;
	}
	
	public ChiTietDonHang(String id, String donHang_id, String sanPham_id, float soLuong, float dateBaoHanh,
			double thanhTien) {
		this.id = id;
		this.donHang_id = donHang_id;
		this.sanPham_id = sanPham_id;
		this.soLuong = soLuong;
		this.dateBaoHanh = dateBaoHanh;
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

	public float getDateBaoHanh() {
		return dateBaoHanh;
	}

	public void setDateBaoHanh(float dateBaoHanh) {
		this.dateBaoHanh = dateBaoHanh;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien() {
		DSNhanVien dsnv = new DSNhanVien();
		dsnv.DocFile();
		this.thanhTien = soLuong * 111111;
	}
	public void nhap() {
		setId();
		System.out.println("nhap id san pham: ");
		setSanPham_id(sc.nextLine());
		System.out.println("nhap so luong: ");
		setSoLuong(Float.parseFloat(sc.nextLine()));
		System.out.println("Nhap so ngay bao hanh: ");
		setDateBaoHanh(Float.parseFloat(sc.nextLine()));
		setThanhTien();
		
	}
	
	public void xuat() {
		System.out.println(toString());
	}
	
}
