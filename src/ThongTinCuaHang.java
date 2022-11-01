import java.util.Scanner;

public class ThongTinCuaHang {
	private String id;
	private String ten;
	private String diaChi;
	private String sdt;
	private String email;
	private String maSoThe;
	private String Fax;
	private static int stt = 0;
	Scanner sc = new Scanner(System.in);
	public String getId() {
		return id;
	}

	public void setId() {

		this.id = "CH"+ ++stt;
	}

	public ThongTinCuaHang() {
		super();
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaSoThe() {
		return maSoThe;
	}

	public void setMaSoThe(String maSoThe) {
		this.maSoThe = maSoThe;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public void Tao() {
		setId();
		System.out.println("Nhap ten");
		setTen(sc.nextLine());
		System.out.println("Nhap dia chi");
		setDiaChi(sc.nextLine());
	}

	@Override
	public String toString() {
		return "ThongTinCuaHang [id=" + id + ", ten=" + ten + ", diaChi=" + diaChi + "]";
	}
	
	public void Xuat() {
		System.out.println(toString());
	}
	
	
	
	
}
