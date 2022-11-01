import java.util.Scanner;

public class DonHang {
	Scanner sc = new Scanner(System.in);
	
	
	private String id, hinhThucThanhToan;
	private String thuNhan_id;
	private String kh_id;
	private String cuaHang_id;
	private float gia = 0;
	private Date date = new Date();
	private Date dateBaoHanh = new Date();
	public DonHang(String id, String hinhThucThanhToan, String thuNhan_id, String kh_id, String cuaHang_id, float gia,
			Date date, Date dateBaoHanh) {
		super();
		this.id = id;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.thuNhan_id = thuNhan_id;
		this.kh_id = kh_id;
		this.cuaHang_id = cuaHang_id;
		this.gia = gia;
		this.date = date;
		this.dateBaoHanh = dateBaoHanh;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public String getThuNhan_id() {
		return thuNhan_id;
	}
	public void setThuNhan_id(String thuNhan_id) {
		this.thuNhan_id = thuNhan_id;
	}
	public String getKh_id() {
		return kh_id;
	}
	public void setKh_id(String kh_id) {
		this.kh_id = kh_id;
	}
	public String getCuaHang_id() {
		return cuaHang_id;
	}
	public void setCuaHang_id(String cuaHang_id) {
		this.cuaHang_id = cuaHang_id;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDateBaoHanh() {
		return dateBaoHanh;
	}
	public void setDateBaoHanh(Date dateBaoHanh) {
		this.dateBaoHanh = dateBaoHanh;
	}
	public void Tao() {
		System.out.println();
	}
}
